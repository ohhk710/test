package day2;

public class switchtest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = (int) (Math.random() * 101); // 0~100
		int grade = score / 10;

		switch (grade) {
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';

			break;
		case 7:
			grade = 'C';
			break;
		case 6:
			grade = 'D';
			break;
		default:
			grade = 'F';

		}
		System.out.println(score + "점은 " + (char)(grade) + "등급 입니다.");

	}
}
