package day11;


class Value1{
	String obj;
	void put(String obj) {
		this.obj=obj;
	}
	String get() {
		return obj;
	}
}
class Value2{
	Object obj;
	void put(Object obj) {
		this.obj=obj;
	}
	Object get() {
		return obj;
	}
}
class Value3<TT>{ //제네릭스구문 타입파라미터에따라 다바뀜
	TT obj;
	void put(TT obj) {
		this.obj=obj;
	}
	TT get() {
		return obj;
	}
}


public class CreateGenericTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Value1 o1 =new Value1();
		o1.put("abc");
		String s1=o1.get();
		System.out.println(s1);
		
		Value2 o2 =new Value2();
		o1.put("abc");
		String s2=(String)o1.get();
		System.out.println(s2);
		
		Value3<String> o3 =new Value3<String>();
		o1.put("abc");
		String s3=o3.get();//형변환필요없음
		System.out.println(s3);
//		
//		Value4 <Date> o4 =new Value4 <Date>();
//		o4.put(new Date());
//		Date s4=o4.get();//형변환필요없음
//		System.out.println(s4);
	}
}
