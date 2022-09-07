package com.itmo.compstore.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
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
    private String descr;

    @OneToMany(mappedBy = "productGroup")
    private List<Product> product;

    public ProductGroups(String title, String descr) {
        this.title = title;
        this.descr = descr;
    }
}
