package nl.inholland.javafx.views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.awt.*;

public class LoginWindow extends Application {
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

        grid.add(username, 1,1);
        grid.add(usernameText, 2, 1);
        grid.add(password, 1,2);
        grid.add(passwordText, 2,2);

        Button login = new Button("Login");

        grid.add(login, 1,3);

        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.show();

    }
}
