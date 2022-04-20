create table person
(
    id   bigint not null primary key,
    email varchar(50),
    surname varchar(50),
    name varchar(50),
    last_name varchar(50),
    phone varchar(50)
);
create sequence SEQ_PERSON increment 5 start 50;

