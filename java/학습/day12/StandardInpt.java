package day12;

import java.io.InputStreamReader;

public class StandardInpt {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("입력");
//		int input =(char)System.in.read();// 예외 꼭
		char input=(char)new InputStreamReader(System.in).read();
		System.out.println("입력된 내용: "+input);
	}

}
