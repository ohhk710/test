package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VisitorList2 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// TODO Auto-generated method stub
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 오라클 메모리에 올리는것. 안되면 class not found exception
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", // jdbc url, 오라클접속
					// LOCALHOST = 지금 서버위치/ 1521 접속할 서버위치
					"jdbctest", "jdbctest");
			stmt = conn.createStatement();
			String sql = "SELECT NAME, WRITEDATE, MEMO FROM VISITOR";
			rs = stmt.executeQuery(sql);
			
			System.out.println(conn.getClass().getName());
			System.out.println(stmt.getClass().getName());
			System.out.println(rs.getClass().getName());
			
			while (rs.next()) {
				System.out.print(rs.getString("NAME"));

				System.out.print(rs.getString("WRITEDATE"));

				System.out.println(rs.getString("MEMO"));
			}
		} catch (Exception e) {
			System.err.println("오류발생 : " + e);

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
