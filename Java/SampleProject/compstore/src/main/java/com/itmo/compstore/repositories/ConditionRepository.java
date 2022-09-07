package com.itmo.compstore.repositories;

import com.itmo.compstore.models.Conditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConditionRepository extends JpaRepository<Conditions, Integer> {

}