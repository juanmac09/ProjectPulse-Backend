package com.example.projectpulse.serviceInterfaces.userstory;

import com.example.projectpulse.dtos.userstory.read.UserStoryGeneralDto;
import com.example.projectpulse.entities.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserStoryReadService {
     UserStoryGeneralDto getUserStory(Long id, Company company);
     Page<UserStoryGeneralDto> getUserStories(Pageable pageable, Company company);
     Page<UserStoryGeneralDto> getUserStoryByProjectId(Long projectId, Company company, Pageable pageable);
}
