SET SERVEROUTPUT ON
DECLARE
BEGIN
UPDATE DEPARTMENTS
SET location_id = 3000
WHERE department_id = 280;
DELETE FROM DEPARTMENTS
WHERE DEPARTMENT_ID = 280;
COMMIT;
END;
/
--SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=280