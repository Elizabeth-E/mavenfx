package nl.inholland.javafx.dal.repository;

import nl.inholland.javafx.models.Movie;
import nl.inholland.javafx.dal.Database;
import nl.inholland.javafx.models.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public class MovieRepository {
    private final Database database;

    public MovieRepository(Database database) {
        this.database = database;
    }

    public void create(String title, LocalDateTime startTime, LocalDateTime endTime, Ticket ticket) {
        Movie movie = new Movie(title, startTime, endTime);

        if (ticket != null) {
            List<Ticket> tickets = movie.getTickets();
            tickets.add(ticket);
            movie.setTickets(tickets);
        }

        List<Movie> movies = database.getMovies();
        movies.add(movie);

        database.setMovies(movies);
    }

    public Movie read(String title) {
        List<Movie> movies = database.getMovies();

        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                return movie;
            }
        }

        return null;
    }

    public List<Movie> readAll() {
        return database.getMovies();
    }

    public void update(Movie oldMovie, Movie updatedMovie) {
        List<Movie> movies = database.getMovies();

        // Find movie index
        int movieIndex ;
        for (movieIndex = 0; movieIndex < movies.size(); movieIndex++) {
            if (movies.get(movieIndex).equals(oldMovie)) {
                break;
            }
        }

        database.getMovies().set(movieIndex, updatedMovie);
    }

    public void delete(Movie movie) {
        database.getMovies().remove(movie);
    }

    public void deleteAll() {
        database.getMovies().clear();
    }
}
