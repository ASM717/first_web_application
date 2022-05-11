create schema if not exists users;

drop table if exists users.users;

create table if not exists users.users(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);