package lol;

import java.util.*;

class Solution {
	public int solution(String arrangement) {
		int answer = 0;
		Stack<Character> stk = new Stack<Character>();
		// Stack<Integer> stk= new Stack<Integer>();
		// 스택에 인덱스 넣거나.
		// 스택에 arrangement 스트링에서 괄호 하나씩 넣고 나중에 없앨거다

		for (int i = 0; i < arrangement.length(); i++) {// 하나씩 비교
			if (arrangement.charAt(i) == '(') {
				stk.add(arrangement.charAt(i));
			} else {// ')' 일때
				stk.pop();// 공통적으로 스택쌓인거 뺌

				if (arrangement.charAt(i - 1) == '(') { // 스택에서 보고 결국 ()일때=레이저
					answer += stk.size(); // 쌓인 값만큼 막대기수 생겼으니 더함

				} else { // ')'만 일때
					answer++;// 단일 괄호 만큼 막대기수 더함
				}
			}
		}
		return answer;
	}
}