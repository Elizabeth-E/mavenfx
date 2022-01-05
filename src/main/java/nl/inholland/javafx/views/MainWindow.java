package nl.inholland.javafx.views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.inholland.javafx.models.Screening;
import nl.inholland.javafx.models.User;


public class MainWindow extends Application {
    protected User user;
    protected String window;
    protected VBox layout;
    protected HBox formBox;
    protected VBox menuBox;
    protected HBox tableBox;
    protected VBox errorBox;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Fabulous Cinema -- Main");
        stage.setWidth(800);
        stage.setHeight(500);
        
        layout = new VBox();
        menuBox = new VBox();
        tableBox = new HBox();
        formBox = new HBox();
        errorBox = new VBox();

        TableView<Screening> room1 = new TableView<>();
        TableView<Screening> room2 = new TableView<>();
        tableBox.getChildren().add(room1);
        tableBox.getChildren().add(room2);

        tableBox.getStyleClass().add("hbox");
        menuBox.getStyleClass().add("menu");
        formBox.getStyleClass().add("form");
        errorBox.getStyleClass().add("errorBox");
        this.fillPurchaseForm();

        //formBox.setVisible(false);

        layout.getChildren().add(menuBox);
        layout.getChildren().add(tableBox);
        layout.getChildren().add(formBox);
        layout.getChildren().add(errorBox);

        Scene scene = new Scene(layout);
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

}
