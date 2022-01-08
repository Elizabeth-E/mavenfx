package nl.inholland.javafx.dal.repository;

import nl.inholland.javafx.models.Room;
import nl.inholland.javafx.dal.Database;

import java.util.List;

public class RoomRepository {
    private final Database database;

    public RoomRepository(Database database) {
        this.database = database;
    }

    public void create(String name, int seats) {
        Room room = new Room(name, seats);

        List<Room> rooms = database.getRooms();
        rooms.add(room);

        database.setRooms(rooms);
    }

    public Room read(String name) {
        List<Room> rooms = database.getRooms();

        for (Room room : rooms) {
            if (room.getName().equals(name)) {
                return room;
            }
        }

        return null;
    }

    public List<Room> readAll() {
        return database.getRooms();
    }

    public void update(Room oldRoom, Room updateRoom) {
        List<Room> rooms = database.getRooms();

        // Find room index
        int roomIndex ;
        for (roomIndex = 0; roomIndex < rooms.size(); roomIndex++) {
            if (rooms.get(roomIndex).equals(oldRoom)) {
                break;
            }
        }

        database.getRooms().set(roomIndex, updateRoom);
    }

    public void delete(Room room) {
        database.getRooms().remove(room);
    }

    public void deleteAll() {
        database.getRooms().clear();
    }
}
