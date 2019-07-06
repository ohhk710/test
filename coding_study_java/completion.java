package practice;

import java.util.HashMap;

class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (String partlist : participant) {
			if (map.containsKey(partlist)) // 동명이인을 위해 참여자get한거 value에 +1함
				map.put(partlist, map.get(partlist) + 1);
			else // 기본적으로 참여자의 value=1
				map.put(partlist, 1);
		}
		// 다른방법 : getOrDefaul(변수명,value값) +1) = 있으면 value값에 +1 하고 없으면 value의 디폴트값으로 0
		// 자동지정

		// 변수 같아도됨 ==i 처럼
		for (String partlist : completion)
			map.put(partlist, map.get(partlist) - 1); // 기존에 있던거에서 다 -1함

		for (String partlist : map.keySet()) { // key값 찾아서 비교
			if (map.get(partlist) != 0) { // value가 0이 아니면= 동명이인때문에 1이상인것
				answer = partlist;
				break;// 해줘야 효율성올림/ 어차피 한명만 return되니까 찾으면 멈춤
			}
		}
		return answer;
	}
}
