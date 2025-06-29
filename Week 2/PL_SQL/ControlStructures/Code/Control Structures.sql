SET SERVEROUTPUT ON;

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE loans';
  EXECUTE IMMEDIATE 'DROP TABLE customers';
EXCEPTION
  WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE customers (
  customer_id NUMBER PRIMARY KEY,
  name VARCHAR2(100),
  age NUMBER,
  balance NUMBER,
  loan_interest NUMBER(5,2),
  is_vip VARCHAR2(5)
);

CREATE TABLE loans (
  loan_id NUMBER PRIMARY KEY,
  customer_id NUMBER,
  due_date DATE
);

BEGIN
  INSERT INTO customers VALUES (1, 'Arun', 65, 8000, 5.5, 'FALSE');
  INSERT INTO customers VALUES (2, 'Meena', 58, 12000, 6.0, 'FALSE');
  INSERT INTO customers VALUES (3, 'Kumar', 70, 15000, 7.0, 'FALSE');
  INSERT INTO customers VALUES (4, 'Divya', 35, 4000, 4.5, 'FALSE');

  INSERT INTO loans VALUES (101, 1, SYSDATE + 10);
  INSERT INTO loans VALUES (102, 2, SYSDATE + 40);
  INSERT INTO loans VALUES (103, 3, SYSDATE + 5);
  INSERT INTO loans VALUES (104, 4, SYSDATE + 25);

  COMMIT;
END;
/

BEGIN
  FOR c IN (SELECT customer_id FROM customers WHERE age > 60) LOOP
    UPDATE customers
    SET loan_interest = loan_interest - 1
    WHERE customer_id = c.customer_id;
  END LOOP;

  FOR c IN (SELECT customer_id FROM customers WHERE balance > 10000) LOOP
    UPDATE customers
    SET is_vip = 'TRUE'
    WHERE customer_id = c.customer_id;
  END LOOP;

  FOR l IN (
    SELECT l.loan_id, c.name, l.due_date
    FROM loans l
    JOIN customers c ON l.customer_id = c.customer_id
    WHERE l.due_date <= SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || l.name || ', your loan (ID: ' || l.loan_id || ') is due on ' || TO_CHAR(l.due_date, 'DD-MON-YYYY'));
  END LOOP;

  COMMIT;
END;
/

SELECT * FROM customers;
