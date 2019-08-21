#1-1 mpg 의 행의 개수와 열의 개수를 출력한다.
dim(mpg)
#1-2 mpg의 데이터를 앞에서 10개 출력한다.
head(mpg,10)
#1-3 mpg의 데이터를 뒤에서 10개 출력한다.
tail(mpg,10)
#1-4. mpg의 데이터를 GUI 환경으로 출력한다.
View(mpg)
#1-5 mpg를 열 단위로 요약한다.
summary(mpg)
#1-6 mpg의 구조를 확인한다.
str(mpg)

#2-1 복사본 데이터로 변수명 바꾸기
mpg <-as.data.frame(ggplot2::mpg)
copy_mpg<-mpg
copy_mpg<-rename(copy_mpg,city=cty)
copy_mpg<-rename(copy_mpg,highway=hwy)
#2-2 결과물 확인
head(copy_mpg)

#3-1
midwest<-as.data.frame(ggplot2::midwest)
midwest

#3-2
midwest<-rename(midwest,total=poptotal)
midwest<-rename(midwest,asian=popasian)

#3-3
midwest %>% mutate(meanAsian=asian/total*100)

#3-4
midwest %>% mutate(meanAsian=asian/total*100,meanTotal=mean(meanAsian),meanPop=ifelse(meanAsian>=meanTotal,"large","small"))

#4-1
mpg %>% filter(displ<=4) %>% summarise(mean(hwy))
mpg %>% filter(displ>=5)%>% summarise(mean(hwy))


#4-2
mpg %>% filter(manufacturer=="audi")%>% summarise(mean(cty))
mpg %>% filter(manufacturer=="toyota")%>% summarise(mean(hwy))


#4-3 
mpg %>% filter(manufacturer%in%c("chevrolet","ford","honda")) %>% summarise(mean(hwy))


#5-1
nn<-mpg %>% select(class,cty)
new_classcty<-as.data.frame(nn)

#5-2
new_classcty %>% filter(class%in%c("suv","compact")) %>%  arrange(desc(cty))

#6-1
mpg %>% filter(manufacturer=="audi") %>% arrange(hwy) %>% head(5)
                     