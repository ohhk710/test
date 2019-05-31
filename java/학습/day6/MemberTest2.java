package day6;

class Member2 {
	String name;
	String account;
	String passwd;
	int birthyear;
}

public class MemberTest2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member2 objA[] = new Member2[3];

		objA[0] = new Member2();
		objA[0].name = "피카츄";
		objA[0].account = "001";
		objA[0].passwd = "1111";
		objA[0].birthyear = 2000;
		// System.out.println("회원1: "+
		// objA[0].name+"("+objA[0].account+","+objA[0].passwd+","+objA[0].birthyear+")");

		objA[1] = new Member2();
		objA[1].name = "파이리";
		objA[1].account = "002";
		objA[1].passwd = "2222";
		objA[1].birthyear = 2000;
		// System.out.println("회원2: "+
		// objA[1].name+"("+objA[1].account+","+objA[1].passwd+","+objA[1].birthyear+")");

		objA[2] = new Member2();
		objA[2].name = "꼬부기";
		objA[2].account = "003";
		objA[2].passwd = "3333";
		objA[2].birthyear = 2000;
		// System.out.println("회원3: "+
		// objA[2].name+"("+objA[2].account+","+objA[2].passwd+","+objA[2].birthyear+")");
		for (int i = 0; i < objA.length; i++)
			System.out.println("회원" + i + ":" + objA[i].name + "(" + objA[i].account + "," + objA[i].passwd + ","
					+ objA[i].birthyear + ")");
	}
}