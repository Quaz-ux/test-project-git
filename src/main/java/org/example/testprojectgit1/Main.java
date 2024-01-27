package org.example.testprojectgit1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;



@Component
public class Main implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    @Override
    public void run(String... args) {
        // Tworzymy instancję serwisu zamówień
        OrderService orderService = new OrderService();

        // Przykład składania zamówienia
        String customerId = "123";
        Map<String, Integer> products = new HashMap<>();
        products.put("ProductA", 2);
        products.put("ProductB", 1);
        String deliveryAddress = "Example Street, City";

        Order placedOrder = orderService.placeOrder(customerId, products, deliveryAddress);
        System.out.println("Placed Order ID: " + placedOrder.getId());
        System.out.println("Customer ID: " + placedOrder.getCustomerId());
        System.out.println("Products: " + placedOrder.getProducts());
        System.out.println("Delivery Address: " + placedOrder.getDeliveryAddress());


        // Przykład sprawdzenia statusu zamówienia
        String orderIdToCheck = placedOrder.getId();
        Status orderStatus = orderService.checkOrderStatus(orderIdToCheck);
        System.out.println("Order Status: " + orderStatus);

        // Przykład anulowania zamówienia
        String orderIdToCancel = placedOrder.getId();
        OrderCancellationResponse cancelResponse = orderService.cancelOrder(orderIdToCancel);
        System.out.println("Cancellation Result: " + cancelResponse.isSuccess());
        System.out.println("Cancellation Message: " + cancelResponse.getMessage());

        // Przykład potwierdzenia dostarczenia zamówienia
        String orderIdToConfirm = placedOrder.getId();
        OrderConfirmationDeliveryResponse OrderConfirmationDeliveryResponse = orderService.confirmDelivery(orderIdToConfirm);
        System.out.println("Confirmation Result: " + OrderConfirmationDeliveryResponse.isSuccess());
        System.out.println("Confirmation Message: " + OrderConfirmationDeliveryResponse.getMessage());

        // Przykład sprawdzenia statusu zamówienia po potwierdzeniu dostarczenia
        orderStatus = orderService.checkOrderStatus(orderIdToConfirm);
        System.out.println("Order Status after Delivery Confirmation: " + orderStatus);
    }
}
