CREATE TABLE IF NOT EXISTS users (
     id              SERIAL PRIMARY KEY,
     first_name      VARCHAR(254) NOT NULL ,
     last_name       VARCHAR(254) NOT NULL ,
     email           VARCHAR(254) NOT NULL ,
     phone_number    VARCHAR(254) UNIQUE NOT NULL ,
     password        VARCHAR(100) NOT NULL
);