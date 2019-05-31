package day5;

public class MethodTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main() 수행시작");
		printMyName(5, '*');
		printMyName(1, '@');
		printMyName(2, '#');
		System.out.println("main() 수행종료");
	}

	static void printMyName(int num, char deco) {
		for (int i = 1; i <= num; i++)
			System.out.println(deco + "오현경" + deco);
	}

}
