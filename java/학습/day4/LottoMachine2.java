package day4;

public class LottoMachine2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lottonum = new int[6];
		boolean check = false;

		for (int i = 0; i < lottonum.length; i++) {

			while (true) {
				lottonum[i] = (int) (Math.random() * 45) + 1;
				for (int j = 0; j < i; j++) {
					if (lottonum[i] == lottonum[j]) {
						check = true;
						break;
					}
				}
				if (check != true) {
					break;
				}
			}

		}System.out.println("오늘의 로또 번호 - ");
		for (int i = 0; i < 6; i++) {
			if (i <5) {
				System.out.print(lottonum[i]+ ",");
			} else {
				System.out.print(lottonum[i] );
			
			}
		}
	}
}
