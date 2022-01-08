package nl.inholland.javafx.service;

import nl.inholland.javafx.dal.Database;
import nl.inholland.javafx.dal.repository.MovieRepository;
import nl.inholland.javafx.models.Movie;
import nl.inholland.javafx.models.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public class MovieService {
    private final Database database;
    private final MovieRepository movieRepository;

    public MovieService(Database database) {
        this.database = database;
        movieRepository = new MovieRepository(this.database);
    }

    public void create(String title, LocalDateTime startTime, LocalDateTime endTime, Ticket ticket) {
        movieRepository.create(title, startTime, endTime, ticket);
    }

    public Movie read(String title) {
        return movieRepository.read(title);
    }

    public List<Movie> readAll() {
        return movieRepository.readAll();
    }

    public void update(Movie oldMovie, Movie updatedMovie) {
        movieRepository.update(oldMovie, updatedMovie);
    }

    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }

    public void deleteAll() {
        movieRepository.deleteAll();
    }
}
