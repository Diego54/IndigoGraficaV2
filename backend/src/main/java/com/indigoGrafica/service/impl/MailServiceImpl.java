package com.indigoGrafica.service.impl;

import com.indigoGrafica.models.Purchase;
import com.indigoGrafica.service.MailService;
import com.indigoGrafica.util.MailContentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.inject.Inject;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import java.util.Locale;
import java.util.Properties;

@Service
public class MailServiceImpl implements MailService{

    @Qualifier("getJavaMailSender")
    public JavaMailSender emailSender;

    @Autowired
    MailContentBuilder mailContentBuilder;

    @Override
    public void send() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo("d.caminos54@gmail.com");
        helper.setSubject("Email Test");
        helper.setText("",true);


        emailSender.send(message);
    }

    @Override
    public void send(Purchase purchase) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo("d.caminos54@gmail.com");
        helper.setSubject("Nueva solicitud de " +purchase.getOwner().getFirstName() + " " + purchase.getOwner().getLastName());
        String body = mailContentBuilder.build(purchase);
        helper.setText(body,true); //TODO html here!
        addAttachment(helper,purchase);
        emailSender.send(message);
    }

    private void addAttachment(MimeMessageHelper helper, Purchase purchase) {
        purchase.getItems().forEach( item -> {
            InputStreamSource attachmentSource = new ByteArrayResource(item.getDesign());
            DataSource dataSource = new ByteArrayDataSource(item.getDesign(), "application/png");
            try {
                helper.addAttachment("imagen_item_" + item.getId() + ".png", dataSource);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void send(Purchase purchase, String template) {

    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("indigo.grafica.tip@gmail.com");
        mailSender.setPassword("indigotip");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

}