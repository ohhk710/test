library(tm)
library(proxy)

fruit<-NULL
dk <- c("사과 포도 망고")
dl <- c("포도 자몽 자두")
dc <- c("복숭아 사과 포도")
dun <- c("오렌지 바나나 복숭아")
kd <- c("포도 바나나 망고")
hd <- c("포도 귤 오렌지")
fruit<-c(dk,dl,dc, dun, kd, hd)

cps <- VCorpus(VectorSource(fruit))
tdm <- TermDocumentMatrix(cps,control=list(wordLengths = c(1, Inf)))
#글자수 작은것까지 다 나오도록
tdm
m <- as.matrix(tdm)


#(1) 좋아하는 과일이 가장 유사한 친구들을 찾아본다.
com <- t(m) %*% m
#사람 기준 행/열 바꿔 곱셈
dist(com, method = "cosine")
#1일수록 유사도 멀어짐.

value<-rowSums(m)
#(2) 학생들에게 가장 많이 선택된 과일을 찾아본다.
sort(value,decreasing = T)
#(3) 학생들에게 가장 적게 선택된 과일을 찾아본다.
sort(value,decreasing = F)
