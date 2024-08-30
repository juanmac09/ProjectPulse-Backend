package com.example.projectpulse.mapping.userstory;

import com.example.projectpulse.dtos.userstory.read.UserStoryGeneralDto;
import com.example.projectpulse.dtos.userstory.write.UserStoryCreateDto;
import com.example.projectpulse.entities.UserStory;
import com.example.projectpulse.mapping.Mapper;
import com.example.projectpulse.mapping.project.NameAndDescriptionProjectMapper;
import org.springframework.stereotype.Component;

@Component
public class GeneralUserStoryMapper implements Mapper<UserStoryGeneralDto, UserStory> {

    private final NameAndDescriptionProjectMapper nameAndDescriptionProjectMapper;
    public GeneralUserStoryMapper(NameAndDescriptionProjectMapper nameAndDescriptionProjectMapper) {
        this.nameAndDescriptionProjectMapper = nameAndDescriptionProjectMapper;
    }

    /**
     * Converts a UserStory entity into a UserStoryGeneralDto.
     *
     * @param userStory The UserStory entity to convert.
     * @return A UserStoryGeneralDto containing the details of the UserStory, or null if the input userStory is null.
     */
    @Override
    public UserStoryGeneralDto map(UserStory userStory) {
        if (userStory == null) return null;

        UserStoryGeneralDto userStoryGeneralDto = new UserStoryGeneralDto();
        userStoryGeneralDto.setId(userStory.getId());
        userStoryGeneralDto.setTitle(userStory.getTitle());
        userStoryGeneralDto.setDescription(userStory.getDescription());
        userStoryGeneralDto.setProjectNameAndDescription(this.nameAndDescriptionProjectMapper.map(userStory.getProject()));

        return userStoryGeneralDto;
    }

}
