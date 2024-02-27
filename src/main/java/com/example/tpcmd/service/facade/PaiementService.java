package com.example.tpcmd.service.facade;

import com.example.tpcmd.bean.Paiement;

import java.util.List;

public interface PaiementService {

    // 3.	Ecrire le service: Paiement findByRef (String ref)
    Paiement findByCode(String code);

    int deleteByCode(String code);

    int deleteByCommandeRef(String ref);

    List<Paiement> findByCommandeRef(String ref);

    int save(Paiement paiment);

    // 7.	Ecrire un service int encaisser (String  codePaiement) qui permet d’encaisser un paiement.
    // 1-Trouver le paiement en se basant sur le code. (Sinon -1)
    // 2-Vérifier que le paiement est de type chèque. (Sinon -2)
    // 3-Vérifier que le paiement est non encaissé. (Sinon -3)
    // 4-sinon: (i) update le paiement(encaisement = true), (ii) update la commande
    // (montantPayeCheque-=montant & montantPayeEspece+=montant)
    int encaisser(String codePaiment);
}
