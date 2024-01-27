package org.example.testprojectgit1;

import java.util.Map;
import java.util.UUID;

public class Order {

    private final String id;
    private final String customerId;
    private final Map<String, Integer> products;
    private final String deliveryAddress;
    private Status status;

    public Order(String customerId, Map<String, Integer> products, String deliveryAddress) {
        this.id = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.products = products;
        this.deliveryAddress = deliveryAddress;
        this.status = Status.NOWE;
    }

    public String getId() {
        return id;
    }
    public String getCustomerId() {
        return customerId;
    }
    public Map<String, Integer> getProducts() {
        return products;
    }
    public String getDeliveryAddress() {
        return deliveryAddress;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
