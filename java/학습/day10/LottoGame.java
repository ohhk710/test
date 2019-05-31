package day10;

import java.util.Random;//Random 클라스 사용하기

class DuplicateException extends Exception {
	DuplicateException() {
		super("중복된 로또 번호가 발생했습니다.");
	}
}

class LottoMachine {
	private int[] nums;

	public LottoMachine() {
		nums = new int[6];
	}

	public void creatLottoNums() {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = new Random().nextInt(20) + 1;
		}
	}

	public void checkLottoNums() throws DuplicateException {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					throw new DuplicateException();
				}
			}
		}
	}

	public int[] getNums() {
		return nums;
	}
}

public class LottoGame {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LottoMachine lot = new LottoMachine();

		// lot을 출력하면 주소값나와서
		// 새배열 만들필요있음
		int lot1[];
		try {

			lot.creatLottoNums();
			lot.checkLottoNums();

		} catch (DuplicateException e) {
			// System.out.println("중복된 로또 번호가 발생했습니다");
			System.out.println("오류 발생 : " + e.getMessage());// 자동 dup클라스 오류멘트
			return;//main의 리턴은 jvm한테가니 곧 시스템종료임
			//system.exit(-1); 강제종료 안쓰는게 좋음
		}

		lot1 = lot.getNums();
		// 그래서 새배열만듦 이것으로 length를 설정가능함
		for (int i = 0; i < lot1.length; i++) {
			System.out.print(lot1[i]);
			if (i < lot1.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println();
	}

}
