package day2;

public class breaktest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hyun: for (int dan = 1; dan <= 9; dan++) {
			for (int num = 1; num <= 9; num++) {
				if(dan*num>30)
					break hyun;
				System.out.println(dan + "x" + num + "=" + dan * num);
			}
			System.out.println();
		}
	}
}
