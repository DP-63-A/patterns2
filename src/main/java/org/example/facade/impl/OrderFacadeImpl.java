package org.example.facade.impl;

import org.example.facade.OrderFacade;
import org.example.model.OrderStatus;
import org.example.model.Order;
import org.example.repository.OrderRepository;
import org.example.service.OrderService;
import org.example.util.Logger;

public class OrderFacadeImpl implements OrderFacade {
    private OrderService orderService;

    public OrderFacadeImpl(OrderRepository orderRepository) {
        this.orderService = new OrderService(orderRepository);
    }
    @Override
public void placeOrder(Order order) {
    try {
        orderService.placeOrder(order);
        Logger.log("Order placed: " + order.toString());
    } catch (Exception e) {
        Logger.log("Error placing order: " + e.getMessage());
    }
}

@Override
public OrderStatus trackOrder(int orderId) {
    try {
        OrderStatus status = orderService.trackOrder(orderId);
        Logger.log("Tracking order " + orderId + ": " + (status != null ? status.getStatus() : "Unknown"));
        return status;
    } catch (Exception e) {
        Logger.log("Error tracking order: " + e.getMessage());
        return null;
    }
}
}
