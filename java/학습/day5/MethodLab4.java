package day5;

public class MethodLab4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] n1={10,20,30};
		int[] n2={100, 500, 300, 200, 400};
		int[] n3={1, 10, 3, 4, 5, 8, 7, 6, 9, 20};
		
		System.out.println("가장 큰 값은"+maxNumArray(n1)+"입니다.");
		System.out.println("가장 큰 값은"+maxNumArray(n2)+"입니다.");
		System.out.println("가장 큰 값은"+maxNumArray(n3)+"입니다.");
	}
	static int maxNumArray(int[] num) {
		int big=0;
		for(int i=0;i<num.length;i++) {
			if(num[i]>=big) {
				big=num[i];
			
			}
		}return big;
	}

	
	
}
