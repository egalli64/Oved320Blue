use blue;

drop table if exists prodotti;
drop table if exists utenti;
drop table if exists acquisti;

create table prodotti(
prodotto_id integer primary key auto_increment,
nome_prodotto varchar(20),
tipo_di_vino varchar(10));

insert into prodotti(nome_prodotto,tipo_di_vino) value('barolo','rosso');
insert into prodotti(nome_prodotto,tipo_di_vino) value('pecorino','bianco');
insert into prodotti(nome_prodotto,tipo_di_vino) value('ferrari','spumante');

create table utenti(
utente_id integer primary key auto_increment,
nome_utente varchar(10),
password_utente varchar(10));

insert into utenti(nome_utente,password_utente) value('mariorossi','mrossipw');

create table acquisti(
acquisto_id integer primary key auto_increment,
utente_id integer,
foreign key (utente_id) references utenti(utente_id),
prodotto_id int,
foreign key (prodotto_id) references prodotti(prodotto_id),
data_e_ora timestamp);