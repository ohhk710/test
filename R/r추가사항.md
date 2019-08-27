데이터 불러오기 

+ xlsx
  + xlsx -> "readxl" 패키지

    <-read_excel(" .xlsx") - 새변수에 할당

  + 첫행이 데이터라면

    ​	(" ", col_name=F) : 임의로 컬럼명 생김

  + 여러개 sheet 중 한개부를떄 ex) 3번째 시트

    ​	(" ", sheet=3)

+ csv

  + read.csv( ) - 새변수에 할당

  + 첫행이 데이터라면

    ​	(" ",header=F)

  + 파일에 문자있을때 factor타입이 아니도록

    ​	(" " , stringsAsFactors=F)

  + 파일 저장

    write.csv(데이터프레임명, "파일명.csv")

+ RData : r전용 파일

  + save(데이터프레임명, "파일명.rda")
  + load("파일명.rda") 
    + 따로 변수에 할당 안해도 자동으로만들어짐

+ summary 요약 통계량 함수

  + 'median 수치 중심으로 1st Qu 와 3rd Qu 사이 

    몰려있다'

+ 패키지속 특정 데이터 사용하려면 

  ​	(패키지명:: 데이터명) 

+ str() : 각 변수의 속성

+ help(데이터명) : 설명글 각 변수 의미..

+ dplyr 패키지 : 데이터 가공

+ 데이터 변형시 복사본 이용시 더 좋음

+ 파생변수 : 데이터프레임명$새변수명 <-

+ 빈도표 : 변수의 각 값이 몇개씩 존재하는지 갯수로

  ​	table(데이터명$변수명)

+ 막대그래프 = 각 항목 빈도수=갯수 :qplot() 

+ 데이터 가공 = 데이터 전처리

  + dplyr패키지 : %>% 사용 더욱 간편 !
    + A %in% B : A 변수에 B조건 존재하는지 
    + select( - 변수명) : 그 변수만 제외
    + 몇줄 쓸떄  %>% 후 엔터
    + 중간에 확인용 : head
    + summarise( ) : group_by()조합해  통합/집단별 요약표
      + =n( ) : 데이터가 몇 행인지 : 빈도 : 함수x. 빈괄호
    + group_by (변수) : 변수 항목별 데이터 분리 
    + 가로 합병 : left_join(데이터, 데이터 , by="기준변수명")
    + 세로 합병 시 변수 명 다르면 rename 해서 합쳐야함

+ filter(!is.na(변수명)) :  결측치 제거해서 새 변수에 적용

  또는 함수  na.rm=T

  + [행 , "열"] :  데이터 위치

  + 데이터가 작을때 결측치 제거하면 왜곡 심해짐. 따라서 

    대체 할수있음  : 각 결측치의 예측값

    1. 평균값으로 대체 : 결측치 제외하고 평균값 구함
    2. ifelse 로 NA 값을 평균값으로 대체

+ 이상치 : 범위 벗어남

  + 이상치 확인 : table()

  + ifelse(변수조건 , NA , 변수) :  조건이 맞으면 NA, else 원래값

  + 이상치 -> 결측치 -> 결측치 제외 

  + 상자 그림으로 극단치 제거 - 사분위수 이용

    boxplot( )$stats :상자그림 통계치 출력

    + 행렬 구조 - 인덱스값으로 표시
    + 위에서부터 아래로 == 아래쪽 극단치 경계값,1사분위수, 중앙값,3사분위수, 위쪽 극단치경계값
    + 극단치 경계값으로 NA 처리 후 결측치 제외

+ 그래프

  + ggplot2 그래프 패키지 :  + 로 연결/ 엔터 가독성

    + 산점도 : 변수간 관계 표현

    + 레이어 구조 : 배경(축)->그래프추가(점,막대,선)->설정추

      1. 배경

         ggplot(data=사용할데이터명, aes(x=변수,y=변수))

      2. 그래프 추가 

         ​	' + ' 로 이어서 그림 

         + geom_point():산점도 그리는 함수	

      3. 설정 

         x축 범위 : + xlim(a,b) , y축범위 : +ylim(a,b)

    + 막대그래프 : 집단간 차이 표현 유용 = **요약표** 사용!!!

      1. **평균값** 구하기

      2. 순서 변경 (변수 지정시=aes(x=,y=)): 

         값 크기 : reorder(변수, -정렬변수) :  -:내림차순

      3. +geom_col( ) : 막대그래프 함수

    + 빈도 막대그래프 : 값의 개수 표현  =**원자료** 사용!!!

      + y축 없이 **x축만** 지정 =(x= ) / y는 알아서 count값
      + geom_bar( )

    + 선그래프 = 시간에 따라 달라지는 데이터 =시계열

      + ggplot2 - economics데이터 이용
      + geom_line( )

    + 상자그림 : 데이터 분포(퍼져있는 상태) : 직사각형으로 푠현 : 분포 알기 쉬움

      + +geom_boxplot( )
  
+ 예제

  ```R
  @@ -0,0 +1,87 @@
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
  ```

  