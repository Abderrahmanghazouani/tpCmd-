package com.example.tpcmd.service.impl;


import com.example.tpcmd.bean.TypePaiement;
import com.example.tpcmd.dao.TypePaimDao;
import com.example.tpcmd.service.facade.TypePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypePaimServiceImpl implements TypePaiementService {

    @Autowired
    private TypePaimDao typePaimDao;

    @Override
    public TypePaiement findByCode(String code) {
        return typePaimDao.findByCode(code);
    }

    @Override
    public int deleteByCode(String code) {
        return typePaimDao.deleteByCode(code);
    }

    // service de save Type paiement
    @Override
    public int save(TypePaiement typePaiement) {
        if (findByCode(typePaiement.getCode()) == null) {
            return -1;
        } else {
            typePaimDao.save(typePaiement);
            return 1;
        }

    }


}
