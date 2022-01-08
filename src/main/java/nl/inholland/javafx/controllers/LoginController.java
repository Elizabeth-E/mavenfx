package nl.inholland.javafx.controllers;

import javafx.stage.Stage;
import nl.inholland.javafx.dal.Database;
import nl.inholland.javafx.models.User;
import nl.inholland.javafx.models.enums.RoleEnum;
import nl.inholland.javafx.service.UserService;
import nl.inholland.javafx.views.AdminWindow;
import nl.inholland.javafx.views.MainWindow;

public class LoginController {
    private final Database database;
    private final UserService userService;
    private final MainWindow mainWindow;
    private final AdminWindow adminWindow;
    private final Stage stage;

    public LoginController(Stage stage, Database database) {
        this.database = database;
        this.stage = stage;

        mainWindow = new MainWindow(this.database);
        adminWindow = new AdminWindow(this.database);
        userService = new UserService(this.database);
    }

    public void authenticate(String username, String password) {
        boolean isAuthenticated = userService.authenticate(username, password);

        if ( ! isAuthenticated) {
            stage.close();
            return; // Early return to exit method
        }

        User user = userService.read(username);
        if (userService.isAuthorized(user, RoleEnum.ADMIN)) {
            stage.close();
            adminWindow.start(stage);
        }
        else{
            stage.close();

            try {
                mainWindow.start(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
