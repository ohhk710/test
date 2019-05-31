package day1;

public class IfTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grade=(int)(Math.random()*6+1); //1-6

		if(grade>3)
			System.out.println(grade+"학년은 고학년 입니다");
		else
			System.out.println(grade+"학년은 저학년 입니다");
	}

}
