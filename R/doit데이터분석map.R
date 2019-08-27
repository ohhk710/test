install.packages("ggiraphExtra")
#단계구분도 
library(ggiraphExtra)
str(USArrests)
head(USArrests)

library(tibble)
crime<-rownames_to_column(USArrests,var="state")
#행 이름을 state 변수로 바꿔 새 데이터 프레임 만듦
#소문자. 대문자 데이터 맞추기 여기서는 소문자로
crime$state<-tolower(crime$state)
str(crime)

library(ggplot2)
install.packages("maps")
library(maps)
states_map<-map_data("state") #미국 주별 위경도 나타낸 state 데이터
#map_data()  : 데이터 프레임 형태로 부름
str(states_map)

install.packages("mapproj")
library(mapproj)
ggChoropleth(data=crime,#지도에 쓸 데이터
             aes(fill=Murder, #색깔 채우기
             map_id=state), #지역 기준 변수 
             map=states_map,#지도데이터
             interactive = T) #인터렉티브 - 마우스 따라 반응

#대한민국 시도별 인구,결핵환자수 단계 구분도 만들기
install.packages("kormaps2014")
#대한민국 지역 통계데이터와 지도 데이터 사용
install.packages("stringi")
install.packages("devtools")
devtools::install_github("cardiomoon/kormaps2014")
#devtools:: github 
library(kormaps2014)
str(changeCode(korpop1))
#2015년 센서스 데이터 (시도별) . - 인구
#changeCode():인코딩 변환utf-8윈도우에서한글깨짐 ->cp949
str(changeCode(kormap1))
#2014년 한국 행정지도 (시도별)- 위경도
install.packages("ggplot2")
library(ggplot2)
ggChoropleth(data=korpop1,
             aes(fill=pop,
                 map_id=code,#지역기준 변수
                 tooltip=name),#지도위 표시할 지역명
             map=kormap1,
             interactive = T)

#인터랙티브 그래프 
#마우스 움직임에 반응 하는 그래프 -html하면 사용자도 조작가능
install.packages("plotly")
library(plotly)
p<-ggplot(data=mpg,aes(x=displ,y=hwy,col=drv))+geom_point()
ggplotly(p)
#viewer -> export -> save as web page -> html로 저장하면 웹에서 보임

#막대그래프
p<-ggplot(data=diamonds,aes(x=cut,fill=clarity))+geom_bar(position="dodge")
ggplotly(p)

#dygraphs 패키지로 인터랙티브 시계열 그래프 만들기
install.packages("dygraphs")
library(dygraphs)
#economics데이터 이용
economics<-ggplot2::economics
head(economics)
library(xts)
?xts #시간속성 갖기 :(x: 시간순으로 변경할 컬럼,order.by=인덱스)
eco<-xts(economics$unemploy,order.by = economics$date)
head(eco)
dygraph(eco)#그래프 생성
dygraph(eco) %>% dyRangeSelector()
#그래프 아래 날짜 범위 선택기능
eco_a<-xts(economics$psavert,order.by = economics$date)#저축률도 같이
eco_b<-xts(economics$unemploy/1000,order.by = economics$date)#단위수정
eco2<-cbind(eco_a,eco_b)
colnames(eco2)<-c("psavert","unemploy")#변수명 바꾸기
eco2
head(eco2)
dygraph(eco2) %>% dyRangeSelector()
