package day5;

public class MethodLab3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(" getRandom(x) °ª");
		for (int i = 1; i <= 5; i++) {
			if (i == 5) {
				System.out.print(getRandom(10));
			} else {
				System.out.print(getRandom(10) + ",");
			}
		}
		System.out.println();
		System.out.println(" getRandom(x,y) °ª");
		for (int i = 1; i <= 5; i++) {
			if (i == 5) {
				System.out.print(getRandom(10,20));
			} else {
				System.out.print(getRandom(10,20) + ",");
			}
		}
	}

	public static int getRandom(int n) {
			int num1 = (int) (Math.random()*n) + 1;
			return num1;
		}
	

	public static int getRandom(int n1, int n2) {
			int num2 = (int) (Math.random()*(n2-n1+1))+n1;
			return num2;
		}
	
}
