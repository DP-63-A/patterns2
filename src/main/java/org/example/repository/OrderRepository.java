package org.example.repository;

import org.example.model.Order;
import java.util.List;

public interface OrderRepository {
    void addOrder(Order order);
    Order getOrder(int id);
    List<Order> getAllOrders();
    void sortOrders(java.util.Comparator<Order> comparator);
}