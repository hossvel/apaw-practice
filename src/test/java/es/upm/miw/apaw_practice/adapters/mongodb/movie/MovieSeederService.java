package es.upm.miw.apaw_practice.adapters.mongodb.movie;

import es.upm.miw.apaw_practice.adapters.mongodb.movie.daos.CinemaRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.daos.FilmDirectorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.daos.MovieRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.CinemaEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.FilmDirectorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.FilmRoomEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.MovieEntity;
import es.upm.miw.apaw_practice.domain.models.movie.Movie;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieSeederService {

    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private FilmDirectorRepository filmDirectorRepository;
    @Autowired
    private MovieRepository movieRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Movie Initial Load -----------");
        FilmDirectorEntity[] filmDirectories = {
                FilmDirectorEntity.builder().name("Jose").fulName("Luis Rodriguez").age(38).build(),
                FilmDirectorEntity.builder().name("Pedro").fulName("Munoz Roda").age(30).build(),
                FilmDirectorEntity.builder().name("Marta").fulName("Gomez Gomez").age(28).build(),
                FilmDirectorEntity.builder().name("Luis").fulName("Franco Perez").age(55).build(),
                FilmDirectorEntity.builder().name("Hector").fulName("Munoz Merida").age(22).build()
        };
        this.filmDirectorRepository.saveAll(Arrays.asList(filmDirectories));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        MovieEntity[] movies = {
                new MovieEntity(new Movie("Frozen", filmDirectories[4], LocalDateTime.parse("1986-04-08 10:30", formatter), "ppppppp", 10)),
                new MovieEntity(new Movie("Kill", filmDirectories[0], LocalDateTime.parse("2000-02-23 20:50", formatter), "dddddddddd", 2)),
                new MovieEntity(new Movie("Avengers", filmDirectories[4], LocalDateTime.parse("2010-01-09 14:12", formatter), "tttttttt", 5)),
                new MovieEntity(new Movie("Deadpool", filmDirectories[3], LocalDateTime.parse("2020-02-14 18:20", formatter), "ggggggg", 6)),
                new MovieEntity(new Movie("Let's Be Cops", filmDirectories[1], LocalDateTime.parse("1986-06-08 13:21", formatter), "lllllll", 3)),
                new MovieEntity(new Movie("The dark Knight", filmDirectories[2], LocalDateTime.parse("1986-11-03 23:32", formatter), "wwwwwww", 7)),
                new MovieEntity(new Movie("X-Men", filmDirectories[3], LocalDateTime.parse("1986-05-14 11:23", formatter), "yyyyyyyyyy", 9)),
                new MovieEntity(new Movie("The Simpsons", filmDirectories[4], LocalDateTime.parse("1986-02-17 20:30", formatter), "qqqqqqq", 1))
        };
        this.movieRepository.saveAll(Arrays.asList(movies));
        FilmRoomEntity[] filmRooms = {
                new FilmRoomEntity(150, 12, true),
                new FilmRoomEntity(85, 14, false),
                new FilmRoomEntity(70, 8, false),
                new FilmRoomEntity(67, 15, false),
                new FilmRoomEntity(170, 10, true),
                new FilmRoomEntity(55, 3, false),
                new FilmRoomEntity(55, 7, false),
                new FilmRoomEntity(55, 9, false)
        };
        CinemaEntity[] cinemas = {
                new CinemaEntity(List.of(movies[0], movies[1], movies[3]), List.of(filmRooms[0], filmRooms[1]), "YelmoCine", new BigDecimal("10.23"), "Alcorcon"),
                new CinemaEntity(List.of(movies[1], movies[1]), List.of(filmRooms[2], filmRooms[3]), "OdeonCine", new BigDecimal("9.24"), "Mostoles"),
                new CinemaEntity(List.of(movies[4], movies[5], movies[7]), List.of(filmRooms[4], filmRooms[5]), "Cinepolis", new BigDecimal("8.34"), "Fuenlabrada"),
                new CinemaEntity(List.of(movies[2], movies[3], movies[0]), List.of(filmRooms[6], filmRooms[7]), "Cinessa", new BigDecimal("8.45"), "Boadilla")
        };
        this.cinemaRepository.saveAll(Arrays.asList(cinemas));
    }

    public void deleteAll() {
        this.cinemaRepository.deleteAll();
        this.movieRepository.deleteAll();
        this.filmDirectorRepository.deleteAll();
    }
}

