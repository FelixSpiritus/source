SET SERVEROUTPUT ON
DECLARE
    TYPE dept_table_type IS TABLE OF departments.department_name%TYPE INDEX BY PLS_INTEGER;
    f_loop_count NUMBER:=10;
    v_deptno NUMBER:=0;
    my_dept_table dept_table_type;
BEGIN
    LOOP
    v_deptno:=v_deptno+1;
    SELECT department_name INTO my_dept_table(v_deptno) FROM departments
    WHERE department_id=f_loop_count;
    f_loop_count:=f_loop_count+10;
    EXIT WHEN v_deptno=10;
    END LOOP;
    FOR i IN my_dept_table.FIRST..my_dept_table.LAST
    LOOP
    dbms_output.put_line(my_dept_table(i));
    END LOOP;
END;
/