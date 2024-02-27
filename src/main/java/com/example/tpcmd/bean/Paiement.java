package com.example.tpcmd.bean;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private LocalDateTime datePaiement;
    private double montant;
    private boolean isEncaissement;

    @ManyToOne
    private TypePaiement  typePaiement ;

    @ManyToOne
    private Commande commande;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDateTime datePaiement) {
        this.datePaiement = datePaiement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public TypePaiement getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }

    public boolean isEncaissement() {
        return isEncaissement;
    }

    public void setEncaissement(boolean encaissement) {
        this.isEncaissement = encaissement;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}

