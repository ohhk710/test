리눅스 ip 
vmnet8 - ipv4 =192.168.40.1 을 변경해야 서버 연결됨
192.168.xxx.1
변경방법 p68 / vmnetcfg.exe 실행시켜 111로 바꿈
하드웨어 감싸는것 =커널
커널을 감싸는걸 =shelle
총= 운용프로그램

명령어
연속일때 한칸 띄우고
date 날짜
ls 현재디렉토리 리스트 만들어주는것 파란색=폴더/ 검은색=파일
cd +엔터 = 홈 으로 이동
pwd = 위치!
gedit ifcfg-eno16777728 =

rmdir 만들었던것 삭제, 빈폴더이여함
rm 빈폴더 아니여도 삭제  rm -f : 무조건삭제 , rm-rf : 서브 dir 까지 다 삭제 
mkdir tools : tools라는 dir 만들어짐

touch 파일명 = 파일생성
cat 파일명 =파일내용
tar : 아카이브 (꾸러미) 생성 , 풀기 ,리스트 보기
    tar cvf 아카이브파일명 파일리스트
    tar xvf 아카이브파일명
    tar cvf 아카이브파일명
    tar cvf myApp.tar *.class
    tar cvf tools.tar tools
  gzip myApp.tar ---->myApp.tar.gz 압출풀기
   but, prefer to = tar xvfz myApp.tar.gz  xvfz =z는 압축풀기

bzip2 압축풀기 : -dk 를 같이 주면 원본파일도 남겨둔다

vi
문자하나 지우기  = x
한행 삭제 =dd
한 행 복사 =yy
아래 행에 붙이기 =p
단어 삭제 =dw

저장 = :w, 종료 =  :q, 강제종료 = :q!
저장+종료 = :wq

파일내용체크:
cat :파일 다보여줌, head : 위에서 10행, tail : 아래에서 10행, more : 스크롤 페이지단위로 보여줌 

파일내용을 출력하거나 편집기로 오픈하지 않고도 체크
grep 찾으려는 단어 파일명
grep unico *.txt

파일시스템에서 어떤 명칭의 파일이 어디 있는지 체크
 find 폴더명 -name 파일명
 find / -name test.java
 find /tmp -name test.java
 find tools -name test.java
 find dir1/dir2 -name test.java

cat Test.java >Output.java
cd
ls -al >list.txt : home dir list 넣지만
cd tools
ls -al >>list.txt : 오버라이딩 . > 오른쪽 파일이 
>> 오른쪽 파일이 upend 로 redirecttion 


명령->입력 모드 : a i o
입력-> 명령모드 : esc

cp: 파일복사
cp old 파일명= new 파일명
cp old 디렉토리 new 디렉토리
cp -r 폴더, 폴더내 모든 파일 복사 -r: recurssive
mv old파일명 new파일명 =파일명 변경
mv old파일명 dir =이동

ls -a = 파일 다 보여줌
ls -l = 리스트로 파일 다보여줌 
ls -al= 숨김파일까지 리스트로 다 보여줌

파이프 기호
ls -al | more |=and 이어지는것
ls -al |wc -l
명령1|명령2|명령3

cd : 현 dir 이동할때 , cd 절대패스 , cd 상대패스 ,


cd tools : tools 는 현재 dir 밑이라 cd 하고 바로
최상위 dir 기준으로 할땐 / 하기

/etc : 시스템 정보와 관련된 파일들
/usr : JDK 와 같은 개발 툴을 보관하는 디렉토리
/tmp :  여러목적의 임시 폴더와 파일들이 생성되는 디렉토리

export JAVA_HOME=/usr/jdk1.8.0_131
export PATH=$JAVA_HOME/bin:$PATH

./ : 파일 실행

systemctl stop firewalld : 방화벽 정지시키기 왜? 서버 구동 접속위해서

ps -process status
(현재 수행중인 프로그램)
kill -9 PID
ls -al => ps -ef 다중 사용자

생성되는 모든 파일과 디렉토리는 사용자 허가모드가 정해져 있다

사용자 허가모드 : 읽기 ,쓰기 , 실행

chmod 허가모드 스펙 대상파일명
u -undo, -redo
:set nu -행 넘버, : 넘버 :100 :1 shift +g
/찾을 단어 -단어 찾기, n -forward 방향으로 다음 , N 또는 b(반장) -forward 방향으로 다음
:s/old단어/new단어

