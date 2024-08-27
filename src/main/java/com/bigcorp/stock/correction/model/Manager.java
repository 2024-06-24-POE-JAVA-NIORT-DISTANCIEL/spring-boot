package com.bigcorp.stock.correction.model;

import jakarta.persistence.*;
import org.apache.catalina.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Cette entité implémente  UserDetails.
 * Ainsi, Spring Security peut s'en servir
 * pour authentifier des utilisateurs.
 * Le username de Spring Security correspond ici à l'attribut email
 * et le password à l'attribut password
 */
@Entity
public class Manager implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToOne
    @JoinColumn(name= "TEAM_ID")
    private Team team;

    private String nom;

    private String prenom;

    private Integer poids;

    private Integer salaire;

    private String email;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    public Integer getSalaire() {
        return salaire;
    }

    public void setSalaire(Integer salaire) {
        this.salaire = salaire;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", poids=" + poids +
                ", salaire=" + salaire +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "$2a$10$phgIasQBRXjA2G29MXsvqujzB1YsXdHYuBifkG4vHcjdSuCFVmmUu";
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}