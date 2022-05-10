/*CREATE TABLE EMP
  AS (SELECT * FROM EMPLOYEES)
ALTER TABLE EMP
  ADD (stars varchar2(50));*/
DECLARE
v_empno emp.employee_id%TYPE:=176;
v_asterisk emp.stars%TYPE:=NULL;
v_sal emp.salary%TYPE;
BEGIN
SELECT SALARY INTO v_sal FROM EMP
WHERE employee_id = v_empno;
v_asterisk:=TRIM(LPAD(' ', ROUND(v_sal/1000)+1,'*'));
UPDATE EMP
SET STARS = v_asterisk
WHERE employee_id = v_empno;
COMMIT;
END;
/
SELECT employee_id, salary FROM EMP WHERE EMPLOYEE_ID=176