package day3;

public class ArrayLab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[10];

		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 21) + 4;
			if (i == num.length-1) {
				System.out.println(num[i]);
			} else {
				System.out.print(num[i] + ",");
			}
		}	
		int sum=0, i=0;
		while(i<num.length) {
			sum+=num[i];
			i++;
		}
		System.out.println("모든 원소의 합 : " + sum);

	}
}
