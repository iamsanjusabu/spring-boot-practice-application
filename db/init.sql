CREATE EXTENSION IF NOT EXISTS CITEXT;

CREATE TABLE user_table (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username VARCHAR(20) NOT NULL ,
    password TEXT NOT NULL,
    age INT,
    gender CHAR(1) NOT NULL CHECK (gender IN ('M', 'F', 'O')),
    email CITEXT NOT NULL,
    CONSTRAINT unique_username UNIQUE (username),
    CONSTRAINT unique_email UNIQUE (email)
);