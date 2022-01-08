package nl.inholland.javafx.models;

import lombok.Data;
import lombok.NonNull;

@Data
public class Ticket {
    @NonNull
    private double price;
}
