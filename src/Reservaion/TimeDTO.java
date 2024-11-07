package Reservaion;


import java.sql.Connection;
import java.sql.DriverManager;

public class TimeDTO {
	int roomnum;
	int num;
	String room;
	String time;
	int count;
	
	public TimeDTO() {

	}
	
	public TimeDTO( String time) {
		super();

		this.time = time;
	}
	
	public TimeDTO( String time, int count) {
		super();

		this.time = time;
		this.count = count;
	}

	
	public TimeDTO(String room, String time, int count) {
		super();

		this.room = room;
		this.time = time;
		this.count = count;
	}

	public TimeDTO(int roomnum, int num, String room, String time, int count) {
		super();
		this.roomnum = roomnum;
		this.num = num;
		this.room = room;
		this.time = time;
		this.count = count;
	}

	@Override
	public String toString() {
		return "TimeDAO [roomnum=" + roomnum + ", num=" + num + ", room=" + room + ", time=" + time + ", count=" + count
				+ "]";
	}

	public int getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}

