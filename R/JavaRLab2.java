package rjava;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class JavaRLab2 {

	public static void getHotel2() throws RserveException, REXPMismatchException {
		RConnection rc = new RConnection();
		REXP x=rc.eval("imsi<-source('c:/RStudy/lab.R');imsi$value");
		RList list =x.asList();
		
		String[] nouns =list.at("nouns").asStrings();
		String[] freq =list.at("Freq").asStrings();

		System.out.println("R에서 보내온 최빈 명사들 : ");
		for(int i=0;i<nouns.length;i++) {
			System.out.println(nouns[i]+" "+freq[i]);
		}
		rc.close();	
	}

	public static void main(String[] args) throws REXPMismatchException, REngineException {
		// TODO Auto-generated method stub
		JavaRLab2.getHotel2();
	}

}
