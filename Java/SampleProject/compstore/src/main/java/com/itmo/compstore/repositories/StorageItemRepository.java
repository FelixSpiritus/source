package com.itmo.compstore.repositories;

import com.itmo.compstore.models.StorageItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageItemRepository extends JpaRepository<StorageItems, Long> {
}
