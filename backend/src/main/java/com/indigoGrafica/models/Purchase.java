package com.indigoGrafica.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "purchase")
@Access(AccessType.FIELD)
public class Purchase extends ParentEntity{


    private static final long serialVersionUID = -8334865503694319942L;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
    @JoinColumn(name = "owner", referencedColumnName = "id")
    private Person owner;

    @Column(name = "date", columnDefinition = "date")
    private Date date;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchase", fetch = FetchType.LAZY)
    private List<Item> items;

    @Transient
    public Double total= 0.0;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}