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

    public OrderCancellationResponse cancelOrder (String orderId) {
        Order order = orders.get(orderId);
        if (order != null) {
            if (order.getStatus() == Status.NOWE) {
                order.setStatus(Status.ANULOWANE);
                return new OrderCancellationResponse(true, "Order cancelled successfully.");
            } else {
                return new OrderCancellationResponse(false, "Cannot cancel order W_REALIZACJI or DOSTARCZONE.");
            }
        } else {
            return new OrderCancellationResponse(false, "Order not found.");
        }
    }

    public OrderConfirmationDeliveryResponse confirmDelivery(String orderId) {
        Order order = orders.get(orderId);
        if (order != null && order.getStatus() == Status.W_REALIZACJI) {
            order.setStatus(Status.DOSTARCZONE);
            return new OrderConfirmationDeliveryResponse(true, "Order delivered!");
        } else {
            return new OrderConfirmationDeliveryResponse(false, "Cannot confirm delivery for the order :(");
        }
    }
}
