
package nl.inholland.javafx.dal.repository;

import nl.inholland.javafx.models.User;
import nl.inholland.javafx.dal.Database;
import nl.inholland.javafx.models.enums.RoleEnum;
import java.util.List;

public class UserRepository {
    private final Database database;

    public UserRepository(Database database) {
        this.database = database;
    }

    public void create(String username, String password, RoleEnum role) {
        User user = new User(username, password, role);

        List<User> users = database.getUsers();
        users.add(user);

        database.setUsers(users);
    }

    public User read(String username) {
        List<User> users = database.getUsers();

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }

    public List<User> readAll() {
        return database.getUsers();
    }

    public void update(User oldUser, User updatedUser) {
        List<User> users = database.getUsers();

        // Find User index
        int userIndex ;
        for (userIndex = 0; userIndex < users.size(); userIndex++) {
            if (users.get(userIndex).equals(oldUser)) {
                break;
            }
        }

        database.getUsers().set(userIndex, updatedUser);
    }

    public void delete(User user) {
        database.getUsers().remove(user);
    }

    public void deleteAll() {
        database.getUsers().clear();
    }
}
