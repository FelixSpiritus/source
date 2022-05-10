SET SERVEROUTPUT ON
DECLARE
v_max_depno NUMBER;
v_dept_name departments.department_name%TYPE:='Education'; 
v_dept_id NUMBER;
BEGIN
SELECT MAX(DEPARTMENT_ID) INTO v_max_depno
FROM DEPARTMENTS;
v_dept_id:=v_max_depno+10;
INSERT INTO DEPARTMENTS (department_name, department_id, location_id)
VALUES(v_dept_name, v_dept_id, null);
dbms_output.put_line('The maximum department_id is: ' || v_max_depno);
dbms_output.put_line('SQL%ROWCOUNT gives ' || SQL%ROWCOUNT );
END;
/
SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=280