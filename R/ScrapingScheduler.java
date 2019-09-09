package rjava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScrapingScheduler {
	@Scheduled(fixedDelay = 10000)
	public void scheduleRue() throws RserveException, REXPMismatchException, IOException {
		RConnection rc = new RConnection();
		REXP x = rc.eval("imsi<-source('c:/RStudy/ScrapingScheduler.R');imsi$value");
		RList list = x.asList();

		String[] newstitle = list.at("newstitle").asStrings();
		String[] newspapername = list.at("newspapername").asStrings();
		String[] datetime = list.at("datetime").asStrings();

		for (String imsi : newstitle) {
			System.out.println(imsi);
		}
		// filewriter: 출력 고정 / outputstream : utf-8에 맞춰서 출력 가능
		// BufferedWriter bw = new BufferedWriter(new
		// FileWriter("C:/Rstudy/daumnews_schedule.csv", true));
		File file = new File("C:/Rstudy/daumnews_schedule.csv");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"));
		for (int i = 0; i < newstitle.length; i++) {
			String content = newstitle[i] + "," + newspapername[i] + "," + datetime[i];
			bw.append(content + "\r\n");
		}
		bw.close();
		rc.close();
	}
}
