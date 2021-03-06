package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialTrend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class SocialTrendPersistenceMongoDBIT {

    @Autowired
    private SocialTrendPersistenceMongoDB socialTrendPersistenceMongoDB;

    @Test
    void testReadByName() {
        Optional<SocialTrend> socialTrend = this.socialTrendPersistenceMongoDB.readByName("Europan")
                .filter(trend -> trend.getPosition() == 1)
                .findFirst();
        assertTrue(socialTrend.isPresent());
        assertNotNull(socialTrend.get().getId());
        assertNotNull(socialTrend.get().getSocialPostId());
    }

    @Test
    void testUpdate() {
        Optional<SocialTrend> socialTrend = this.socialTrendPersistenceMongoDB.readByName("Europan")
                .filter(trend -> trend.getPosition() == 1)
                .findFirst();
        assertTrue(socialTrend.isPresent());
        socialTrend.get().setName("Europan Updated");
        this.socialTrendPersistenceMongoDB.update(socialTrend.get());
        Optional<SocialTrend> socialTrendUpdated = this.socialTrendPersistenceMongoDB.readByName("Europan Updated")
                .filter(trend -> trend.getPosition() == 1)
                .findFirst();
        assertTrue(socialTrendUpdated.isPresent());
        assertEquals(socialTrend.get().getName(), socialTrendUpdated.get().getName());
        assertEquals(1, socialTrendUpdated.get().getPosition());
        assertEquals(socialTrend.get().getSocialPostId(), socialTrendUpdated.get().getSocialPostId());
        assertEquals(socialTrend.get().getId(), socialTrendUpdated.get().getId());
        socialTrendUpdated.get().setName("Europan");
        this.socialTrendPersistenceMongoDB.update(socialTrendUpdated.get());
    }

}
