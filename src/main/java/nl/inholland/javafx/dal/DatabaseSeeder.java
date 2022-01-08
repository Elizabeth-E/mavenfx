package nl.inholland.javafx.dal;

import nl.inholland.javafx.models.*;
import nl.inholland.javafx.models.enums.RoleEnum;
import nl.inholland.javafx.service.MovieService;
import nl.inholland.javafx.service.RoomService;
import nl.inholland.javafx.service.TicketService;
import nl.inholland.javafx.service.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DatabaseSeeder {
    private List<User> users;
    private List<Room> rooms;
    private List<Ticket> tickets;
    private Database database;

    public DatabaseSeeder(Database db) {
        database = db;
    }

    public Database seed() {
        seedUsers();
        seedMovies();
        seedRooms(database.getMovies());
        seedTickets(database.getRooms());

        return database;
    }

    private void seedUsers() {
        UserService userService = new UserService(database);
        userService.create("elizabeth", "admin", RoleEnum.ADMIN);
        userService.create("esmee", "user", RoleEnum.USER);
        userService.create("kilo", "user", RoleEnum.USER);
        userService.create("mitchel", "user", RoleEnum.USER);
    }

    private void seedMovies() {
        // Movie duration should be a random int in a min-max range
        Random rnd = new Random();
        int rndMin = 60;
        int rndMax = 200;
        int rndMovieTime = rndMax + (rndMin - rndMax) * rnd.nextInt();

        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusMinutes(rndMovieTime);

        MovieService movieService = new MovieService(database);
        movieService.create("No Time to Die", startTime, endTime, null);
        movieService.create("The Adams Family 19", startTime, endTime, null);
        movieService.create("Belle and the Beast", startTime, endTime, null);
        movieService.create("The Witcher", startTime, endTime, null);
        movieService.create("The Southern Resurrection", startTime, endTime, null);
        movieService.create("Esmée is Super Cute!", startTime, endTime, null);
    }

    private void seedRooms(List<Movie> movies) {
        RoomService roomService = new RoomService(database);
        roomService.create("Room 1", 200);
        roomService.create("Room 2", 100);

        List<Room> rooms = roomService.readAll();

        // Divide screenings over available rooms
        for (Movie movie : database.getMovies()) {
            Random rnd = new Random();
            Room rndRoom = rooms.get(rnd.nextInt(rooms.size()));

            Room rndRoomUpdated = rndRoom;
            rndRoom.addMovie(movie);

            roomService.update(rndRoom, rndRoomUpdated);
        }
    }

    private void seedTickets(List<Room> rooms) {
        TicketService ticketService = new TicketService(database);
        RoomService roomService = new RoomService(database);
        MovieService movieService = new MovieService(database);

        // Price should be a random double in a min-max range
        Random rnd = new Random();
        double rndMin = 25.00;
        double rndMax = 7.50;
        double rndTicketPrice = rndMax + (rndMin - rndMax) * rnd.nextDouble();

        // Add a tickets for every movie in the room based on available seats
        for (Room room : roomService.readAll()) {
            for (Movie movie : room.getMovies()) {
                List<Ticket> tickets = new ArrayList<>();

                for (int i = 0; i < room.getSeats(); i++) {
                    ticketService.create(rndTicketPrice);
                    Ticket ticket = ticketService.readAll().get(i);
                    tickets.add(ticket);
                }
                Movie updatedMovie = movie;
                movie.setTickets(tickets);
                movieService.update(movie, updatedMovie);
            }
        }
    }
}
