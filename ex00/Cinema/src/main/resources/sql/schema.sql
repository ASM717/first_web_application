create schema if not exists users;

drop table if exists users.users;

create table if not exists users.users(
    first_name VARCHAR(127) NOT NULL,
    last_name VARCHAR(127) NOT NULL,
    phone_number VARCHAR(320) NOT NULL UNIQUE,
    password VARCHAR(72) NOT NULL
);