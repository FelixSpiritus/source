package com.itmo.compstore.services;

import com.itmo.compstore.models.Product;
import com.itmo.compstore.models.ProductsInStockView;
import com.itmo.compstore.repositories.ProductRepository;
import com.itmo.compstore.repositories.StockViewRepository;
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


    private final StockViewRepository stockViewRepository;


    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findOne(Long id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        return foundProduct.orElse(null);
    }

    public List<ProductsInStockView> findProductsInStock(){
        return stockViewRepository.productsInStock();
    }
    public List<ProductsInStockView> findProductsInStockGroup(Long id){
        return stockViewRepository.productsInStockGroup(id);
    }

    public List<ProductsInStockView> findProductsInStockProduct(Long id){
        return stockViewRepository.productsInStockProduct(id);
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
