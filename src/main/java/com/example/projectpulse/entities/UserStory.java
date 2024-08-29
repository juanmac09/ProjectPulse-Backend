package com.example.projectpulse.entities;

import jakarta.persistence.*;

@Table(name = "user_stories")
@Entity
public class UserStory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Long id;
}
