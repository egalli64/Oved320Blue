
drop user blue;
drop schema blue;


create user blue identified by 'password'; 
create schema blue; 
grant all privileges on blue.* to blue;
grant alter routine on blue.* to blue;
