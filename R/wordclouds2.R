library(devtools)
library(KoNLP)
library(wordcloud2)
library(dplyr)
library(stringr)
library(DBI)
library(rJava)
library(RJDBC)
library(tidyverse)

drv<-JDBC(driverClass="com.mysql.jdbc.Driver",classPath="C:/Rstudy/mysql-connector-java-5.1.40.jar")
conn<-dbConnect(drv,"jdbc:mysql://70.12.113.176:3306/newsbigdata","news","bigdata")

result<-dbGetQuery(conn,"select content from bigkinds where category='정치'")

tbresult<-as_tibble(result)
tbcontent<-result$content

unA<-paste(unlist(SimplePos22(tbcontent)))
extracted<-str_match(unA,"([가-힇]+)/NC")
keyword <- extracted[, 2] %>% na.omit(keyword)
keyword<-Filter(function(x) {nchar(x)>=2}, keyword)
keyword30<-head(sort(table(keyword),TRUE),30)

keyword30<-as.data.frame(keyword30)
a<-wordcloud2(keyword30)

install.packages("igraph")
library(igraph)
mg<-graph_from_data_frame(keyword30)

V(mg)$type <- bipartite_mapping(mg)$type 
mm <- as_incidence_matrix(mg) %*% t(as_incidence_matrix(mg)) 
diag(mm) <- 0 
mg <- graph_from_adjacency_matrix(mm)
plot(mg)
