package es.upm.miw.apaw_practice.domain.persistence_ports.school;

import es.upm.miw.apaw_practice.domain.models.school.Subject;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectPersistence {
    Subject updateName(String id, String name);
}
