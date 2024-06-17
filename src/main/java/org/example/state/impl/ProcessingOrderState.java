package org.example.state.impl;

import org.example.model.Order;
import org.example.state.OrderState;

public class ProcessingOrderState implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new ShippedOrderState());
    }

    @Override
    public void prev(Order order) {
        order.setState(new NewOrderState());
    }

    @Override
    public String getStatus() {
        return "Processing";
    }
}
