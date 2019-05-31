package day12;

import java.util.ArrayList;

public class ListTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array= {3,4,2,5,2,3,6,7,5,7,9};
		ArrayList<Integer> arrayList = new CreateList().convertList(array);
		for(int data:arrayList)
			System.out.println(data);
	}

}
