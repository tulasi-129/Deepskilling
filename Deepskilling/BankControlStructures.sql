SET SERVEROUTPUT ON;

BEGIN

    -------------------------------------------------------
    -- Scenario 1: Apply 1% discount to customers above 60
    -------------------------------------------------------
    FOR c IN (SELECT CustomerID, Age FROM Customers) LOOP
        IF c.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = c.CustomerID;

            DBMS_OUTPUT.PUT_LINE('Interest rate updated for Customer ID: ' || c.CustomerID);
        END IF;
    END LOOP;

    -------------------------------------------------------
    -- Scenario 2: Promote customers to VIP
    -------------------------------------------------------
    FOR c IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF c.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = c.CustomerID;

            DBMS_OUTPUT.PUT_LINE('Customer ID ' || c.CustomerID || ' promoted to VIP.');
        END IF;
    END LOOP;

    -------------------------------------------------------
    -- Scenario 3: Loan reminders due within 30 days
    -------------------------------------------------------
    FOR l IN (
        SELECT LoanID, CustomerID, DueDate
        FROM Loans
        WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Customer ID ' || l.CustomerID ||
            ' | Loan ID: ' || l.LoanID ||
            ' | Due Date: ' || TO_CHAR(l.DueDate, 'DD-MON-YYYY')
        );
    END LOOP;

    COMMIT;

END;
/