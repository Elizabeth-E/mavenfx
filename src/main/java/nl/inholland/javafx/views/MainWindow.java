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


public class MainWindow extends Application {
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

    public MainWindow(Database database) {
        this.database = database;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Fabulous Cinema -- Main");
        stage.setWidth(800);
        stage.setHeight(500);
        
        layout = new VBox();
        constructMenu();
        this.fillPurchaseForm();


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
        formBox = new HBox();

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

        Menu help = new Menu("Help");
        Menu logout = new Menu("Logout");
        MenuItem about = new MenuItem("about");

        help.getItems().add(about);

        menuBar.getMenus().addAll(help, logout);

        menuBox.getChildren().add(menuBar);
    }


}
