package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VisitorList4 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "SELECT NAME, WRITEDATE, MEMO FROM VISITOR";

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
				// jdbc url, 오라클접속. LOCALHOST = 지금 서버위치/ 1521 접속할 서버위치
				"jdbctest", "jdbctest");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			// 객체 리턴갑없으면 null이 아니라, 비워있는 resultset 객체 리턴됨
			// rs 만으로 확인 불가 따라서 next 호출해야만 알수있음{
			// 추출된 결과가 한 행이라도 존재하면 리스틀를 출력하고 없으면 "추출된 행 없음" 이라고 출력
			// 오라클 메모리에 올리는것. 안되면 class not found exception
			if (rs.next()) {
				do {// 무조건 한번실행 이 반복문 2번보다 나음
					System.out.print(rs.getString("NAME"));
					System.out.print(rs.getString("WRITEDATE"));
					System.out.println(rs.getString("MEMO"));
				} while (rs.next());// 세미콜론!

			} else {
				System.out.println("추출행 없음");
			}
		} catch (Exception e) {
			System.err.println("오류발생 : " + e.toString());
		}
	}
}

//			if (rs.next()) {
//				while (rs.next()) {
//					System.out.print(rs.getString("NAME"));
//					System.out.print(rs.getString("WRITEDATE"));
//					System.out.println(rs.getString("MEMO"));
//				}
