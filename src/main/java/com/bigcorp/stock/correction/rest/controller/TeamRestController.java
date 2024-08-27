package com.bigcorp.stock.correction.rest.controller;

import com.bigcorp.stock.correction.model.Manager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class TeamRestController {

    @GetMapping("/teams/{id}/managers")
    public List<Manager> getManagers(@PathVariable("id") Long id,
                                     @RequestParam(name = "nom", required = false) String nom,
                                     @RequestParam(name = "prenom", required = false) String prenom){
        System.out.println("L'id de l'équipe vaut : " + id);
        System.out.println("Le nom recherché : " + nom);
        System.out.println("Le prenom recherché : " + prenom);
        return Collections.emptyList();
    }

}
