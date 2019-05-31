package day2;

public class ForLab3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char and = '&';
		int num510 = (int) (Math.random() *6)+5;
		
		for (int i = 1; i <= num510; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(and);
				
			}System.out.println("");

		}

	}
}
