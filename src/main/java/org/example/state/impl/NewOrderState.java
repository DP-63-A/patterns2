package org.example.state.impl;

import org.example.model.Order;
import org.example.state.OrderState;

public class NewOrderState implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new ProcessingOrderState());
    }

    @Override
    public void prev(Order order) {
    }

    @Override
    public String getStatus() {
        return "New";
    }
}