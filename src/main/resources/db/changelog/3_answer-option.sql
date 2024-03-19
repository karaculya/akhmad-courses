--liquibase formatted sql

--changeset karina:3 endDelimiter:/

CREATE TABLE ANSWER_OPTION(
    ID BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ANSWER VARCHAR(255),
    ANSWER_VALUE INT,
    QUESTION_ID BIGINT NOT NULL,
    foreign key (QUESTION_ID) references QUESTION(ID)
);