package day10;

public class ExceptionTest1 {

	public static void main(String[] args) throws InterruptedException {//예외가있구나 인지/throws로 예외처리하겠다-JVM이 알아서처리
		// TODO Auto-generated method stub
		System.out.println("수행시작");
		Thread.sleep(3000);
		//반드시 예외처리 해야되는 매서드,호출하기위해
		
		System.out.println("수행종료");
		
	}
}
