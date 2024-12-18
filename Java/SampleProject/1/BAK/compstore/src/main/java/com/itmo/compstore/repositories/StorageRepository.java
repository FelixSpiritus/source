package com.itmo.compstore.repositories;

import com.itmo.compstore.models.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StorageRepository extends JpaRepository<Storage, Integer> {

}