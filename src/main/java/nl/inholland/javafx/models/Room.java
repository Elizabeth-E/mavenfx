package nl.inholland.javafx.models;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;

@Data
public class Room {
    @NonNull
    private String name;
    @NonNull
    private int seats;
    private ArrayList<Screening> screenings = new ArrayList<>();

    public void addScreening(Screening screening) {
        screenings.add(screening);
    }
}
