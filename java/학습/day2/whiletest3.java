package day2;

public class whiletest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main() 수행시작");
		char munja = '가';
		while (munja < '나') {
			System.out.printf("%c %d %x\n",(int)munja ,(int)munja, (int)munja);
			munja++;
		}
		System.out.println("main() 수행종료");

	}
}