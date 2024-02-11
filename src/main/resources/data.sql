DROP DATABASE IF EXISTS aquent_data;
CREATE DATABASE aquent_data;

\c aquent_data

INSERT INTO person (
    first_name,
    last_name,
    email_address,
    street_address,
    city,
    state,
    zip_code,
    company_id
) VALUES (
    'John',
    'Smith',
    'fake1@aquent.com',
    '123 Any St.',
    'Asheville',
    'NC',
    '28801',
    '1'

), (
    'Jane',
    'Smith',
    'fake2@aquent.com',
    '123 Any St.',
    'Asheville',
    'NC',
    '28801',
    '2'
);

INSERT INTO company(
    company_name,  
    website,
    phone,
    mailing_address
) 
VALUES (
    'Spotify',
    'spotify.com',
    '1235556789',
    '123 Fake Project Ln.'
    
), (
    'Meta',
    'Meta.com',
    '3215559876',
    '456 Fake Project Ln.' 
);

