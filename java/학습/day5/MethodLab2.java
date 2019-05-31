package day5;

public class MethodLab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=5;i++) {
			int num1=(int)(Math.random()*30)+1;
			int num2=(int)(Math.random()*30)+1;
			int w=minus(num1,num2);
			
		System.out.println(num1+" 와 "+num2+ " 의 차는 "+w+"입니다" );
		}
	}

	static int minus(int x, int y) {
		if (x <= y) {
			return y - x;
		} else {
			return x - y;
		}
	}

}
