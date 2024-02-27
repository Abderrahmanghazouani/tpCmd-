package com.example.tpcmd.dao;


import com.example.tpcmd.bean.TypePaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePaimDao extends JpaRepository<TypePaiement,Long> {
    TypePaiement findByCode(String code);
    int deleteByCode(String code);




}
