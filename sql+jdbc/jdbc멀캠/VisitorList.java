package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VisitorList {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 오라클 메모리에 올리는것. 안되면 class not found exception
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", // jdbc url, 오라클접속
				// LOCALHOST = 지금 서버위치/ 1521 접속할 서버위치
				"jdbctest", "jdbctest");
		Statement stmt = conn.createStatement();
		String sql = "SELECT NAME, WRITEDATE, MEMO FROM VISITOR";
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			System.out.print(rs.getString("NAME"));

			System.out.print(rs.getString("WRITEDATE"));

			System.out.println(rs.getString("MEMO"));
		}
		rs.close();
		stmt.close();
		conn.close();
	}

}
