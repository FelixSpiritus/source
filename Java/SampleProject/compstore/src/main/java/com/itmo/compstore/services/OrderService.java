package com.itmo.compstore.services;

import com.itmo.compstore.models.Orders;
import com.itmo.compstore.models.OrdersSummView;
import com.itmo.compstore.models.SalesView;
import com.itmo.compstore.repositories.OrderRepository;
import com.itmo.compstore.repositories.OrdersSummViewRepository;
import com.itmo.compstore.repositories.SalesViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;
    private final SalesViewRepository salesViewRepository;

    public final OrdersSummViewRepository ordersSummViewRepository;

    public List<Orders> findAll() {
        return orderRepository.findAll();
    }

    public Orders findOne(Long id) {
        Optional<Orders> foundOrder = orderRepository.findById(id);
        return foundOrder.orElse(null);
    }

    public List<SalesView> findSoldProducts(){
        return salesViewRepository.soldProducts();
    }

    public List<SalesView> findSoldProductsOrder(Long id){
        return salesViewRepository.soldProductsOrder(id);
    }

    public Double findOrderSum(Long id) {
        try{
            return ordersSummViewRepository.OrderTotal(id).getTotal();
        } catch (Exception e){
            return .0;
        }

    }

    public List<OrdersSummView> findOrdersSum() {
        return ordersSummViewRepository.OrdersTotal();
    }

    @Transactional
    public void save(Orders order) {
        orderRepository.save(order);
    }

    @Transactional
    public void update(Long id, Orders updatedOrder) {
        updatedOrder.setId(id);
        orderRepository.save(updatedOrder);
    }

    @Transactional
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}