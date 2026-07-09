SET SERVEROUTPUT ON;

DECLARE
    v_age NUMBER;
BEGIN
    FOR rec IN (
        SELECT c.CustomerID,
               c.DOB,
               l.LoanID,
               l.InterestRate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
    )
    LOOP
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);

        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;

            DBMS_OUTPUT.PUT_LINE(
                'Discount Applied to Customer ID: '
                || rec.CustomerID
                || ' | New Interest Rate: '
                || (rec.InterestRate - 1)
            );
        ELSE
            DBMS_OUTPUT.PUT_LINE(
                'No Discount for Customer ID: '
                || rec.CustomerID
            );
        END IF;
    END LOOP;

    COMMIT;
END;
