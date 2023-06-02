package org.example.services;

import org.example.entities.Order;
import org.example.utils.ConnectionFactory;
import org.example.repositories.OrderRepository;

public class OrderService {
    private final OrderRepository orderRepository = new OrderRepository(new ConnectionFactory());
    public Long getLastId() {
        return orderRepository.getLastId();
    }
    public Order getOrderById(Long id) {
        return orderRepository.get(id);
    }

    public boolean saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
