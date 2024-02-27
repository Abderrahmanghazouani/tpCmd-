package com.example.tpcmd.ws.facade;


import com.example.tpcmd.bean.Paiement;
import com.example.tpcmd.service.facade.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/paiement/")
public class FacadePaiement {
    @Autowired
    private PaiementService paiementService;

    @GetMapping("code/{code}")
    public Paiement findByCode(@PathVariable String code) {
        return paiementService.findByCode(code);
    }

    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return paiementService.deleteByCode(code);
    }

    @DeleteMapping("commande/ref/{ref}")
    public int deleteByCommandeRef(@PathVariable String ref) {
        return paiementService.deleteByCommandeRef(ref);
    }

    @GetMapping("commande/ref/{ref}")
    public List<Paiement> findByCommandeRef(@PathVariable String ref) {
        return paiementService.findByCommandeRef(ref);
    }

    @PostMapping
    public int save(@RequestBody Paiement paiment) {
        return paiementService.save(paiment);
    }

  @PutMapping("encaisser/code/{code}")
    public int encaisser(@PathVariable String codePaiment) {
        return paiementService.encaisser(codePaiment);
    }

}
