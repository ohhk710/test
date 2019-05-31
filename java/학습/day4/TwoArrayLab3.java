package day4;

public class TwoArrayLab3 {

	public static void main(String[] args) {
		char play[][] = { { 'X', 'X', 'X', 'R', 'X', 'R' }, { 'R', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'X', 'R', 'X', 'X', 'X' }, { 'R', 'X', 'X', 'x', 'X', 'X' }, { 'X', 'R', 'F', 'X', 'X', 'X' },
				{ 'X', 'R', 'X', 'R', 'X', 'R' }, };

		int catchNum = 0;
		/*
		 * R은 토끼이고 F는 여우다 여우의 위치는 정해져 있고 정해진 위치에서 대각선과 직선으로만 이동 가능하다. 위와 같은 2차원 배열 데이터에서
		 * 토끼를 몇마리 잡겠는가?
		 */
		int fPosi = 0;
		int fPosj = 0;

		// 구현
		for (int i = 0; i < play.length; i++) {
			for (int j = 0; j < play[i].length; j++) {
				if (play[i][j] == 'F') {
					fPosi = i;
					fPosj = j;
					break;
				}
			}
		}

		for (int i = 0; i < play.length; i++) {
			for (int j = 0; j < play[i].length; j++) {
				if (play[i][j] == 'R') {
					if (fPosi == i) {
						catchNum++;
					}
					if (fPosj == j) {
						catchNum++;
					}

					if ((i + j == fPosi + fPosj || i - j == fPosi - fPosj)) {
						catchNum++;
					}
				}
//						if ((i == fPosi || j == fPosj || fPosi - fPosj == i-j || fPosi + fPosj  == i+j ) && play[i][j] == 'R')
//							catchNum++;
//					}
			}
		}
		System.out.println("여우의 위치 : (" + fPosi + "," + fPosj + ")");
		System.out.printf("여우는 토끼를 %d 마리 잡는다.", catchNum);
	}
}