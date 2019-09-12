--liquibase formatted sql

--changeset Goravsky:1

CREATE SCHEMA IF NOT EXISTS hcdb1 DEFAULT CHARACTER SET utf8 ;
USE hcdb1 ;

CREATE TABLE  codes (
                        id INT NOT NULL AUTO_INCREMENT,
                        code INT NOT NULL UNIQUE ,
                        PRIMARY KEY (id));

CREATE TABLE transactions (
                        code_id INT NOT NULL,
                        status VARCHAR(7) NOT NULL,
                        time TIMESTAMP(6) NOT NULL,
                        contact_number INT NOT NULL,
                        PRIMARY KEY (code_id),
                        INDEX fk_transactions_codes_idx (code_id ASC),
                        CONSTRAINT fk_transactions_codes
                            FOREIGN KEY (code_id)
                            REFERENCES hcdb1.codes (id)
                            ON DELETE NO ACTION
                            ON UPDATE NO ACTION);

--changeset Goravsky:2

INSERT INTO codes (code) VALUES (11);
INSERT INTO codes (code) VALUES (12);
INSERT INTO codes (code) VALUES (13);

INSERT INTO transactions (code_id, status, time, contact_number)  VALUES (1, "NEW", CURRENT_TIMESTAMP, 8800);
INSERT INTO transactions (code_id, status, time, contact_number)  VALUES (2, "FINAL", CURRENT_TIMESTAMP, 8890);
INSERT INTO transactions (code_id, status, time, contact_number)  VALUES (3, "NEW", CURRENT_TIMESTAMP, 8999);
