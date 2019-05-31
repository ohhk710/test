package day11;
import java.util.*;//랜덤클라스 랑 Hashset 부를수있음

public class LottoSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> hs=new HashSet<Integer>(); //<>을 통해 변수타입점검하니까 쓰는게 더좋음
		//리스트화  부모격 Set으로 해도되고 HashSet으로도됨
		
//		for(int i=0;hs.size()<10;i++) {//길이 size / size가 확실하지않으니까 사이즈가 길이조건임
//			hs.add(new Random().nextInt(21)+10);
			//저장 하기위해 .add()
			//i사용 없으니 while구문 유용
		while(true) {
			hs.add(new Random().nextInt(21)+10);
			if(hs.size()==10) {
				break;
			}
			
		}System.out.println("오늘의 로또 번호 : "+hs);
		
	}

}
