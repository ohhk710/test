library(RSelenium)
site <- paste("http://www.yes24.com/24/goods/40936880")
remDr<-remoteDriver(remoteServerAddr="localhost",port=4445,browserName="chrome")
remDr$open()
remDr$navigate(site)

webElem <- remDr$findElement("css", "body")
webElem
remDr$executeScript("scrollTo(0, document.body.scrollHeight-5000)", args = list(webElem))

#remDr$executeScript("scrollBy(0, 2500)", args = list(webElem))
#Sys.sleep(1)
#remDr$executeScript("scrollBy(0, 2500)", args = list(webElem))
#Sys.sleep(1)
#remDr$executeScript("scrollBy(0, 2500)", args = list(webElem))
#Sys.sleep(1)
#remDr$executeScript("scrollBy(0, 1000)", args = list(webElem))
#Sys.sleep(3)

repl_v = NULL
endFlag <- FALSE
page <- 3
repeat {
  for(index in 3:7) {
    fullContentLinkCSS <- paste0('#infoset_reviewContentList > div:nth-child(',index,') > div.btn_halfMore > a > em.txt.txt_open')
    fullContentLink<-remDr$findElements(using='css',  fullContentLinkCSS)
    if (length(fullContentLink) == 0) {
      endFlag <- TRUE
      break
    }
    sapply(fullContentLink,function(x){x$clickElement()})      
    Sys.sleep(3)
    fullContentCSS <- paste0('#infoset_reviewContentList > div:nth-child(',index,') > div.reviewInfoBot.origin > div.review_cont')
    fullContent<-remDr$findElements(using='css', fullContentCSS)
    print(fullContent)
    repl <-sapply(fullContent,function(x){x$getElementText()})    
    print(repl)
    repl_v <- c(repl_v, unlist(repl))
  }
  if(endFlag)
    break;  
  page <- page+1;
  
  up<-'#yDetailTabNavWrap > div > div > ul > li.tabOn > a'
  upLink<-remDr$findElements(using='css',up) 
  sapply(upLink,function(x){x$clickElement()})  
  Sys.sleep(3)
  
  nextPageCSS <- paste0('#infoset_reviewContentList > div.review_sort.sortTop > div.review_sortLft > div > a:nth-child(',page,')')
  nextPageLink<-remDr$findElements(using='css',nextPageCSS)
  sapply(nextPageLink,function(x){x$clickElement()})
  Sys.sleep(2)
  if(page > 12)
    page<-3

  print(page)
}
write(repl_v, "yes24.txt")
