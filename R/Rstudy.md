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

+ <-**scan**("sample_num.txt") : 텍스트 파일 =실수나 문자 ) 불러와 **백터로 저장**

  <-scan("sample_num.txt" ,**what**=" ") : what : 데이터를 무엇으로 인식 : "character"

  + 파일이 테이블 형식 이 아닐때 scan 해서 table화 만들어 table( ) , 필요한거 추출
  
  <-readLine**s**("sample_ansi.txt") : 파일 한줄씩 읽어와 배열에 담음
  
+ break : 반복문 나옴

+ next = continue

#### 함수

+ <- function ( [  ] )

+ 호출 : function ( )

+ return () 함수! 사용 좋음 arg 있던 (리턴값 지정) / 없던

+ 수행문장 1개일때 { } 생략가능

+ 함수내 데이터 셋이 c() :백터일때/ 문자 포함하면 큰 타입으로 자동 형변환되서 sum 안됨

  !!!! list () 하면 자동 형변환 안되서 문자따로 숫자 따로 계산됨

+ 지역변수 가 다른곳에서는 값 안나옴

+ 매개변수 넣어야할때 호출시 무조건 넣어줘야함

+ x<<-40  : 외부변수 수정

+ 전역변수 / 지역변수

  미리 선언 / 그냥 출력 시 전역변수 값 나오고

  호출시 매개변수=지역변수 로 함수 속에서 값 나옴

+ invisible( ) = 함수만 호출할경우 리턴값을 못담음 / 저장해야함

+ testParamType <- function(x){
    if(is.vector(x)) print("벡터를 전달했군요!")
    if(is.data.frame(x)) print("데이터프레임을 전달했군요!")
    if(is.list(x)) print("리스트를 전달했군요!")
    if(is.matrix(x)) print("매트릭스를 전달했군요!")
    if(is.array(x)) print("배열을 전달했군요!")
    if(is.function(x)) print("함수를 전달했군요!")
  }

  #dataframe이 list에, list는 vector에 포함 됨 
  #list는 원소 1개 짜리 1차원 배열과 같다.

  testParamType(100)
  testParamType(LETTERS)
  testParamType(data.frame())
  testParamType(matrix())
  testParamType(list())
  testParamType(array())
  testParamType(function(){})

  

+ testParamType1 <- function(x){
    result <- NULL
    if(is.vector(x)  && !is.list(x)) result <-"벡터를 전달했군요!"
    else if(is.data.frame(x)) result <- "데이터프레임을 전달했군요!"
    else if(is.list(x)) result <- "리스트를 전달했군요!"
    else if(is.matrix(x)) result <- "매트릭스를 전달했군요!"
    else if(is.array(x)) result <- "배열을 전달했군요!"
    else if(is.function(x)) result <- "함수를 전달했군요!"
    return(result)
  }
  
+ f6<-function(...){ #...가변인자 (...):아무거나 받음
    print("수행시작")
    data<-c(...) #받아서  벡터나 리스트나 등등 받아서 변수에 넣음
    for(item in data){
      print(item)
    }
    return (length(data)) #length로 갯수 
  }

+ 매개변수 : 1 개 =function(x)

     리턴 값 : 숫자

  ​      기능 : 전달받은 아규먼트가 벡터인 경우에만 기능을 수행합니다.

  ​              

  벡터가 “벡터만 전달하숑!”라는 에러 메시지를 가지고 **에러를** 발생한다. 

  =if(is.vector(x)==FALSE)
          **stop**("벡터만 전달하세요")

  벡터라 하더라도 숫자 벡터가 아니면 “숫자 벡터를 전달하숑!” 라는 **경고** **메시지를** 가지고 경고 에러를 발생한다. 이 때 리턴값은 0이다.

  else{
          if(is.numeric(x))
            return(sum(x))
          else{
            **warning**("숫자 벡터를 전달하숑!")
            return(0)
          }
        }

