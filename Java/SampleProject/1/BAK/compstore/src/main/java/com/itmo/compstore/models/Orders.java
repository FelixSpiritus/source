package com.itmo.compstore.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
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

    @NotNull(message = "Customer required")
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @NotNull(message = "Responsible person required")
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @NotNull(message = "Receipt date date can't be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "receiptdate")
    private LocalDate receiptdate;

    @Column(name = "shipdate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate shipdate;

    @NotNull(message = "Conditions required")
    @ManyToOne
    @JoinColumn(name = "condition_id", referencedColumnName = "id")
    private Conditions condition;

    public Orders(Customer customer, Person person, LocalDate receiptdate, LocalDate shipdate, Conditions condition) {
        this.customer = customer;
        this.person = person;
        this.receiptdate = receiptdate;
        this.shipdate = shipdate;
        this.condition = condition;
    }
}
