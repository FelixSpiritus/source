package com.itmo.compstore.services;

import com.itmo.compstore.models.Conditions;
import com.itmo.compstore.repositories.ConditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ConditionService {

    private final ConditionRepository conditionRepository;

    public List<Conditions> findAll() {
        return conditionRepository.findAll();
    }

    public Conditions findOne(Integer id) {
        Optional<Conditions> foundCondition = conditionRepository.findById(id);
        return foundCondition.orElse(null);
    }

    @Transactional
    public void save(Conditions condition) {
        conditionRepository.save(condition);
    }

    @Transactional
    public void update(Integer id, Conditions updatedCondition) {
        updatedCondition.setId(id);
        conditionRepository.save(updatedCondition);
    }

    @Transactional
    public void delete(Integer id) {
        conditionRepository.deleteById(id);
    }
}
