package day13;
import java.io.*;
public class CopyExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader reader=null;
		try {
			reader= new FileReader("C:\\Users\\student\\Desktop\\sample.txt");
			while(true)
			{
				int data=reader.read();
			}
		}
	}

}
