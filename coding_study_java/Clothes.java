package practice;

import java.util.HashMap;

public class Clothes {
	public int solution(String[][] clothes) {
        int answer = 1; //의상수 1부터 시작이니까 =무조건 하나는 입음
        HashMap <String,Integer> hmap=new HashMap<>();
        // 종류, 종류에 따른 갯수 =hmap
        
        for(int i=0;i<clothes.length;i++) {//종류 넣기[i][1] 고정값 //중복값고려하기
        	if(hmap.containsKey(clothes[i][1])) hmap.put(clothes[i][1], hmap.get(clothes[i][1])+1);
        	else //기본적으로 +1
        		hmap.put(clothes[i][1],1);
        }
        for(int n: hmap.values()) {
        	answer *=(n+1); //기본적 경우의 수 a+b+(a*b)식
        }
        //옷을 다 안입는 경우는 -1 해야함
        answer -=1;
        
        return answer;
	}
}
/*간단히
 * for(int i=0;i<clothes.length;i++) {//종류 넣기[i][1] 고정값 //중복값고려하기
        if(hmap.containsKey(clothes[i][1])) 
                hmap.put(clothes[i][1], hmap.getOrDefault(clothes[i][1],1)+1);
       	else //기본적으로 +1
        		hmap.put(clothes[i][1],2); (n+1)대신 한번에 1에 +1한값 으로 바꿈
        }
        for(String key: hmap.keySet()) {
        	answer *=hmap.get(key);
        }
        
        또는
        else //기본적으로 +1
        		hmap.put(clothes[i][1],1); 1유지하고
        }
        for(String key: hmap.keySet()) {
        	answer *=(hmap.get(key)+1); 각 value값에 +1함
        }
 */
