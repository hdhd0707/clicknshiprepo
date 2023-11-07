-- Create service account and reader users

DROP USER IF EXISTS 'clicknship-service-account';
CREATE USER 'clicknship-service-account' IDENTIFIED WITH mysql_native_password BY 'clicknship';
GRANT SELECT, INSERT, UPDATE, DELETE ON *.* TO 'clicknship-service-account';

DROP USER IF EXISTS 'clicknship-reader';
CREATE USER 'clicknship-reader' IDENTIFIED WITH mysql_native_password BY 'reader';
GRANT SELECT ON *.* TO 'clicknship-reader';
