package org.example.repository.impl;

import org.example.model.Order;
import org.example.repository.OrderRepository;
import org.example.util.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private List<Order> orders = new ArrayList<>();
    @Override
    public void addOrder(Order order) {
        orders.add(order);
        Logger.log("Order added: " + order.toString());
    }

    @Override
    public Order getOrder(int id) {
        Order order = orders.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                .orElse(null);
        if (order != null) {
            Logger.log("Order retrieved: " + order.toString());
        } else {
            Logger.log("Order not found: " + id);
        }
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        Logger.log("Retrieving all orders");
        return new ArrayList<>(orders);
    }

    @Override
    public void sortOrders(Comparator<Order> comparator) {
        orders.sort(comparator);
        Logger.log("Orders sorted");
    }
}
