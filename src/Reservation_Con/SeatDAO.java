package Reservation_Con;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultButtonModel;
import javax.swing.DefaultListModel;

import oracle.jdbc.proxy.annotation.Pre;

public class SeatDAO {
	// 1. db 연결
	public SeatDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// System.out.println("연결 완 ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}



	// 2. 로그인
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "C##dbexam";
		String password = "m1234";

		try {
			conn = DriverManager.getConnection(url, user, password);
			// System.out.println("로그인 완");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}


	// 각 정보 저장해두기 
	public int imfosave(SeatDTO seatdto) {
		String sql = "insert into reservation values (?, ?, ?, ?, ?, ?)";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int result =0 ;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seatdto.getImage());
			pstmt.setString(2, seatdto.getMvname());
			pstmt.setString(3, seatdto.getCal());
			pstmt.setString(4, seatdto.getTime());
			pstmt.setString(5, seatdto.getRoom());
			pstmt.setInt(6, seatdto.getCount());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	
	}


		
}
