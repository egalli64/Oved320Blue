use blue;

drop table if exists acquisti;
drop table if exists prodotti;
drop table if exists tipi;
drop table if exists utenti;


create table tipi(
tipo_id integer primary key auto_increment,
nome varchar(10));

insert into tipi(nome) value('rosso');
insert into tipi(nome) value('bianco');
insert into tipi(nome) value('spumante');


create table prodotti(
prodotto_id integer primary key auto_increment,
nome varchar(20),
prezzo decimal(4,2) , 
anno int, 
tipo_id int,
foreign key (tipo_id) references tipi(tipo_id),
stock int);

insert into prodotti(nome, prezzo, anno, tipo_id, stock) value('Bonarda',15.00 , 2020, 1, 10);
insert into prodotti(nome, prezzo, anno, tipo_id, stock) value('Lambrusco',15.00, 2019, 1, 10);
insert into prodotti(nome, prezzo, anno, tipo_id, stock ) value('Negroamaro',18.00 ,2019, 1, 10);
insert into prodotti(nome, prezzo, anno, tipo_id, stock) value('Chardonnay',18.00, 2019, 2, 10);
insert into prodotti(nome, prezzo, anno, tipo_id, stock) value('Lugana', 19.00, 2018, 2, 10);
insert into prodotti(nome, prezzo, anno, tipo_id, stock) value('Vermentino',20.00, 2018, 2, 10);
insert into prodotti(nome,prezzo, anno, tipo_id, stock) value('Prosecco', 22.00, 2018, 3, 10);
insert into prodotti(nome, prezzo, anno, tipo_id, stock) value('Champagne',28.00, 2019, 3, 10);
insert into prodotti(nome, prezzo, anno, tipo_id, stock) value('TrentoDoc', 28.00, 2018, 3, 10);

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