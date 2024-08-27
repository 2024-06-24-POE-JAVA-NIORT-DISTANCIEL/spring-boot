package com.bigcorp.stock.correction.service;

import com.bigcorp.stock.correction.dao.ManagerDao;
import com.bigcorp.stock.correction.model.Manager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service qui implémente UserDetailsService : Spring
 * Security peut s'en servir pour authentifier un utilisateur.
 */
@Service
public class ManagerService implements UserDetailsService{

    @Autowired
    private ManagerDao managerDao;

    @Autowired
    private TeamService teamService;

    @Transactional
    public Manager save(Manager manager){
        Manager savedManager = this.managerDao.save(manager);
        return savedManager;
    }

    public Manager findById(Long id){
        Optional<Manager> optionalManager = this.managerDao.findById(id);
        if(optionalManager.isEmpty()){
            return null;
        }
        return optionalManager.get();
    }

    @Transactional
    public void delete(Long id) {
        managerDao.deleteById(id);
    }

    public Iterable<Manager> findAll(){
        return this.managerDao.findAll();
    }


    /**
     * Cette méthode est appelée par Spring security
     * pour charger un utilisateur par son username (unique, peut être un login)
     * et l'identifier, ou l'authentifier.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Manager> managers = this.managerDao.findByEmail(username);
        if(managers.isEmpty()){
            throw new UsernameNotFoundException("Could not find manager from username : " + username);
        }
        //else...
        return managers.get(0);
    }
}
