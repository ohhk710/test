package lol;

import java.util.ArrayList;

class CompleteSearch {
	public int[] solution(int[] answers) {

		int[] stu1 = { 1, 2, 3, 4, 5 };
		int[] stu2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] stu3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		

		for (int i = 0; i < answers.length; i++) {
			if (stu1[i1] == stu1.length) {
				i1 = 0;
			}
			if (answers[i] == stu1[i1]) {
				cnt1++;
			}
			if (stu2[i2] == stu2.length) {
				i2 = 0;
			}
			if (answers[i] == stu2[i2]) {
				cnt2++;
			}
			if (stu3[i3] == stu3.length) {
				i3 = 0;
			}
			if (answers[i] == stu3[i3]) {
				cnt3++;
			}
			i1++;
			i2++;
			i3++;
		}
			
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (cnt1 == cnt2 && cnt1 == cnt3) {
			list.add(1);
			list.add(2);
			list.add(3);
		} else {
			if (cnt1 == cnt2 && cnt1 > cnt3) {
				list.add(1);
				list.add(2);
			} else if (cnt1 == cnt3 && cnt1 > cnt2) {
				list.add(1);
				list.add(3);
			} else if (cnt2 == cnt3 && cnt2 > cnt1) {
				list.add(2);
				list.add(3);
			} else {
				int one = Math.max(Math.max(cnt1, cnt2), cnt3);
				if (cnt1 == one)
					list.add(1);
				else if (cnt2 == one)
					list.add(2);
				else if (cnt3 == one) // else 가능
					list.add(3);
			}
		}
		int[] answer = new int[list.size()];

		// 리스트에서 배열로 이동
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		
		}
		return answer;
	}
}