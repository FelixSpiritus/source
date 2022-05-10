SET SERVEROUTPUT ON
DECLARE
    CURSOR c_emp_cursor (deptno NUMBER) IS SELECT last_name, job_id, hire_date, salary
    FROM employees WHERE department_id in (select department_id from employees where employee_id < 120)
    and department_id=deptno;
    CURSOR c_dept_cursor IS SELECT department_id, department_name
    FROM departments WHERE department_id < 100 order by department_id;
    c_dept_id departments.department_id%TYPE;
    c_dept_name departments.department_name%TYPE;
    c_emp_last_name employees.last_name%TYPE;
    c_emp_job_id employees.job_id%TYPE;
    c_emp_hire_date employees.hire_date%TYPE;
    c_emp_salary employees.salary%TYPE;
BEGIN
    OPEN c_dept_cursor;
    LOOP
       FETCH c_dept_cursor INTO c_dept_id,c_dept_name;
       EXIT WHEN c_dept_cursor%NOTFOUND; 
       dbms_output.put_line('Department Number: '||c_dept_id||' Department Name: '||c_dept_name);
       IF NOT c_emp_cursor%ISOPEN THEN
            OPEN c_emp_cursor(c_dept_id);
       END IF;
       LOOP
       FETCH c_emp_cursor INTO c_emp_last_name,c_emp_job_id,c_emp_hire_date,c_emp_salary;
       EXIT WHEN c_emp_cursor%NOTFOUND; 
       dbms_output.put_line(c_emp_last_name||' '||c_emp_job_id||' '||c_emp_hire_date||' '||c_emp_salary);
       END LOOP;
       dbms_output.put_line('--------------------------------------------------------');
       CLOSE c_emp_cursor;
    END LOOP;
    CLOSE c_dept_cursor;
END;
/