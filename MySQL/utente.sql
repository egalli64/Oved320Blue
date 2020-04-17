create user blue identified by 'password'; 
create schema blue; 
grant all privileges on blue.* to me; -- tutti i privilegi standard sullo schema me all’utente me
grant alter routine on blue.* to me; -- privilegi per modificare le procedure