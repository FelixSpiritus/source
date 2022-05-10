/*CREATE TABLE top_salaries 
(salary  number(8,2))*/

SET SERVEROUTPUT ON
DECLARE
v_num number:=5;
sal employees.salary%TYPE;
CURSOR c_emp_cursor  IS SELECT DISTINCT SALARY FROM EMPLOYEES ORDER BY SALARY DESC;
BEGIN
OPEN c_emp_cursor;
LOOP
FETCH c_emp_cursor INTO sal;
EXIT WHEN c_emp_cursor%ROWCOUNT>v_num or NOT c_emp_cursor%FOUND ;
INSERT INTO top_salaries(salary) VALUES(sal);
END LOOP;
CLOSE c_emp_cursor;
COMMIT;
END;
/
--select * from top_salaries
--TRUNCATE TABLE top_salaries