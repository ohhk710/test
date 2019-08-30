install.packages("RSelenium")
install.packages("rvest")
library(rvest)
library(RSelenium)
library(stringr)
jobwithjava=NULL

remDr<-remoteDriver(remoteServerAddr = "localhost", port=4445, browserName="chrome")
remDr$open()
remDr$navigate("http://www.jobkorea.co.kr/")

searchCss<-remDr$findElement(using="id",value="stext")
searchCss$setElementAttribute("value","자바")

searchBtn<-('#common_search_btn')
searchBtnLink<-remDr$findElements(using='css',searchBtn)
sapply(searchBtnLink,function(x){x$clickElement()})

page<-2
for(i in 1:20){
  for(index in 1:30){
    doms<-paste('#smGiList > div.list > ul > li:nth-child(',index,') > span.detailInfo > p.gibInfo > a')
    domsLink<-remDr$findElements(using='css',doms)
    contents<-sapply(domsLink,function(x){x$getElementText()})
    jobwithjava<-c(jobwithjava,unlist(str_split(contents,", ")))
  }
  if(page==11){
    nextPageCSS <-('#smGiList > div.tplPagination > p > a')
    nextPageLink<-remDr$findElements(using='css',nextPageCSS)
    sapply(nextPageLink,function(x){x$clickElement()})
    page<-1
    Sys.sleep(1)
  }
    linkCss<-paste('#smGiList > div.tplPagination > ul > li:nth-child(',page,') > a')
    linkCssLink<-remDr$findElements(using='css',linkCss)
    sapply(linkCssLink,function(x){x$clickElement()})
    Sys.sleep(1)
    
    page<-page+1
}
  write(jobwithjava, "jobwithjava.txt")



jobwithjavaTXT<-readLines("jobwithjava.txt")
words<-unlist(jobwithjavaTXT)
wordsort<-table(words)
wordsort2<-sort(wordsort,decreasing = T)
wordtop15<-head(wordsort2,15)
write(jobwithjava, "jobwithjava.csv")


install.packages("wordcloud2")
install.packages("KoNLP")
library(KoNLP)
library(wordcloud2)

wordcloud2(wordsort2, size=0.7, col="random-light", backgroundColor = "black")
write(words, "jobwithjava.png")

