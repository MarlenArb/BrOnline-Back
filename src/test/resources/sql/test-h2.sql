BEGIN;
TRUNCATE TABLE clients;
 
INSERT INTO clients(name) VALUES
    ('Client Test 1'),
    ('Client Test 2'),
    ('Client Test 3');
 
COMMIT;
