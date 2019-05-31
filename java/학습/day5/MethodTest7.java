package day5;

public class MethodTest7 {

	public static void main(String[] args) {
		System.out.println(args.length);
		if (args.length == 0) {
			System.out.println("전달된 프로그램 아규먼트가 없어욤");
			return; //main 매서드의 리턴문은 프로그램 수행의 종료됨 = 밑 처리 안함
		}
		for (String data : args) {
			System.out.println(data);
		}
		System.out.println("프로그램 아규먼트를" + args.length + "개 전달했어욤");
	}
}
