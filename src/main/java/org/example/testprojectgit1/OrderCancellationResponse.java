package org.example.testprojectgit1;

public class OrderCancellationResponse {
    private final boolean success;
    private final String message;

    public OrderCancellationResponse(boolean success, String message) {
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
