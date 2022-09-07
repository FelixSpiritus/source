package com.compshop.repo;

import com.compshop.models.ProductGroups;
import org.springframework.data.repository.CrudRepository;

public interface ProductGroupRepository extends CrudRepository<ProductGroups, Long> {
}
