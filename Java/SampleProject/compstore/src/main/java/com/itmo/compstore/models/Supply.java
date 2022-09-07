package com.itmo.compstore.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Supply")
public class Supply {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Supplier required")
    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;

    @NotEmpty(message = "Supply date can't be empty")
    @Column(name = "supplydate")
    private Date supplydate;

    @NotNull(message = "Product required")
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @NotEmpty(message = "Quantity can't be empty")
    @Column(name = "quantity")
    private Integer quantity;

    @NotEmpty(message = "Purchase price can't be empty")
    @Column(name = "pricein")
    private Double pricein;

    @NotEmpty(message = "Wholesale price can't be empty")
    @Column(name = "pricewh")
    private Double pricewh ;

    @NotEmpty(message = "Retail price can't be empty")
    @Column(name = "priceret")
    private Double priceret;

    @NotNull(message = "Person required")
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    public Supply(Supplier supplier, Date supplydate, Product product, Integer quantity, Double pricein, Double pricewh, Double priceret, Person person) {
        this.supplier = supplier;
        this.supplydate = supplydate;
        this.product = product;
        this.quantity = quantity;
        this.pricein = pricein;
        this.pricewh = pricewh;
        this.priceret = priceret;
        this.person = person;
    }
}
