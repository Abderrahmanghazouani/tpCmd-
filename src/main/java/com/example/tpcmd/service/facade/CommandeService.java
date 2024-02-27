package com.example.tpcmd.service.facade;

import com.example.tpcmd.bean.Commande;

import java.util.List;

public interface CommandeService {
    Commande findByRef(String ref);


    int deleteByRef(String ref);



    void update(Commande commande);

    // 6- 	Ecrire un service List< Commande > findNonPaye() qui permet
    // de consulter la liste des commandes non payées (montantTotal > montantPayeEspece +montantPayeCheque).
    List<Commande> findNonPaye();
}
