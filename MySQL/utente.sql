-- run this as root

drop user if exists blue;
drop schema if exists blue;

create user blue identified by 'password'; 
create schema blue; 
grant all privileges on blue.* to blue;
grant alter routine on blue.* to blue;
