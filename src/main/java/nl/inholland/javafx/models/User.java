package nl.inholland.javafx.models;

import lombok.Data;
import lombok.NonNull;
import nl.inholland.javafx.models.enums.RoleEnum;

@Data
public class User {
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private RoleEnum role;
}
