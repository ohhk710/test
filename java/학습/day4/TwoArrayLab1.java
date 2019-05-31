package day4;

public class TwoArrayLab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] Alpha4 = { { 'B', 'C', 'A', 'A' }, { 'C', 'C', 'B', 'B' }, { 'D', 'A', 'A', 'D' }, };
		int[] Num4 = new int[4];
		

		for (int i = 0; i < Alpha4.length; i++) {
			for (int j = 0; j < Alpha4[i].length; j++) {
				if (Alpha4[i][j] == 'A') {
					Num4[0] += 1;
				} else if (Alpha4[i][j] == 'B') {
					Num4[1] += 1;
				} else if (Alpha4[i][j] == 'C') {
					Num4[2] += 1;
				} else {
					Num4[3] += 1;
				}

			}
		}for(int i=0;i<Num4.length;i++) {
			System.out.println((char)(65+i)+"는" + Num4[i] + "개 입니다.");
		}
		

	}

}