+ 매개변수 : 가변(숫자, 문자열, 논리형(데이터 타입의 제한이 없다.)

    function(...){

    ​      리턴 값 : 리스트객체

    ​			 return(list(.....)

    ​      기능 : 전달된 아규먼트가 없으면 NULL을 리턴한다.

    ​				data<-list(...)
    ​					  if(length(data)=0)
    ​    				      return(NULL)

    ​          전달된 데이터들을 각각의 타입에 알맞게 벡터들을 만들어서 

    ​			for(x in data){
    ​      			if(is.numeric(x)) 
    ​       			 num<-**append(num,x)**
    ​     			 else if(is.character(x))
    ​       			 char<-append(char,x)
    ​     			 else if(is.logical(x))
    ​       			 log<-append(log,x)
      			  }

    ​				리스트에 담아서 리턴한다.

    ​					return(list("num"=num,"char"=char,"log"=log)) : 

    ​			**빈 것에 넣기 위해 기본 =0 되는 것부터 시작 해야함**

## 웹 크롤링

+ installed.packages() 
  #이미 설치된 패키지 libraray 에 메모리에 올려놓아야 한다
  search() 
  #자동으로 메모리에 로딩

+ rvest 라이브러리 함수 : 크롤링 해온 html문서에서 원하는 돔객체를 찾고 거기서 원하는 것을 추출하는  : 세션 다시 할때마다 실행해야함

+ <head>에 텍스트가 UTF-8인지 아닌지 보고 작성 

  + library(rvest)
    url<-"https://movie.daum.net/moviedb/grade?movieId=121137&type=netizen"
    daummovie1<-NULL
    text<-read_html(url,encoding = "UTF-8")
    text

    nodes<-html_nodes(text,'.emph_grade')
    grade<-html_text(nodes)
    grade

    nodes<-html_nodes(text,'.desc_review')
    content<-html_text(nodes,trim=TRUE)
    review<-gsub("\r\n","",review)
    content

    page<-cbind(grade,content)
    page
    daummovie1<-data.frame(page)
    write.csv(daummovie1,"daummovie1.csv")

    

+ library(rvest)
  url_base<-"https://movie.daum.net/moviedb/grade?movieId=121137&type=netizen&page="
  daummovie2**<-NULL**
  text<-read_html(url_base,encoding = "UTF-8")
  text

  allmovie2<-data.frame() #할때마다 새롭게 

  **for(i in 1:20) **{

    url=**paste**(url_base,i,sep="")
    text<-read_html(url,encoding = "UTF-8")

    nodes<-html_nodes(text,'.emph_grade')
    grade<-html_text(nodes)

    nodes<-html_nodes(text,'.desc_review')
    content<-html_text(nodes,trim=TRUE)
    review<-gsub("**[\r\n]**","",review) #정규식
    content

    daummovie2<-data.frame(grade,content)
    allmovie2<-**rbind**(allmovie2,daummovie2)
  }

  write.csv(allmovie2,"daummovie2.csv")

+ **xml 라이브러리**

  install.packages("XML")
  library(XML)
  t <- htmlParse("http://hankookilbo.com")
  content<- xpathSApply(t,"**//p[@class='title'**]", xmlValue);  #p의 자손으로

  **xpathSApply**(html,xpath,FUN) :찾은 함수에 바로 함수까지 적용시켜줍니다. / 추출한 노드는 하위 노드의 정보를 모두 포함하고 있습니다.

  **//**하위 아무거나 태그  **/** : 자손중에 고를수있는 태그

  + [[:punct:][:cntrl:]] : 특수문자 
  + [:cntrl:] : \n , \r 등

  span태그
  content
  content <- gsub("[[:punct:][:cntrl:]]", "", content)

  content
  content <- trimws(content) : 앞뒤 공백제거
  content

  + httr 패키지 사용 - GET 방식 요청

  install.packages("httr")
  library(httr)
  http.standard <- GET('http://www.w3.org/Protocols/rfc2616/rfc2616.html')

  title2 = html_nodes(read_html(http.standard), 'div.toc h2')
  title2 = html_text(title2)
  title2

  + httr 패키지 사용 - POST 방식 요청

  library(httr)
  + POST 함수를 이용해 모바일 게임 랭킹 10월 29일 주  모바일 게임 랭킹을 찾는다

  #(http://www.gevolution.co.kr/score/gamescore.asp?t=3&m=0&d=week) 
  game = POST('http://www.gevolution.co.kr/score/gamescore.asp?t=3&m=0&d=week',
              encode = 'form', body=list(txtPeriodW = '2018-12-03'))
  title2 = html_nodes(read_html(game), 'a.tracktitle')
  title2 = html_text(title2)
  title2[1:10]

  + 뉴스, 게시판 등 글 목록에서 글의 URL만 뽑아내기 

  res = GET('https://news.naver.com/main/list.nhn?mode=LSD&mid=sec&sid1=001')
  htxt = read_html(res)
  link = html_nodes(htxt, 'div.list_body a')
  article.href = unique(html_attr(link, 'href'))
  article.href
  + pdf

  res = GET('http://cran.r-project.org/web/packages/httr/httr.pdf')
  writeBin(content(res, 'raw'), 'c:/Temp/httr.pdf')
  + jpg

  h = read_html('http://unico2013.dothome.co.kr/productlog.html')
  imgs = html_nodes(h, 'img')
  img.src = html_attr(imgs, 'src')
  for(i in 1:length(img.src)){
    res = GET(paste('http://unico2013.dothome.co.kr/',img.src[i], sep=""))
    writeBin(content(res, 'raw'), paste('c:/Temp/', img.src[i], sep=""))
  }

+ 실습으로 보는 코드

  1. library(httr) #css
     news<-NULL
     url <- GET("http://media.daum.net/ranking/popular/")
     newstitle <- html_nodes(read_html(url), 'ul.list_news2 a.link_txt')
     newstitle <- html_text(newstitle)

     newspapername <- html_nodes(read_html(url), 'ul.list_news2 span.info_news')
     newspapername <- html_text(newspapername)

     news <- data.frame(newstitle,newspapername)

     write.csv(news, "daumnews.csv")

  2. library(XML)
     t<-read_html("http://media.daum.net/ranking/popular/",encoding = "UTF-8")
     article<-htmlParse(t)

     newstitle <- xpathSApply(t,"//a[@class='link_txt']", xmlValue)
     newstitle <- gsub("[[:punct:][:cntrl:]]", "", newstitle)

     newspapername  <- xpathSApply(t,"//span[@class='info_news", xmlValue)

     daumnews<-data.frame(newstitle,newspapername)
     write.csv(daumnews, "daumnews.csv")

+ **apply**( ) : 행/열 단위 연산 쉽게 (x :데이터타입, fun : 연산함수 , na.rm=T : NA값 제거)

  lapply( ) : 연산 결과를 list형태

  sapply( ) : 행렬/ 벡터/DF 등의 다양한 타입으로 반환 (x: 데이터타입 ,fun : 함수 , simplify =f : 기본- 백터)

  

+ **RSelenium**

  + 웹브라우저를 원격조정 하는것  /매크로방식

  + 기존에 학습했던 read_html는 해당 페이지의 소스를 가져오는 것

    , 해당 코드는 이동하는 것이다.

  1. JAVA설치

  2. CMD 에 입력
  
     + cd C:\selenuim java
   + remDr <- remoteDriver(remoteServerAddr = 'localhost', 
       [#](https://blog.naver.com/PostListByTagName.nhn?blogId=najam90&encodedTagName=) 포트번호 입력

  3. r입력
  
     + remDr$open() 
     + remDr$navigate()
     + findElement() 함수를 이용하여 특정 위치를 지정 2가지 방식
       1. xpath 방식
          - id <- remDr$findElement(using="xpath", value='//*[@id=\"id\"]') / or "[name='q']" :name이 q인 요소 찾기
       2. css selector방식
          - id <- remDr$findElement(using="css selector", value="input#id")
   + sendKeysToElement(list("JAVA", key="enter") :입력하
       + *list(입력할문자열,key=작업)*

     
  
   ex)실습
     + 페이지 번호 규칙찾기

       + 1,2,3,4,5 = 1->2->3->4->4->4->4... 페이지이동방식

     + remDr$executeScript("**scrollBy**(0,8500)") 

       *#페이지 이동*
  
       mored <- remDr$findElements(using='css','#dismiss-btn > p')
       *#해당 p 태그 찾아 - 여기서는 팝업창에 닫기 버튼* 
        sapply(mored,function(x){x$clickElement()})
       #*지우기*
       
       
       
       ### **dplyr** 패키지 : 파이프 기법 사용 : 전처리 사용시 조작편리 패키지
       
       str(**ggplot2::**mpg)# 이렇게 써야함
       
       mpg<-as.data.frame(ggplot2::mpg) #mpg 를 데이터프레임변환후 이 세션만의 mpg만듦 
       
       
       
       v3<-함수1( )**%>%** 함수2 () **%>%** 함수3 ()
       
       ​	== v3<-함수3(함수2(함수()))
       
       
       
       - 함수(with ex)
       
         - 변수명 변경(데이터,변경후=변경전) : rename(copy_mpg,city=cty) 
         - 행 추출 : filter(class=="suv") 
         - 열 (변수) 추출 : select(class,cty) : class,cty 변수 추출
         - 정렬 : arrange(hwy)
         - 전체값 통계량 : summarise(변수명=mean(hwy) 
         - 변수추가 : mutate(meanAsian=asian/total*100)
         - 집단별로 나눔 : group_by(drv)
         - 데이터 열 합침 : left_join(mpg,fuel,by="fl")
         - 데이터 행 합침 :bind_rows(group_a,group_b)
       
         
       
       + 데이터 만들기 : 
       
         test1<-data.frame(id=c(1,2,3,4,5),midterm=c(60,80,70,90,85))
       
       + mpg[c(65,124,131,153,212),"hwy"] <- **NA**
       
         결측치 NA 삽입
       
         table(**is.na**(mpg$drv)) : 결측치 존재 확인
       
         filter(**!is.na**(cty)&!is.na(drv)) : 결측치 제외 값 #행 자체 없어짐
       
       + mpg[c(10,14,58,93),"drv"]<-"k" 
       
         drv 변수에 번호 행마다 "k" 라는 **이상치** :존재x값  넣기
       
         - table(mpg$drv)  : 이상치 확인
       
         - mpg$drv<-ifelse(mpg$drv**%in%** "k",NA,mpg$drv)
       
           이상치 k 있으면 NA :결측치 로 바꾸고 / 아니면 그대로
       
         - 상자그림
       
           - **boxplot**(mpg$cty)$stats : 이상치 수치로 확인
       
           - cty<-ifelse(mpg$cty<9 | mpg$cty>26,NA,mpg$cty)
       
             수치 범위 이외는 NA 값으로 아니면 그대로
       
       + 또는 na.rm=T 로 제외 가능
       
       - **ggplot2** :그래프 패키지
         - data frame
         - aes
         - geoms
         - stats
         - scale
       
       ​	
       
       
       
       
       
       
       
       
       
       
