package com.itmo.compstore.services;

import com.itmo.compstore.models.Supplier;
import com.itmo.compstore.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public Supplier findOne(Long id) {
        Optional<Supplier> foundSupplier = supplierRepository.findById(id);
        return foundSupplier.orElse(null);
    }

    @Transactional
    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Transactional
    public void update(Long id, Supplier updatedSupplier) {
        updatedSupplier.setId(id);
        supplierRepository.save(updatedSupplier);
    }

    @Transactional
    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }
}