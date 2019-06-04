package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchEmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {//1. 드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT ENAME, TO_CHAR(HIREDATE,'YYYY\"년\"MM\"월\"'),deptno" + " FROM EMP " + " Where ENAME=? ";
		// 값 바꿀때  where 다음에 '=?' 이렇게 씀  . FROM EMP 양옆에 꼭 띄어쓰기 해야함 안그러면 합쳐져서 인식못함

		Scanner sc = new Scanner(System.in);
//		String nm=sc.nextLine();

		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "tiger");
				//2. DB와 연결
				PreparedStatement pstmt = conn.prepareStatement(sql);// sql실행위해 객체생성/ while 문 전에
				// perparedStatement =질의문에 물음표가 있을때 사용하는 것
		) {
			ResultSet rs;
			while (true) {// while문안에 변수 선언x
				// 디비 정보를 검색한 결과만큼 반복실행하여 데이터를 하나씩 꺼내와서 화면에 출력
				System.out.println("직원 이름? ");
				String name = sc.next().toUpperCase();
				
				pstmt.setString(1, name);// 첫번째 물음표 , 대체할것
				rs = pstmt.executeQuery();// 결과 찾을때, 매번 실행해야하니까 , 
				
				if (rs.next()) {
					System.out.println(rs.getString("ENAME") + "직원은 근무중입니다.");
					System.out.println(rs.getString(2) + "에 입사했고 현재 " + rs.getInt(3) + "부서에서 근무하고 있습니다.");
				} else {
					System.out.println(name + "직원은 근무하지 않습니다");
				}
				System.out.println("계속 =1 아니면 2");
				int a = sc.nextInt();
				if (a == 1) {
					continue;
				} else {
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
