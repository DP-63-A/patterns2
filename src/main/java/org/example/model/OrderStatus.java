package org.example.model;

public class OrderStatus {
    private int orderId;
    private String status;

    public OrderStatus(int orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }
}
