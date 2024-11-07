package food;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SnackBackDAO {
	// 1. 드라이버 등록확인
	public SnackBackDAO() {

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

	// 장바구니에 담기
	public int snackbag(SnackBackDTO Backdto) {
		String sql = "insert into snackback values (?,?,?,?,?)";

		int result = 0;
		// 1) db 접속하기
		Connection conn = getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Backdto.getNum());
			pstmt.setString(2, Backdto.getFoodname());
			pstmt.setInt(3, Backdto.getPrice());
			pstmt.setInt(4, Backdto.getAmount());
			pstmt.setInt(5, Backdto.getPricetot());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	// 장바구니 결제 하기
	public List<SnackBackDTO> snackbagTOT(int num) {
		List<SnackBackDTO> list = new ArrayList<SnackBackDTO>();
		String sql = "select * from snackback where num = ?";

		// 1) db 접속하기
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				 num = rs.getInt("num");
				String foodname = rs.getString("foodname");
				int price = rs.getInt("price");
				int amount = rs.getInt("amount");
				int pricetot = rs.getInt("pricetot");

				SnackBackDTO Backdto = new SnackBackDTO(num,foodname, price, amount, pricetot);
				list.add(Backdto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

}
