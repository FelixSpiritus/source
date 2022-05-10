CREATE PROCEDURE greet IS
  V_today DATE := SYSDATE;
  V_tommorow v_today%TYPE;
BEGIN
  V_tommorow := v_today +1;
  DBMS_OUTPUT.PUT_LINE('TODAY IS:'|| v_today);
  DBMS_OUTPUT.PUT_LINE('TOMMOROW IS:'|| v_tommorow);
END;