package day4;
import java.util.Scanner;
public class ScannerTest4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("데이터를 입력하세요 : ");
		String str1 = sc.next();
		String str2 = sc.next();
		sc.nextLine();  
		// 입력버퍼에 남아있는 개행문자를 청소하는 기능 next()에서 nextLine()으로 할때 next만 읽어서 급 처리되므로,...
		String line1 = sc.nextLine();
		String line2 = sc.nextLine();
		System.out.printf("[%s] [%s] [%s] [%s]", str1, str2, line1, line2);
		sc.close();//꼭
	}
}






