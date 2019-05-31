package day2;

public class whiletest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lottoNum;
		while(true) {
			lottoNum=(int)(Math.random()*6)+1;
			if(lottoNum==3) {
				System.out.printf("당첨!!!ㅋㅋㅋ: %d\n",lottoNum);
				break;
			}else {
				System.out.printf("재시도!!ㅠㅠㅠ: %d\n",lottoNum);
			}
		}System.out.println("수행종료..."+lottoNum);
		
	}

}
