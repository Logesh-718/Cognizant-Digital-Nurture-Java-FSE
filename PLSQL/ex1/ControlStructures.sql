SET SERVEROUTPUT ON;

DROP TABLE Loan;
DROP TABLE Customer;

CREATE TABLE Customer (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(50),
    Age NUMBER,
    Balance NUMBER,
    IsVIP VARCHAR2(5)
);

CREATE TABLE Loan (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    InterestRate NUMBER(5,2),
    DueDate DATE,
    CONSTRAINT fk_customer
    FOREIGN KEY (CustomerID)
    REFERENCES Customer(CustomerID)
);

INSERT INTO Customer VALUES (101, 'John', 65, 15000, 'FALSE');
INSERT INTO Customer VALUES (102, 'David', 45, 5000, 'FALSE');
INSERT INTO Customer VALUES (103, 'Alice', 70, 22000, 'FALSE');

COMMIT;

INSERT INTO Loan VALUES (1, 101, 10, DATE '2026-07-15');
INSERT INTO Loan VALUES (2, 102, 11, DATE '2026-08-28');
INSERT INTO Loan VALUES (3, 103, 9, DATE '2026-07-10');

COMMIT;

BEGIN
    FOR rec IN (
        SELECT CustomerID
        FROM Customer
        WHERE Age > 60
    )
    LOOP
        UPDATE Loan
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = rec.CustomerID;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Scenario 1 Completed');
END;
/

SELECT * FROM Loan;

BEGIN
    FOR rec IN (
        SELECT CustomerID, Balance
        FROM Customer
    )
    LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customer
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Scenario 2 Completed');
END;
/

SELECT * FROM Customer;

BEGIN
    FOR rec IN (
        SELECT c.Name,
               l.DueDate
        FROM Customer c
        JOIN Loan l
        ON c.CustomerID = l.CustomerID
        WHERE l.DueDate <= SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: ' ||
            rec.Name ||
            ' Loan Due on ' ||
            TO_CHAR(rec.DueDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
/