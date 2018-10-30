package com.aszmurlo.hotelmanagementapp.web.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Room {
	@Id
	@GeneratedValue
    private int id;
	
    private String user;
    
    @Size(min=6, message="Enter at least 6 characters...")
    private String roomName;

    private boolean ac;
    
	private Date creationDate;
    private boolean isAvailable;

    public Room() {
    	super();
    }
    
    public Room(int id, String user, String roomName, boolean ac, Date creationDate, boolean isAvailable) {
        super();
        this.id = id;
        this.user = user;
        this.roomName = roomName;
        this.ac = ac;
        this.creationDate = creationDate;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    
    public boolean isAc() {
		return ac;
	}

	public void setAc(boolean ac) {
		this.ac = ac;
	}
	
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Room other = (Room)obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Room [id=%s, user=%s, roomName=%s, ac=%s, creationDate=%s, isAvailable=%s]", 
        		id, user, roomName, ac, creationDate, isAvailable);
    }
}