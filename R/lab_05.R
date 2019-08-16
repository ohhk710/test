#[ 실습 1 ]
exam1<-function(x,y){
  if(x>y){
    n<-x-y
  }else if(y>x){
    n<-y-x
  }else{
    n<-0
  }
  return(n)
}
result1<-exam1(10,20)
result1

#[ 실습 2 ]
exam2<-function(x,y,z){
  if(y=="+")
    r<-x+z
  else if(y=="-" && x>=z)
    r<-x-z
  else if(y=="-" && z>x)
    r<-z-x
  else if(y=="*")
    r<-x*z
  else if(y=="%/%"){
    r<-x%/%z
    if(x==0)
      r<-"오류1"
  }
  else if(y=="%%"){
    r<-x%%z
    if(z==0)
      r<-"오류2"
  }
  else
    r="규격의 연산자만 전달하세요"
  return(r)
}
result2<-exam2(0,"%/%",5)
result2

#[ 실습 3 ]
exam3<-function(x,y="#"){
  if(x>=0){
    for(i in 1:x)
      cat(y)
  }
}
exam3(4)

#[ 실습 4 ]
exam4<-function(a){
  a<-c(90,70,60,NA)
  for(item in a){
    if(is.na(item)==TRUE)
      print("NA는 처리불가")
    else{
      if(item>=85)
        print("상")
      else if(item>=70)
        print("중")
      else
        print("하")
    }
  }
}
exam4(a)

#[ 실습 5 ]
countEvenOdd<-function(x){
  even<-0;odd<-0
  if(is.numeric(x)){
  for(item in x){
    if(item%%2==0)
        even<-even+1
    else
        odd<-odd+1
  }
    return(list(even=even, odd=odd))#초기화 설정=0
  }else
      return(NULL)
  }

countEvenOdd(c(1,2,3,4,5,6,7))
countEvenOdd(list(1,2,3,4,5,6,7))
#[ 실습 6 ]
vmSum<-function(x){
      if(is.vector(x)==FALSE)
        stop("벡터만 전달하세요")
      else{
        if(is.numeric(x))
          return(sum(x))
        else{
          warning("숫자 벡터를 전달하숑!")
          return(0)
        }
      }
}
vmSum(c(1,2,3,4,5))
vmSum(c("1","2","3"))
vmSum(list(c(1,2,3,4,5)))    

#[ 실습 7 ]
createVector<-function(...){#...가변
  data<-list(...)
  if(length(data)=0)
    return(NULL)
  else{
    for(x in data){
      if(is.numeric(x)) 
        num<-append(num,x)
      else if(is.character(x))
        char<-append(char,x)
      else if(is.logical(x))
        log<-append(log,x)
    }
    return(list("num"=num,"char"=char,"log"=log))
  }
}
createVector(3,4,5,"ee", TRUE, "abc")
createVector((list(c(1:3))))

#[ 실습 8 ]
txt1<-scan("iotest1.txt")
cat("오름차순 : ",sort(txt1),"/n")
cat("내림차순 : ",sort(txt1,decreasing = TRUE),"/n")
cat("합 : ",sum(txt1),"/n")
cat("평균 : ",mean(txt1),"/n")

#[ 실습 9 ]
txt2<-scan("iotest2.txt",what="",encoding = "UTF-8")
#txttable<-table(txt2)
#print(txttable)
#word<-names(txttable[which.max(txttable)])
#word<-names(sort(txttable,decreasing=T))[1]
word<-names(sort(summary(factor(txt2)),decreasing=T))[1]
#summary(factor(txt2)) 하면 따로 table화 안해도됨
#summary 해서 각 총합 나온후 sort 해서 가장 위 : [1]=max
cat("가장 많이 등장한 단어는", word ,"입니다.")

