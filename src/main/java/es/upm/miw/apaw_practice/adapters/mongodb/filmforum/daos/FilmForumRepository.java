package es.upm.miw.apaw_practice.adapters.mongodb.filmforum.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.filmforum.entities.FilmForumEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface FilmForumRepository extends MongoRepository<FilmForumEntity, String> {
    Optional<List<FilmForumEntity>> findByYear(Integer year);
}
