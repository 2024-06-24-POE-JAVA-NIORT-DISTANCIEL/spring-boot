package com.bigcorp.stock.dao;


import com.bigcorp.stock.service.MonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MonDaoTest {

    @Autowired
    MonDao monDao;

    @Autowired
    MonService monService;

    @Test
    public void testGenereBoolean(){
        Assertions.assertTrue(monDao.genereBoolean());
        Assertions.assertNotNull(monService.getMonDao());
    }
}
