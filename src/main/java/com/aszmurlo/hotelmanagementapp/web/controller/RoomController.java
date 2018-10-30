package com.aszmurlo.hotelmanagementapp.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.aszmurlo.hotelmanagementapp.web.model.Room;
import com.aszmurlo.hotelmanagementapp.web.service.RoomRepository;
import com.aszmurlo.hotelmanagementapp.web.service.RoomService;

@Controller
public class RoomController {

	@Autowired
	RoomService service;

	@Autowired
	RoomRepository repository;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-rooms", method = RequestMethod.GET)
	public String showRooms(ModelMap model) {
		String name = getLoggedInUserName(model);
		model.put("rooms", repository.findByUser(name));
		//model.put("rooms", service.retrieveRooms(name));
		return "list-rooms";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal instanceof UserDetails) {
			return ((UserDetails)principal).getUsername();
		}
		return principal.toString();
	}

	@RequestMapping(value = "/add-room", method = RequestMethod.GET)
	public String showAddRoomPage(ModelMap model) {
		model.addAttribute("room", new Room(0, getLoggedInUserName(model), "Room ", false, new Date(), true));
		return "room";
	}

	@RequestMapping(value = "/delete-room", method = RequestMethod.GET)
	public String deleteRoom(@RequestParam int id) {
		repository.deleteById(id);
		//service.deleteRoom(id);
		return "redirect:/list-rooms";
	}

	@RequestMapping(value = "/update-room", method = RequestMethod.GET)
	public String showUpdateRoomPage(@RequestParam int id, ModelMap model) {
		Room room = repository.findById(id).get();
		//Room room = service.retrieveRoom(id);
		model.put("room", room);
		return "room";
	}

	@RequestMapping(value = "/update-room", method = RequestMethod.POST)
	public String updateRoom(ModelMap model, @Valid Room room, BindingResult result) {
		if (result.hasErrors()) {
			return "room";
		}

		room.setUser(getLoggedInUserName(model));
		repository.save(room);
		//service.updateRoom(room);

		return "redirect:/list-rooms";
	}

	@RequestMapping(value = "/add-room", method = RequestMethod.POST)
	public String addRoom(ModelMap model, @Valid Room room, BindingResult result) {
		//String roomNameErrorText;
		
		if (result.hasErrors()) {
			return "room";
		}

		for (Room roomm: repository.findAll()) {
			if (room.getRoomName().equals(roomm.getRoomName()))
				//roomNameErrorText = "This room name already exists";
				return "room";
		}
		
		room.setUser(getLoggedInUserName(model));
		repository.save(room);
		//service.addRoom(getLoggedInUserName(model), room.getRoomName(), false, room.getCreationDate(), false);
		
		return "redirect:/list-rooms";
	}
}