package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Level11 {

	public int solution(int n, int[] lost, int[] reserve) {
		int answer =n-lost.length;

		ArrayList<Integer> aryLost = new ArrayList<>();
		for (int i = 0; i < lost.length; i++)
			aryLost.add(lost[i]);

		ArrayList<Integer> aryReserve = new ArrayList<>();
		for (int i = 0; i < reserve.length; i++)
			aryReserve.add(reserve[i]);

		Collections.sort(aryLost);
		Collections.sort(aryReserve);

		for (int i = 0; i < aryReserve.size(); i++) {
			for (int j = 0; j < aryLost.size(); j++) {
				if (aryReserve.get(i) == aryLost.get(j)) {
					//System.out.println(aryReserve.get(i));
					answer++;
					aryLost.remove(j);
					j--;
					//System.out.println(answer);
					break;
				} else {
					if (aryReserve.get(i) - 1 == aryLost.get(j) || aryReserve.get(i) + 1 == aryLost.get(j)) {

						answer++;
						aryLost.remove(j);
						j--;
						
						break;
					} else {
						if (aryReserve.get(i) + 1 < aryLost.get(j)) {
							j--;
							
							break;
							
						}
						
					}
				}
			}
		}
		return answer;
	}
}

public class Level1 {

	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 2, 4};
		int[] reserve = { 3 };
		Level11 sol = new Level11();
		int answer = sol.solution(n, lost, reserve);
		System.out.println(answer);
	}
}

//Iterator<Integer> it = aryReserve.iterator();
//while (it.hasNext()) {
//	int value = (int) it.next();
//	System.out.println(value);
//	for(int i=0;i<aryLost.size();i++) {
//		if(value==aryLost.get)
//		if(value-1 ==aryLost.get(i)||value+1 ==aryLost.get(i)) {
//			nb++;
//		}
//	 }
//
//}
