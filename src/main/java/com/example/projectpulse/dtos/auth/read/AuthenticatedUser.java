package com.example.projectpulse.dtos.auth.read;

import com.example.projectpulse.entities.User;

public class AuthenticatedUser {

    private User user;

    //Setters and Getters here...

    public User getUser(){
        return this.user;
    }
    public void setUser(User user){
        if (this.user == null){
            this.user = user;
        }
    }
}
