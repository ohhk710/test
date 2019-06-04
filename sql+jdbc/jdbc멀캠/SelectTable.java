package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTable {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jdbctest", "jdbctest");
		Statement stmt =conn.createStatement();
		ResultSet rs= stmt.executeQuery("SELECT * from product");
		
		while(rs.next()){
			//인덱스 가능 대신 테이블의 컬럼순서와 맞게 System.out.print(rs.getString(1)+"   ");
			System.out.print(rs.getString("id")+"   ");
			System.out.print(rs.getString("classid")+"   ");
			System.out.print(rs.getString("name")+"   ");
			System.out.print(rs.getString("balance")+"   ");
			System.out.println(rs.getString("price"));	
		}
		rs.close();
		stmt.close();
		conn.close();
	}

}
