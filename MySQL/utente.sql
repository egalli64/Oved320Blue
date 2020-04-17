create user blue identified by 'password'; -- password delimitata da apici e case sensitive
create schema blue; -- ambito in cui sono definiti oggetti correlati (in MySQL è sinonimo di database)
grant all privileges on blue.* to blue; -- tutti i privilegi standard sullo schema me all’utente me
grant alter routine on blue.* to blue; -- privilegi per modificare le procedure