package com.example.projectpulse.services.userstory;


import com.example.projectpulse.dtos.userstory.read.UserStoryGeneralDto;
import com.example.projectpulse.dtos.userstory.write.UserStoryCreateDto;
import com.example.projectpulse.dtos.userstory.write.UserStoryUpdatedDto;
import com.example.projectpulse.entities.UserStory;
import com.example.projectpulse.exception.userstory.UserStoryException;
import com.example.projectpulse.mapping.userstory.GeneralUserStoryMapper;
import com.example.projectpulse.repositories.userstory.UserStoryRepository;
import com.example.projectpulse.serviceInterfaces.userstory.IUserStoryWriteService;
import org.springframework.stereotype.Service;

@Service
public class UserStoryWriteService implements IUserStoryWriteService {

    private final UserStoryRepository userStoryRepository;
    private final GeneralUserStoryMapper generalUserStoryMapper;

    public UserStoryWriteService(UserStoryRepository _userStoryRepository, GeneralUserStoryMapper _generalUserStoryMapper) {
        this.userStoryRepository = _userStoryRepository;
        this.generalUserStoryMapper = _generalUserStoryMapper;
    }

    /**
     * Creates a new UserStory from the provided UserStoryCreateDto and saves it to the repository.
     *
     * @param userStoryCreateDto The DTO containing the details for the new UserStory.
     * @return A UserStoryGeneralDto representing the saved UserStory.
     */
    @Override
    public UserStoryGeneralDto create(UserStoryCreateDto userStoryCreateDto) {
        UserStory userStory = new UserStory();
        userStory.setTitle(userStoryCreateDto.getTitle());
        userStory.setDescription(userStoryCreateDto.getDescription());
        userStory.setProject(userStoryCreateDto.getProjectId());

        return this.generalUserStoryMapper.map(this.userStoryRepository.save(userStory));
    }


    /**
     * Updates an existing UserStory with the provided details.
     *
     * @param id The ID of the UserStory to update.
     * @param userStoryUpdatedDto The DTO containing the updated details for the UserStory.
     * @return A UserStoryGeneralDto representing the updated UserStory.
     * @throws UserStoryException If the UserStory with the given ID is not found.
     */
    @Override
    public UserStoryGeneralDto update(Long id, UserStoryUpdatedDto userStoryUpdatedDto) throws UserStoryException {
        UserStory userStory = this.userStoryRepository.findById(id).orElse(null);
        if (userStory == null) throw new UserStoryException("User Story Not Found");
        if (userStoryUpdatedDto.getTitle() != null) userStory.setTitle(userStoryUpdatedDto.getTitle());
        if (userStoryUpdatedDto.getDescription() != null) userStory.setDescription(userStoryUpdatedDto.getDescription());

        return this.generalUserStoryMapper.map(this.userStoryRepository.save(userStory));
    }
}
