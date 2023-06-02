package org.example.services;

import org.example.entities.OrderItem;
import org.example.utils.ConnectionFactory;
import org.example.repositories.OrderItemRepository;

public class OrderItemService {
    private final OrderItemRepository orderItemRepository = new OrderItemRepository(new ConnectionFactory());
    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.get(id);
    }

    public boolean saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
