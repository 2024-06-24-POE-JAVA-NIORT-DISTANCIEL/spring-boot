package com.bigcorp.stock.correction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class HelloController {

    @GetMapping("/")
    public String afficheHome(){
        return "home";
    }

    @GetMapping("/hello")
    public String afficheHello(){
        System.out.println("Le contrôleur est appelé");
        return "hello";
    }

    @ModelAttribute
    public MonObjet getMonObjet(){
        return new MonObjet();
    }


    private class MonObjet {

        private String mot = "coucou";
        private int entier = 42;
        private String classeDynamique = "ma-classe-dynamique";

        public String getMot() {
            return LocalDateTime.now().toString();
        }

        public void setMot(String mot) {
            this.mot = mot;
        }

        public int getEntier() {
            return entier;
        }

        public void setEntier(int entier) {
            this.entier = entier;
        }

        public String getClasseDynamique() {
            return classeDynamique;
        }

        public void setClasseDynamique(String classeDynamique) {
            this.classeDynamique = classeDynamique;
        }
    }
}
