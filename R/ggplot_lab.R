library(ggplot2)
library(dplyr)
library(stringr)
#1
ggplot(mpg,aes(x=cty,y=hwy,col=cty))+
  geom_point()

#2
ggplot(data = mpg, aes(x = mpg$class,fill=class)) +geom_bar()

#3
midwest<-as.data.frame(ggplot2::midwest)
ggplot(midwest,aes(x=poptotal,y=popasian,fill=popasian,col=popasian))+
  geom_point(size = 1)+
  xlim(1000,5e+05)+ylim(0,10000)


#4
mpg_filter<-mpg %>% filter(class %in% c("compact", "subcompact", "suv"))
ggplot(data=mpg, aes(x=class,y=cty,fill=class))+geom_boxplot()

#5
click<-readLines("product_click.log")
clickstr<-substr(click,14,17)
clicknb<-unlist(clickstr)
countclick<-table(clicknb)
dfcount<-as.data.frame(countclick)
ggplot(data=dfcount,aes(x=clicknb,y=Freq,fill=clicknb))+geom_col()

#6
date<-readLines("product_click.log")
datestr<-substr(date,1,8)
x1<-weekdays(as.Date(datestr,"%Y%m%d"))
count<-table(x1)
dfcountweek<-as.data.frame(count)
ggplot(data=dfcountweek,aes(x=x1,y=Freq,fill=x1))+geom_col()
  

       