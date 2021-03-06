package es.upm.miw.apaw_practice.adapters.mongodb.project.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.project.daos.UserStoryRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.project.entities.UserStoryEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestConfig
public class UserStoryPersistenceMongodbIT {

    @Autowired
    private UserStoryPersistenceMongodb userStoryPersistence;
    @Autowired
    private UserStoryRepository userStoryRepository;

    @Test
    void testDelete() {
        assertEquals(1, this.userStoryRepository.findAll().stream()
                .filter(userStory -> userStory.getName().equals("delete"))
                .count());
        UserStoryEntity userStoryEntity = this.userStoryRepository.findAll().stream()
                .filter(userStory -> userStory.getName().equals("delete"))
                .findFirst().get();
        this.userStoryPersistence.delete(userStoryEntity.getId());
        assertFalse(this.userStoryRepository.findAll().stream()
                .anyMatch(userStory -> "delete".equals(userStory.getName())));
    }

}
