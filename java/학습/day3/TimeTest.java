package day3;

public class TimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int time = 32150;
		int hour=time/3600, minute = time/60%60, second=time%60;
		System.out.println(hour+"시간"+ minute+"분"+ second+"초");
	}

}
