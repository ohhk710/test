package jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class SelectEmp {

   public static void main(String[] args)  {
      try {
         Class.forName("oracle.jdbc.OracleDriver"); 
      }catch(ClassNotFoundException e) {
         e.printStackTrace();
      }//드라이버 로딩 만을 위한 try
      
      String sql = "SELECT ENAME, TO_CHAR(SAL,'999,999'), TO_CHAR(HIREDATE, 'YYYY\"년 \"MM\"월 \"DD\"일\"')"+ "FROM EMP";
      //select문 executuequery 실행 // 띄어쓰기 입력방식 'YYYY\"년 \"MM\"월 \"DD\"일\"'
      
      Random rd = new Random();
      Boolean b = rd.nextBoolean();
       System.out.println(b);
       //boolean 랜덥식
      
      try(
      Connection conn = DriverManager.getConnection(   
    		  "jdbc:oracle:thin:@localhost:1521:XE","scott", "tiger");
    		  //연결할 주소 ,아이디,비번
    		  //이렇게도 가능 String url = "jdbc:oracle:thin:@localhost:1521:XE";
    	      //String user = "scott", pwd = "tiger";
    		 

      Statement stmt = conn.createStatement();
    		//3. SQL 문을 관리하는 Statement 객체 생성 
      ResultSet rs = stmt.executeQuery(sql);
    		//4.SQL 구문 실행
      )  { 
         if(b==true) {   
            while(rs.next())
               System.out.printf("%s 직원의 월급은 %s원입니다.\n",rs.getString("ENAME"),rs.getString("SAL"));
         }else {
        	 while(rs.next())
            System.out.printf("%s 직원은 %s에 입사하였습니다.\n",rs.getString(1),rs.getString(3));
         }
         
      }catch(Exception e) {
         System.err.println("오류 발생 : "+ e.toString());
         }//err 오류다 라는것 
   }
}