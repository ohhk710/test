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

  

  