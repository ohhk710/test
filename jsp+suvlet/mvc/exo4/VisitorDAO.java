package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.VisitorVO;

/*connection 객체를 미리 만들어 놓고 그것을 가져다 쓰는것입니다. 또 다쓰고 난 후에는 반환해 놓는 것. 
 * 하지만 유저 한명이 접속해서 한번에 하나의 커넥션만 일으키지 않고 게시판 하나만 봐도 목록볼때 한번, 글읽을때마다 한번, 글쓸때 한번 등등… 
 * 엄청나게 많은 커넥션이 일어나기에, 커넥션풀은 커넥션을 또 만드는 오버헤드를 효율적으로 하기 위해 DB에 접속하는 객체를 전용으로 하나만 만들고,
 *  모든 페이지에서 그 객체를 호출해다 사용한다면? 이렇게 커넥션을 하나만 가져오고 
 *  그 커넥션을 가져온 객체가 모든 DB와의 연결을 하는것이 바로 DAO 객체
*/
public class VisitorDAO {
	//Data Access Object의 약자로 간단히 Database의 data에 접근을 위한 객체
	public ArrayList<VisitorVO> listAll() {
		
		ArrayList<VisitorVO> list = new ArrayList<VisitorVO>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//DB와 연결할 Connection을 가져온다
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest",
				"jdbctest");
				//어떤 DB를 사용할 것이며, 어떤 드라이브와 로그인 정보를 사용할 것인가
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
						"select name, to_char(writedate, 'yyyy\"년\" mm\"월\" dd\"일\"'), memo,id from visitor")) {
			VisitorVO vo;
			while (rs.next()) {
				vo = new VisitorVO();
				vo.setName(rs.getString(1));
				vo.setWriteDate(rs.getString(2));
				vo.setMemo(rs.getString(3));
				vo.setId(rs.getInt(4));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<VisitorVO> search(String keyword) {
		ArrayList<VisitorVO> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest",
				"jdbctest");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt
						.executeQuery("select , name, to_char(writedate, 'yyyy\"년\" mm\"월\" dd\"일\"'), memo,id "
								+ "from visitor where memo like '%" + keyword + "%'")) {
			VisitorVO vo;
			while (rs.next()) {
				vo = new VisitorVO();
				vo.setName(rs.getString(1));
				vo.setWriteDate(rs.getString(2));
				vo.setMemo(rs.getString(3));
				vo.setId(rs.getInt(4));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean insert(VisitorVO vo) {
		boolean result = true;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest",
				"jdbctest");
				PreparedStatement pstmt = conn
						.prepareStatement("insert into visitor values(?, sysdate, ?,visitor_seq.nextval)");) {
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getMemo());
			pstmt.executeQuery();
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

	public boolean delete(int id) {
		boolean result = true;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest",
				"jdbctest"); PreparedStatement pstmt = conn.prepareStatement("delete from visitor where id=?");) {
			pstmt.setInt(1, id);
			int deleteNum = pstmt.executeUpdate();
			if (deleteNum != 1)
				result = false;

		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
}
