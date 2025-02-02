

create table users(
    id bigserial primary key,
    username text unique not null,
    email text not null,
    password text not null,
    role text not null default 'USER'
);

create table employe
(
    id             bigserial primary key,
    specialization text not null,
    email          text not null,
    location       text not null,
    about_me       text not null,
    age            timestamp without time zone,
    competencies   jsonb
);

create table place_work
(
    id           bigserial primary key,
    company_name text not null,
    date_begin   timestamp without time zone,
    date_end     timestamp without time zone,
    position     text not null,
    employee_id  bigint references employe not null
);