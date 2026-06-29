SET SERVEROUTPUT ON;

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    AccountType VARCHAR2(20),
    Balance NUMBER
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    EmployeeName VARCHAR2(50),
    Department VARCHAR2(30),
    Salary NUMBER
);

INSERT INTO Accounts VALUES (101,'John','Savings',10000);
INSERT INTO Accounts VALUES (102,'David','Savings',5000);
INSERT INTO Accounts VALUES (103,'Alice','Current',8000);

INSERT INTO Employees VALUES (1,'James','IT',40000);
INSERT INTO Employees VALUES (2,'Maria','HR',35000);
INSERT INTO Employees VALUES (3,'Robert','IT',45000);

COMMIT;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully.');
END;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_Department VARCHAR2,
    p_Bonus NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_Bonus / 100)
    WHERE Department = p_Department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Employee bonus updated successfully.');
END;
/

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_FromAccount NUMBER,
    p_ToAccount NUMBER,
    p_Amount NUMBER
)
IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_FromAccount;

    IF v_Balance >= p_Amount THEN

        UPDATE Accounts
        SET Balance = Balance - p_Amount
        WHERE AccountID = p_FromAccount;

        UPDATE Accounts
        SET Balance = Balance + p_Amount
        WHERE AccountID = p_ToAccount;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');

    END IF;
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/

SELECT * FROM Accounts;

BEGIN
    UpdateEmployeeBonus('IT',10);
END;
/

SELECT * FROM Employees;

BEGIN
    TransferFunds(101,102,2000);
END;
/

SELECT * FROM Accounts;