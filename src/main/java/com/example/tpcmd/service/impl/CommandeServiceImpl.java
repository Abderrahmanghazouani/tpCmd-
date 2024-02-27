package com.example.tpcmd.service.impl;


import com.example.tpcmd.bean.Commande;
import com.example.tpcmd.dao.CommandeDao;
import com.example.tpcmd.service.facade.CommandeService;
import com.example.tpcmd.service.facade.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeDao commandeDao;

    //pour la ques:5
    @Autowired
    private PaiementService paiementService;

    /* 2.	Ecrire le service: Commande findByRef(String ref)*/
    @Override
    public Commande findByRef(String ref) {
        return commandeDao.findByRef(ref);
    }




    //5.	Ecrire un service int  deleteByRef(String ref) qui permet de supprimer une commande avec ses paiement
    @Override
    @Transactional
    public int deleteByRef(String ref) {
        int res1 = paiementService.deleteByCommandeRef(ref);
        int res2 = commandeDao.deleteByRef(ref);
        return res1 + res2;// le nbr de paiment supprime et les cmd supprime
    }


    @Override
    public void update(Commande commande) {
        if (findByRef(commande.getRef()) != null) {
            commandeDao.save(commande);
        }
    }
    // 6- 	Ecrire un service List< Commande > findNonPaye() qui permet
    // de consulter la liste des commandes non payées (montantTotal > montantPayeEspece +montantPayeCheque) : C'est une requete (query).
    @Override
    public List<Commande> findNonPaye() {
        return commandeDao.findNonPaye();
    }
}
