package com.itmo.compstore.repositories;

import com.itmo.compstore.models.SalesView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesViewRepository extends ReadOnlyRepository<SalesView, Long>{

    @Query(nativeQuery = true, value="select ordi.id orditemid, sti.id stitemid, p.product_group_id, pg.title pgtitle, product_id," +
            " p.title ptitle, storage_id, st.title sttitle, pricein,pricewh, priceret, saleprice, qtyinstorage, qtyinorder, order_id from product p" +
            "    join product_groups pg on pg.id = p.product_group_id" +
            "    join supply s on p.id = s.product_id" +
            "    join storage_items sti on s.id = sti.supply_id" +
            "    join storage st on st.id = sti.storage_id" +
            "    join order_items ordi on sti.id=ordi.storage_items_id" +
            "    where qtyinorder > 0")
    List<SalesView> soldProducts();

    @Query(nativeQuery = true, value="select ordi.id orditemid, sti.id stitemid, p.product_group_id, pg.title pgtitle, product_id," +
            " p.title ptitle, storage_id, st.title sttitle, pricein,pricewh, priceret, saleprice, qtyinstorage, qtyinorder, order_id from product p" +
            "    join product_groups pg on pg.id = p.product_group_id" +
            "    join supply s on p.id = s.product_id" +
            "    join storage_items sti on s.id = sti.supply_id" +
            "    join storage st on st.id = sti.storage_id" +
            "    join order_items ordi on sti.id=ordi.storage_items_id" +
            "    where qtyinorder > 0 and order_id=?1")
    List<SalesView> soldProductsOrder(Long id);
}
