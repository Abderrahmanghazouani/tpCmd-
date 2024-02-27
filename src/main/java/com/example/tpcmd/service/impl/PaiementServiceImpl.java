package com.example.tpcmd.service.impl;

import com.example.tpcmd.bean.Commande;
import com.example.tpcmd.bean.Paiement;
import com.example.tpcmd.bean.TypePaiement;
import com.example.tpcmd.dao.PaiementDao;
import com.example.tpcmd.service.facade.CommandeService;
import com.example.tpcmd.service.facade.PaiementService;
import com.example.tpcmd.service.facade.TypePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementServiceImpl implements PaiementService {

    @Autowired
    private PaiementDao paiementDao;

    // juste service parle avec un autre service
    @Autowired
    private CommandeService commandeService;

    @Autowired
    private TypePaiementService typePaiementService;

    // 3.Ecrire le service: Paiement findByCode (String ref)
    @Override
    public Paiement findByCode(String code) {
        return paiementDao.findByCode(code);
    }

    @Override
    public int deleteByCode(String code) {
        return paiementDao.deleteByCode(code);
    }

    @Override
    public int deleteByCommandeRef(String ref) {
        return paiementDao.deleteByCommandeRef(ref);
    }

    @Override
    public List<Paiement> findByCommandeRef(String ref) {
        return paiementDao.findByCommandeRef(ref);
    }



   /* 4.Ecrire un service int save(String crefCommande, Paiement paiement) qui permet de réaliser le paiement d’une commande :
            ●	Trouver la commande en se basant sur le ref. (Sinon -1)
            ●	Le montantPayeEspece + montantPayeCheque + montant du paiement ne doit pas dépasser le montant total de la commande. (Sinon -2)
            ●	Verifier que le code de type de paiement est soit espece ou cheque(Sinon -3)
            ● 	Sinon (i) save le paiement,
            (ii) modifier la commande ( si paiement.typePaiement .code = espece ⇒ montantPayeEspece += paiement.montant ;
            si paiement.typePaiement .code = cheque⇒ montantPayeCheque += paiement.montant )*/


    @Override  //redefinition
    public int save(Paiement paiment) { // supprimer String refCommane car a l'int de paiment il existe commande et a lin de cmd il y a ref

        // pour eviter exeption : save the transient instanse
        //1-cle etrangere :cmd
        String ref = paiment.getCommande().getRef();
        Commande commande = commandeService.findByRef(ref);
        paiment.setCommande(commande);

        //2-cle etrangere: type paiment
        TypePaiement typePaiement = typePaiementService.findByCode(paiment.getTypePaiement().getCode());
        paiment.setTypePaiement(typePaiement);


        if (commande == null) {
            return -1;
        } else if (commande.getMontantPayeEspece() + commande.getMontantPayeCheque() + paiment.getMontant() > commande.getTotal()) {
            return -2;
        } else if (paiment.getTypePaiement() == null || !paiment.getTypePaiement().getCode().equals("espece") && !paiment.getTypePaiement().getCode().equals("cheque")) {
            return -3;
        } else {
            paiementDao.save(paiment);
            String codeTypePaiment = paiment.getTypePaiement().getCode();
            if (paiment.getTypePaiement().getCode().equals("espece")) {
                commande.setMontantPayeEspece(commande.getMontantPayeEspece() + paiment.getMontant());
            } else {
                commande.setMontantPayeEspece(commande.getMontantPayeEspece() + paiment.getMontant());
            }
            commandeService.update(commande);
            return 1;
        }


    }

    // 7.	Ecrire un service int encaisser (String  codePaiement) qui permet d’encaisser un paiement.
    // 1-Trouver le paiement en se basant sur le code. (Sinon -1)
    // 2-Vérifier que le paiement est de type chèque. (Sinon -2)
    // 3-Vérifier que le paiement est non encaissé. (Sinon -3)
    // 4-sinon: (i) update le paiement(encaisement = true), (ii) update la commande
    // (montantPayeCheque-=montant & montantPayeEspece+=montant)
@Override
    public int encaisser(String codePaiment) {
        Paiement paiement= paiementDao.findByCode(codePaiment);
        if (paiement == null) {
            return -1;
        } else if (paiement.getTypePaiement() == null || !paiement.getTypePaiement().getCode().equals("cheque")) {
            return -2;
        } else if (paiement.isEncaissement()==true) {
            return -3;
        }else {
           paiement.setEncaissement(true);
           paiementDao.save(paiement);

            Commande commande = paiement.getCommande();// appel de l'obj commande mn BD kaml mashi hi id
            commande.setMontantPayeCheque(commande.getMontantPayeCheque()-paiement.getMontant());
            commande.setMontantPayeEspece(commande.getMontantPayeEspece()+paiement.getMontant());
            commandeService.update(commande);
            return 1;
        }

    }
}




