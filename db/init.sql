CREATE TABLE users_table (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(15) NOT NULL,
    age INT NOT NULL,
    gender CHAR(1) NOT NULL CHECK (GENDER IN ('M', 'F')),
    email VARCHAR(50)
);


INSERT INTO users_table(name, age, gender, email)
VALUES ('Sanju', 19, 'M', 'sanjusabu@icloud.com');