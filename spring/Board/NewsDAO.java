package dao;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.NewsVO;

@Repository
public class NewsDAO {
	@Autowired
	SqlSession session = null;
	
	public boolean insert(NewsVO vo) {
		boolean result=true;
		String statement = "resource.NewsMapper.insert";
		if(session.insert(statement, vo) != 1)
			result = false;
		return result;
}
	
	public boolean update(NewsVO vo) {
		boolean result=true;
		String statement = "resource.NewsMapper.update";
		if(session.update(statement, vo) != 1)
			result = false;
		return result;	
	}	
	
	public boolean delete(int id) {
		boolean result=true;
		String statement = "resource.NewsMapper.delete";
		if(session.delete(statement, id) != 1)
			result = false;
		return result;
	}

	public List<NewsVO> listAll(){ 
		List<NewsVO> list=null;
		String statement ="resource.NewsMapper.listAll";
		list=session.selectList(statement); 
		return list;
	}
		
	public NewsVO listOne(int id) {
		NewsVO vo=null;
		String statementCnt = "resource.NewsMapper.cnt";
		String statement ="resource.NewsMapper.listOne";
		vo=session.selectOne(statement, id);
		vo=session.selectOne(statementCnt, vo);
		vo=session.selectOne(statement, id);
		return vo;
	}
		
		
	public List<NewsVO> listWriter(HashMap<String, String> hash){
		List<NewsVO> list=null;
		String statement ="resource.NewsMapper.listWriter";
		list=session.selectList(statement,hash); 
		return list;
	}
	
	public List<NewsVO> search(HashMap<String, String> hash){ 
		List<NewsVO> list=null;
		String statement ="resource.NewsMapper.listWriter";
		list=session.selectList(statement,hash);
		return list;
	}
}