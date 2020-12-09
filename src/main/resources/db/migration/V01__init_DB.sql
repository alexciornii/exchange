CREATE TABLE cash 
(
    id bigint NOT NULL AUTO_INCREMENT,
    amount FLOAT,
    currency_code varchar(255),
    operator_username varchar(255),
    created_date bigint,
    primary key (id)
);

CREATE TABLE angajati
(
    id bigint NOT NULL AUTO_INCREMENT,
    first_name varchar(255),
    last_name varchar(255),
    username varchar(255), primary key (id)
);

CREATE TABLE curs_valutar (
    id bigint NOT NULL AUTO_INCREMENT,
    course FLOAT,
    course_date bigint,
    rate integer,
    currency_code varchar(255),
    primary key (id)
);

CREATE TABLE dictionar_valute (
    id bigint NOT NULL AUTO_INCREMENT,
    code varchar(255),
    name varchar(255),
    number integer,
    primary key (id)
);

CREATE TABLE schimb_valutar (
    id bigint NOT NULL AUTO_INCREMENT,
    amount_received FLOAT,
    amount_released FLOAT,
    course FLOAT,
    exchange_date bigint,
    currency_code varchar(255),
    primary key (id)
);

ALTER TABLE angajati ADD CONSTRAINT angajati_username UNIQUE (username);
ALTER TABLE dictionar_valute ADD CONSTRAINT dictionar_valute_code UNIQUE (code);
ALTER TABLE cash ADD CONSTRAINT cash_currency_code_fk FOREIGN KEY (currency_code) REFERENCES dictionar_valute (code);
ALTER TABLE cash ADD CONSTRAINT cash_operator_username_fk FOREIGN KEY (operator_username) REFERENCES angajati (username);
ALTER TABLE curs_valutar ADD CONSTRAINT curs_valutar_currency_code_fk FOREIGN KEY (currency_code) REFERENCES dictionar_valute (code);
ALTER TABLE schimb_valutar ADD CONSTRAINT schimb_valutar_currency_code_fk FOREIGN KEY (currency_code) REFERENCES dictionar_valute (code);

INSERT INTO dictionar_valute (name, code, number) VALUES ('Moldovan Leu', 'MDL', 498);
INSERT INTO dictionar_valute (name, code, number) VALUES ('Euro', 'EUR', 978);
INSERT INTO dictionar_valute (name, code, number) VALUES ('US Dollar', 'USD', 840);

INSERT INTO angajati (username, first_name, last_name) VALUES ('operator1', 'Ion', 'Creanga');
INSERT INTO angajati (username, first_name, last_name) VALUES ('operator2', 'Mihai', 'Eminescu');
INSERT INTO angajati (username, first_name, last_name) VALUES ('operator3', 'John', 'Travolta');

INSERT INTO curs_valutar (currency_code, rate, course, course_date) VALUES ('EUR', 1, 19.70, UNIX_TIMESTAMP());
INSERT INTO curs_valutar (currency_code, rate, course, course_date) VALUES ('USD', 1, 17.40, UNIX_TIMESTAMP());

INSERT INTO schimb_valutar (currency_code, course, amount_received, amount_released, exchange_date) VALUES ('EUR', 19.70, 100, 1970, UNIX_TIMESTAMP());

INSERT INTO cash (currency_code, operator_username, amount, created_date) VALUES ('EUR', 'operator1', 1450, UNIX_TIMESTAMP());
