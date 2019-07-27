# 게시판 spring mybatis

### 스프링이 파일 읽는 순서

(pom.xml) web.xml -> dispatcher.xml -> controller -> service -> dao -> mapper -> database

database -> mapper -> dao -> service -> controller -> dispatcher.xml -> jsp

### 스프링 구조

src/main/**java** : 패키지와 클래스

src/main/**resources** :  DB환경설정 mybatis 사용을 위한 mapper 등등..

src/main/**webapp** : js,css,img

src/main/webapp/WEB-INF/**views** : jsp

+ 스프링 환경설정위해 = *dispatcher-servlet.xml*

  - src/main/webapp/WEB-INF/spring/**root-context.xml**

  - src/main/webapp/WEB-INF/spring/appServlet/**servlet-context.xml**

src/main/webapp/WEB-INF/**web.xml** : dispatcher-servlet.xml 정의,이미지 확장자,인코딩 설정위해

pom.xml: maven기능위해 / xml코드를 통해 라이브러리 다운하는 xml



root-context(parent) : AOP설정 : **service, repository, db**관련 설정

servlet-context(child) :  - controller, service, dao, aop의 상위 패키지를(kr.co.song) scan 스캔

​											-client의 요청에 응답해주는 **controller**



										- <context:component-scan :  특정 패키지 안의 클래스들을 스캔하고 빈 인스턴스를 생성할 수 있다. //  @component, @repository, @service, @controller어노테이션이 존재해야 빈을 생성





