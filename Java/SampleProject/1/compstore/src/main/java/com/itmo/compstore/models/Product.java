package com.itmo.compstore.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productGroup_id", referencedColumnName = "id")
    private ProductGroups productGroup;

    @NotEmpty(message = "Title can't be empty")
    @Size(min = 2, max = 150, message = "Title must be between 2 and 150 symbols")
    @Column(name = "title")
    private  String title;

    @Column(name = "Spec")
    private String Spec;

    @Column(name = "weight")
    private double weight;

    @Column(name = "size")
    private String size;



}
