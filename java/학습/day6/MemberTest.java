package day6;

class Member{
	String name;
	String account;
	String passwd;
	int birthyear;	
}

public class MemberTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member mb1=new Member();
		mb1.name="피카츄";
		mb1.account="001";
		mb1.passwd="1111";
		mb1.birthyear=2000;
		System.out.println("회원1: "+ mb1.name+"("+mb1.account+","+mb1.passwd+","+mb1.birthyear+")");
		
		Member mb2=new Member();
		mb2.name="파이리";
		mb2.account="002";
		mb2.passwd="2222";
		mb2.birthyear=2000;
		System.out.println("회원2: "+ mb2.name+"("+mb2.account+","+mb2.passwd+","+mb2.birthyear+")");
		
		Member mb3=new Member();
		mb3.name="꼬부기";
		mb3.account="003";
		mb3.passwd="3333";
		mb3.birthyear=2000;
		System.out.println("회원3: "+ mb3.name+"("+mb3.account+","+mb3.passwd+","+mb3.birthyear+")");		
	}
}
