package com.Clothing_Shop.Product.exception;



import java.time.Instant;
import java.util.Map;
 
public class ApiError {
    private int status;
    private String error;
    private String message;
    private Instant timestamp = Instant.now();
    private Map<String, String> details; // optional additional details (e.g., validation field errors)
 
    public ApiError() {}
 
    public ApiError(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }
 
    public ApiError(int status, String error, String message, Map<String, String> details) {
        this(status, error, message);
        this.details = details;
    }
 
    // getters & setters
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
 
    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
 
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
 
    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
 
    public Map<String, String> getDetails() { return details; }
    public void setDetails(Map<String, String> details) { this.details = details; }
}
 