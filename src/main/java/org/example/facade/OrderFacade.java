package org.example.facade;

import org.example.model.OrderStatus;
import org.example.model.Order;

public interface OrderFacade {
    void placeOrder(Order order);
    OrderStatus trackOrder(int orderId);
}