use blue;

drop table if exists prodotti;
drop table if exists utenti;
drop table if exists acquisti;

create table prodotti(
prodotto_id integer primary key,
nome_prodotto varchar(20));

create table utenti(
utente_id integer primary key,
nome_utente varchar(10),
password_utente varchar(10));

create table acquisti(
acquisto_id integer primary key,
utente_id integer,
foreign key (utente_id) references utenti(utente_id),
prodotto_id int,
foreign key (prodotto_id) references prodotti(prodotto_id),
data_e_ora timestamp);