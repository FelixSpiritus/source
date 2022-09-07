package com.itmo.compstore.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ProductGroups")
public class ProductGroups {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Title can't be empty")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 symbols")
    @Column(name = "title")
    private  String title;

    @Column(name = "descr")
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
