package com.example.projectpulse.repositories.userstory;

import com.example.projectpulse.entities.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStoryRepository extends JpaRepository<UserStory, Long> {
}
