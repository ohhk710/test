library(rvest)
url_base<-"https://movie.daum.net/moviedb/grade?movieId=121137&type=netizen&page="
daummovie2<-NULL
text<-read_html(url_base,encoding = "UTF-8")
text

allmovie2<-data.frame()

for(i in 1:20){
  
  url=paste(url_base,i,sep="")
  text<-read_html(url,encoding = "UTF-8")
  
  nodes<-html_nodes(text,'.emph_grade')
  grade<-html_text(nodes)
  
  nodes<-html_nodes(text,'.desc_review')
  content<-html_text(nodes,trim=TRUE)
  review<-gsub("[\r\n]","",review)
  content
  
  daummovie2<-data.frame(grade,content)
  allmovie2<-rbind(allmovie2,daummovie2)
}
allmovie2

write.csv(allmovie2,"daummovie2.csv")
