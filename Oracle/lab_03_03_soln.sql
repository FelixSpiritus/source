--VARIABLE b_basic_percent NUMBER
--VARIABLE b_pf_percent NUMBER
SET SERVEROUTPUT ON
DECLARE
b_basic_percent NUMBER:=45;
b_pf_percent NUMBER:=12;
v_fname VARCHAR2(15);
v_emp_sal NUMBER(10);
towards NUMBER(10,2);
BEGIN
  /*:b_basic_percent:=45;
  :b_pf_percent:=12;*/
  SELECT first_name, salary
  INTO v_fname, v_emp_sal
  FROM employees
  WHERE employee_id=110;
  towards:=(v_emp_sal*b_basic_percent*b_pf_percent)/10000;
  DBMS_OUTPUT.PUT_LINE('Hello '||v_fname);
  DBMS_OUTPUT.PUT_LINE('YOUR SALARY IS: '||v_emp_sal);
  DBMS_OUTPUT.PUT_LINE('YOUR CINTRIBUTION TOWARDS PF: '||towards);
END;
/
/*PRINT b_basic_percent
PRINT b_pf_percent*/






