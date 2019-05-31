package day3;

public class ForLab4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final char STAR = '*';
		for (int i = 1; i <= 7; i++) {
			for (int j = 7; j >= i; j--) {
				System.out.print(STAR);
			}
			System.out.println("");
		}

	}
}
