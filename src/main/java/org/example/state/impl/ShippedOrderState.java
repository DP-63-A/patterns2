package org.example.state.impl;

import org.example.model.Order;
import org.example.state.OrderState;

public class ShippedOrderState implements OrderState {
    @Override
    public void next(Order order) {
    }

    @Override
    public void prev(Order order) {
        order.setState(new ProcessingOrderState());
    }

    @Override
    public String getStatus() {
        return "Shipped";
    }
}
