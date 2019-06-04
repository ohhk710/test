package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prob {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		kaja("E");
	}

	public static void kaja(String fn) {
//여기에 구현하시오
		String sql = "SELECT FIRST_NAME, LAST_NAME, TO_CHAR(SALARY,'999,999') " 
					+ " FROM EMPLOYEES " 
					+ " WHERE FIRST_NAME= LIKE '"
					+ fn + "%";
					
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				System.out.printf("%s(%s) %,d원 ", rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),
						rs.getInt("SALARY"));
			}

		} catch (SQLException sqle) {
			System.out.println("DB연동 오류 발생 : "+ sqle.toString());
		}
	}
}
