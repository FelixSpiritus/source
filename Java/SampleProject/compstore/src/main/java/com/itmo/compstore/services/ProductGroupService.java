package com.itmo.compstore.services;

import com.itmo.compstore.models.ProductGroups;
import com.itmo.compstore.repositories.ProductGroupRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ProductGroupService {

    private final ProductGroupRepository productGroupRepository;

    public List<ProductGroups> findAll() {
        return productGroupRepository.findAll();
    }

    public ProductGroups findOne(Long id) {
        Optional<ProductGroups> foundProductGroup = productGroupRepository.findById(id);
        return foundProductGroup.orElse(null);
    }

    @Transactional
    public void save(ProductGroups productGroup) {
        productGroupRepository.save(productGroup);
    }

    @Transactional
    public void update(Long id, ProductGroups updatedProductGroup) {
        updatedProductGroup.setId(id);
        productGroupRepository.save(updatedProductGroup);
    }

    @Transactional
    public void delete(Long id) {
        productGroupRepository.deleteById(id);
    }
}
