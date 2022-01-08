package nl.inholland.javafx.service;

import nl.inholland.javafx.dal.Database;
import nl.inholland.javafx.dal.repository.UserRepository;
import nl.inholland.javafx.models.User;
import nl.inholland.javafx.models.enums.RoleEnum;

import java.util.List;

public class UserService {
    private final Database database;
    private final UserRepository userRepository;

    public UserService(Database database) {
        this.database = database;
        userRepository = new UserRepository(this.database);
    }

    public void create(String username, String password, RoleEnum role) {
        userRepository.create(username, password, role);
    }

    public User read(String username) {
        return userRepository.read(username);
    }

    public List<User> readAll() {
        return userRepository.readAll();
    }

    public void update(User oldUser, User updatedUser) {
        userRepository.update(oldUser, updatedUser);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    // TODO: Create a separate authentication service
    public boolean authenticate(String username, String password) {
        for (User user: readAll()) {
            boolean isCorrectUser = username.equals(user.getUsername());
            boolean isCorrectPassword = password.equals(user.getPassword());

            if (isCorrectUser &&  isCorrectPassword) {
                return true;
            }
        }

        return  false;
    }

    // TODO: Create a separate authentication service
    public boolean isAuthorized(User user, RoleEnum role) {
        if (user.getRole().equals(role)) {
            return true;
        }

        return false;
    }
}
