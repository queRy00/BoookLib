***
## Database Script
***

CREATE TABLE author (

id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,

age VARCHAR(255),

country VARCHAR(255),

gender INT,

name VARCHAR(255)

);

CREATE TABLE book (

id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,

author_id BIGINT,

category VARCHAR(255),

isbn BIGINT,

name VARCHAR(255),

CONSTRAINT tb_fk FOREIGN KEY (author_id) REFERENCES author(id)

);

***