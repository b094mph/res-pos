CREATE SCHEMA IF NOT EXISTS restaurant;
USE restaurant;
START TRANSACTION;
CALL dropTables;
CALL createTables;
COMMIT;
