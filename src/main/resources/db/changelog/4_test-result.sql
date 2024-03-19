--liquibase formatted sql

--changeset karina:4 endDelimiter:/

CREATE TABLE TEST_RESULT(
    ID BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    RESULT VARCHAR(32),
    RESULT_INFO VARCHAR(1024),
    TEST_ID BIGINT NOT NULL,
    foreign key (TEST_ID) references TEST(ID)
);