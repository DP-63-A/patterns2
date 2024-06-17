package org.example.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.example.state.OrderState;
import org.example.state.impl.*;


public class Order {
    private int id;
    private String details;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = NewOrderState.class, name = "New"),
            @JsonSubTypes.Type(value = ProcessingOrderState.class, name = "Processing"),
            @JsonSubTypes.Type(value = ShippedOrderState.class, name = "Shipped")
    })
    private OrderState state;
    public Order() {
    }

    public Order(int id, OrderState state, String details) {
        this.id = id;
        this.state = state;
        this.details = details;
    }

    public Order(NewOrderState newOrderState) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id + '\'' +
                ", details:" + details + '\'' +
                ", state=" + state.getStatus() +
                '}' + '\'';
    }
}
