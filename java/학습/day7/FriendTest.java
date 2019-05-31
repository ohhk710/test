package day7;

class Person {
	private String name; //직접호출 불가 대신 getInfo 로 name 부름

	Person(String name) {
		this.name = name;
	}

	public String getInfo() {
		return name;
	}
}

class Friend extends Person {
	private String phoneNum;
	private String email;

	Friend(String name, String phoneNum, String email) {
		super(name);
		this.phoneNum = phoneNum;
		this.email = email;
	}

	public String getInfo() {
		return super.getInfo() + "  " + phoneNum + "  " + email;
		//매서드 오버라이딩 관련있는 getInfo를 super로 부름
	}
}

public class FriendTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Friend[] f = new Friend[5];

		f[0] = new Friend("a", "01000010001", "a@naver.com");
		f[1] = new Friend("b", "01000020002", "b@naver.com");
		f[2] = new Friend("c", "01000030003", "c@naver.com");
		f[3] = new Friend("d", "01000040004", "d@naver.com");
		f[4] = new Friend("e", "01000050005", "e@naver.com");

		for (int i = 0; i < f.length; i++) {
			//for(Friend data:f)
			System.out.println(f[i].getInfo());
		}
	}

}
