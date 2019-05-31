package day7;

class SalaryExpr {  //class 클라스명 중괄호.
	
	private int bonus; //정해진생성자나 매서드를 통해만 접근하도록
	
	SalaryExpr(){ 
		//bonus=0;
	}//멤버변수에 0을 할당 -> 0 입력없이 자동 초기화  or this(0);
	
	SalaryExpr(int bonus){ //생성자 매서드=클라스명과 동일! 리턴값없음! 필요시 this
		this.bonus=bonus; }
	//매개변수 보너스 값 받아서 멤버변수로 저장 = 같은이름 =this
	
	int getSalary(int grade) { 
				if(grade==1)
					 bonus+=100;
				else if(grade==2)
					 bonus+=90;
				else if(grade==3)
					 bonus+=80;
				else if(grade==4)
					 bonus+=70;
				return bonus; //리턴값 하나. bonus 
			}
}
public class SalaryExam {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int month=(int)(Math.random()*12)+1;
		//public 클라스안이라 사용가능(day5.MethodLab3.getRandom(12);
		int grade=(int)(Math.random()*4)+1;
		
		//변수 미리 선언 .초기화 반복절 들어가기전에 써야 다 담음. 그후 생성만함
		SalaryExpr gift; //참조변수에 값없을때 =null 로 해야함
		if(month%2==0) {
			gift=new SalaryExpr(100); //"salaryexpr(100)(<-arg있는거 호출)을 가지고 salaryexpr 의 인스턴스를 생성"
			
		}else {
			gift=new SalaryExpr();
			
			
		}//프린트 구성 같으면 if else 에서 빼내서 한번에 함.
		System.out.printf("%d월 %d등급의 월급은 %d 입니다",month,grade,gift.getSalary(grade));
	}

}
