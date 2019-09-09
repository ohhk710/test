package rtest;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Service;

@Service
public class OnePersonService {
	public String returnLeaflet1(String path,String gu) {
		RConnection r= null;
		String retStr="";
		try {
			r= new RConnection();
			
		r.eval("library(leaflet)");
		r.eval("library(Kormaps)");
		r.eval("library(htmlwidgets)");
		r.eval("library(dplyr)");
		r.eval("library(ggmap)");
		r.eval("register_google(key='AIzaSyD-nx_y7aBlJgfgVZRaIwMbnShQJsxpryY')");
		
		r.eval("DONG<-read.csv('c:/RStudy/one.csv')");
		r.eval("data(korpopmap3)");

		r.eval("Encoding(names(korpopmap2))<-'UTF-8'");
		r.eval("Encoding(korpopmap3@data$name_eng)<-'UTF-8'");
		r.eval("Encoding(korpopmap2@data$name)<-'UTF-8'");
		r.eval("Encoding(korpopmap2@data$행정구역별_읍면동)<-'UTF-8'");
		
	
		if(gu.equals("종로구")) {
			r.eval("korpopmap3@data<-korpopmap3@data[c(1:18),]");
			r.eval("korpopmap3@polygons<-korpopmap3@polygons[c(1:18)]");
		}else if(gu.equals("강남구")) {
			r.eval("korpopmap3@data<-korpopmap3@data[c(359:380),]");
			r.eval("korpopmap3@polygons<-korpopmap3@polygons[c(359:380)]");
		}
		r.eval("korpopmap3@data$name<-gsub('·','',korpopmap3@data$name)");
		r.eval("colnames(DONG)<-c('구별','name','일인가구')");
		r.eval("dong<- DONG %>%filter(구별=='"+gu+"')");
	
		
		r.eval("korpopmap3@data<-merge(korpopmap3@data,dong,by.x='name',sort=FALSE)");
		r.eval("mymap <- korpopmap3@data");
		r.eval("mypalette<-colorNumeric(palette ='RdYlBu' , domain = mymap$'일인가구')");
		r.eval("mypopup <- paste0(mymap$name,'<br> 1인가구: ',mymap$'일인가구')");
		
		r.eval("mk<-geocode(enc2utf8('"+gu+"'), source = 'google')");
		r.eval("lat<-mk$lat");
		r.eval("lan<-mk$lon");
		
		r.eval("map7 <- NULL");
		r.eval("map7<-leaflet(korpopmap3) %>% addTiles() %>% setView(lat=lat, lng=lan, zoom=12) %>% addPolygons(stroke =FALSE,smoothFactor = 0.2,fillOpacity = .9,popup = mypopup, color = ~mypalette(mymap$'일인가구')) %>% addLegend( values = ~mymap$일인가구, pal =mypalette , title = '인구수', opacity = 1)");

		String fileName = path+"/index.html";
		
		r.eval("saveWidget(map7,'"+fileName+"',  selfcontained = F)");	        
		retStr = r.eval("'index.html'").asString();
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			r.close();
		}
		return retStr;
	}	
}


