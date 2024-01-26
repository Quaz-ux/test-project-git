package org.example.testprojectgit1;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    private final Map<String, Order> orders = new HashMap<>();

    public Order placeOrder(String customerId, Map<String, Integer> products, String deliveryAddress) {
        Order order = new Order(customerId, products, deliveryAddress);
        orders.put(order.getId(), order);
        return order;
    }

    public Status checkOrderStatus (String orderId) {
        Order order = orders.get(orderId);
        if (order != null) {
            return order.getStatus();
        } else {
            return Status.NIE_ZNALEZIONO;
        }
    }


}
