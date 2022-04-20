package com.indigoGrafica.service.impl;

import com.indigoGrafica.models.Item;
import com.indigoGrafica.models.Person;
import com.indigoGrafica.models.Purchase;
import com.indigoGrafica.repository.PurchaseRepository;
import com.indigoGrafica.service.PersonService;
import com.indigoGrafica.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    PersonService personService;

    @Override
    public Purchase save(Purchase purchase) {
        Person p = personService.findByCuit(purchase.getOwner().getCuit());
        if(p != null){
            /*Logger.getLogger("COSO::").log(Level.INFO,"Se Encontro la persona con cuit " + p.getCuit() + " e Id " + p.getId());*/
            p.assign(purchase.getOwner());
            purchase.setOwner(p);
        }
        return purchaseRepository.save(purchase);
    }

}