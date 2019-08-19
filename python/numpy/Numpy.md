Numpy 외장 라이브러리

 - 다차원 배열 / 행렬 연산

 - import numpy as np

 - array([ ... ]) 속 데이터 타입 같아야함

 - axis=0 : 각 열의 평균값 / axis=1 : 각 행의 평균값

 - 함수: .zeros() : 원소 0으로만 이루어짐, .ones() : 원소 1로만 이루어짐, .linespace() :간격지어 만듦 등등. / range() : 0~n-1 생성

 - 데이터 자료형 지정 않아면 알아서 / np.array(변수명, np.int)

   자료형 확인 : .dtype()

- 연산 빠름 : np.array([...]) / np.array([...]) : +-/* or 함수이용:add(),substract(),multiply(),divide()

  - 행렬의 연산 : prod()/sum() /곱셈:multiply 대신 dot() 사용 = product 이라 부름 = np.dot(a,b)

- 슬라이싱 [a: b] : a에서 b-1까지 

  list=[[1,2,3],[4,5,6],[7,8,9]]

  ar=np.array(list)

  a=ar[0:2,0:2]

  print(a) => 0행에서 1행 / 0열에서 1열 뽑음 :[[1,2][4,5]]

- 브로드캐스팅 :자료형이 달라도 알아서 계산

- reshape() :기존 데이터유지/ 차원과 형상 바뀜/ 다차원으로 변형하는 함수  1->다차원

  ​	a=np.array(range(20)).reshape((5,4))  :5행 4열되고

  ​	a=np.array(range(15)).rechape((3,5))  : 3행 5열로 바뀜 

  - reshape(-1)= 1차원 배열 반환 / -1 은 0 이전에 -1인덱스 넣어 총 행이나 열 갯수 만듦

- 다차원 배열 -> 1차원  함수 3개 =  reshape()  <-> ravel(),flatten()

  - a1= np.array([[1,2],[3,4]])

    a2=a1.ravel() or a2= a1.reshape(-1) or a2=a1.flatten()

    = array([1,2,3,4])

  - a1 원본 값 변경시 a2값 변경 됨 but flatten()만 변경안됨=복사되는것
  
- 

- **SciPy** 라이브러리 : 

  - 파이썬 을 기반으로 하여 과학, 분석, 그리고 엔지니어링을 위한 과학(계산)적 컴퓨팅 영역의 여러 기본적인 작업을 위한 라이브러리.
  -  Scipy는 기본적으로 Numpy, Matplotlib, Pandas, Sympy등 과 함께 사용. NumPy와 Scipy를 함께 사용하면 확장 애드온을 포함한 MATLAB을 완벽하게 대체.
  - SciPy는 NumPy위에서 구동되는 라이브러리 정도로 이해해도 무방. SciPy는 기본적으로 NumPy의 ndarray를 기본 자료형으로 사용. - Numpy의 < array > 객체 조작 틀
    - 이미지 작업: 이미지 읽기/쓰기/저장
    - MATLAB files : .mat 파일 읽기
    - 두점 사이의 거리 구하기
    - plotting - 이미지 출력
  - SciPy는 다른 과학 컴퓨팅 영역을 다루는 하위 패키지로 구성됩니다