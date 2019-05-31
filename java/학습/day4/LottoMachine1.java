package day4;

public class LottoMachine1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lottonum = new int[6];
 
		
		for (int i = 0; i < lottonum.length; i++) {
			lottonum[i] = (int) (Math.random() * 45) + 1;
			System.out.print(lottonum[i] + " ");

			int j = 0;
			while (j <= i) {
				if (lottonum[i] == lottonum[j]) {
					lottonum[j] = (int) (Math.random() * 45) + 1;
				}j++;
					
				System.out.print("오늘의 로또 번호 - "+ lottonum + " ");
				}
				
			}
		}
	}
