package com.bigcorp.stock.correction.rest.controller;

import com.bigcorp.stock.correction.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/managers")
public class ManagerRestController {

    @GetMapping("/{id}")
    public Manager getManager(@PathVariable("id") Long id){
        Manager manager = new Manager();
        manager.setId(id);
        manager.setNom("JsdsdanJean");
        manager.setSalaire(3000);
        return manager;
    }

    @PostMapping
    public Manager save(@RequestBody Manager manager){
        manager.setNom("J'ai sauvegardé ce manager");
        return manager;
    }

}