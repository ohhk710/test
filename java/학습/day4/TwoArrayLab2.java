package day4;

public class TwoArrayLab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] num = 
			{ { 10, 20, 30, 40, 50 }, 
				{ 5, 10, 15},
				{ 11, 22, 33, 44 },
				{ 9, 8, 7, 6, 5, 4, 3, 2, 1 }
				};
		
		int r1 = 0, r2 = 0, r3 = 0, r4 = 0;
		
		
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				if(i==num[i].length) {
					r1+=num[i][j];
					
				}
				if(j<num[i].length) {
					r2+=num[i][j];
					
				}if(j<num[i].length) {
					r3+=num[i][j];
					
				}if(j<num[i].length) {
					r4+=num[i][j];
				}

			}
		}
		System.out.println("1행의 합은" + r1 + " 입니다.");
		System.out.println("2행의 합은" + r2 + " 입니다.");
		System.out.println("3행의 합은" + r3 + " 입니다.");
		System.out.println("4행의 합은" + r4 + " 입니다.");

	}

}
