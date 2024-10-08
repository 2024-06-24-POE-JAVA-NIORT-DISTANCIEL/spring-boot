package com.bigcorp.stock.correction.rest.controller;

import com.bigcorp.stock.correction.model.Manager;
import com.bigcorp.stock.correction.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/managers")
public class ManagerRestController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/{id}")
    public Manager getManagerWithPathVariable(@PathVariable("id") Long id){
        System.out.println("Appel de getManagerWithPathVariable");
       return managerService.findById(id);
    }

    @GetMapping
    public Manager getManagerWithRequestParam(@RequestParam("id") Long id){
        System.out.println("Appel de getManagerWithRequestParam");
        return managerService.findById(id);
    }

    @PostMapping
    public Manager save(@RequestBody Manager manager){
        return managerService.save(manager);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        managerService.delete(id);
    }

}