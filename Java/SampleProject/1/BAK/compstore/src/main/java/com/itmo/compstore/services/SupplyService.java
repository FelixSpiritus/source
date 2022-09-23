package com.itmo.compstore.services;

import com.itmo.compstore.models.Supply;
import com.itmo.compstore.repositories.SupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class SupplyService {

    private final SupplyRepository supplyRepository;

    public List<Supply> findAll() {
        return supplyRepository.findAll();
    }

    public Supply findOne(Long id) {
        Optional<Supply> foundSupply = supplyRepository.findById(id);
        return foundSupply.orElse(null);
    }

    @Transactional
    public void save(Supply supply) {
        supplyRepository.save(supply);
    }

    @Transactional
    public void update(Long id, Supply updatedSupply) {
        updatedSupply.setId(id);
        supplyRepository.save(updatedSupply);
    }

    @Transactional
    public void delete(Long id) {
        supplyRepository.deleteById(id);
    }
}