library(dplyr)
library(ggmap)
library(ggplot2)

register_google(key='AIzaSyD-nx_y7aBlJgfgVZRaIwMbnShQJsxpryY')

#geocode(enc2utf8('서울&language=ko'), source = 'google', output = 'latlona')
df <- read.csv("지역별장애인도서관정보.csv", stringsAsFactors=F)  


library_map <- qmap(location="seoul", zoom=11, maptype="roadmap")
#서울 우선 띄우기
library_map + geom_point(data = df, aes(x = LON, y = LAT), colour = 'green',
                       size = 4)+geom_text(data=df,               
                                           aes(x=LON,y=LAT),               
                                           size=3,               
                                           label=df$"도서관명") 

