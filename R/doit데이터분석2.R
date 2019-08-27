install.packages("rJava")
install.packages("memoise")
install.packages("KoNLP")
install.packages("dplyr")

library(rJava)
library(memoise)
library(KoNLP)
library(dplyr)
useNIADic()

txt<-readLines("hiphop.txt")
head(txt)
#특수문자 제거
install.packages("stringr")
library(stringr)
txt<-str_replace_all(txt,"\\W,"," ")
#정규표현식\\W

#명사 추출 - 무엇내용 파악
nouns<-extractNoun(txt)
#리스트반환
#리스트 문자열을 벡터로 변환해 빈도수 세기
wordcount<-table(unlist(nouns))

df_word<-as.data.frame(wordcount, stringsAsFactors = F)
#데.프 로 변환

df_word<-rename(df_word,word=Var1,freq=Freq)

df_word<-filter(df_word, nchar(word)>=2)
#두글자 이상으로 단어 빈도추출

top20<-df_word %>% arrange(desc(freq))
head(top20)


#워드클라우드 만들기 
install.packages("wordcloud")
library(wordcloud)
library(RColorBrewer)

pal<-brewer.pal(9,"Blues")[5:9] #단어색깔
set.seed(1234) #난수 고정

wordcloud(words= df_word$word,
          freq=df_word$freq,
          min.freq = 2,
          max.words=200,
          random.order = F,
          rot.per=.1,
          scale=c(4,0.3),
          colors=pal)

#국정원 트윗 텍스트 마이닝
install.packages("dplyr")
library(dplyr)
twitter<-read.csv("twitter.csv",
                  stringsAsFactors = F,
                  fileEncoding = "UTF-8")
twitter<-rename(twitter,
                no=번호,
                id=계정이름,
                date=작성일,
                tw=내용)
twitter$tw<-str_replace_all(twitter$tw,"\\W"," ")

nouns<-extractNoun(twitter$tw)
wordcount<-table(unlist(nouns))
df_word<-as.data.frame(wordcount,stringsAsFactors = F)
df_word<-rename(df_word,word=Var1,freq=Freq)
df_word<-filter(df_word,nchar(word)>=2)

top20<-df_word %>% arrange(desc(freq)) %>% head(20)
install.packages("ggplot2")
library(ggplot2)

order<-arrange(top20,freq)$word #빈도순
ggplot(data=top20,aes(x=word,y=freq))+
  ylim(0,2500)+
  geom_col()+
  coord_flip()+
  scale_x_discrete(limit=order)+
  geom_text(aes(label=freq),hjust=-0.3) #빈도표시

pal<-brewer.pal(8,"Dark2")
set.seed(1234)
wordcloud(words=df_word$word,
          freq=df_word$freq,
          min.freq = 10,
          max.words = 200,
          random.order = F,
          rot.per = .1,
          scale=c(6,0.2),
          colors=pal)


