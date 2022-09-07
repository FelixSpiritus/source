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
@Table(name = "Orders")
public class Orders {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @NotEmpty(message = "Receipt date date can't be empty")
    @Column(name = "receiptdate")
    private Date receiptdate;

    @Column(name = "shipdate")
    private Date shipdate;

    @NotNull(message = "Conditions required")
    @ManyToOne
    @JoinColumn(name = "condition_id", referencedColumnName = "id")
    private Conditions condition;

    public Orders(Customer customer, Person person, Date receiptdate, Date shipdate, Conditions condition) {
        this.customer = customer;
        this.person = person;
        this.receiptdate = receiptdate;
        this.shipdate = shipdate;
        this.condition = condition;
    }
}
