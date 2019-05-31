package day2;

public class whiletest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum =0;
		int i=0;
		while(sum<100) {
			i=(int)(Math.random()*50)+1;
			sum+=i;
			System.out.printf("sum= %d\n",sum);
			
		}

	}

}
