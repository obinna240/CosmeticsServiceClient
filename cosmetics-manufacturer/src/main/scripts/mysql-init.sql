DROP DATABASE IF EXISTS cosmeticmanufacturer;
DROP USER IF EXISTS `cosmeticmanufacturerservice`@`%`;
CREATE DATABASE IF NOT EXISTS cosmeticmanufacturer CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `cosmeticmanufacturerservice`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, INDEX, REFERENCES, EXECUTE, ALTER, SHOW VIEW, CREATE VIEW,
CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `cosmeticmanufacturer`.* TO `cosmeticmanufacturerservice`@`%`;
FLUSH PRIVILEGES;