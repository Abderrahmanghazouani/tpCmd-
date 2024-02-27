package com.example.tpcmd.service.facade;

import com.example.tpcmd.bean.TypePaiement;

public interface TypePaiementService  {

    TypePaiement findByCode(String code);

    int deleteByCode(String code);

    int save(TypePaiement typePaiement);
}
