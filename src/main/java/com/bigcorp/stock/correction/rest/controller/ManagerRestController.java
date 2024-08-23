package com.bigcorp.stock.correction.rest.controller;

import com.bigcorp.stock.correction.model.Manager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerRestController {

    @GetMapping("managers/{id}")
    public Manager getManager(@PathVariable("id") Long id){
        Manager manager = new Manager();
        manager.setId(id);
        manager.setNom("Jacques");
        manager.setSalaire(3000);
        return manager;
    }

}