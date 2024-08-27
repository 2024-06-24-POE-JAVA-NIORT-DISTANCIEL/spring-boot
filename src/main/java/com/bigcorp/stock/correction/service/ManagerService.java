package com.bigcorp.stock.correction.service;

import com.bigcorp.stock.correction.dao.ManagerDao;
import com.bigcorp.stock.correction.model.Manager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerService {

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

}
