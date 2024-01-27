package org.example.testprojectgit1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    private Order testOrder;

    @BeforeEach
    void setUp() {
        Map<String, Integer> products = new HashMap<>();
        products.put("TestProduct", 3);
        testOrder = orderService.placeOrder("testCustomerId", products, "Test Address");
    }

    @AfterEach
    @BeforeEach
    void tearDown() {
        // W razie potrzeby wyczyść dane testowe
    }

    @Test
    void placeOrder() {
        assertNotNull(testOrder);
        assertEquals("testCustomerId", testOrder.getCustomerId());
        assertFalse(testOrder.getProducts().isEmpty());
        assertEquals("Test Address", testOrder.getDeliveryAddress());
    }

    @Test
    void checkOrderStatus() {
        assertNotNull(testOrder);
        Status status = orderService.checkOrderStatus(testOrder.getId());
        assertNotNull(status);
    }

    @Test
    void cancelOrder() {
        assertNotNull(testOrder);
        OrderCancellationResponse response = orderService.cancelOrder(testOrder.getId());
        assertTrue(response.isSuccess());
        assertEquals("Order cancelled successfully.", response.getMessage());
    }

    @Test
    void confirmDelivery() {
        assertNotNull(testOrder);
        OrderConfirmationDeliveryResponse response = orderService.confirmDelivery(testOrder.getId());
        assertTrue(response.isSuccess());
        assertEquals("Order delivered!", response.getMessage());
    }
}
