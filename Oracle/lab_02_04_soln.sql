SET SERVEROUTPUT ON
DECLARE
v_amount varchar(20);
v_today date:=SYSDATE;
v_tommorow v_today%TYPE;
BEGIN
v_tommorow:=v_today+1;
v_amount:='Hello World';
DBMS_OUTPUT.PUT_LINE(v_amount);
DBMS_OUTPUT.PUT_LINE('TODAY IS: '||v_today);
DBMS_OUTPUT.PUT_LINE('TOMORROW IS: '||v_tommorow);
END;






