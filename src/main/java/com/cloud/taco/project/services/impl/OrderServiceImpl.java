package com.cloud.taco.project.services.impl;

import com.cloud.taco.project.domain.Order;
import com.cloud.taco.project.repositories.OrderRepository;
import com.cloud.taco.project.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Order Service
 * @author Michał Urbański
 */

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order save(Order object) {
        return repository.save(object);
    }

    @Override
    public Set<Order> findAll() {
        Set<Order> orders = new LinkedHashSet<>();
        repository.findAll().iterator().forEachRemaining(orders::add);
        return orders;
    }

    @Override
    public Order findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Order object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Order object) {
        repository.save(object);
    }
}
