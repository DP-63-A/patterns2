package org.example;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.facade.impl.OrderFacadeImpl;
import org.example.model.Order;
import org.example.model.OrderStatus;
import org.example.repository.OrderRepository;
import org.example.repository.impl.OrderRepositoryImpl;
import org.example.util.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        OrderRepository orderRepository = new OrderRepositoryImpl();

        try {
            byte[] jsonData = Files.readAllBytes(Paths.get("src/main/resources/data/data.json"));
            List<Order> orders = mapper.readValue(jsonData, new TypeReference<List<Order>>() {});
            orders.forEach(orderRepository::addOrder);

            Logger.info("Orders successfully loaded");

            Order order = orderRepository.getOrder(7);
            if (order != null) {
                Logger.info("Order created: " + order.toString());

                OrderFacadeImpl orderFacade = new OrderFacadeImpl(orderRepository);
                OrderStatus status = orderFacade.trackOrder(order.getId());
                Logger.info("Order status: " + (status != null ? status.getStatus() : "Unknown"));

                order.getState().next(order);
                Logger.info("Order " + order.getId() + " moved to " + order.getState().getStatus());
                order.getState().next(order);
                Logger.info("Order " + order.getId() + " moved to " + order.getState().getStatus());
            } else {
                Logger.info("Order not found.");
            }
        } catch (IOException e) {
            Logger.error("Error reading orders data: " + e.getMessage());
        } catch (Exception e) {
            Logger.error("Unexpected error: " + e.getMessage());
        }
    }
}

