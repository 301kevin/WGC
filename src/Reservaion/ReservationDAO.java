package Reservaion;

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

public class ReservationDAO {
	// 1. db 연결
	public ReservationDAO() {
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

	// 인기순 나열 = 영화 이름만
	public DefaultListModel<String> popdesc() {
		String sql = "select * from movie order by num asc";
		DefaultListModel<String> list = new DefaultListModel<String>();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");

				list.addElement(name);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 3. db 접속 끊기
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// 좌석 수만 출력 
	public DefaultListModel<String> namedesc() {
		String sql = "select * from room order by roomnum,num asc";
		DefaultListModel<String> list = new DefaultListModel<String>();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				list.addElement(name);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 3. db 접속 끊기
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// 사진 매칭
	public String mvimagedesc(String name) {
		List<ReservationDTO> list = new ArrayList<ReservationDTO>();
		String sql = "select * from movie where name = ?";

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String imagename = "";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				imagename = rs.getString("image");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 3. db 접속 끊기
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return imagename;
	}

}
