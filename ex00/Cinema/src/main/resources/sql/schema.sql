create schema if not exists schema;

drop table if exists schema.users;

create table if not exists schema.users(
   id SERIAL PRIMARY KEY,
   first_name VARCHAR(50) NOT NULL,
   last_name VARCHAR(50) NOT NULL,
   email VARCHAR(50) NOT NULL,
   phone_number VARCHAR(50) NOT NULL UNIQUE,
   password VARCHAR(72)
);