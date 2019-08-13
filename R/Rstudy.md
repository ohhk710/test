## R

변수 <- 속성

plot ( _) : 이미지 띄우기

q( ) :저장

변수 [ ] : 값위치

#: 주석 처리 

확장자 .r

## Rstudio

#### 설정

+ 프로젝트 생성 : file -> new project -> New Directory -> New project -> 폴더 이름/위치 설정

+ Tools - Global Option : R 설정메뉴  / Code - Save : 저장 파일 언어 UTF-8 설정

+ plot : 정적 이미지  / packages : 패키지모음 / viewer : 동적 이미지 show

+ File - New File - R script: R스크립트 작성 창 / 콘솔에서는 바로 나옴

+ Run 방법

  + contr + Enter : 행단위 수행 
  + 블럭처리후 Run 수행 (변수만 수행 가능) or Run 수행
  + 한 줄 에 수행시    " ; " 

+ R 구문 = 모두 객체로 봄

  + 데이터 타입의 종류
    + 자동 형변환 가능 : 문자열>>>순치열>>논리형 
    + 강제 형변환 함수 : as.
  + 데이터셋의 종류 (벡터:1차원 / 매트릭스:2차원 / 배열:3차원 / 데이터프레임:2차원 / 리스트:모든유형의 객체 집합)
  + 연산자
  + 제어문(if, witch(), for, while ..)
  + 함수

  

  ### 벡터함수

  + class(x) : 타입

  + rev(x) : 역으로 출력

  + range(x) : 범위  / length(x) : 길이

  + sort(x): 정렬 / sort(x,decreasing=TRUE / T) 내림차순 

  + help : 사용법 

    + ?함수 : 함수정의 설명보여줌

  + 인덱스 관련

    + 벡터 인덱스 1부터!!!!!!!!

    + -인덱스 : 그 인덱스 빼고 출력!

    + 범위 : x[c(2,4)]; 2번째 4번째 출력 -이면 빼고 나머지 출력

    + x[n]<- n  : 값 바꾸기

    + max(x);min(x);mean(x);sum(x);

    + summary(x) : Min. 1st Qu.  Median    Mean 3rd Qu.    Max. 
          					2.0     5.0     9.0     9.4    10.0    21.0 

    + x>n : TRUE OR FALSE 로 출력

    + x[x>n] : 대괄호 부터 계산 -> T OR F 를 -> x에 인덱스대신에 사용해서 조건맞는 값만 출력

      

    + names(x) <-LETTERS[1:5]

      ​	 A  B  C  D  E 
      ​      2  5 21  9 10 

    + (z3<-seq(1,20,2)) :  1  3  5  7  9 11 13 15 17 19

    + ?rep : 데이터 복사

      + rep(1:5,3) : 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5

    + sample () : 랜덤 : sample(1:20,3) : 6 1 7 // sample(1:10,7, replace=T) : 중복값 허용

    + c(T, T, F, F) & c(T, F, T, F) : 맞는것 T 보냄 / & =AND / || =OR

    + ls( ) : 어떤 함수 만들어져있는지 확인

    + rm(num2) : 지우기

    + which(조건) : 조건이 맞는 !인덱스! 추출 

      + which.max( ) / which.min( )

  ### 행렬

  + **apply**() : 3번째 arg 에 따라 행/열 단위로 값 나옴

    ​	apply(x2, 1,sum); = 행단위 sum 나옴
  
  + array(1:30,dim=c(2,3,5)) : 데이터1~30 까지 dim: 2행 3열 5층
  
    ​	a1[ , 2 , ] : 생략: 모든 행 , 층 에 2열 
  
  + **factor** : 특별한 형태의 벡터 : 정해진 값(=level)만 보관 
  
    + f_score<-factor(score)
      > f_score
      >  [1] 1 3 2 4 2 1 3 5 1 3 3 3
      > Levels: 1 2 3 4 5
      >
      > summary(f_score)
      > 1 2 3 4 5 
      > 3 2 5 1 1
  
  
  
  ### 데이터셋
  
  + 내장 데이터셋:
  
    +  data() / View() :원자료 보기 / #Dataframe
      no <- c(1,2,3,4)
      name <- c('Apple','Banana','Peach','Berry')
      qty <- c(5,2,7,9)
      price <- c(500,200,200,500)
      fruit <- data.frame(no, name, qty, price)
      str(fruit)
      View(fruit)() : 데이터 속성/summary() : 요약데이터
  
  + 데이터 만들기
  
    #Dataframe
    no <- c(1,2,3,4)
    name <- c('Apple','Banana','Peach','Berry')
    qty <- c(5,2,7,9)
    price <- c(500,200,200,500)
    fruit <- **data.frame**(no, name, qty, price)
    str(fruit)
    View(fruit)
  
    fruit[, c(3,4)] : 열중에 3열과 4열 
  
    + 한 열 추출시 : fruit[,3] == **fruit[3]**  == fruit$qty  ==fruit[[3]]
  
      
  
    ex)
  
    df <- data.frame(var1=c(4,3,8), var2=c(2,6,1))
  
    ​	 $ var1    : num  4 3 8
  
    ​	 $ var2    : num  2 6 1
  
    ​	df$var_sum<-df$var1+df$var2
    ​	df$var_mean<-df$var_sum/2
  
    ​	df$result<-ifelse(df$var1>df$var2,"var1이 크다","var2가 작다")
    ​	str(df)
  
    ​		ifelse : if 문처럼 쓰임	
  
    ​	여러조건 : <-ifelse**( **score$sum>=230,"A",
    ​                    		ifelse(score$sum>=215,"B",
    ​                           	ifelse(score$sum>=200,"C","D")) **)**
  
    df
     	 var1 var2 var_sum 	var_mean      result	
    1    	4    2       6      		3.0 			var1이 크다
    2   	 3    6       9    	 	 4.5 			var2가 작다
    3   	 8    1       9      		4.5			 var1이 크다
  
    ------
  
    + getwd() : 현재 working directory
  
      
  
    + #### csv 파일 
  
    + <-**read.csv("이름.csv")** : df 로 읽어옴
  
    + 제목 행 따로 있음 = 컬럼명
  
    + summary 에 만들어지고 추가된거는 chararcter형으로 보임
  
      **summary(score$result)**
  
      ​	   Length     Class      Mode 
      ​       20 character character 
  
      factor 함수 이용시 summary 로 범주형으로 나와 총계 나옴
  
      **summary(factor(score$result))** or table(score$result)
  
      ​	fail pass 
         	9   11 
  
    + 구조 변환 -> 마무리는 다시 summary 하면 구조 바뀜
  
      + score$id=**as.character**(score$id) : 문자열로 변환
  
        score$class=**factor**(score$class) :factor로 변환
  
    + **sort**() 정렬 / **order**() 인덱스 정렬
  
      + order : df 정렬 할때
  
        emp [order(emp$sal) ,  ]  : sal 작은순서로 ,  모든정보
  
    + <- **read.csv(file.choose())** : 파일 열기
  
    + emp[,c(2,3,6)]
      emp[,c("ename","job","sal")]
  
      or subset() 함수 
  
      subset(emp,**select=**c(ename,job,sal))
  
      결과 같음
  
      > **subset(emp,emp$ename=="KING")**
      >   empno ename       job mgr   hiredate  sal
      > 9  7839  KING PRESIDENT  NA 1981-11-17 5000
      >   comm deptno
      > 9   NA     10
      >
      > **emp$ename=="KING"**
      >  [1] FALSE FALSE FALSE FALSE FALSE FALSE FALSE
      >  [8] FALSE  TRUE FALSE FALSE FALSE FALSE FALSE
      >
      >  **emp[emp$ename=="KING", ]**
      >   empno ename       job mgr   hiredate  sal
      > 9  7839  KING PRESIDENT  NA 1981-11-17 5000
      >   comm deptno
      > 9   NA     10
  
    + **select ename,sal from emp between 2000 and 3000**
      subset (emp, select=c("ename","sal"),subset=(sal>=2000 &sal<=3000))
  
      == emp[emp$sal>=2000,c("ename","sal")]
  
    + emp 에서 **커미션이 정해지지 않은 직원**의 이름과 커미션 정보를 출력한다.
  
      ​         (**NA** 값을 채크하는 것은 제공된 교육자료의 6 페이지를 참고한다.)
  
      emp[ **is.na** (emp$comm),]
  
  + List
  
    + 연산 안됨!!!
  
    + lds<-list(1,2,3)
  
      ​	lds[1] : [[1]]
      ​			[1] 1
  
      ​	lds[1]+10 : 불가능
      ​	lds [ [ 1 ] ]+10 : 가능
  
      a[[1]]
      [1] 1 2 3
  
      > $a
      > [1] 1 2 3
      >
      > a$a
      > [1] 1 2 3
      >
      > a[[1]]
      > [1] 1 2 3
      >
      >  a [ [ 1 ] ] [1]
      > [1] 1
  
    + 합치기 : paste("I'm","Duli","!!") 
  
       	두개일때 같은 행 끼리 합쳐짐
  
  ### 제어문
  
+ switch(EXPRE=   , )  정수 이면 정수 번째 , 문자면 해당문자열

  num <- sample(1:10,1)
  num (=num이 6나오면)
  switch(EXPR = num,"A","B","C","D")

  for(num in 1:10){
    cat(num,":",switch(EXPR = num,"A","B","C","D"),"\n")
  }

  출력:

  1 : A 
  2 : B 
  3 : C 
  4 : D 
  5 : 
  6 : 

+ <-scan("sample_num.txt") : 텍스트 파일을 불러와 백터로 저장

  <-scan("sample_num.txt" ,what=" ") : what : 데이터를 무엇으로 인식 : "character"

  <-readLine**s**("sample_ansi.txt") : 파일 한줄씩 읽어와 배열에 담음