package com.bigcorp.stock.correction.service;

import com.bigcorp.stock.correction.dao.ManagerDao;
import com.bigcorp.stock.correction.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service qui implémente UserDetailsService :
 * Spring Security va se servir de ce service
 * pour récupérer des utilisateurs, et les valider
 * (avec le mot de passe, le fait qu'ils sont actifs ...).
 * Pour Spring Security un utilisateur implémente UserDetails
 */
@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    private ManagerDao managerDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Manager> managers = this.managerDao.findByNom(username);
        if(managers.isEmpty()){
            return null;
        }
        return managers.get(0);
    }
}
