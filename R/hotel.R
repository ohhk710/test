install.packages("RSelenium")
library(RSelenium)
review = NULL;
url<-'https://www.agoda.com/ko-kr/shilla-stay-seocho/hotel/seoul-kr.html?cid=-204'
remDr<-remoteDriver(remoteServerAddr="localhost",port=4445L,browserName="chrome")
remDr$open()
remDr$navigate(url)

remDr$executeScript("scrollBy(0,8500)") #페이지 이동

mored <- remDr$findElements(using='css','#dismiss-btn > p')
#해당 p 태그 찾아 - 여기서는 팝업창에 닫기 버튼 
sapply(mored,function(x){x$clickElement()})
#지우기기


for(i in 1:15){
  if(i>=4){
    linkCss<-'#reviewSection > div:nth-child(4) > div > span.Review-paginator-numbers > span:nth-child(4)'
  }else{
  linkCss<-paste0('#reviewSection > div:nth-child(4) > div > span.Review-paginator-numbers > span:nth-child(',i,')')
  }
  print(linkCss)
  
  linkDom<-remDr$findElements(using ="css selector",linkCss)
  print(linkDom)
  sapply(linkDom,function(x){x$clickElement()})
  Sys.sleep(1)
  doms<-remDr$findElements(using="css selector",".Review-comment-bodyText")
  contents<-sapply(doms,function(x){x$getElementText()})
  review<-c(review,unlist(contents))
  print(contents)
}
write(review, "review.txt")
