library(rvest)
url<-"https://movie.daum.net/moviedb/grade?movieId=121137&type=netizen"
daummovie1<-NULL
text<-read_html(url,encoding = "UTF-8")
text

nodes<-html_nodes(text,'.emph_grade')
grade<-html_text(nodes)
grade

nodes<-html_nodes(text,'.desc_review')
content<-html_text(nodes,trim=TRUE)
review<-gsub("\r\n","",review)
content

page<-cbind(grade,content)
page
daummovie1<-data.frame(page)
write.csv(daummovie1,"daummovie1.csv")
