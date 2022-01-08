package nl.inholland.javafx.models;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Movie {
    @NonNull
    private String title;
    @NonNull
    private LocalDateTime startMovie;
    @NonNull
    private LocalDateTime endMovie;
    private List<Ticket> tickets = new ArrayList<>();
}
