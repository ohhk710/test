package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.MeetingVO;

public class MeetingJDBCDAO implements MeetingDAO { //상속받기
	public ArrayList<MeetingVO> listAll() {
		
		ArrayList<MeetingVO> list = new ArrayList<>();
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
						"select id,name,title, to_char(meetingDate,'yyyy\"년\" mm\"월\" dd\"일\" hh24 \"시 \" mi\"분\"') from meeting");) {
			MeetingVO vo;
			while (rs.next()) {
				vo = new MeetingVO();
				vo.setId(rs.getInt(1)); /* 열인덱스 */
				vo.setName(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setMeetingDate(rs.getString(4));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<MeetingVO> search(String keyword) {
		ArrayList<MeetingVO> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest",
				"jdbctest");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select id,name,title,to_char(meetingDate,'yyyy\"년\" mm\"월\" dd\"일\" hh24 \"시 \" mi\"분\"'),"
						+"title from meeting where memo like '%" + keyword + "%'");) {
			MeetingVO vo;
			while (rs.next()) {
				vo = new MeetingVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setMeetingDate(rs.getString(4));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean insert(MeetingVO vo) {
		boolean result = true;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest",
				"jdbctest");
				PreparedStatement pstmt = conn
						.prepareStatement("insert into meetingdate values(meetingdate_seq.nextval,?,?,to_date(?,'yyyy-mm-dd\"T\"hh24:mi'))");) {
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getMeetingDate());
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
				"jdbctest"); PreparedStatement pstmt = conn.prepareStatement("delete from meetingdate where id=?");) {
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
	
	public boolean update(MeetingVO vo) {
		boolean result=true;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest","jdbctest"); 
				PreparedStatement pstmt = conn.prepareStatement(
						"UPDATE MEETING SET"
						+"NAME=?"
						+"TITLE=?"
						+"datetime = TO_DATE(?,yyyy-mm-dd\\\"T\\\"+hh24:mi')"
						+"WHERE id=?");){
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getMeetingDate());
			pstmt.setInt(4, vo.getId());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}	
}
