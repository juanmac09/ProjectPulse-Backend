package com.example.projectpulse.services.userstory;


import com.example.projectpulse.dtos.userstory.read.UserStoryGeneralDto;
import com.example.projectpulse.entities.Company;
import com.example.projectpulse.entities.UserStory;
import com.example.projectpulse.mapping.userstory.GeneralUserStoryMapper;
import com.example.projectpulse.repositories.userstory.UserStoryRepository;
import com.example.projectpulse.serviceInterfaces.userstory.IUserStoryReadService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserStoryReadService implements IUserStoryReadService {

    private final UserStoryRepository userStoryRepository;
    private final GeneralUserStoryMapper generalUserStoryMapper;
    public UserStoryReadService(UserStoryRepository userStoryRepository, GeneralUserStoryMapper generalUserStoryMapper) {
        this.userStoryRepository = userStoryRepository;
        this.generalUserStoryMapper = generalUserStoryMapper;
    }

    /**
     * Retrieves a UserStory by its ID for a specific company.
     *
     * @param id The ID of the UserStory to retrieve.
     * @param company The company for which to retrieve the UserStory.
     * @return A UserStoryGeneralDto representing the UserStory, or null if no UserStory is found for the given ID and company.
     */
    @Override
    public UserStoryGeneralDto getUserStory(Long id, Company company) {
        UserStory userStories = this.userStoryRepository.findAllByCompanyIdAndUserStoryId(id, company.getId());
        return this.generalUserStoryMapper.map(userStories);
    }

    /**
     * Retrieves all User Stories for a specific company with pagination.
     *
     * @param pageable The pagination information (page number and size).
     * @param company The company for which to retrieve the User Stories.
     * @return A Page of UserStoryGeneralDto containing the paginated list of User Stories.
     */
    public Page<UserStoryGeneralDto> getUserStories(Pageable pageable, Company company) {
        Page<UserStory> userStories = this.userStoryRepository.findAllByCompanyId(company.getId(), pageable);
        return userStories.map(this.generalUserStoryMapper::map);
    }



}
