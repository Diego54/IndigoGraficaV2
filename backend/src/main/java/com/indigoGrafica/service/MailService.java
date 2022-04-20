package com.indigoGrafica.service;

import com.indigoGrafica.models.Purchase;

import javax.mail.MessagingException;

public interface MailService {

    void send() throws MessagingException;
    void send(Purchase purchase) throws MessagingException;
    void send(Purchase purchase, String template);
}
