package com.itmo.compstore.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product group required")
    @ManyToOne
    @JoinColumn(name = "productGroup_id", referencedColumnName = "id")
    private ProductGroups productGroup;

    @NotEmpty(message = "Title can't be empty")
    @Size(min = 2, max = 150, message = "Title must be between 2 and 150 symbols")
    @Column(name = "title")
    private String title;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "country")
    private String country;

    @Column(name = "spec")
    private String spec;
    @DecimalMin(value = "0.0", message = "Weight must be 0 or above")
    @Column(name = "weight")
    private Double weight;

    @Column(name = "size")
    private String size;

    @OneToMany(mappedBy = "product")
    private List<Supply> supply;

    public Product(ProductGroups productGroup, String title, String manufacturer, String country, String spec, Double weight, String size) {
        this.productGroup = productGroup;
        this.title = title;
        this.manufacturer = manufacturer;
        this.country = country;
        this.spec = spec;
        this.weight = weight;
        this.size = size;
    }
}
