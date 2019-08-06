package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import vo.OnePersonVO;

@Repository
public class OnePersonDAO {
	@Autowired
	@Qualifier("hiveDataSource")	
	DataSource ds;
	
	public List<OnePersonVO> select1() {
		List<OnePersonVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from oneperson order by personnb desc");
			OnePersonVO vo = null;
			while(rs.next()) {
				vo = new OnePersonVO();
				vo.setGu(rs.getString(1));
				vo.setDong(rs.getString(2));
				vo.setPersonnb(rs.getInt(3));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				if( conn != null ) conn.close();
			} catch (Exception e) {
				e.printStackTrace();				
			} 
		}
		return list;		
	}
	public List<OnePersonVO> select2() {
		List<OnePersonVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select gu,sum(personnb) from oneperson group by gu");
			OnePersonVO vo = null;
			while(rs.next()) {
				vo = new OnePersonVO();
				vo.setGu(rs.getString(1));
				vo.setPersonnb(rs.getInt(2));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				if( conn != null ) conn.close();
			} catch (Exception e) {
				e.printStackTrace();				
			} 
		}
		return list;		
	}
	public List<OnePersonVO> select3() {
		List<OnePersonVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select gu, dong, personnb from oneperson order by personnb desc limit 1");
			OnePersonVO vo = null;
			while(rs.next()) {
				vo = new OnePersonVO();
				vo.setGu(rs.getString(1));
				vo.setDong(rs.getString(2));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				if( conn != null ) conn.close();
			} catch (Exception e) {
				e.printStackTrace();				
			} 
		}
		return list;		
	}	
	public List<OnePersonVO> select4() {
		List<OnePersonVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select gu, sum(personnb) pn from oneperson group by gu order by pn desc limit 1");
			OnePersonVO vo = null;
			while(rs.next()) {
				vo = new OnePersonVO();
				vo.setGu(rs.getString(1));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				if( conn != null ) conn.close();
			} catch (Exception e) {
				e.printStackTrace();				
			} 
		}
		return list;		
	}	
	public List<OnePersonVO> search(String guname) {
		List<OnePersonVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from oneperson where gu='"+guname+"'");
			OnePersonVO vo = null;
			while(rs.next()) {
				vo = new OnePersonVO();
				vo.setGu(rs.getString(1));
				vo.setDong(rs.getString(2));
				vo.setPersonnb(rs.getInt(3));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( stmt != null ) stmt.close();
				if( conn != null ) conn.close();
			} catch (Exception e) {
				e.printStackTrace();				
			} 
		}
		return list;		
	}	
}
