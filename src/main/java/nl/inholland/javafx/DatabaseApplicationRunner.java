package nl.inholland.javafx;

import lombok.Getter;
import nl.inholland.javafx.dal.DatabaseSeeder;
import nl.inholland.javafx.models.*;

import java.util.List;

public class DatabaseApplicationRunner {
        @Getter
        private List<User> users;
        @Getter
        private List<Movie> movies;
        @Getter
        private List<Screening> screenings;
        @Getter
        private List<Room> rooms;
        @Getter
        private List<Ticket> tickets;

        public DatabaseApplicationRunner() {
            users = DatabaseSeeder.seedUsers();
            movies = DatabaseSeeder.seedMovies();
            screenings = DatabaseSeeder.seedScreenings(movies);
            rooms = DatabaseSeeder.seedRooms(screenings);
            tickets = DatabaseSeeder.seedTickets(rooms);
        }
}
