package day7;

class A {
	A() {
		super();
		System.out.println("A클래스의 객체 생성");
	}
}

class B extends A {
	B(int su) {
		System.out.println("B클래스의 객체 생성");
	}
}

class C extends B {
	C() {
		super(10);
		System.out.println("C클래스의 객체 생성");
	}
}

public class ABCTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new C();
	}

}
