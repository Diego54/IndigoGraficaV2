package com.indigoGrafica.controllers;

import com.indigoGrafica.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class MailController {
    @Autowired
    protected MailService mailService;

    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public List<Long> send(){
        try {
            mailService.send();
        } catch (MessagingException e) {
            Logger.getLogger("Se rompio todo a la mierda").log(Level.SEVERE, e.toString()); ;
        }
        return new ArrayList<Long>();
    }
}
