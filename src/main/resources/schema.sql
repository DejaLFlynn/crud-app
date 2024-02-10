CREATE TABLE person (
    person_id integer IDENTITY,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    email_address varchar(50) NOT NULL,
    street_address varchar(50) NOT NULL,
    city varchar(50) NOT NULL,
    state varchar(2) NOT NULL,
    zip_code varchar(5) NOT NULL,
    company_id integer REFERENCES company (compnany_id)
);

CREATE TABLE company(
    company_id SERIAL PRIMARY KEY,
    company_name varchar(50) NOT NULL,  
    website varchar(50) NOT NULL,
    phone varchar(50) NOT NULL,
    mailing_address varchar(50) NOT NULL

);

