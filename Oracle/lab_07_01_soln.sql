SET SERVEROUTPUT ON
DECLARE
    v_deptno NUMBER:=10;
    
    CURSOR c_emp_cursor IS SELECT employee_id, last_name FROM employees WHERE department_id =v_deptno;  
BEGIN
    --OPEN c_emp_cursor;
    FOR emp_record IN c_emp_cursor
    LOOP
    dbms_output.put_line(emp_record.department_id||emp_record.employee_id);
    END LOOP;
    --CLOSE c_emp_cursor;
END;
/