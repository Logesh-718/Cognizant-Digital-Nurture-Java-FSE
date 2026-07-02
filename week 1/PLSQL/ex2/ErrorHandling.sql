SET SERVEROUTPUT ON;

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    Balance NUMBER
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    EmployeeName VARCHAR2(50),
    Salary NUMBER
);

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    City VARCHAR2(30)
);

INSERT INTO Accounts VALUES (101,'John',10000);
INSERT INTO Accounts VALUES (102,'David',5000);

INSERT INTO Employees VALUES (1,'Alice',40000);
INSERT INTO Employees VALUES (2,'Bob',50000);

INSERT INTO Customers VALUES (1,'John','Chennai');

COMMIT;

CREATE OR REPLACE PROCEDURE SafeTransferFunds(
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

    IF v_Balance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001,'Insufficient Funds');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_Amount
    WHERE AccountID = p_FromAccount;

    UPDATE Accounts
    SET Balance = Balance + p_Amount
    WHERE AccountID = p_ToAccount;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer Failed : ' || SQLERRM);
END;
/

CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_EmpID NUMBER,
    p_Percentage NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_Percentage / 100)
    WHERE EmployeeID = p_EmpID;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE NO_DATA_FOUND;
    END IF;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee ID not found.');

    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/

CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_ID NUMBER,
    p_Name VARCHAR2,
    p_City VARCHAR2
)
IS
BEGIN
    INSERT INTO Customers
    VALUES(p_ID,p_Name,p_City);

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Customer added successfully.');

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Customer ID already exists.');

    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/

BEGIN
    SafeTransferFunds(101,102,2000);
END;
/

SELECT * FROM Accounts;

BEGIN
    UpdateSalary(1,10);
END;
/

SELECT * FROM Employees;

BEGIN
    AddNewCustomer(2,'David','Bangalore');
END;
/

BEGIN
    AddNewCustomer(1,'John','Chennai');
END;
/

SELECT * FROM Customers;