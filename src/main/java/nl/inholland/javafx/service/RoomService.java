package nl.inholland.javafx.service;

import nl.inholland.javafx.dal.Database;
import nl.inholland.javafx.dal.repository.RoomRepository;
import nl.inholland.javafx.models.Movie;
import nl.inholland.javafx.models.Room;

import java.util.List;

public class RoomService {
    private final Database database;
    private final RoomRepository roomRepository;

    public RoomService(Database database) {
        this.database = database;
        roomRepository = new RoomRepository(this.database);
    }

    public void create(String name, int seats) {
        roomRepository.create(name, seats);
    }

    public Room read(String title) {
        return roomRepository.read(title);
    }

    public List<Room> readAll() {
        return roomRepository.readAll();
    }

    public void update(Room oldRoom, Room updatedRoom) {
        roomRepository.update(oldRoom, updatedRoom);
    }

    public void delete(Room room) {
        roomRepository.delete(room);
    }

    public void deleteAll() {
        roomRepository.deleteAll();
    }
}
