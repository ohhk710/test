library(RSelenium)

site <- paste("https://www.istarbucks.co.kr/store/store_map.do?disp=locale")
remDr<-remoteDriver(remoteServerAddr="localhost",port=4445,browserName="chrome")
remDr$open()
remDr$navigate(site)

webElem <- remDr$findElement("css", "body")

repl_v = NULL

seoul<-'#container > div > form > fieldset > div > section > article.find_store_cont > article > article:nth-child(4) > div.loca_step1 > div.loca_step1_cont > ul > li:nth-child(1) > a'
seoulLink<-remDr$findElements(using='css',seoul) 
sapply(seoulLink,function(x){x$clickElement()})  
Sys.sleep(1)

allList<-'#mCSB_2_container > ul > li:nth-child(1)'
allListLink<-remDr$findElements(using='css',allList) 
sapply(allListLink,function(x){x$clickElement()})  
Sys.sleep(1)

num <- '#container > div > form > fieldset > div > section > article.find_store_cont > article > article:nth-child(4) > div.loca_step3 > div.result_num_wrap > span'
numLink<-remDr$findElements(using='css', num)
numList<-sapply(numLink,function(x){x$getElementText()})
as.numeric(numList)

starbucks <- data.frame(stringsAsFactors = F)

for(index in 1:numList){#1-498
  
    shopname1 <- paste0('#mCSB_3_container > ul > li:nth-child(',index,') > strong')
    shopnameLink<-remDr$findElements(using='css', shopname1)
    shopname<-unlist(sapply(shopnameLink,function(x){x$getElementText()}))
    print(shopname)
    
    addr1 <- paste0('#mCSB_3_container > ul > li:nth-child(',index,') > p')
    addrLink<-remDr$findElements(using='css',  addr1)
    use<-sapply(addrLink,function(x){x$getElementText()})
    addresse<-strsplit(use[[1]],"\n")[[1]]
    addr<-addresse[1]
    telephone<-addresse[2]
    print(addr)
    print(telephone)
    
    map <- paste0('#mCSB_3_container > ul > li:nth-child(',index,')')
    lonLink<-remDr$findElements(using='css',map)
    long<-unlist(sapply(lonLink,function(x){x$getElementAttribute('data-long')}))
    lat<-unlist(sapply(lonLink,function(x){x$getElementAttribute('data-lat')}))
    print(long)
    print(lat)
    
    repl_v<-data.frame(shopname,addr,telephone,long,lat)
    starbucks <- rbind(starbucks , repl_v)
    
    if(index == 498){
      break
    }
    if(index%%3==0){
      remDr$executeScript("var su=arguments[0]; var dom=document.querySelectorAll('#mCSB_3_container > ul > li')[su];dom.scrollIntoView();",list(index))
  }
}

write.csv(starbucks, "starbucks.csv")

