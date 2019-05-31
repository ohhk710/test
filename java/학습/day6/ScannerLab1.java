package day6;

import java.util.Scanner;

public class ScannerLab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("첫 번째 숫자를 입력하세요 :");
		Scanner sc= new Scanner(System.in); 
		int a,b;
		
		a=sc.nextInt();
		System.out.println("두 번째 숫자를 입력하세요 :");
		b=sc.nextInt();
		System.out.println(" 연산자(+, -, *, /)를 입력하세요 :");
		String c=sc.next();
		
		int result=0;
		switch(c) {
			case "+" : 
				result= a+b;
				System.out.printf("%d 와 %d의 %s 연산 결과는 %d 입니다.", a, b, c, result);
				break;
				
			case "-" : 
				if(a>=b) 
					result= a-b;
				else
					result=b-a;
				System.out.printf("%d 와 %d의 %s 연산 결과는 %d 입니다.", a, b, c, result);
				break;
				
			case "/" : 
				if(a>=b) 
					result= a/b;
				else
					result=b/a;
				System.out.printf("%d 와 %d의 %s 연산 결과는 %d 입니다.", a, b, c, result);
				break;
			case "*" : result= a*b;
			System.out.printf("%d 와 %d의 %s 연산 결과는 %d 입니다.", a, b, c, result);
				
		
		}sc.close();
	}
	

}
