package rjava;


import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class JavaRLab1 {

	public static void getHotel() throws RserveException, REXPMismatchException {
		RConnection rc = new RConnection();
		rc.eval("sapply(hotel,extractNoun,USE.NAMES = F)");
		rc.eval("unlist(nouns)");
		rc.eval("Filter(function(x) {nchar(x) >=2},nouns2)");
		rc.eval("table(nouns)");
		rc.eval("as.data.frame(word_count,stringsAsFactors = F)");
		rc.eval("df_word %>% arrange(desc(Freq)) %>% head(10)");
		String[] n = rc.eval("top10$nouns").asStrings();
		System.out.println("R에서 보내온 최빈 명사들 : ");
		for(int i=0;i<n.length;i++) {
			System.out.print(n[i]+" ");
		}
		rc.close();	
	}
	
	public static void main(String[] args) throws REXPMismatchException, REngineException {
		// TODO Auto-generated method stub
		JavaRLab1.getHotel();
	}

}
