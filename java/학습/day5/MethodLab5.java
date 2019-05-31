package day5;

public class MethodLab5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] r1 = powerArray(2);
		int[] r2 = powerArray(3);
		int[] r3 = powerArray(4);
		
		print(r1);
		System.out.println();
		print(r2);
		System.out.println();
		print(r3);
	}

	static int[] powerArray(int n) {
		int[] ary = new int [10]; 
		for (int i = 0; i<ary.length; i++) {
				ary[i] = ary[i+1] * n;
		}
		return ary;
	}

	static void print(int[] num) {
		for (int i = 0; i < 10; i++) {
			if (i == num.length - 1)
				System.out.println(num[i]);
			else
				System.out.print(num[i] + ", ");

		}
	}
}