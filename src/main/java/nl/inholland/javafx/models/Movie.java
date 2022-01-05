package nl.inholland.javafx.models;

import lombok.Data;
import lombok.NonNull;

@Data
public class Movie {
    @NonNull
    private String title;
}
