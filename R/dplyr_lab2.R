mpg<-as.data.frame(ggplot2::mpg)
#7-1
new_mpg<-mpg
new_mpg<-new_mpg %>% mutate("합산연비변수"=(cty+hwy))
#7-2
new_mpg<-new_mpg %>% mutate("평균연비변수"=합산연비변수/2)
#7-3
new_mpg %>% arrange(desc(평균연비변수)) %>% head(3)
#7-4
mpg %>% mutate("합산연비변수"=(cty+hwy),"평균연비변수"=합산연비변수/2) %>% arrange(desc(평균연비변수)) %>% head(3)

#8-1
mpg %>% group_by(class) %>% summarise(mean_cty=mean(cty))
#8-2
mpg %>% group_by(class) %>% arrange(desc(mean_cty))
#8-3
mpg %>% group_by(manufacturer) %>% summarise(mean_hwy=mean(hwy)) %>% head(3)
#8_4
mpg %>% filter(class=="compact") %>% group_by(manufacturer)%>% summarise(n=n()) %>% arrange(desc(n))

#9-1
fuel<-data.frame(fl=c("c","d","e","p","r"),price_fl=c(2.35,2.38,2.11,2.76,2.22),stringsAsFactors = F)
fuel
left_join(mpg,fuel,by="fl")

#9-2
select(model,fl,price_fl) %>% head(5)

#10-1
midwest<-as.data.frame(ggplot2::midwest)
popchild<-midwest$poptotal - midwest$popadult
midwest<-midwest %>%mutate("전체인구대비미성년인구백분율"=popchild/poptotal*100)
#10-2
midwest %>% select(county,전체인구대비미성년인구백분율) %>% arrange(desc(전체인구대비미성년인구백분율)) %>% head(5)
#10-3
midwest<-midwest %>% mutate("분류"=ifelse(전체인구대비미성년인구백분율>=40,"large",ifelse(전체인구대비미성년인구백분율>=30,"middle","small")))
table(midwest$분류)
#10-4
midwest<-midwest %>%mutate("전체인구대비아시아인구백분율"=popasian/poptotal*100)
midwest %>% select(state,county,전체인구대비아시아인구백분율) %>% arrange(전체인구대비아시아인구백분율) %>% head(10)

#11-1
mpg<-as.data.frame(ggplot2::mpg)
mpg[c(65,124,131,153,212),"hwy"] <- NA

table(is.na(mpg$drv))
table(is.na(mpg$hwy))

#11-2
mpg %>% filter(!is.na(hwy)) %>%  group_by(drv)%>% summarise(mean(hwy))

#12-1
mpg<-as.data.frame(ggplot2::mpg)
mpg[c(10,14,58,93),"drv"]<-"k"
mpg[c(29,43,129,203),"cty"]<-c(3,4,39,42)


table(mpg$drv)
mpg$drv<-ifelse(mpg$drv%in% "k",NA,mpg$drv)
table(mpg$drv)

#12-2
mpg<-as.data.frame(ggplot2::mpg)
boxplot(mpg$cty)$stats

mpg$cty<-ifelse(mpg$cty<9 | mpg$cty>26,NA,mpg$cty)
table(is.na(mpg$cty))
boxplot(mpg$cty)$stats

#12-3
mpg %>% filter(!is.na(cty)&!is.na(drv)) %>% group_by(drv) %>% summarise(mean_cty=mean(cty))
