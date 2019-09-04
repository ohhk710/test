library(DBI)
library(RJDBC)
library(ggplot2)
library(dplyr)
iris
names(iris)<-c("SLENGTH","SWIDTH","PLENGTH","PWIDTH","SPECIES")

drv<-JDBC("oracle.jdbc.driver.OracleDriver","C:/hk/ojdbc6.jar")
conn<-dbConnect(drv,"jdbc:oracle:thin:@localhost:1521:xe","jdbctest","jdbctest")

#테이블생성
dbWriteTable(conn, "iris", iris)
#불러오기기
result<-dbReadTable(conn,"IRIS")

ggplot(result,aes(x=SLENGTH,y=SWIDTH))+
  geom_point(aes(colour=SPECIES))
ggsave("db1.jpg")

ggplot(result,aes(x=PLENGTH,y=PWIDTH))+
  geom_point(aes(colour=SPECIES))
ggsave("db2.jpg")
