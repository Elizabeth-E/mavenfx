package nl.inholland.javafx.dal;

import nl.inholland.javafx.models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DatabaseSeeder {
    public static List<User> seedUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User("elizabeth", "admin", Role.ADMIN));
        users.add(new User("esmee", "user", Role.USER));
        users.add(new User("kilo", "user", Role.USER));
        users.add(new User("mitchel", "user", Role.USER));

        return users;
    }

    public static List<Movie> seedMovies() {
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("No Time to Die"));
        movies.add(new Movie("The Adams Family 19"));
        movies.add(new Movie("Belle and the Beast"));
        movies.add(new Movie("The Witcher"));
        movies.add(new Movie("The Southern Resurrection"));
        movies.add(new Movie("Esmée is Super Cute!"));

        return movies;
    }

    public static List<Room> seedRooms(List<Screening> screenings) {
        List<Room> rooms = new ArrayList<>();

        rooms.add(new Room("Room 1", 200));
        rooms.add(new Room("Room 2", 100));

        // Divide screenings over available rooms
        for (Screening screening : screenings) {
            Random rnd = new Random();
            Room rndRoom = rooms.get(rnd.nextInt(rooms.size()));

            rndRoom.addScreening(screening);
        }

        return rooms;
    }

    public static List<Screening> seedScreenings(List<Movie> movies) {
        List<Screening> screenings = new ArrayList<>();

        // Movie duration should be a random int in a min-max range
        Random rnd = new Random();
        int rndMin = 60;
        int rndMax = 200;
        int rndMovieTime = rndMax + (rndMin - rndMax) * rnd.nextInt();

        for (Movie movie : movies) {
            LocalDateTime startTime = LocalDateTime.now();
            LocalDateTime endTime = startTime.plusMinutes(rndMovieTime);

            screenings.add(new Screening(movie, startTime, endTime));
        }

        return screenings;
    }

    public static List<Ticket> seedTickets(List<Room> rooms) {
        List<Ticket> tickets = new ArrayList<>();

        // Price should be a random double in a min-max range
        Random rnd = new Random();
        double rndMin = 25.00;
        double rndMax = 7.50;
        double rndTicketPrice = rndMax + (rndMin - rndMax) * rnd.nextDouble();

        // Add a tickets for every screening in the room based on available seats
        for (Room room : rooms) {
            for (Screening screening : room.getScreenings()) {
                for (int i = 0; i < room.getSeats(); i++) {
                    Ticket ticket = new Ticket(rndTicketPrice, screening);

                    tickets.add(ticket);
                }
            }
        }

        return tickets;
    }
}
