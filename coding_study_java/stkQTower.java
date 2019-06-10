package lol;

import java.util.ArrayList;

class Solution {
	public int[] solution(int[] heights) {
        int[] answer = {};
       
        ArrayList<Integer> aryReturn =new ArrayList<Integer>();
        
        int[] ary= {};
        	for(int i=heights.length-1; i==0;i--) {
        		for(int j=i-1; j==0;j--) {
            		if(heights[i]<heights[j]) {
            			aryReturn.add(heights[j]+1);
            		}else {
            			i++;
            			continue;
            		}
            		
            		
            		
        		}	
        	}	
        //		aryReturn.add()
       // 	reverse
        //½ºÅÃÅ¥,.,,?
        	        
        }

	return answer;
}}