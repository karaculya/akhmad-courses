--liquibase formatted sql

--changeset karina:2 endDelimiter:/

CREATE TABLE QUESTION(
    ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    QUESTION VARCHAR(255) NOT NULL,
    CORRECT_ANSWER INT,
    TEST_ID BIGINT NOT NULL,
    foreign key (TEST_ID) references TEST(ID)
)