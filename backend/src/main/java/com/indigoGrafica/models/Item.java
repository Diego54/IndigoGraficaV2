package com.indigoGrafica.models;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Access(AccessType.FIELD)
public class Item extends ParentEntity{
    private static final long serialVersionUID = 233248965914244935L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "design", columnDefinition = "BLOB")
    private byte[] design;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id", referencedColumnName = "id")
    private Purchase purchase;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public byte[] getDesign() {
        return design;
    }

    public void setDesign(byte[] design) {
        this.design = design;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
