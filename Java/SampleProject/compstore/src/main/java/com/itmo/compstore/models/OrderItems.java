package com.itmo.compstore.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "OrderItems")
public class OrderItems {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Field required")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "storageItems_id", referencedColumnName = "id")
    private StorageItems storageItems;

    @NotNull(message = "Sale price can't be empty")
    @Column(name = "saleprice")
    private Double price;

    @NotNull(message = "Product can't be empty")
    @Column(name = "qtyinorder")
    private Integer quantity;

    @NotNull(message = "Order required")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Orders order;

    public OrderItems(StorageItems storageItems, Double price, Integer quantity, Orders order) {
        this.storageItems = storageItems;
        this.price = price;
        this.quantity = quantity;
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "id=" + id +
                ", storageItems=" + storageItems.getId() +
                ", price=" + price +
                ", quantity=" + quantity +
                ", order=" + order.getId() +
                '}';
    }
}
