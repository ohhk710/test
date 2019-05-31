package day6;

class Member4 {
	String name;
	String account;
	String passwd;
	private int birthyear;

	void setBirthyear(int birthyear) {

		if (birthyear < 0) {
			return;
		}
		this.birthyear = birthyear;
	}

	int getBirthyear() {
		return birthyear;
	}
}

public class MemberTest4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member4 objA[] = new Member4[3];

		objA[0] = new Member4();
		objA[0].name = "피카츄";
		objA[0].account = "001";
		objA[0].passwd = "1111";
		objA[0].setBirthyear(-2000);
		// System.out.println("회원1: "+
		// objA[0].name+"("+objA[0].account+","+objA[0].passwd+","+objA[0].birthyear+")");

		objA[1] = new Member4();
		objA[1].name = "파이리";
		objA[1].account = "002";
		objA[1].passwd = "2222";
		objA[1].setBirthyear(2000);
		// System.out.println("회원2: "+
		// objA[1].name+"("+objA[1].account+","+objA[1].passwd+","+objA[1].birthyear+")");

		objA[2] = new Member4();
		objA[2].name = "꼬부기";
		objA[2].account = "003";
		objA[2].passwd = "3333";
		objA[2].setBirthyear(2000);
		// System.out.println("회원3: "+
		// objA[2].name+"("+objA[2].account+","+objA[2].passwd+","+objA[2].birthyear+")");
		for (int i = 0; i < objA.length; i++)
			System.out.println("회원" + (i + 1) + ":" + objA[i].name + "(" + objA[i].account + "," + objA[i].passwd + ","
					+ objA[i].getBirthyear() + ")");
	}
}