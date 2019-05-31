package day3;

public class ArrayLab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] Java = { 'M', 'a', 'v', 'a' };
		
		for (int i = 0; i < Java.length; i++) {
			if (65 <= Java[i] && Java[i] <= 90) {
				Java[i] += 32;
			} else {
				Java[i] -= 32;

			}
			if (i == Java.length - 1) {
				System.out.print(Java[i]);
			} else {
				System.out.print(Java[i] + ",");
			}
		}

	}

}
