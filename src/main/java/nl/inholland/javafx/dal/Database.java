package nl.inholland.javafx.dal;

import lombok.Getter;
import lombok.Setter;
import nl.inholland.javafx.models.*;

import java.util.ArrayList;
import java.util.List;

public class Database {
    @Getter @Setter
    private List<User> users = new ArrayList<>();
    @Getter @Setter
    private List<Movie> movies = new ArrayList<>();
    @Getter @Setter
    private List<Room> rooms = new ArrayList<>();
    @Getter @Setter
    private List<Ticket> tickets = new ArrayList<>();
}
