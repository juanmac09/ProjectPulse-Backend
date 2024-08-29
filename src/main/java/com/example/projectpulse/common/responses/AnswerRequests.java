package com.example.projectpulse.common.responses;

// Generic class for handling responses in API requests.
public class AnswerRequests<T> {

    // Indicates whether the request was successful.
    private boolean success;

    // Message providing additional information about the request's outcome.
    private String message;

    // Generic data payload associated with the response.
    private T data;

    // Getter for the success status of the response.
    public boolean getSuccess() {
        return this.success;
    }

    // Setter for the success status of the response.
    public void setSuccess(boolean success) {
        this.success = success;
    }

    // Getter for the message providing information about the response.
    public String getMessage() {
        return this.message;
    }

    // Setter for the message providing information about the response.
    public void setMessage(String message) {
        this.message = message;
    }

    // Getter for the data payload of the response.
    public T getData() {
        return this.data;
    }

    // Setter for the data payload of the response.
    public void setData(T data) {
        this.data = data;
    }
}
