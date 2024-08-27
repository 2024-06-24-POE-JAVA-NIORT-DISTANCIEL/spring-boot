package com.bigcorp.stock.correction.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Classe de configuration de Spring Security
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    /**
     * Configure les URLs et la sécurité associée à chacune d'entre elles
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //Réutilisation de HttpSecurity fourni par SpringSecurity
        http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests -> requests
                        // les URLs ci-dessous peuvent être requêtées par tout le monde
                        .requestMatchers("/", "/home", "/login", "/error", "/logout", "/managers/**", "/teams/**").permitAll()
                        // Toute autre requête ne peut être émise que par une personne
                        // authentifiée
                        .anyRequest().authenticated())
                // la page de login est accessible via /login
                // et est accessible par tout le monde
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll())
                // La page de logout est aussi accessible
                //par tout le monde
                .logout(logout -> logout.permitAll());
        return http.build();
    }

    /**
     * Il est possible d'insérer dans le contexte de Spring
     * une instance de UserDetailsService, qui indique comment
     * récupérer les utilisateurs, pour les authentifier.
     * @return
     */
    public UserDetailsService userDetailsService() {
        // La méthode ci-dessous est dépréciée : il n'est pas conseillé
        // de mettre en dur un login et un mot de passe, mais de
        // récupérer un utilisateur d'une base de données, ou d'un
        // référentiel d'utilisateurs (annuaire LDAP)
        @SuppressWarnings("deprecation")
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        // Renvoie une implémentation de UserDetailsService
        // qui stocke les utilisateurs en mémoire (ici, un seul utilisateur)
        return new InMemoryUserDetailsManager(user);
    }

    /**
     * Spring security demande un passwordencoder : ici, on
     * utilise BCrypt (configuré par défaut avec 10 tours) .
     * Par exemple password devient : $2a$10$phgIasQBRXjA2G29MXsvqujzB1YsXdHYuBifkG4vHcjdSuCFVmmUu
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
