package org.example.testprojectgit1;

public class OrderConfirmationDeliveryResponse {
    private final boolean success;
    private final String message;

    public OrderConfirmationDeliveryResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
