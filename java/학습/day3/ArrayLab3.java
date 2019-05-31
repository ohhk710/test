package day3;

public class ArrayLab3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] IntAry = new int[10];// 1~10은 그대로 사용

		char[] CharAry = new char[10];// A는 65, a는 96

		for (int i = 0; i < IntAry.length; i++) {
			IntAry[i] = (int) (Math.random() * 26) + 1;
			CharAry[i] = (char) (IntAry[i] + 64);
		}
		for (int i = 0; i < IntAry.length; i++) {
			System.out.print(IntAry[i]);
			if (IntAry.length - 1 != i)
				System.out.print(",");
			else
				System.out.println();
		}

		for (int i = 0; i < CharAry.length; i++) {
			System.out.print(CharAry[i]);
			if (CharAry.length - 1 != i)
				System.out.print(",");
			else
				System.out.println();
		}

	}

}
