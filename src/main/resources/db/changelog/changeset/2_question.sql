--liquibase formatted sql

--changeset nikita:1 endDelimiter:/

CREATE TABLE QUESTION(
    ID BIGINT NOT NULL PRIMARY KEY,
    QUESTION VARCHAR(255) NOT NULL,
    CORRECT_ANSWER INT,
    TEST_ID BIGINT NOT NULL,
    foreign key (TEST_ID) references TEST(ID)
)