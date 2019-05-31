package day10;

public class ExceptionTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("수행시작");
		
		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			int result = num1 / num2;
			System.out.println("연산결과 : " + result);
		} catch(Exception e) {
			System.out.println(e);
		}
		/*
			 * catch (ArrayIndexOutOfBoundsException e) {
			 * System.out.println("프로그램 아규먼트를 2개 전달하세요");
			 * 
			 * } catch (ArithmeticException e) {
			 * System.out.println("2번째 프로그램 아규먼트는 0이아닌 값을 전달하세요");
			 * System.out.println(e.getMessage()); return; } catch (NumberFormatException e)
			 * { System.out.println("프로그램 아규먼트로 숫자를 전달하세요"); }
			 */finally {
			System.out.println("항상수행");
		}
		System.out.println("수행종료");

	}

}
