package com.bigcorp.stock.correction.dao;

import com.bigcorp.stock.DemoSpringBootStockApplication;
import com.bigcorp.stock.correction.model.Manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ManagerDaoTest {

    @Autowired
    ManagerDao managerDao;

    @Test
    public void testSaveManager(){
        Manager newManager = new Manager();
        newManager.setNom("Roger");

        System.out.println("Avant save");
        Manager savedManager = managerDao.save(newManager);
        System.out.println("Après save");

        Assertions.assertNotNull(savedManager.getId());
        Assertions.assertEquals("Roger", savedManager.getNom());

        System.out.println("Avant findById");
        Optional<Manager> managerFromDataBase = managerDao.findById(savedManager.getId());
        Assertions.assertTrue(managerFromDataBase.isPresent());
        Manager managerFromDataBaseNotNull = managerFromDataBase.get();

        System.out.println("Après findById");
        Assertions.assertEquals("Roger", managerFromDataBaseNotNull.getNom());

    }

    @Test
    public void testFindByName(){
        Manager newManager = new Manager();
        newManager.setNom("JeanJean");
        Manager savedManager = managerDao.save(newManager);

        List<Manager> managersDontLeNomVautJeanJean = managerDao.findByNom("JeanJean");

        Assertions.assertEquals(1, managersDontLeNomVautJeanJean.size());

    }

    @Test
    public void testFindPourAugmentation(){

        //Given
        Manager robert = new Manager();
        robert.setPrenom("Robert");
        robert.setSalaire(10_000);
        managerDao.save(robert);

        Manager barnabe = new Manager();
        barnabe.setPrenom("Barnabe");
        barnabe.setSalaire(5_000);
        managerDao.save(barnabe);

        //When
        List<Manager> resultats = managerDao.findManagerPourAugmentation("Robert", 3_000);
        //Then
        Assertions.assertEquals(0, resultats.size());

        //When
        resultats = managerDao.findManagerPourAugmentation("Robert", 5_000);
        //Then
        Assertions.assertEquals(0, resultats.size());

        //When
        resultats = managerDao.findManagerPourAugmentation("Robert", 7_000);
        //Then
        Assertions.assertEquals(1, resultats.size());

        //When
        resultats = managerDao.findManagerPourAugmentation("Robert", 11_000);
        //Then
        Assertions.assertEquals(1, resultats.size());

    }

}
