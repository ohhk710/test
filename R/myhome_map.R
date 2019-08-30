library(ggmap)
register_google(key='AIzaSyD-nx_y7aBlJgfgVZRaIwMbnShQJsxpryY')
names<-("부모님집")
addr <- c("양평군 용문면 학골길")
gc <- geocode(enc2utf8(addr))

df <- data.frame(name=names,
                 lon=gc$lon,
                 lat=gc$lat)
cen <- c(mean(df$lon),mean(df$lat))
wk<-weekdays(as.Date(Sys.Date()))

if(wk=="금요일"){
  map <- get_googlemap(center=cen, maptype="roadmap",zoom=15, marker=gc)
  
}else if(wk=="월요일"|"화요일"){
  map <- get_googlemap(center=cen, maptype="terrain",zoom=8, marker=gc)
  
}else if(wk=="수요일"|"목요일"){
  map <- get_googlemap(center=cen, maptype="satellite",zoom=14, marker=gc)
  
}else{
  map <- get_googlemap(center=cen, maptype="hybrid",zoom=14, marker=gc)
  
}

ggmap(map)+labs(title="부모님의 집", x="경도", y="위도")
