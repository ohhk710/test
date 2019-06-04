package jdbcexam;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class ConnectDB {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//오라클 메모리에 올리는것. 안되면 class not found exception
		Connection conn =DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:XE",//jdbc url, 오라클접속
						//LOCALHOST = 지금 서버위치/ 1521 접속할 서버위치
						"jdbctest", "jdbctest");
		System.out.println(conn.getClass().getName());//참조하게된 객체에 클라스정보
		DatabaseMetaData mdata=conn.getMetaData();

		System.out.println(mdata.getClass().getName());
		
		System.out.println("접속된 db 서버 : "+mdata.getDatabaseProductName());
		
		conn.close();
	}

}
