package com.example.projectpulse.controllers.auth;

public class LoginResponse {
    private String token;

    private long expiresIn;

    // Getters and setters...
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
    public long getExpiresIn() {
        return expiresIn;
    }
}
