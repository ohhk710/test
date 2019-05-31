package day4;

public class TwoArrayTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums=new int[3][4];
		
		for(int row=0; row<nums.length;row++) {
			for (int col=0; col<nums[row].length;col++)
				System.out.println(nums[row][col]+"  ");
			System.out.println();
		}
		for(int[] rowData :nums) {
			for(int data: rowData)
				System.out.println(data+" ");
		}
	}

}
