package day1;

public class TypeTest2 {

	public static void main(String[] args) {
		System.out.println(100); //println 출력후 행바꿈 / 출력 print
		int num;//변수선언
		num = 1000;
		System.out.println(num); // 에러 난 이유 -초기화 값 필요
		num=10+20;
		System.out.println(num);
		char munja ='A';
		System.out.println(munja);
		munja ++;
		System.out.println(munja); //B
		munja +=1;
		System.out.println(munja); //C
		munja=(char)(munja+1); // 변수바꿈
		System.out.println(munja); //D
	}

}
