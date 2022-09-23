package com.itmo.compstore.repositories;


import com.itmo.compstore.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    List<Product> findProductsByProductGroupIdOrderByTitle(Long id);
//
//    @Query("SELECT s.product FROM Supply as s JOIN StorageItems as si ON s.id = si.supply.id where si.qtyinstorage > 0")
//    List<Product> productsInStock();

}