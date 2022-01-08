package nl.inholland.javafx;

import javafx.application.Application;
import javafx.stage.Stage;
import nl.inholland.javafx.dal.Database;
import nl.inholland.javafx.dal.DatabaseSeeder;
import nl.inholland.javafx.views.LoginWindow;

public class App extends Application {
    @Override
    public void start(Stage window) throws Exception {
        // Initialize & seed database
        Database database = new Database();

        DatabaseSeeder databaseSeeder = new DatabaseSeeder(database);
        database = databaseSeeder.seed();

        /*
        // TODO: Example for database changes
        // Add observers to data lists
        ObservableList<Movie> databaseMovies = FXCollections.observableArrayList(database.getMovies());
        ObservableList<Room> databaseRooms = FXCollections.observableArrayList(database.getRooms());
        ObservableList<Screening> databaseScreenings = FXCollections.observableArrayList(database.getScreenings());
        ObservableList<Ticket> databaseTickets = FXCollections.observableArrayList(database.getTickets());
        ObservableList<User> databaseUsers = FXCollections.observableArrayList(database.getUsers());

        // Listen for changes on the user
        databaseUsers.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("A user has been added or removed from the collection");
            }
        });

        // Test adding a user
        databaseUsers.add(new User("Hans", "badpassword", RoleEnum.USER));
         */

        LoginWindow login = new LoginWindow(database);
        login.start(window);
    }
}
