package nl.inholland.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import nl.inholland.javafx.views.LoginWindow;

public class App extends Application {
    @Override
    public void start(Stage window) throws Exception {
        LoginWindow login = new LoginWindow();
        login.start(window);
    }
}
