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
import nl.inholland.javafx.dal.Database;
import nl.inholland.javafx.models.Role;
import nl.inholland.javafx.models.User;

import java.io.IOException;


public class LoginWindow extends Application {
    MainWindow main = new MainWindow();
    private Database database;

    public LoginWindow(Database db) {
        database = db;
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
                try {

                    // TODO: Move to controller
                    for (User user: database.getUsers()) {
                        boolean isCorrectUser = usernameText.getText().toLowerCase().equals(user.getUsername());
                        boolean isCorrectPassword = passwordText.getText().equals(user.getPassword());

                        if (isCorrectUser &&  isCorrectPassword) {
                            // Correct
                        }
                        else {
                            // wrong
                        }
                    }
                    stage.close();
                    main.start(stage);
                }
                catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        grid.add(login, 1,3);

        Scene scene = new Scene(grid);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();

    }
}
