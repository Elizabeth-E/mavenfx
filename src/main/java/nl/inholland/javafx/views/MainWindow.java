package nl.inholland.javafx.views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.inholland.javafx.models.User;

public class MainWindow extends Application {
    protected User user;
    protected String window;
    protected MenuComponent menuComponent;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Fabulous Cinema -- Main");
        stage.setWidth(300);
        stage.setHeight(200);

        //GridPane grid = new GridPane();
        VBox mainBox = new VBox();

        //HBox menu = MenuComponent;
        Scene scene = new Scene(mainBox);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }


}
