### Pandas 

	- 판다스 기본 데이터 구조 DataFrame 와 Series
	- 행과 열 데이터 객체 만들어 다룸
	- 정렬 오류 방지 / 다양하게 색인가능
	- 시계열 기능 /비시계열 다룸
	- 누락 데이터 처리 유연함

+ ### Data Frame
   

  + Load

    + df=read_csv(",,,.csv") -> df구조로 반환

  + Concatenating and appending = inner and outer joins

  + data Aggregation :  groupby( )

  + joining

    + pd.merge(....on=' ')
    + pd.merge(dt1,dt2, how='inner') / how='outer'
    + 기준변수명.join(붙일변수, lsuffix=' ',rsuffix=' ')

  + Missing Values

    + df = df [ [ 'Country', df.columns [ -2 ]  ] ] [ : 2 ] 

      ​					컬럼 추출 								~행 추출

    + pd.isnull(df) : nan 값 T OR F 찾기

      df.notnull( ) : T or F

    + '+' np.nan :연산시 하나라도 nan이면 nan 으로 채워짐

    + **df.fillna**(변경할 값) : NAN -> 값

    + **pd.date_range**('시작의 날짜형 문자','끝의 날짜형 문자')

      : 연속적인 날짜의 출력 / freq= 빈도수 / period: 일자

  + **import sys**
    **try**:
        print("Date range",pd.date_range('1/1/1677',periods=4,freq='D'))
    **except**:
        **etype, value, _ =sys.exc_info()**
        #오류클래스, 발생이우. 발생위치정보 = 튜플
        print("Error encountered",etype,value)

  + #**offset** : 입력값 그대로 출력 / **DateOffset** :날짜 변수 받음
    offset= pd.DateOffset(seconds=2 ** 33/10 **9)
    mid=pd.to_datetime('1/1/1970')
    #string 타입의 시간을 Timestamp형**

  + **print("Illegal date coerced", pd.to_datetime(['1902-11-12', 'not a date'], **errors='coerce')**)
    #파싱이 불가한 경우 NaN(Not a Number)값으로 반환
    #errors= : 'coerce' : '무시'/'raise' : ''예외'/''ignore' : ' 강제'

    #errors 없으면 오류남

  + **pivot_table**(data, values=None, index=None, columns=None, aggfunc='mean', fill_value=None, margins=False, margins_name='All')

    + data: 분석할 데이터프레임 (메서드일 때는 필요하지 않음)

      values: 분석할 데이터프레임에서 분석할 열

      index: 행 인덱스로 들어갈 키 열 또는 키 열의 리스트

      columns: 열 인덱스로 들어갈 키 열 또는 키 열의 리스트

      aggfunc: 분석 메서드 / 없으면 평균값

      fill_value: NaN 대체 값

      margins: 모든 데이터를 분석한 결과를 오른쪽과 아래에 붙일지  T or F : T이면 aggfunc결과값

      margins_name: 마진 열(행)의 이름'

      

+ ### Pandas Series

  + 1차원 배열
  + 인덱스 존재
  + pd.Series({'인덱스1':값1 , '인덱스2' : 값2 })
  + Numpy 함수 사용 가능 
    + NAN 존재 
    + seed() 고정 랜덤 난수
  + 연산시 하나라도 nan이면 nan 으로 채워짐