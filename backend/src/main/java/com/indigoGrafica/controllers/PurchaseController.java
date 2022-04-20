package com.indigoGrafica.controllers;

import com.indigoGrafica.models.Item;
import com.indigoGrafica.models.Purchase;
import com.indigoGrafica.service.MailService;
import com.indigoGrafica.service.PurchaseService;
import com.indigoGrafica.util.RestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class PurchaseController {

    @Inject
    protected MailService mailService;

    @Inject
    protected PurchaseService purchaseService;

    @Inject
    protected ObjectMapper objectMapper;

    @RequestMapping(value = "/purchase/request-operation", method = RequestMethod.POST)
    public RestResponse save(@RequestBody String purchaseJson) throws IOException {
        Purchase purchase = objectMapper.readValue(purchaseJson, Purchase.class);
        purchase.getItems().forEach(item -> item.setPurchase(purchase));
        Purchase purchaseStored = purchaseService.save(purchase);
        try {
            purchaseStored.getItems().forEach(item -> purchaseStored.total += item.getProduct().getPrice());
            mailService.send(purchaseStored);
        } catch (MessagingException e) {
            return new RestResponse(HttpStatus.OK.value(), "No fue posible ");
        }
        return new RestResponse(HttpStatus.OK.value(), "Su solicitud fue enviada. Su numero de operacion es: " + purchaseStored.getId());
    }
}
