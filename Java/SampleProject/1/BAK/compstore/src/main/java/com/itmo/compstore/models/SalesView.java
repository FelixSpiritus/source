package com.itmo.compstore.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
@Immutable
@Table(name = "Sales")
public class SalesView implements Serializable {
    @Id
    private Long orditemid;
    private Long stitemid;
    private Long product_group_id;
    private String pgtitle;
    private Long product_id;
    private String ptitle;
    private Integer storage_id;
    private String sttitle;
    private Double pricein;
    private Double pricewh;
    private Double priceret;
    private Double saleprice;
    private Integer qtyinstorage;
    private Integer qtyinorder;
    private Long order_id;

}
