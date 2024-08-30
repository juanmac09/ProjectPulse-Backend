package com.example.projectpulse.serviceInterfaces.userstory;

import com.example.projectpulse.controllers.userstories.UserStoryController;
import com.example.projectpulse.dtos.userstory.read.UserStoryGeneralDto;
import com.example.projectpulse.dtos.userstory.write.UserStoryCreateDto;
import com.example.projectpulse.dtos.userstory.write.UserStoryUpdatedDto;

public interface IUserStoryWriteService {

    UserStoryGeneralDto create(UserStoryCreateDto userStoryCreateDto);
    UserStoryGeneralDto update(Long id,UserStoryUpdatedDto userStoryUpdatedDto);
}
