gedit ifcfg-eno16777728 =

rmdir 만들었던것 삭제, 빈폴더이여함
rm 빈폴더 아니여도 삭제  rm -f : 무조건삭제 , rm-rf : 서브 dir 까지 다 삭제 
mkdir tools : tools라는 dir 만들어짐
touch 파일명 = 파일생성
cat 파일명 =파일내용
cp old 파일명= new 파일명
cp old 디렉토리 new 디렉토리
mv old 파일명 new 파일명 =파일명 변경
mv old 파일명 dir =이동

ls -a =
cd tools : tools 는 현재 dir 밑이라 cd 하고 바로
최상위 dir 기준으로 할땐 / 하기
xvfz =z는 압축풀기

/etc : 시스템 정보와 관련된 파일들
/usr : JDK 와 같은 개발 툴을 보관하는 디렉토리
/tmp :  여러목적의 임시 폴더와 파일들이 생성되는 디렉토리

export JAVA_HOME=/usr/jdk1.8.0_131
export PATH=$JAVA_HOME/bin:$PATH

vi (visual editor)
두가지 모드
1-입력모드 : 입력되는 문자를 입력 데이터로 인식
2-명령모드 : 입력되는 문자를 편집 명령어로 인식

편집명령어가 알파벳 문자다.
초기에는 명령모드이다. 입력모드로 변환하려면 a, i, o 문자를 입력한다
o; 아래 '
i; 현재위치
a; 다음 위치

입력모드에서 명령모드로 변환 하려면 ESC키를 누른다.

저장 - :w, 종료 -:q, 강제종료 -:q!
저장+종료 -:wq

cd ../tools 
cd tools 서브로 감= 오류