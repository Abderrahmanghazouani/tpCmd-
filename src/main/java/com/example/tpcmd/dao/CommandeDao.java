package com.example.tpcmd.dao;

import com.example.tpcmd.bean.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface CommandeDao extends JpaRepository<Commande, Long> {
        Commande findByRef(String ref);
        int deleteByRef(String ref);


    @Query(value = "SELECT item from Commande item where item.total<item.montantPayeCheque + item.montantPayeEspece") /*requete JPQl  , !Commande avec C majuscule(entite)*/
    //@Query(value = "Select * from commande where total < montantPayeCheque + montantPayeEspece" , nativeQuery = true) /*requete sql , ! commande avec c miniscule*/
        List<Commande> findNonPaye();
}
