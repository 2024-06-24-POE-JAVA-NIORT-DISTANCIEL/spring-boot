package com.bigcorp.stock.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MonDao {

    public MonDao(){
        System.out.println("Hey, j'ai été instancié");
    }

    public boolean genereBoolean(){
        return true;
    }
}
