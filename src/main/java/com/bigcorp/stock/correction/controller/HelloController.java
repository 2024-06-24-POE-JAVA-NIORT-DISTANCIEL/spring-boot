package com.bigcorp.stock.correction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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

        public String getMot() {
            return mot;
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
    }
}
