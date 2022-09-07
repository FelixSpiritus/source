package com.itmo.compstore.repositories;

import com.itmo.compstore.models.ProductGroups;
import org.springframework.data.repository.CrudRepository;

public interface ProductGroupRepository extends CrudRepository<ProductGroups, Long> {
}
