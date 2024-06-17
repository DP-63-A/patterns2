package org.example.service;

import org.example.model.Order;
import org.example.model.OrderStatus;
import org.example.repository.OrderRepository;
import org.example.util.Logger;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void placeOrder(Order order) {
        orderRepository.addOrder(order);
        Logger.log("Order " + order.getId() + " placed.");
    }

    public OrderStatus trackOrder(int orderId) {
        Order order = orderRepository.getOrder(orderId);
        if (order != null) {
            return new OrderStatus(orderId, order.getState().getStatus());
        } else {
            Logger.log("Order " + orderId + " not found.");
            return null;
        }
    }
}