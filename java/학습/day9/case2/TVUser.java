package day9.case2;

public class TVUser {
	public static void main(String[] args) {
		TV tv = new SamsungTV();//호출방식 규격화TV.java ,따라서 삼성을 lg라고해도 가능함
		//TV만 상속받은 자손객체만 적용가능
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
	}

}
