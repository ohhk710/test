package day2;

public class fortest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
		}
		for (int i = 1; i <= 10; i += 2) {
			System.out.print(i + " ");
		}
		for (int i = 10; i >=1; i--) {
			System.out.print(i + " ");
		}
		System.out.println();
		int sum =0;
		for (int i=1; i<=10; i++) {
			sum+=i;	
		}System.out.println("ÇÕ°è"+sum);
		System.out.println();
		int pow =1;
		for (int i=1; i<=10; i++) {
			pow*=i;	
		}System.out.println("°ö"+pow);
	}
}
