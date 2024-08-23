package com.bigcorp.stock.correction.service;

import com.bigcorp.stock.correction.dao.ManagerDao;
import com.bigcorp.stock.correction.dao.TeamDao;
import com.bigcorp.stock.correction.model.Manager;
import com.bigcorp.stock.correction.model.Team;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamDao teamDao;

    @Transactional
    public Team save(Team team){
        //Ici, du code super intelligent
        return this.teamDao.save(team);
    }


}
