package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SearchEmp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT ENAME " + "FROM EMP join dept using (deptno)" + "WHERE DNAME=?";

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
				PreparedStatement pstmt = conn.prepareStatement(sql);
				Scanner sc = new Scanner(System.in);) {

			System.out.println("Scott 계정 접속 완료");
			String deptname;
			boolean check = true;
			do {
				System.out.println("부서명 ? ");
				deptname = sc.nextLine().toUpperCase();
				pstmt.setString(1, deptname);

				try (ResultSet rs = pstmt.executeQuery()) {
					if (rs.next()) {
						// 직원 데이터 행 있음
						System.out.println(deptname + "부서에서 근무하는 직원들");
						// 이름 반복필요, 필수
						do {
							System.out.println("\t" + rs.getString("ENAME"));
						} while (rs.next());

					} else {// 직원 데이터검색 안됨 - xxx부서확인하기
						String re_sql = "SELECT DNAME" + " FROM DEPT " + "WHERE DNAME='" + deptname + "'";
						try (Statement re_stmt = conn.createStatement(); // 다시 객체생성
								ResultSet rs2 = re_stmt.executeQuery(re_sql)// 결과값받기
						) {
							// 부서검색 됨
							if (rs2.next())
								System.out.println(deptname + "부서에서 근무하는 직원이 없습니다.");
							// 부서없음
							else
								System.out.println(deptname + "부서는 존재하지 않아요. ");
						} catch (SQLException e) {
							e.printStackTrace();
						}

					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("계속? Y");
				if (!"Y".equals(sc.nextLine().toUpperCase()))
					check = false;
			} while (check);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
