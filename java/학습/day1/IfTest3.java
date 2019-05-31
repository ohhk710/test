package day1;

public class IfTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int month = (int) (Math.random() * 12) + 1; // 1~12

		if (month == 12 || month == 1 || month == 2)
			System.out.println(month + "월 은 겨울");
		else if (month == 3 || month == 4 || month == 5)
			System.out.println(month + "월 은 봄");
		else if (month == 6 || month == 7 || month == 8)
			System.out.println(month + "월 은 여름");
		else
			System.out.println(month + "월 은 가울");
	}

}
