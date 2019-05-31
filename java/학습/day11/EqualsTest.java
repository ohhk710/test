package day11;

import java.util.Date;

class Value{
	int value;
		Value(int value){
			this.value=value;
		}
		public boolean equals(Object obj) {//조상Object 오버라이딩
			boolean result=false;
			if(obj!=null&&obj instanceof Value)//obj는 어떤값도 올수있음 
				//v==null 이면 바로 return , 
				if(value==((Value)obj).value)
					result=true;
			return result;
		}
}

public class EqualsTest {
	public static void main(String[] args) {
		Value v1=new Value(10);
		Value v2=new Value(10);
		//값이 같아도 각각 참조변수 있어서 다른 객체임
		Value v3=new Value(20);
		System.out.println(v1.equals(null));//f
		System.out.println(v1.equals(v3));//f
		System.out.println(v1.equals(v2));//t
		System.out.println(v1.equals(new Date()));//f
		

		
//		if(v1.equals(v2))
//			System.out.println("v1과 v2는 같습니다");
//		else
//			System.out.println("v1과 v2는 다릅니다");
//		v2=v1;
//		if(v1.equals(v2))
//			System.out.println("v1과 v2는 같습니다");
//		else
//			System.out.println("v1과 v2는 다릅니다");
////		
		
		String s1 = "가나다";
		String s2 = "가나다";
		String s3 = new String("가나다");
		String s4 = new String("가나다");
		
		System.out.println(s1 == s2);//t
		System.out.println(s3 == s4);//f =string객체라 각 참조값가짐
		System.out.println(s3.equals(s4));
		
	}
}
