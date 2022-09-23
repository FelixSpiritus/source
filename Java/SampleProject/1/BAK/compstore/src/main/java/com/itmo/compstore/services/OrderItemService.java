package com.itmo.compstore.services;

import com.itmo.compstore.models.Customer;
import com.itmo.compstore.models.OrderItems;
import com.itmo.compstore.models.StorageItems;
import com.itmo.compstore.repositories.OrderItemRepository;
import com.itmo.compstore.repositories.StorageItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final StorageItemRepository storageItemRepository;
    private final StorageItemService storageItemService;

    public List<OrderItems> findAll() {
        return orderItemRepository.findAll();
    }

    public OrderItems findOne(Long id) {
        Optional<OrderItems> foundOrderItem = orderItemRepository.findById(id);
        return foundOrderItem.orElse(null);
    }

    @Transactional
    public void add(OrderItems orderItem) {
        orderItemRepository.save(orderItem);
        StorageItems storageItem = storageItemService.findOne(orderItem.getStorageItems().getId());
        storageItem.setQtyinstorage(storageItem.getQtyinstorage()-orderItem.getQuantity());
        storageItemRepository.save(storageItem);
    }

    @Transactional
    public void remove(OrderItems orderItem) {
        StorageItems storageItem = storageItemService.findOne(orderItem.getStorageItems().getId());
        storageItem.setQtyinstorage(storageItem.getQtyinstorage()+orderItem.getQuantity());
        orderItem.setQuantity(0);
        storageItemRepository.save(storageItem);
        orderItemRepository.save(orderItem);
    }

    @Transactional
    public void save(OrderItems orderItem) {
        orderItemRepository.save(orderItem);
    }

    @Transactional
    public void update(Long id, OrderItems updatedOrderItem) {
        updatedOrderItem.setId(id);
        orderItemRepository.save(updatedOrderItem);
    }

    @Transactional
    public void delete(Long id) {
        orderItemRepository.deleteById(id);
    }
}