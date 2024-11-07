package food;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SnackDAO {
	// 1. 드라이버 등록확인
	public SnackDAO() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 2. db 접속하기 함수
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "C##dbexam";
		String password = "m1234";

		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 접속 성공 : Connection 객체, 접속 실패 : null
		return conn;
	}

	// 3.3. update
	public int updatesnack(String foodname, int amount) {
		String sql = "update snack set amount=amount-? where foodname =? AND amount > 0 ";
		int result = 0;
		// 1) DB 접속하기
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {
			// 2) sql 작업
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, amount);
			pstmt.setString(2, foodname);
			// 2-1) sql문 전송 2-2) 응답을 기다림 2-3) 전달된 값을 리턴함
			// => update 일 경우 , 처리된 데이터 갯수 저장
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 전체 검색
	public int selectArticle(String foodname) {
		String sql = "SELECT amount FROM snack WHERE foodname = ?";
		int result = -1; // 초기값 -1로 설정

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, foodname);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt("amount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

		return result;
	}

	// 전체 검색
	public List<SnackDTO> selectArticle1(String foodname) {
		String sql = "SELECT foodname, amount FROM snack WHERE foodname = ?";
		List<SnackDTO> list = new ArrayList<SnackDTO>();

		// 1) db 접속하기
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 2) sql 처리
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, foodname);
			// 2-1) sql 전송 2-2) 응답을 기다림 2-3) 응답결과를 리턴함
			// => select일 경우에는 검색결과가 문자열로 리턴되어옴
			// 문자열에서 1줄씩 꺼내서 resultSet 객체에 저장하고 리턴함
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SnackDTO dto = new SnackDTO();
				dto.setFoodname(rs.getString("foodname"));
				dto.setAmount(rs.getInt("amount")); // 음식의 양도 설정
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 3) db 접속끊기
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

}
