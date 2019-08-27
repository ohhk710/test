install.packages("foreign")
#다양한 통계분석 파일
library(foreign) #spss파일 부르기
library(dplyr) #전처리
library(ggplot2) #시각화
library(readxl) #엑셀파일 부르기

raw_welfare<-read.spss(file="Koweps_hpc10_2015_beta1.sav", to.data.frame = T)
#to.data.frame = T : sav 파일을 데이터프레임형태로 변환 , 안쓰면 리스트 형식
welfare<-raw_welfare #복사본 사용

summary(welfare)
#변수명이 코드일때 데이터 특성알려주는 '코드북' 이라는 설명서 있음 
#보고 코드에서 변수명을 바꾸도록
welfare<-rename(welfare,
                sex=h10_g3,
                birth=h10_g4,
                marriage=h10_g10,
                religion=h10_g11,
                income=p1002_8aq1,
                code_job=h10_eco9,
                code_region=h10_reg7)
welfare

#성별에 따른 월급차이
class(welfare$sex) #numeric 남/여를 1,2로 나눔
table(welfare$sex) #코드북에서 1=남,2=여
#결과 이상치 없음 
#이상치 검토-> 결측치 만듦
table(is.na(welfare$sex)) #결측치 없음

#값 이름 바꾸기=ifelse
welfare$sex<-ifelse(welfare$sex==1,"male","female")
qplot(welfare$sex)

#범주 확인= table
#연속 변수 = summary(): 요약 확인 
summary(welfare$income)
#NA값 확인
#코드북에서 1부터 9998 월급 인데 최소값 0 존재= 이상치 , 9999도 이상치
qplot(welfare$income)+xlim(0,1000)

welfare$income<-ifelse(welfare$income %in% c(0,9999), NA, welfare$income)
table(is.na(welfare$income)) #TRUE=결측치 확인

#결측 제외하고 분석하기
#성별 월급 평균 분석
#평균 변수 만들기 ! 수입이 없는 사람은 분석 대상 제외 =filter
sex_income <- welfare %>% filter(!is.na(income)) %>% group_by(sex) %>% summarise(mean_income=mean(income))
sex_income
ggplot(data=sex_income,aes(x=sex,y=mean_income))+geom_col()+coord_flip()
#coord_flip() x축을 세로 로 해서 가로막대 =그래프 오른쪽회전

#나이에 따른 월급변화 = 태어난 연도 변수 있음
class(welfare$birth)
summary(welfare$birth)
qplot(welfare$birth)

#이상치. 결측치 없음
#나이 변수 만들기
welfare$age<- 2015-welfare$birth+1
summary(welfare$age)
qplot(welfare$age)

age_income<-welfare %>% filter(!is.na(income)) %>% group_by(age) %>% summarise(mean_income=mean(income))
ggplot(data=age_income,aes(x=age,y=mean_income))+geom_line()

#연령대
welfare<-welfare %>% mutate(ageg=ifelse(age<30,"young",ifelse(age<=59,"middle","old")))
table(welfare$ageg)
qplot(welfare$ageg)
ageg_income<-welfare %>% filter(!is.na(income)) %>% group_by(ageg) %>% summarise(mean_income=mean(income))
ageg_income
ggplot(data=ageg_income, aes(x=ageg,y=mean_income))+geom_col()
#알파벳순-> 나이순
ggplot(data=ageg_income, aes(x=ageg,y=mean_income))+
  geom_col()+
  scale_x_discrete(limits=c("young","middle","old"))

#연령대 및 성별 월급차이
sex_income<-welfare %>% filter(!is.na(income)) %>% group_by(ageg,sex) %>% summarise(mean_income=mean(income))
ggplot(data=sex_income,aes(x=ageg,y=mean_income, fill=sex))+geom_col(position="dodge")+scale_x_discrete(limits=c("young","middle","old"))
#geom_col(position="dodge") : 막대 분리

#연령대 순으로 막대 색깔 나열 : fill 변수의 범주(level) 순서 지정 현재 a연령대는 a문자열이라 levels 없음
#따라서 factor() 이용해 펙터 타입으로 변환하고 level 이용 level=c(막대범주명)
#aes 에 fill=변수명 
