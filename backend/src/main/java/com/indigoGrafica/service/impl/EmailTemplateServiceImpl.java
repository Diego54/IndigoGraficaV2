package com.indigoGrafica.service.impl;

import com.indigoGrafica.models.EmailTemplate;
import com.indigoGrafica.repository.EmailTemplateRepository;
import com.indigoGrafica.service.EmailTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailTemplateServiceImpl implements EmailTemplateService {

    @Autowired
    EmailTemplateRepository emailTemplateRepository;


    @Override
    public EmailTemplate findByKey(String key) { return emailTemplateRepository.findByKey(key);}
}
