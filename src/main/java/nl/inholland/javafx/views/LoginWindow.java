package nl.inholland.javafx.views;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import nl.inholland.javafx.controllers.LoginController;
import nl.inholland.javafx.dal.Database;


public class LoginWindow extends Application {
    private Database database;

    public LoginWindow(Database database) {
        this.database = database;
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Fabulous Cinema -- Login");
        stage.setWidth(300);
        stage.setHeight(200);

        GridPane grid = new GridPane();

        Label username = new Label("Username");
        TextField usernameText = new TextField("Username");

        Label password = new Label("Password");
        PasswordField passwordText = new PasswordField();
        Label errorText = new Label("error");

        grid.add(username, 1,1);
        grid.add(usernameText, 2, 1);
        grid.add(password, 1,2);
        grid.add(passwordText, 2,2);
        grid.add(errorText,1,4);

        Button login = new Button("Login");
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = usernameText.getText().toLowerCase();
                String password = passwordText.getText();

                LoginController loginController = new LoginController(stage, database);
                loginController.authenticate(username, password);
            }
        });

        grid.add(login, 1,3);

        Scene scene = new Scene(grid);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();

    }
}
