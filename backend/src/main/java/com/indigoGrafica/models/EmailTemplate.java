package com.indigoGrafica.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "emailtemplate")
public class EmailTemplate extends ParentEntity{

    @Column(name = "email_template_key", nullable = false, unique = true)
    private String key;

    @Column(name = "email_template_subject", nullable = false)
    private String subject;

    @Column(name = "email_template_body", nullable = false)
    private String body;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
