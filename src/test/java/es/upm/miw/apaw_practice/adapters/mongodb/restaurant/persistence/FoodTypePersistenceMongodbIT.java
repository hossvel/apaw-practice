package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.restaurant.FoodType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class FoodTypePersistenceMongodbIT {

    @Autowired
    private FoodTypePersistenceMongodb foodTypePersistenceMongodb;

    @Test
    void updateSpicyNotFound() {
        FoodType foodType = new FoodType("tag7", false);
        assertThrows(NotFoundException.class, () -> this.foodTypePersistenceMongodb.update(foodType));
    }

    @Test
    void testReadByIdNotFound() {
        assertThrows(NotFoundException.class, () -> this.foodTypePersistenceMongodb.findById("tag7"));
    }

    @Test
    void testReadById() {
        assertEquals("tag1", this.foodTypePersistenceMongodb.findById("tag1").getId());
    }
}
