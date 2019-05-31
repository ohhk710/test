package day2;

public class ForLab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num310 = (int) (Math.random() * 8)+3;
		int num13 = (int) (Math.random() * 3)+1;

		for (int i = 1; i <= num310; i++) {
			if (num13 == 1) {
				System.out.println("*");

			} else if (num13 == 2) {
				System.out.println("$");

			} else if (num13 == 3) {
				System.out.println("$");
			}
		}
	}
}