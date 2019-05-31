package day6;

class Student {
	String name;
	String project;
	int age;

	// 클래스의 변수 지정= 클래스 멤버
	void study() {
		System.out.println(name + " 학생이 " + project + "을 학습합니다");
	}

	String getStudentInfo() {
		return "이름: " + name + ", 나이:" + age;
	}
}

public class studentTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student st1 = new Student();// 객체 생성
		st1.name = "둘리";
		st1.project = "수학";
		st1.age = 10;
		st1.study();
		System.out.println(st1.getStudentInfo());

		Student st2 = new Student();// 객체 생성
		st2.name = "듀크";
		st2.project = "과학";
		st2.age = 24;
		st2.study();
		System.out.println(st2.getStudentInfo());

		st1=st2;// 같은 객체 참조값.메모리상의 4바이트 나옴 
		System.out.println("st1=st2");
		System.out.println(st1.name);//st1=st2 하면 st2 값으로 대체됨
		System.out.println(st2.name);
		
	}
}
