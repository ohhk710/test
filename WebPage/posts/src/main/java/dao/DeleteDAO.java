//package dao;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import vo.SignupVO;
//
//@Repository
//public class DeleteDAO {
//   @Autowired
//   SqlSession session=null;
//   
//   //id확인후 삭제
//   public boolean deleteAccount(int u_id) {
//      
//      String statement= "resources.LoginMapper.deleteAccount";
//      int a=session.delete(statement,u_id);
//      if(a!=1)
//         return false;
//      return true;
//   }
//   //비밀번호 확인
//   public boolean chkpasswd(SignupVO vo) {
//	   boolean result=false;
//      String statement= "resources.LoginMapper.chkpasswd";
//      int count=session.selectOne(statement,vo);
//      System.out.println(count);
//      if(count==1)
//    	  result=true;
//      return result;
//   }
//   //이메일수정 mapper와 연결 업뎃성공=0.실패=1
//   public boolean updateEmail(SignupVO vo) {
//	   String statement= "resources.LoginMapper.updateEmail";
//	   int a = session.update(statement, vo);
//	   if(a !=1)
//		   return false;
//	   return true;
//   }
//	
//	  //비밀번호수정 mapper와 연결 
//   public boolean updatePasswd(SignupVO vo) {
//	   String statement= "resources.LoginMapper.updatePasswd";
//	   int a=session.update(statement, vo);
//	   if(a !=1)
//		   return false;
//	   return true;
//   }
//}
