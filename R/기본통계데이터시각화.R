#t검정 : 두 집단의 평균에 통계적으로 유의한 차이가 있는지
#t.test()
mpg<-as.data.frame(ggplot2::mpg)
library(dplyr)
mpg_diff<-mpg %>% select(class,cty) %>% filter(class %in% c("compact","suv"))
head(mpg_diff)
table(mpg_diff$class)

t.test(data=mpg_diff,cty ~ class, var.equal=T)
# ~ 비교할 값  
#t검정은 비교집단의 분산 이 같은지 여부에 따라 다른 공식 
#여기서는 같다고 봄 var.equal=T

#결과
#p-value < 2.2e-16 : 2.2앞에0이 16개 = <0.05 미만 : 차이가 유의하다
#compact 와 suv 간 평균 도시 연비 차이 유의하다
#sample estimates: 
#mean in group compact     mean in group suv 
#20.12766              13.50000 
#compact의 도시 연비가 큰것은 우연이 아니다.

##상관 분석 : 두 변수가 서로 관련 있는지 0~1에서 1과 가까울수록 관련성 큼
#cor.test()
economics<-as.data.frame(ggplot2::economics)
cor.test(economics$unemploy,economics$pce)
#p-value < 2.2e-16 : 유의 하다
#sample estimates:
#cor  0.6145176   : 정비례관계다.


#많은 변수 비교시 - 상관행렬
#cor()
head(mtcars)
car_cor<-cor(mtcars) #상관행렬 생성
round(car_cor,2) #소수점 3째자리에서 반올림림
#결과
# mpg행과 cyl 교차 지점 :-0.85 :연비가 높을수록 실린더수 적어짐
#cyl행과 wt무게 교차지점 : 0.78 : 실린더수 높을수록 무게 증가

#변수 많으면 corrplot() 이용해 히트맵 만듦 : 값 크기별로 생깔 다름
install.packages("corrplot")
library(corrplot)
corrplot(car_cor) #원의 크기와 색깔 정도 에따라 상관도 구분가능
#다른 형태
corrplot(car_cor,method="number")
corrplot(car_cor,method="color",
         type="lower", #왼쪽 아래행렬만 표시 =계단식
         order="hclust",  #유사한 상관계수끼리 군집화
         addCoef.col="black", #상관계수 색깔
         tl.col="black", #변수명 색깔
         tl.srt=45, #변수명 45도 기울임임
         diag=F) #대각행렬 제외외

