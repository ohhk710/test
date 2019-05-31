package day3;

public class arraytest4 {

	public static void main(String[] args) {
		int[] ary=new int[5];
		int sum=0;
		for (int data:ary)
			sum+= data; 
		System.out.println("sum="+ sum);
		/*
		 * ary[0]=11; ary[1]=12; ary[2]=13; ary[3]=14; ary[4]=15;
		 */
		for(int i=0;i<ary.length;i++)
			ary[i]=11+i;
		for(int i=0;i<ary.length;i++) {
			if(i==ary.length) {
				System.out.print(ary[i]*2);
			}else {
					System.out.print(ary[i]*2+",");
			}
		}
			
		
		System.out.println();
		for(int data:ary)
			sum+= data;
		System.out.println("sum="+ sum);
		

		
	}

}
