package com.itmo.compstore.repositories;

import com.itmo.compstore.models.ProductGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductGroupRepository extends JpaRepository<ProductGroups, Long> {

}


