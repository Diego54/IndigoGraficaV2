package com.indigoGrafica.util;

import com.indigoGrafica.models.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailContentBuilder {

    private TemplateEngine templateEngine;

    @Autowired
    public MailContentBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String build(Purchase purchase) {
        Context context = new Context();
        context.setVariable("purchase", purchase);
        return templateEngine.process("product-request-template.html", context);
    }

}