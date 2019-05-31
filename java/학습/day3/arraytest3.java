package day3;

public class arraytest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums=new int [5];
		System.out.println(nums);
		
		for (int i=0; i<nums.length;i++)
			System.out.print(nums[i]+"");
		System.out.println();
		for(int data:nums)
			System.out.println(data+" ");
		
		double[] su = new double[3];
		System.out.println(su);
		for (int i=0; i<su.length;i++)
			System.out.print(su[i]+"");
		System.out.println();
		
		for (double data:su)
			System.out.println(data+"");
		
		boolean[] flag = new boolean[8];
		System.out.println(flag);
		for (int i=0; i<flag.length;i++)
			System.out.print(flag[i]+"");
		System.out.println();
		
	}

}
