package day7;
//import java.util.Date;
class Parent{
	int num=1;
}
class Child extends Parent{
	public String toString() { 
		//조상이 갖고있지만 자신에 맞게 재설정->이름은 또같이 but 내용은 바꾸기위해='메서드 오버라이딩'
		return "child 객체 입니다~!";
	}
}

public class ParentChildTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent obj=new Parent(); //객체생성
		System.out.println(obj.toString());
		Child obj2 =new Child();
		System.out.println(obj2.toString());
		System.out.println(obj.num);
		System.out.println(obj2.num);
		System.out.println("객체의 정보: " + obj);
		System.out.println("객체의 정보: " + obj2);
		//java.util.Date d =new java.util.Data();
		//System.out.println("객체의 정보 : "+d);
	}

}
