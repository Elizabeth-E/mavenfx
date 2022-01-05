package nl.inholland.javafx.dal;

import lombok.Getter;
import lombok.Setter;
import nl.inholland.javafx.models.*;

import java.util.List;

public class Database {
    @Getter @Setter
    private List<User> users;
    @Getter @Setter
    private List<Movie> movies;
    @Getter @Setter
    private List<Room> rooms;
    @Getter @Setter
    private List<Screening> screenings;
    @Getter @Setter
    private List<Ticket> tickets;
}
