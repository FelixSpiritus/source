package com.itmo.compstore.repositories;

import com.itmo.compstore.models.ProductsInStockView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockViewRepository extends ReadOnlyRepository<ProductsInStockView, Long>{

    @Query(nativeQuery = true, value="select sti.id stitemid, p.product_group_id, pg.title pgtitle, product_id," +
            " p.title ptitle, storage_id, st.title sttitle, pricein,pricewh, priceret, qtyinstorage from product p\n" +
            "    join product_groups pg on pg.id = p.product_group_id\n" +
            "    join supply s on p.id = s.product_id\n" +
            "    join storage_items sti on s.id = sti.supply_id\n" +
            "    join storage st on st.id = sti.storage_id\n" +
            "    where qtyinstorage > 0")
    List<ProductsInStockView> productsInStock();

    @Query(nativeQuery = true, value="select sti.id stitemid, p.product_group_id, pg.title pgtitle, product_id," +
            " p.title ptitle, storage_id, st.title sttitle, pricein,pricewh, priceret, qtyinstorage from product p\n" +
            "    join product_groups pg on pg.id = p.product_group_id\n" +
            "    join supply s on p.id = s.product_id\n" +
            "    join storage_items sti on s.id = sti.supply_id\n" +
            "    join storage st on st.id = sti.storage_id\n" +
            "    where qtyinstorage > 0 and product_group_id=?1")
    List<ProductsInStockView> productsInStockGroup(Long id);

    @Query(nativeQuery = true, value="select sti.id stitemid, p.product_group_id, pg.title pgtitle, product_id," +
            " p.title ptitle, storage_id, st.title sttitle, pricein,pricewh, priceret, qtyinstorage from product p\n" +
            "    join product_groups pg on pg.id = p.product_group_id\n" +
            "    join supply s on p.id = s.product_id\n" +
            "    join storage_items sti on s.id = sti.supply_id\n" +
            "    join storage st on st.id = sti.storage_id\n" +
            "    where qtyinstorage > 0 and product_id=?1")
    List<ProductsInStockView> productsInStockProduct(Long id);

}
