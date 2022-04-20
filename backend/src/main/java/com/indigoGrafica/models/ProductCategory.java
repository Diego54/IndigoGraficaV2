package com.indigoGrafica.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_category")
@Access(AccessType.FIELD)
public class ProductCategory extends ParentEntity{

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
