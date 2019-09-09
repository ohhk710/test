library(XML)
library(rvest)
url<-read_html("http://media.daum.net/ranking/popular/",encoding = "UTF-8")
article<-htmlParse(url)

newstitle <- head(xpathSApply(article,"//div[@class='cont_thumb']/strong/a", xmlValue),5)
newstitle <- gsub("[[:punct:][:cntrl:]]", "", newstitle)

newspapername  <- head(xpathSApply(article,"//div[@class='cont_thumb']/strong/span", xmlValue),5)
datetime<-format(Sys.time(),format="%Y-%m-%d %H:%M")
daumnews_schedule<-data.frame(newstitle,newspapername,datetime)

