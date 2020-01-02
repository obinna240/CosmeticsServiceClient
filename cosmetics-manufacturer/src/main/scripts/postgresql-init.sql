CREATE ROLE cosmeticmanufacturerservice superuser;
GRANT ROOT TO cosmeticmanufacturerservice;
DROP DATABASE IF EXISTS cosmeticmanufacturer;
DROP USER IF EXISTS cosmeticmanufacturerservice;
CREATE DATABASE cosmeticmanufacturer ENCODING DEFAULT;
CREATE USER cosmeticmanufacturerservice WITH PASSWORD 'password';
GRANT ALL PRIVILEGES ON DATABASE cosmeticmanufacturer TO PUBLIC;
