package com.bigcorp.stock.correction.dao;

import com.bigcorp.stock.correction.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ManagerDao extends CrudRepository<Manager, Long>{

    public List<Manager> findByNom(String nom);

    public Set<Manager> findByPoids(Integer poids);

    public List<Manager> findByNomAndPoidsOrderByPoidsDesc(String nom, Integer poids);

    @Query("select m from Manager m where m.prenom != :prenom and m.salaire is not null and m.salaire < :salaire ")
    public List<Manager> findManagerPourAugmentation(@Param("prenom") String prenom, @Param("salaire") Integer salaire);

}