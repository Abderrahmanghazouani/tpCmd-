package com.example.tpcmd.bean;

import jakarta.persistence.*;

import java.util.List;


@Entity
    public class Commande {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)

        private long id;
        private String ref;
        private double total;
        private double totalPay;
        double montantPayeCheque;
        double montantPayeEspece;

       /* @OneToMany(mappedBy = "commande")
        private List<Paiement> paiments;*/

        public double getMontantPayeCheque() {
            return montantPayeCheque;
        }

        public void setMontantPayeCheque(double montantPayeCheque) {
            this.montantPayeCheque = montantPayeCheque;
        }

        public double getMontantPayeEspece() {
            return montantPayeEspece;
        }

        public void setMontantPayeEspece(double montantPayeEspece) {
            this.montantPayeEspece = montantPayeEspece;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public double getTotalPay() {
            return totalPay;
        }

        public void setTotalPay(double totalPay) {
            this.totalPay = totalPay;
        }
    }

