SELECT EMPLOYEE_ID, LAST_NAME, SALARY FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE LAST_NAME LIKE '%u%')
AND SALARY > (SELECT AVG(SALARY) FROM employees)
 