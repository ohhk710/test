library(httr) #css
news<-NULL
url <- GET("http://media.daum.net/ranking/popular/")
newstitle <- html_nodes(read_html(url), 'ul.list_news2 a.link_txt')
newstitle <- html_text(newstitle)

newspapername <- html_nodes(read_html(url), 'ul.list_news2 span.info_news')
newspapername <- html_text(newspapername)

news <- data.frame(newstitle,newspapername)

write.csv(news, "daumnews.csv")



library(XML)
t<-read_html("http://media.daum.net/ranking/popular/",encoding = "UTF-8")
article<-htmlParse(t)

newstitle <- xpathSApply(t,"//a[@class='link_txt']", xmlValue)
newstitle <- gsub("[[:punct:][:cntrl:]]", "", newstitle)

newspapername  <- xpathSApply(t,"//span[@class='info_news", xmlValue)

daumnews<-data.frame(newstitle,newspapername)
write.csv(daumnews, "daumnews.csv")