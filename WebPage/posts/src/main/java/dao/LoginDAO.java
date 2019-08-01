package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.SignupVO;
import vo.Privilege;

@Repository
public class LoginDAO {
	@Autowired
	SqlSession sqlsession = null;

	// 로그인시 DB에서 logininfo 메퍼를 통해 받은 vo값을 db에 찾아 반환 (아이디 비번)
	public SignupVO logininfo(SignupVO vo) {
		// TODO Auto-generated method stub
		String statement = "LoginMapper.logininfo";

		return sqlsession.selectOne(statement, vo);
	}

	//db에 insert하기 가입하기
	public boolean signup(SignupVO vo) {
		String statement ="LoginMapper.signupmember";
		boolean result=true;//가입 성공하면 = 사용자는 권한이 주어짐 =user 옵션
		vo.setPrivilege(Privilege.valueOf("USER"));//enum 클라스로 속성부여
		if(sqlsession.insert(statement,vo)!=1)
			return false;
		return result;
	}

	// chkid 1 or 0
	public int chkid(String u_id) {
		String statement = "LoginMapper.chkid";
		return sqlsession.selectOne(statement, u_id);
	}
	public int chkemail(String email) {
		String statement ="LoginMapper.chkemail";
		return sqlsession.selectOne(statement,email);
	}
	

}
