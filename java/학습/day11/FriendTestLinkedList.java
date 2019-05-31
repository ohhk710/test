package day11;
import java.util.*;//제네릭스할때 꼭해야함
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

public class FriendTestLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Friend[] f = new Friend[5];
//
//		f[0] = new Friend("a", "01000010001", "a@naver.com");
//		f[1] = new Friend("b", "01000020002", "b@naver.com");
//		f[2] = new Friend("c", "01000030003", "c@naver.com");
//		f[3] = new Friend("d", "01000040004", "d@naver.com");
//		f[4] = new Friend("e", "01000050005", "e@naver.com");
		LinkedList <String> fri=new LinkedList <String>();
		fri.add("a 01000010001 a@naver.com");
		fri.add("b 01000020002 b@naver.com");
		fri.add("c 01000030003 c@naver.com");
		fri.add("d 01000040004 d@naver.com");
		fri.add("e 01000050005 e@naver.com");
		
		//문자열 길이=size()
		//get() linkedlist에서 리스트데이터 호출
//		for (int i = 0; i < fri.size(); i++) {
//			System.out.println(fri.get(i));
//		}
		for(String data:fri) {
			System.out.println(data);
		}
	}

}
