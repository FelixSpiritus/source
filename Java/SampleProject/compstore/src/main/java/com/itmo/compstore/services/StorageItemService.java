package com.itmo.compstore.services;

import com.itmo.compstore.models.StorageItems;
import com.itmo.compstore.repositories.StorageItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;



@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class StorageItemService {

    private final StorageItemRepository storageItemRepository;

    public List<StorageItems> findAll() {
        return storageItemRepository.findAll();
    }

    public StorageItems findOne(Long id) {
        Optional<StorageItems> foundStorageItem = storageItemRepository.findById(id);
        return foundStorageItem.orElse(null);
    }

    @Transactional
    public void save(StorageItems storageItem) {
        storageItemRepository.save(storageItem);
    }

    @Transactional
    public void update(Long id, StorageItems updatedStorageItem) {
        updatedStorageItem.setId(id);
        storageItemRepository.save(updatedStorageItem);
    }

    @Transactional
    public void delete(Long id) {
        storageItemRepository.deleteById(id);
    }
}