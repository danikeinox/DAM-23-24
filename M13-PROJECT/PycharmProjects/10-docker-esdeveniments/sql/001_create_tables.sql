create table if not exists tbl_tipus_mondongo
(
    id serial
        constraint tbl_tipus_esdeveniment_pk
            primary key,
    nom varchar(100)
);

create table if not exists tbl_mondongo
(
    id serial
        primary key,
    nom varchar(255) not null,
    data date not null,
    meme boolean not null
);