package com.bigcorp.stock.correction.dao;

import com.bigcorp.stock.correction.model.Manager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ManagerDao extends CrudRepository<Manager, Long>{

    /**
     * Recherche tous les managers par leur nom
     */
    public List<Manager> findByNom(String nom);

    /**
     * Recherche tous les managers par leur email
     */
    List<Manager> findByEmail(String email);

    /**
     * Recherche tous les managers par leur nom, en ne tenant pas compte de la casse
     */
    public List<Manager> findByNomIgnoreCase(String nom);

    /**
     * Recherche tous les managers par leur nom, en ne tenant pas compte de la casse
     */
    public List<Manager> findByNomContainingIgnoreCase(String nom);

    /**
     * Recherche tous les managers par leur poids
     */
    public Set<Manager> findByPoids(Integer poids);

    /**
     * Recherche tous les managers par leur nom, et leur poids, en triant par poids décroissant
     */
    public List<Manager> findByNomAndPoidsOrderByPoidsDesc(String nom, Integer poids);

    /**
     * Recherche tous les managers par nom de l'équipe
     */
    public List<Manager> findByTeamNom(String nom);

    /**
     * Recherche tous les managers éligibles à une augmentation
     */
    @Query("select m from Manager m where m.prenom != :prenom and m.salaire is not null and m.salaire < :salaire order by salaire desc ")
    public List<Manager> findPourAugmentation(@Param("prenom") String prenom, @Param("salaire") Integer salaire);

    @Query("select m from Manager m where upper(nom) like upper('%' || :nom || '%') ")
    public List<Manager> findByNomLike(@Param("nom") String nom);
}