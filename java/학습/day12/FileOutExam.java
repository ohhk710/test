package day12;

import java.io.*;
import java.util.*;

public class FileOutExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File isDir = new File("c:/iotest");	 //File을 iotest주소에 객체생성
		if (!isDir.exists()) {
	        	isDir.mkdirs(); //새로생성 api
	        }
		
		try(FileWriter fw = new FileWriter("C:/iotest/today.txt");
				PrintWriter out = new PrintWriter(fw)){
			//주소값으로 파일생성하고 파일입력객체 생성
			//그리고 출력하라
			printDayInfo(out);
			//
			System.out.println("저장이 완료되었습니다.");
			
		}catch(IOException e) {
			System.out.println("파일에 저장하는 동안 오류가 발생했습니다.");
		}
		
	}
	
	static void printDayInfo(PrintWriter out) {
		
		GregorianCalendar gc = new GregorianCalendar();
		//API 이용 객체생성
		int year = gc.get(Calendar.YEAR);
		int month = gc.get(Calendar.MONTH) + 1;//월은 0부터 니까 1월맞추려면 
		int day = gc.get(Calendar.DATE);
		int week = gc.get(Calendar.DAY_OF_WEEK);//요일 INT로 나옴 ,,,바꿔야함
		
		out.println("오늘은 " + year + "년 "+ month + "월 "+ day + "일입니다.");
		out.println("오늘은 " + getWeek(week) +"요일입니다.");
		//여기까지 형식
		
		gc = new GregorianCalendar(1995,2,9);
		int birthWeek = gc.get(Calendar.DAY_OF_WEEK);
		out.println("나는 " + getWeek(birthWeek) + "요일에 태어났습니다.");
	}
	
	static String getWeek(int week) {
		switch(week) {
		case 1: return "일";
		case 2: return "월";
		case 3: return "화";
		case 4: return "수";
		case 5: return "목";
		case 6: return "금";
		default: return "토";
		}
	}
}
