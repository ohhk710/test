#문제1
data<-제품클릭<-read.table("product_click.log",header = F)
png(filename="clicklog1.png", height=400, width=700, bg="white") 
plot(data$V2, main="세로바 그래프실습", xlab="상품ID", ylab="클릭수", col=terrain.colors(15))
dev.off()

#문제2
time1<-str_sub(data$V1,9,10)
png(filename="clicklog2.png", height=400, width=700, bg="white") 
time1<-as.factor(time1) #factor로 변환 
sumTime<-summary(time1) #숫자합 셈
numTime<-as.numeric(names(sumTime)) #숫자값 
pie(sumTime, labels=paste(numTime , "-",numTime+1 ), col=rainbow(10),main="파이그래프 실습")
dev.off()
