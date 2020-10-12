package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.persistance;

import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos.SocialListRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork.SocialListPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("socialListPersistance")
public class SocialListPersistanceMongoDB implements SocialListPersistance {

    private SocialListRepository socialListRepository;

    @Autowired
    public SocialListPersistanceMongoDB(SocialListRepository socialListRepository) {
        this.socialListRepository = socialListRepository;
    }

    @Override
    public void deleteById(String id) {
        this.socialListRepository.deleteById(id);
    }

}