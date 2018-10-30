package com.aszmurlo.hotelmanagementapp.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aszmurlo.hotelmanagementapp.web.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
	// service.retrieveRooms(name)
	List<Room> findByUser(String name);
}
