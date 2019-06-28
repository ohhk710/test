package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.NewsVO;

public class NewsDAO {
	private Connection connectDB() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			// DB와 연결할 Connection을 가져온다
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public boolean insert(NewsVO vo) { //삽입은 새로작성 버튼 누를시 발생! - 작성자, 제목, 내용 입력하기
		boolean result = true;
		Connection conn = connectDB();//호출해서 연결만듦
		PreparedStatement pstmt=null; //pre써서 답써야하는 쿼리문 작성. 우선 null
		try {
			pstmt = conn.prepareStatement("insert into news values(news_seq.nextval, ? , ?,?,sysdate,0)"); // ?채워줘야해서
			//news_seq.nextval 일련번호 자동 생성하여 할당 1부터 시작 1씩 증가 = 여기서는 행?칸 ? 생성// ?-작성자 ,?-제목,?-내용,날짜,cnt0부터시작
		
			pstmt.setString(1, vo.getWriter()); //vo에 저장된 값 불러 저장
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			
			int deleteNum = pstmt.executeUpdate(); // pstmt 저장되있는, 처리된 행의 수를=int 변수에 담기
			if (deleteNum != 1) 
				result = false;// 입력수 3개니 , 다되면 멈춤
		} catch (SQLException e) {
			result=false;
			System.out.println(e.getMessage());
		}finally {
			close(conn,pstmt); //try에 넣으면 오류나와도 그냥 닫힘 따라서 따로 빼주기
		}
		return result;
	}

	public boolean update(NewsVO vo) {// 수정은 타이틀 클릭시 발생 - - 작성자, 제목, 내용 수정하기 
		//이 때 클라이언트로부터 전송된 새로운 뉴스글의 Query 문자열안에는 반드시 수정하려는 뉴스글의 id 작성 = id 조건
		boolean result = true;
		Connection conn=connectDB();
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement("UPDATE NEWS SET writer=?, TITLE=?, content=? WHERE ID=?");
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getId());
			
			int deleteNum = pstmt.executeUpdate(); 
			if (deleteNum != 1) // 
				result = false;

		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}finally{
			close(conn,pstmt);
		}
		return result;
	}

	public boolean delete(int id) {
		boolean result = true;
		Connection conn=connectDB();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("delete from news where id=?");
			//반드시 클라이언트로부터 삭제하려는 글의 id 가  전송. 
			//id 변수에 전달된 id 값의 글을 delete 명령으로 삭제 하고 결과를 b oolean 타입으로
			pstmt.setInt(1, id);
			int deleteNum = pstmt.executeUpdate(); 
			if (deleteNum != 1) 
				result = false;
			
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}finally {
			close(conn,pstmt);
		}
		return result;
	}

	public List<NewsVO> listAll() {//NEWSVO를 리스트에 담아 사용하기위해 리스트 객체로 만듦 
		Connection conn = connectDB();
		ArrayList<NewsVO> list = new ArrayList<>();
		Statement stmt =null;
		ResultSet res=null; //리스트 저장값 모으기

		try {
			stmt = conn.createStatement();
			res = stmt.executeQuery(
					"select id,writer,title, content, to_char(writedate,'yyyy/mm/dd HH24:mi'), CNT from news");
			NewsVO vo;
			while (res.next()) { //저장된 곳에서 하나씩 빼서 넣기
				vo = new NewsVO();
				vo.setId(res.getInt(1)); /* 열인덱스 */
				vo.setWriter(res.getString(2));
				vo.setTitle(res.getString(3));
				vo.setContent(res.getString(4));
				vo.setWritedate(res.getString(5));
				vo.setCnt(res.getInt(6));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn, stmt, res);
		}
		return list;
	}

	public NewsVO listOne(int id) { //id 하나로 한 행 만 뽑기
		Connection conn = connectDB();
		NewsVO vo = null;
		Statement stmt = null;
		ResultSet res = null;
		
		try {
			 stmt = conn.createStatement();
			 stmt.executeUpdate("update news set cnt=cnt+1 where id="+id);
			 res = stmt.executeQuery(
				"select id,writer,title, content, to_char(writedate,'yyyy/mm/dd HH24:mi'), CNT from news where id="
							+ id);
			vo = new NewsVO();
			res.next();
			vo.setId(res.getInt(1)); /* 열인덱스 */
			vo.setWriter(res.getString(2));
			vo.setTitle(res.getString(3));
			vo.setContent(res.getString(4));
			vo.setWritedate(res.getString(5));
			vo.setCnt(res.getInt(6));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn,stmt,res);
		}
		return vo;
	}

	private void close(Connection conn, Statement stmt, ResultSet res) {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}//닫을때 
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			res.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void close(Connection conn, PreparedStatement pstmt) {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<NewsVO> listWriter(String writer){//작성자 이름 클릭시 발생 =작성자책만 리스트로 나옴. 작성자 필요
		Connection conn=connectDB();
		List<NewsVO> list=new ArrayList<NewsVO>();//여러개받을려고
		Statement stmt=null;
		ResultSet res=null;
		try {
			stmt=conn.createStatement();
			res=stmt.executeQuery("select id,writer, content ,title,to_char(writedate,'yyyy/mm/dd HH24:mi'), CNT from news where writer="
							+ writer);
			NewsVO vo;
			while(res.next()) {
				vo= new NewsVO();
				vo.setId(res.getInt(1));
				vo.setWriter(res.getString(2));
				vo.setContent(res.getString(3));
				vo.setTitle(res.getString(4));
				vo.setWritedate(res.getString(5));
				vo.setCnt(res.getInt(6));
				list.add(vo);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn,stmt,res);
		}
		return list;
		
	}
	
	public List<NewsVO> search(String key, String searchType){
		Connection conn=connectDB();
		NewsVO vo=null;
		Statement stmt=null;
		ResultSet res=null;
		List<NewsVO> list=new ArrayList<NewsVO>();
		try {
			stmt=conn.createStatement();
			res=stmt.executeQuery("select id,writer, content ,title, to_char(writedate,'yyyy/mm/dd HH24:mi'), CNT from news where "
			+searchType +" like '%"+key+"%'");
			while(res.next()) {
				vo= new NewsVO();
				vo.setId(res.getInt(1));
				vo.setWriter(res.getString(2));
				vo.setContent(res.getString(3));
				vo.setTitle(res.getString(4));
				vo.setWritedate(res.getString(5));
				vo.setCnt(res.getInt(6));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn,stmt,res);
		}
		return list;
	}

}
