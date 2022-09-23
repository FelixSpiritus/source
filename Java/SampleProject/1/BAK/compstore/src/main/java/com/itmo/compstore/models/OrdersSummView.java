package com.itmo.compstore.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Immutable
@Table(name = "OrdersSum")
public class OrdersSummView {
    @Id
    private Long order_id;
    private Double total;
}
