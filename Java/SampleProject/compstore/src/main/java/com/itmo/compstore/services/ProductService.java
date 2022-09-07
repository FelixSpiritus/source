package com.itmo.compstore.services;

import com.itmo.compstore.models.Product;
import com.itmo.compstore.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findOne(Long id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        return foundProduct.orElse(null);
    }

    @Transactional
    public void save(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void update(Long id, Product updatedProduct) {
        updatedProduct.setId(id);
        productRepository.save(updatedProduct);
    }

    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
