package day5;

public class MethodLab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mix('@', 3);
		System.out.println();
		mix('%', 4);
		System.out.println();
		mix('A', 5);
		System.out.println();
		mix('°¡', 3);

	}
	static void mix (char a, int num) {
		for(int i=1;i<=num;i++) {
			System.out.print(a);
		}
	}
}
