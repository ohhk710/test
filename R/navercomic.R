install.packages("XML")
library(XML)
library(rvest)
t<-read_html("https://comic.naver.com/genre/bestChallenge.nhn",encoding = "UTF-8")
url<-htmlParse(t)

comicName<-xpathSApply(url,"//div[@class='challengeInfo']//h6[@class='challengeTitle']",xmlValue)
comicName<- gsub("[[:punct:]]", "", comicName)
comicName
comicSummary<-xpathSApply(url,"//div[@class='challengeInfo']//div[@class='summary']",xmlValue)
comicSummary<- gsub("[[:cntrl:]]", "", comicSummary)
comicSummary

comicGrade<-xpathSApply(url,"//div[@class='rating_type']//strong",xmlValue)
comicGrade<- gsub("[[:cntrl:]]", "", comicGrade)
comicGrade
navercomic<-data.frame(comicName,comicSummary,comicGrade)
write.csv(navercomic, "navercomic.csv")
