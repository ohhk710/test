package day3;

public class arraytest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums=new int [10];
		for (int i=0; i<nums.length;i++)
			System.out.print(nums[i]);
		System.out.println();
		
		int[] nums2=new int[] {10,20, 30 ,40, 50};
		for (int i= nums2.length-1;i>=0;i--)
			System.out.print(nums2[i]);
		System.out.println();
		
		int d1=nums2[0];
		int d2=nums2[nums2.length-1];
		System.out.println(d1+d2);
		
		for (int i=0,res=0; i<nums2.length-1;i+=2) {
			res+=nums2[i];
			System.out.println(res);
		}
		
		
		int[] nums3= {100,200,300};
		for (int i=0; i<nums3.length;i++)
			System.out.print(nums3[i]);
		System.out.println();
	}

}
