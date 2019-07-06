package practice;

import java.util.HashSet;
import java.util.Iterator;

class Solution {
        public boolean solution(String[] phone_book) {
		boolean answer = true;
		
		HashSet <String> hset = new  HashSet<String>();
		//map-put / set-add // hashSet은 key만 검색/저장 할때!
		
        for(String phone : phone_book) //set에 다 넣고 반복하려고
			hset.add(phone);
		String temp;
		Iterator <String> it= hset.iterator();
		while(it.hasNext()) {
			temp=it.next(); //비교할 것
            
			for(String compare : phone_book) {// 비교위해 다시 반복문
				if(!compare.equals(temp)&& temp.startsWith(compare))
					return false;
			}
		}
		return answer;
	}
}
