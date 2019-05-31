package day4;

public class TwoArrayTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = 
			  { { 10, 20, 30, 40 }, 
				{ 11, 21, 31, 41 }, 
				{ 12, 22, 32, 42 }, 
				{ 13, 23, 33, 43 }, };
//		System.out.println(nums[1][2]);

//		for(int j=0;j<nums[2].length;j++)
//				System.out.println(nums[2][j]); //3행만출력
		/*
		 * for(int data: nums[2]) System.out.println(data);
		 */

//		for(int i=0;i<nums.length;i++)
//			System.out.println(nums[i][3]); //4열만 출력

//		for (int i = 0; i < nums.length; i++) {
//			for (int j = 0; j < nums[i].length; j++) {
//				System.out.print(nums[i][j] + " ");
//				i++;
//			}
//		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = 3; j == i; j--) {
				System.out.print(nums[i][j] + " ");
				i++;

			}
		}
	}
}
