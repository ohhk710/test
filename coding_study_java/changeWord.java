package lol;

public class changeWord {
	public int solution(String begin, String target, String[] words) {
		int answer = 0;
		int cnt=0;
		Stack stk= new Stack(); 
		
		
		for(int i=0;i<=words.length;i++) {
			if(target!=words[i]) {
				return 0;
			}else{ //target 확인 시작
				
				
				
				
				
			}
		}
		
		for(int i=0;i<=begin.length();i++) {
			for(int j=0;j<=words.length;j++) {
				if(begin.charAt(i)== words[j].charAt(i)) {
					i++;
				}else {
					cnt++;
					
				}
			}
		}
		

		if(begin.equals(target)) {
			
		}
		
		
		
		
		
		return answer;
	}
}
