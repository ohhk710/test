package day8;
//import방법
//package day8.am;
//package day8.pm;
//import day8.클래스명;
//import day8.*;여러개 할떄
//java.lang 패키지의 클래스는 import 하지 않아도 됨
//이름이 같은 클라스 속한 두 패키지를 import 할때 클래스 앞에 패키지명 붙이기
import day5.MethodLab3;//아래의 파일명만 써서 사용가능

class Multiplication {
	private int dan;
	private int number;
	
	Multiplication() {
	}
	Multiplication(int dan) {
		this.dan = dan;
	}
	Multiplication(int dan, int number){
		this.dan = dan;
		this.number = number;
	}
	void printPart() {
		if (number == 0) {	       
			for(int n=1; n <= 9; n++)
				System.out.print("\t"+dan + "*" + n+ "="+dan*n);
			System.out.println();
		} else {
			System.out.println(dan * number);
		}
	}
}

class GuGuDanExpr extends Multiplication{
	GuGuDanExpr(){ //기본적인 생성자 생성 
		
	}
	GuGuDanExpr(int dan){
		super(dan);
	}
	GuGuDanExpr(int dan, int number){
		super(dan,number);
	}
	
	static void printAll() { //1단부터 9단까지 출력하도록
		for(int i=1; i<=9;i++) {
			for (int j=1;j<=9;j++) {
				System.out.println(i+"*"+j+"="+i*j);
			}//static 과 static 아닌 것은 사용못함 = 상위클라스꺼 printPart못갖고옴
		}
		
	}
	
}

public class GuGuDan {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dan =MethodLab3.getRandom(1,20);
		int number =day5.MethodLab3.getRandom(1,20);			
		
		GuGuDanExpr ggdexpr=null;
		if(dan<10&&number<10) {
			ggdexpr =new GuGuDanExpr(dan,number);
			ggdexpr.printPart();
			
		}else if(dan<10&&number>=10){
			ggdexpr=new GuGuDanExpr(dan);
			ggdexpr.printPart();
			
		}else if(dan>=10) {
			GuGuDanExpr.printAll(); //static 형 메서드는 그 메서드 이름으로 접근
		}
		
		//Date d= new Date();
		//system.out.println("오늘은"+d.getDate());		
	}


}
