package day1;

public class IfTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grade=(int)(Math.random()*101); //0~100

		if(grade>=90)
			System.out.println(grade + "점은  A 등급");
		
		else if(grade>=80)
			System.out.println(grade + "점은  B 등급");
		
		else if(grade>=70)
			System.out.println(grade + "점은  C 등급");
		
		else if(grade>=60)
			System.out.println(grade + "점은  D 등급");
		
		else 
			System.out.println(grade + "점은  E 등급");
		
	}

}
