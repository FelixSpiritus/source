package com.itmo.compstore.services;

import com.itmo.compstore.models.Conditions;
import com.itmo.compstore.models.Storage;
import com.itmo.compstore.repositories.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class StorageService {

    private final StorageRepository storageRepository;

    public List<Storage> findAll() {
        return storageRepository.findAll();
    }

    public Storage findOne(Integer id) {
        Optional<Storage> foundStorage = storageRepository.findById(id);
        return foundStorage.orElse(null);
    }

    @Transactional
    public void save(Storage condition) {
        storageRepository.save(condition);
    }

    @Transactional
    public void update(Integer id, Storage updatedStorage) {
        updatedStorage.setId(id);
        storageRepository.save(updatedStorage);
    }

    @Transactional
    public void delete(Integer id) {
        storageRepository.deleteById(id);
    }
}
