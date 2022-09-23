package com.itmo.compstore.models;

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
@Table(name = "StorageItems")
public class StorageItems {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Storage required")
    @ManyToOne
    @JoinColumn(name = "storage_id", referencedColumnName = "id")
    private Storage storage;

    @NotNull(message = "Supply required")
    @ManyToOne
    @JoinColumn(name = "supply_id", referencedColumnName = "id")
    private Supply supply;

    @NotNull(message = "Quantity can't be empty")
    @Column(name = "qtyinstorage")
    private Integer qtyinstorage;

    public StorageItems(Storage storage, Supply supply, Integer qtyinstorage) {
        this.storage = storage;
        this.supply = supply;
        this.qtyinstorage = qtyinstorage;
    }

}