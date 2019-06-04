-- 제출파일명 : exercise1.sql

--1. 모든 테이블의 리스트를 출력하시오.
SELECT * FROM tab;

--2. 모든 테이블의 구조를 출력하시오.
DESC BONUS;
DESC DEPT;
DESC EMP;
DESC SALGRADE;
SELECT

--3. 사원(emp)테이블에서 모든 데이터를 출력하시오.
SELECT * FROM EMP;

--4. 사원테이블에서 사원번호, 사원이름, 월급을 출력하시오.
SELECT EMPNO, ENAME, SAL FROM EMP;

--5. 사원테이블에서 월급열만 뽑는데 중복된 데이터가 없게 출력하시오.
SELECT DISTINCT SAL FROM EMP;

--6. 사원테이블에서 사원이름과 월급을 출력하는데 각각의 컬럼명을
-- "이 름","월 급"으로 바꿔서 출력하시오. 단, ALIAS에 공백 추가
SELECT ENAME "이 름",SAL "월 급" FROM EMP;

--7. 사원테이블에서 사원이름, 월급을 뽑고, 월급과 커미션을  더한 값을
-- 출력하는데 컬럼명을 '실급여'이라고 해서 출력하시오.
-- 단, NULL값은 나타나지 않게 하시오.(커미션 안받는사람제외)
SELECT ENAME,SAL,SAL+COMM "실급여" FROM  EMP  WHERE COMM IS NOT NULL ;

--8. 사원테이블에서 'SCOTT'이라는 사원의 사원번호, 이름, 월급을 출력하시오.
SELECT EMPNO,ENAME,SAL FROM EMP WHERE ENAME='SCOTT';

--9. 사원테이블에서 직위가 'SALESMAN'인 사원의 사원번호, 이름, 직위를
-- 출력하시오.
SELECT EMPNO,ENAME,JOB FROM EMP WHERE JOB='SALESMAN';

--10. 사원테이블에서 사원번호가 7499, 7521, 7654인 사원의 사원번호, 이름
-- 월급을 출력하시오.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE EMPNO IN (7499, 7521, 7654);

--11. 사원테이블에서 월급이 1500에서 3000사이인 사원의 사원번호, 이름,
-- 월급을 출력하시오.
SELECT EMPNO,ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;

--12. 사원 테이블에서 부서 배치를 받지 못한 직원의 이름을 출력하시오.
SELECT ENAME FROM EMP WHERE DEPTNO IS NULL;

--13. 사원테이블에서 월급이 많은 순으로 모든 정보를 출력하시오.
SELECT * FROM EMP ORDER BY SAL DESC;

--14. 사원테이블에서 직원의 이름과 입사일을 출력하는데 최근에 입사한 순으로 출력하시오.
SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC;

--15. 사원 테이블에서 30번 부서에 근무하는 직원들의 이름을 출력하는데
-- 입사한지 오래된 순으로 출력하시오.
SELECT ENAME FROM EMP WHERE DEPTNO=30 ORDER BY HIREDATE ;

--select*from tab;
--
--SELECT*from bonus;
--SELECT*from dept;
--SELECT*from emp;
--SELECT*from salgrade;
--
--DESC emp;
--DESC dept;
--
--SELECT SYSDATE FROM dept
--SELECT SYSDATE FROM emp
--SELECT 10+20 FROM emp
--SELECT SYSDATE FROM dual
--SELECT ENAME,SAL,SAL*12+COMM,COMM FROM EMP;
--SELECT ENAME,SAL,SAL*12+NVL(COMM,0),COMM FROM EMP;