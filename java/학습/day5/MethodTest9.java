package day5;

public class MethodTest9 {

	public static void main(String[] args) {
		int [] arr = {10,5, 7,15};
		printArray(arr);
		twoValue(arr);
		printArray(arr);
	}//호출식 배열의 값을 넣음
	
	static void twoValue(int[] jumsu) {
		for(int i=0; i<jumsu.length;i++)
			jumsu[i]=jumsu[i]*2;
	}static void printArray(int[] jumsu) {
		for (int data: jumsu)
			System.out.print(data+" ");
		System.out.println();
	}
}