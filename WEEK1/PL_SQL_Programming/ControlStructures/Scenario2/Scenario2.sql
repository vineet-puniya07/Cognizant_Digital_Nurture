SET SERVEROUTPUT ON;

BEGIN
    FOR rec IN (SELECT CustomerID, Name, Balance FROM Customers)
    LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE(
                'Customer ' || rec.Name || ' promoted to VIP.'
            );
        ELSE
            UPDATE Customers
            SET IsVIP = 'FALSE'
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE(
                'Customer ' || rec.Name || ' is NOT VIP.'
            );
        END IF;
    END LOOP;

    COMMIT;
END;
