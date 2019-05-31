package day3;

public class WhileLab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num030 = (int) (Math.random() * 31);
		
		int i = 0;
		while (1 <= num030 && num030 <= 26) {
			char AlphaInt = (char) (num030 + 64);
			System.out.println(AlphaInt + "(" + num030 + ")");
			i++;
		    num030 = (int) (Math.random() * 31);
		}
		
		System.out.println("수행횟수는 " + i + " 번입니다");
	}
}
