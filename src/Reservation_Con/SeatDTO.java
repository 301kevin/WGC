package Reservation_Con;

import java.sql.Connection;
import java.sql.DriverManager;

public class SeatDTO {
	

	String image;
	String mvname;
	String cal;
	String time;
	String room;
	int count;

	public SeatDTO(String image, String mvname, String cal, String time, String room, int count) {
		super();
		this.image = image;
		this.mvname = mvname;
		this.cal = cal;
		this.time = time;
		this.room = room;
		this.count = count;
	}

	
	public SeatDTO() {

	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMvname() {
		return mvname;
	}

	public void setMvname(String mvname) {
		this.mvname = mvname;
	}

	public String getCal() {
		return cal;
	}

	public void setCal(String cal) {
		this.cal = cal;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	

}