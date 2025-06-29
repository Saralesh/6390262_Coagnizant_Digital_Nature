CREATE TABLE savings_accounts (
    account_id NUMBER PRIMARY KEY,
    customer_name VARCHAR2(100),
    balance NUMBER
);

CREATE TABLE employees (
    emp_id NUMBER PRIMARY KEY,
    emp_name VARCHAR2(100),
    department VARCHAR2(50),
    salary NUMBER
);

CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    customer_name VARCHAR2(100),
    balance NUMBER
);

INSERT INTO savings_accounts VALUES (101, 'Arun', 10000);
INSERT INTO savings_accounts VALUES (102, 'Meena', 5000);

INSERT INTO employees VALUES (1, 'Kumar', 'IT', 50000);
INSERT INTO employees VALUES (2, 'Divya', 'IT', 60000);
INSERT INTO employees VALUES (3, 'Ravi', 'HR', 45000);

INSERT INTO accounts VALUES (201, 'Kumar', 10000);
INSERT INTO accounts VALUES (202, 'Kumar', 3000);

COMMIT;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE savings_accounts
    SET balance = balance + (balance * 0.01);
    COMMIT;
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/

SELECT * FROM savings_accounts;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    dept IN VARCHAR2,
    bonus_percent IN NUMBER
) AS
BEGIN
    UPDATE employees
    SET salary = salary + (salary * bonus_percent / 100)
    WHERE department = dept;
    COMMIT;
END;
/

BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/

SELECT * FROM employees;

CREATE OR REPLACE PROCEDURE TransferFunds(
    from_acc_id IN NUMBER,
    to_acc_id IN NUMBER,
    amount IN NUMBER
) AS
    from_balance NUMBER;
BEGIN
    SELECT balance INTO from_balance FROM accounts WHERE account_id = from_acc_id;

    IF from_balance < amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance.');
    END IF;

    UPDATE accounts SET balance = balance - amount WHERE account_id = from_acc_id;
    UPDATE accounts SET balance = balance + amount WHERE account_id = to_acc_id;

    COMMIT;
END;
/

BEGIN
    TransferFunds(201, 202, 2000);
END;
/

SELECT * FROM accounts;
