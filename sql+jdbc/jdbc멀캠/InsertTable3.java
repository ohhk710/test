package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTable3 {//preparedStatement 수행속도 빠름 .처리할 데이터가 이미지같은 경우 반드시

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			//JDBC 드라이버를 로드한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//데이터 베이스에 접속한다. 적절한 jdbc url 설정한다.
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jdbctest", "jdbctest");
			PreparedStatement stmt =conn.prepareStatement(
					"INSERT into product values (?,?,?,?,?)");
			
			stmt.setString(1, args[0]);

			stmt.setString(2, args[1]);

			stmt.setString(3, args[2]);

			stmt.setInt(4, Integer.parseInt(args[3]));
			stmt.setFloat(5, Float.parseFloat(args[4]));
			
			stmt.executeUpdate();
			System.out.println("데이터들을 추가하였습니다.");
			
			stmt.close();
			conn.close();
		}catch(SQLException e){
			System.out.println("오류 발생 : "+ e);
		}
	}
}
