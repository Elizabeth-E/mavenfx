package nl.inholland.javafx.views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.inholland.javafx.dal.Database;
import nl.inholland.javafx.models.Movie;
import nl.inholland.javafx.models.User;

public class AdminWindow extends Application {
    private final Database database;
    protected User user;
    protected String window;
    protected Scene scene;
    protected VBox layout;
    protected HBox formBox;
    protected VBox menuBox;
    protected HBox tableBox;
    protected VBox errorBox;
    protected MenuBar menuBar;

    public AdminWindow(Database database) {
        this.database = database;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Fabulous Cinema -- Admin");
        stage.setWidth(800);
        stage.setHeight(500);

        layout = new VBox();
        formBox = new HBox();
        constructMenu();
        fillPurchaseForm();


        tableBox = new HBox();

        errorBox = new VBox();

        TableView<Movie> room1 = new TableView<>();
        TableView<Movie> room2 = new TableView<>();
        tableBox.getChildren().add(room1);
        tableBox.getChildren().add(room2);

        tableBox.getStyleClass().add("hbox");
        menuBox.getStyleClass().add("menu");
        formBox.getStyleClass().add("form");
        errorBox.getStyleClass().add("errorBox");

        //formBox.setVisible(false);

        layout.getChildren().add(menuBox);
        layout.getChildren().add(tableBox);
        layout.getChildren().add(formBox);
        layout.getChildren().add(errorBox);

        scene = new Scene(layout);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }
    public void fillPurchaseForm(){

        Label room = new Label("Room");
        Label startTime = new Label("Start Time");
        Label endTime = new Label("End Time");
        Label movieTitle = new Label("Title");
        Label seats = new Label("No. of Seats");
        Label nameOnTicket = new Label("Name");

        Label roomDisplay = new Label();
        Label startTimeDisplay = new Label();
        Label endTimeDisplay = new Label();
        Label movieTitleDisplay = new Label();
        TextField seatsDisplay = new TextField();
        seatsDisplay.setPromptText("0");
        TextField nameOnTicketDisplay = new TextField();
        nameOnTicketDisplay.setPromptText("name");

        VBox formLabels1 = new VBox();
        VBox formDisplays1 = new VBox();
        VBox formLabels2 = new VBox();
        VBox formDisplays2 = new VBox();

        formLabels1.getChildren().addAll(room, startTime, endTime);
        formDisplays1.getChildren().addAll(roomDisplay, startTimeDisplay, endTimeDisplay);
        formLabels2.getChildren().addAll(movieTitle, seats, nameOnTicket);
        formDisplays2.getChildren().addAll(movieTitleDisplay, seatsDisplay, nameOnTicketDisplay);

        formBox.getChildren().addAll(formLabels1, formDisplays1, formLabels2, formDisplays2);
    }
    public void constructMenu(){

        MenuBar menuBar = new MenuBar();
        menuBox = new VBox();

        Menu admin = new Menu("Admin");
        MenuItem manageShowings = new MenuItem("Manage Showings");
        MenuItem manageMovies = new MenuItem("Manage Movies");
        admin.setOnShown(e -> {
            formBox.getChildren().clear();
            fillPurchaseForm();
        });
        manageShowings.setOnAction(e -> {
            manageShowingsForm();
        });
        manageMovies.setOnAction(e -> {
            manageMoviesForm();
        });


        admin.getItems().addAll(manageShowings, manageMovies);
        Menu help = new Menu("Help");
        Menu logout = new Menu("Logout");
        MenuItem about = new MenuItem("about");

        help.getItems().add(about);

        menuBar.getMenus().addAll(admin, help, logout);

        menuBox.getChildren().add(menuBar);
    }
    public void manageShowingsForm(){
        formBox.getChildren().clear();

        Label movieTitle = new Label("Title");
        Label room = new Label("Room");
        Label seats = new Label("No. of Seats");

//        TODO:make combo fill movies from database
        ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll(
                "kilo",
                "esmee"
        );

        ComboBox roomComboBox = new ComboBox();
        roomComboBox.getItems().addAll(
                "room 1",
                "room2"
        );
//        TODO: fill seats based on room selection
        Label noOfSeats = new Label("200");

        Label startTime = new Label("Start Time");
        Label endTime = new Label("End Time");
        Label price = new Label("Price");

        DatePicker startDate = new DatePicker();
        TextField time = new TextField();
        time.setPromptText("00:00");
        Label endDisplay = new Label("20:00");
//        TODO:  make dynamic with db
        Label priceDisplay = new Label("12.50");

        Button add = new Button("Add Showing");
        Button clear = new Button("Clear");

        VBox formLabels1 = new VBox();
        VBox formDisplays1 = new VBox();
        VBox formLabels2 = new VBox();
        VBox formDisplays2 = new VBox();
        VBox formDisplays3 = new VBox();
        VBox buttons = new VBox();

        formLabels1.getChildren().addAll(movieTitle, room, seats);
        formDisplays1.getChildren().addAll(comboBox, roomComboBox, noOfSeats);
        formLabels2.getChildren().addAll(startTime, endTime, price);
        formDisplays2.getChildren().addAll(startDate, endDisplay, priceDisplay);
        formDisplays3.getChildren().addAll(time);
        buttons.getChildren().addAll(add, clear);

        formBox.getChildren().addAll(formLabels1, formDisplays1, formLabels2, formDisplays2, formDisplays3, buttons);
    }
    public void manageMoviesForm(){
        formBox.getChildren().clear();

        Label movieTitle = new Label("Title");
        Label room = new Label("Room");
        Label seats = new Label("No. of Seats");

        TextField movieName = new TextField();
        movieName.setPromptText("Fox and the Hound");
        ComboBox roomComboBox = new ComboBox();
        roomComboBox.getItems().addAll(
                "room 1",
                "room2"
        );
        Label noOfSeats = new Label("200");

        Label duration = new Label("Movie Duration");
        Label moviePrice = new Label("Price");

        TextField durationInput = new TextField();
        durationInput.setPromptText("00:00");
        TextField priceInput = new TextField();
        priceInput.setPromptText("12.50");

        Button addMovie = new Button("Add Movie");
        Button clear = new Button("Clear");

        VBox formLabels1 = new VBox();
        VBox formDisplays1 = new VBox();
        VBox formLabels2 = new VBox();
        VBox formDisplays2 = new VBox();
        VBox buttons = new VBox();

        formLabels1.getChildren().addAll(movieTitle, room, seats);
        formDisplays1.getChildren().addAll(movieName, roomComboBox, noOfSeats);
        formLabels2.getChildren().addAll(duration, moviePrice);
        formDisplays2.getChildren().addAll(durationInput, priceInput);
        buttons.getChildren().addAll(addMovie, clear);

        formBox.getChildren().addAll(formLabels1, formDisplays1, formLabels2, formDisplays2, buttons);
    }

}

