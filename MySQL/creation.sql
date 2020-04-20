use blue;

drop table if exists acquisti;
drop table if exists prodotti;
drop table if exists utenti;


create table prodotti(
prodotto_id integer primary key auto_increment,
nome_prodotto varchar(20),
tipo_di_vino varchar(10));

insert into prodotti(nome_prodotto,tipo_di_vino) value('Bonarda','rosso');
insert into prodotti(nome_prodotto,tipo_di_vino) value('Lambrusco','rosso');
insert into prodotti(nome_prodotto,tipo_di_vino) value('Negroamaro','rosso');
insert into prodotti(nome_prodotto,tipo_di_vino) value('Chardonnay','bianco');
insert into prodotti(nome_prodotto,tipo_di_vino) value('Lugana','bianco');
insert into prodotti(nome_prodotto,tipo_di_vino) value('Vermentino','bianco');
insert into prodotti(nome_prodotto,tipo_di_vino) value('Prosecco','spumante');
insert into prodotti(nome_prodotto,tipo_di_vino) value('Champagne','spumante');
insert into prodotti(nome_prodotto,tipo_di_vino) value('TrentoDoc','spumante');

create table utenti(
utente_id integer primary key auto_increment,
nome_utente varchar(20) unique,
password_utente varchar(20));

insert into utenti(nome_utente,password_utente) value('mariorossi','mrossipw');
insert into utenti(nome_utente,password_utente) value('marco','marcopw');
insert into utenti(nome_utente,password_utente) value('giordano','giordanopw');
insert into utenti(nome_utente,password_utente) value('alexander','alexanderpw');

create table acquisti(
acquisto_id integer primary key auto_increment,
utente_id integer,
foreign key (utente_id) references utenti(utente_id),
prodotto_id int,
foreign key (prodotto_id) references prodotti(prodotto_id),
data_e_ora timestamp);