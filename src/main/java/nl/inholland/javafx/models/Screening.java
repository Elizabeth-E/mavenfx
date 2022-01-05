package nl.inholland.javafx.models;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
public class Screening {
    @NonNull
    private Movie movie;
    @NonNull
    private LocalDateTime startMovie;
    @NonNull
    private LocalDateTime endMovie;
}
