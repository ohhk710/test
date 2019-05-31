package day3;

public class arraytest5 {

	public static void main(String[] args) {
		int su = (int) (Math.random() * 6) + 5;
		int[] ary = new int[su];
		System.out.println("배열의 크기: " + ary.length);

		for (int i = 0; i < ary.length; i++) {
			ary[i] = (int) (Math.random() * 45) + 1;
		}
		for (int d : ary)
			System.out.print(d + " ");

		int max = ary[0];
		for (int i = 1; i < ary.length; i++) {
			if (max < ary[i]) {
				max = ary[i];
			}
		}System.out.println("\n최댓값 = "+max);
	
	}
}
