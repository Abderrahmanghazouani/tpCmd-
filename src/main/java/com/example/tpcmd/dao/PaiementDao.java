package com.example.tpcmd.dao;

import com.example.tpcmd.bean.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Long> {
    Paiement findByCode(String code);
    int deleteByCode(String code);

    //ref(commande) ====== liste de paiement :: PaiementDao
    int deleteByCommandeRef(String ref);
    List <Paiement> findByCommandeRef(String ref);

}
