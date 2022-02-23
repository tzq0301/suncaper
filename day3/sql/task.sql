# drop database if exists emps;

# create database emps;

# use emps;

# create table emp
# (
#     EMPNO    INT,         -- 员工号
#     ENAME    VARCHAR(10), -- 员工姓名
#     JOB      VARCHAR(9),  -- 工作岗位
#     MGR      int,         -- 经理的员工号，外键
#     HIREDATE date,        -- 入职时间
#     SAL      double,      -- 底薪
#     COMM     double,      -- 提成
#     DEPTNO   int,         -- 部门编号
#     primary key (EMPNO)
# );


# CREATE TABLE dept
# (
#     DEPTNO int,         -- 部门编号
#     DNAME  varchar(13), -- 部门名称
#     LOC    VARCHAR(13), -- 部门地点
#     primary key (DEPTNO)
# );


-- 插入数据

# Insert into emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
# values (7369, 'SMITH', 'CLERK', 7902, '2003-12-17', 800, null, 20);
#
# Insert into emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
# values (7499, 'ALLEN', 'SALESMAN', 7698, '2007-9-3', 1600, 300, 30);
#
# Insert into emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
# values (7521, 'WARD', 'SALESMAN', 7698, '2005-3-8', 1250, 500, 30);
#
# Insert into emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
# values (7566, 'JONES', 'MANAGER', 7839, '2007-7-7', 2975, null, 20);
#
# Insert into emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
# values (7654, 'MARTIN', 'SALESMAN', 7698, '2005-5-6', 1250, 1400, 30);
#
# Insert into emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
# values (7698, 'BLAKE', 'MANAGER', 7839, '2005-5-6', 2850, null, 30);
#
# Insert into emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
# values (7782, 'CLARK', 'MANAGER', 7839, '2010-3-1', 2450, null, 10);
#
# Insert into emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
# values (7788, 'SCOTT', 'ANALYST', 7566, '2005-5-6', 3000, null, 20);
#
# Insert into emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
# values (7839, 'KING', 'PRESIDENT', null, '2001-5-6', 5000, null, 10);
#
# Insert into emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
# values (7844, 'TURNER', 'SALESMAN', 7698, '2008-8-8', 1500, 0, 30);
#
# Insert into emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
# values (7876, 'ADAMS', 'CLERK', 7788, '2005-5-6', 1100, null, 20);
#
# Insert into emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
# values (7900, 'JAMES', 'CLERK', 7698, '2005-5-6', 950, null, 30);
#
# Insert into emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
# values (7902, 'FORD', 'ANALYST', 7566, '2005-5-6', 3000, null, 20);
#
# Insert into emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
# values (7934, 'MILLER', 'CLERK', 7782, '2005-5-6', 1300, null, 10);
#
#
#
# Insert into dept (DEPTNO, DNAME, LOC)
# values (10, 'ACCOUNTING', 'NEW YORK');
#
# Insert into dept (DEPTNO, DNAME, LOC)
# values (20, 'RESEARCH', 'DALLAS');
#
# Insert into dept (DEPTNO, DNAME, LOC)
# values (30, 'SALES', 'CHICAGO');
#
# Insert into dept (DEPTNO, DNAME, LOC)
# values (40, 'OPERATIONS', 'BOSTON');


-- 1．列出至少有一个员工的所有部门。

SELECT DISTINCT d.DEPTNO, DNAME
FROM emp AS e
         JOIN dept d
              ON e.DEPTNO = d.DEPTNO;

-- 2．列出薪金比“SMITH”多或者相等的所有员工。

WITH SMITH_SALARY(SAL) AS (
    SELECT SAL
    FROM emp
    WHERE ENAME = 'SMITH'
    LIMIT 1
)
SELECT ENAME
FROM emp
WHERE SAL >= ALL (SELECT SAL FROM SMITH_SALARY);


-- 3．列出所有员工的姓名及其直接上级的姓名。

SELECT e.ENAME AS E_NAME, d.ENAME AS M_NAME
FROM emp AS e
         JOIN emp AS d
              ON e.MGR = d.EMPNO;

-- 4．列出受雇日期早于其直接上级的所有员工。

SELECT e.ENAME AS NAME
FROM emp AS e
         JOIN emp AS d
              ON e.MGR = d.EMPNO
WHERE e.HIREDATE < d.HIREDATE;

-- 5．列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门

SELECT *
FROM dept as d
         LEFT JOIN emp e on d.DEPTNO = e.DEPTNO;

-- 6．列出所有“CLERK”（办事员）的姓名及其部门名称。

SELECT e.ENAME AS E_NAME, d.DNAME AS D_NAME
FROM emp AS e
         JOIN dept AS d
              USING (DEPTNO)
WHERE e.JOB = 'CLERK';

-- 7．列出最低薪金大于1500的各种工作。

SELECT DISTINCT JOB
FROM emp
WHERE SAL > 1500;

-- 8．列出在部门“SALES”（销售部）工作的员工的姓名，假定不知道销售部的部门编号。

SELECT e.ENAME AS E_NAME
FROM emp AS e
         JOIN dept AS d
              USING (DEPTNO)
WHERE d.DNAME = 'SALES';

-- 9．列出薪金高于公司平均薪金的所有员工。

SELECT ENAME
FROM emp
WHERE SAL > ALL (
    SELECT AVG(SAL)
    FROM emp
);

-- 10．列出与“SCOTT”从事相同工作的所有员工。

SELECT e1.ENAME
FROM emp AS e1,
     emp AS e2
WHERE e1.JOB = e2.JOB
  AND e2.ENAME = 'SCOTT';

-- 11．列出薪金等于部门30中员工的薪金的所有员工的姓名和薪金。

SELECT *
FROM emp
WHERE SAL = ANY (
    SELECT SAL
    FROM emp
    WHERE DEPTNO = 30
);

-- 12．列出薪金高于在部门30工作的所有员工的薪金的员工姓名和薪金。

SELECT *
FROM emp
WHERE SAL > ALL (
    SELECT SAL
    FROM emp
    WHERE DEPTNO = 30
);

-- 13．列出在每个部门工作的部门名称,员工数量、平均工资。

SELECT d.DNAME AS D_NAME, IFNULL(COUNT(*), 0) AS NUMBER_OF_EMP, IFNULL(AVG(e.SAL), 0) AS AVG_SAL
FROM emp AS e
         RIGHT JOIN dept AS d
                    USING (DEPTNO)
GROUP BY (DEPTNO);

-- 14．列出所有员工的姓名、部门名称和工资(含奖金)。

SELECT e.ENAME, d.DNAME, e.SAL + IFNULL(e.COMM, 0) AS MONEY
FROM emp AS e
         JOIN dept AS d
              USING (DEPTNO);

-- 15．列出所有部门的详细信息和部门人数。

SELECT d.DEPTNO, d.DNAME, d.LOC, COUNT(*)
FROM emp AS e
         JOIN dept AS d
              USING (DEPTNO)
GROUP BY DEPTNO;

-- 16．列出各种工作的最低工资。

SELECT JOB, MIN(SAL)
FROM emp
GROUP BY JOB;

-- 17．列出各个MANAGER（经理）的最低薪金。

SELECT MIN(m.SAL)
FROM emp AS e, emp AS m
WHERE e.MGR = m.EMPNO;

-- 18．列出所有员工的年工资,按年薪从低到高排序。

SELECT SAL * 12 + IFNULL(COMM, 0) AS S
FROM emp
ORDER BY S;

