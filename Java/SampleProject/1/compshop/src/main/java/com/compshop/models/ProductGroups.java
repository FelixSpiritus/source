package com.compshop.models;

import javax.persistence.*;

@Entity
public class ProductGroups {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String title;
    private  String descr;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescr() {
        return descr;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public ProductGroups() {
    }

    public ProductGroups(String title, String descr) {
        this.title = title;
        this.descr = descr;
    }
}
