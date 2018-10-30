package com.aszmurlo.hotelmanagementapp.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aszmurlo.hotelmanagementapp.web.model.Room;

@Service
public class RoomService {
    private static List<Room> rooms = new ArrayList<Room>();
    private static int roomCount = 3;

    static {
        rooms.add(new Room(1, "admin", "Room 101", false, new Date(), false));
        rooms.add(new Room(2, "admin", "Room 102", true, new Date(), true));
        rooms.add(new Room(3, "admin", "Room 111", true, new Date(), false));
    }

    public List<Room> retrieveRooms(String user) {
        List<Room> filteredRooms = new ArrayList<Room>();
        for (Room room : rooms) {
            if (room.getUser().equalsIgnoreCase(user)) {
                filteredRooms.add(room);
            }
        }
        return filteredRooms;
    }
    
    public Room retrieveRoom(int id) {
        for (Room room : rooms) {
            if (room.getId()==id) {
                return room;
            }
        }
        return null;
    }

    public void updateRoom(Room room){
    		rooms.remove(room);
    		rooms.add(room);
    }

    public void addRoom(String name, String roomName, boolean ac, Date targetDate, boolean isAvailable) {
        rooms.add(new Room(++roomCount, name, roomName, ac, targetDate, isAvailable));
    }

    public void deleteRoom(int id) {
        Iterator<Room> iterator = rooms.iterator();
        while (iterator.hasNext()) {
            Room room = iterator.next();
            if (room.getId() == id) {
                iterator.remove();
            }
        }
    }
}