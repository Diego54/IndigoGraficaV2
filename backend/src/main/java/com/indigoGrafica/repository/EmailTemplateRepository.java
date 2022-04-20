package com.indigoGrafica.repository;

import com.indigoGrafica.models.EmailTemplate;
import com.indigoGrafica.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplate,Long> {

    EmailTemplate findByKey(String key);
}