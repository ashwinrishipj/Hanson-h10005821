create database hanson_application;

use hanson_application;

create table hanson_role(
    hanson_user_role_id int not null auto_increment primary key,
    hanson_user_role_name varchar(10) not null
);

create table hanson_users(
	hanson_id int not null primary key auto_increment,
    hanson_username varchar(40) not null unique,
    hanson_password varchar(50) not null,
    hanson_user_role_id int not null,
    foreign key (hanson_user_role_id) references hanson_role(hanson_user_role_id)
);

insert into hanson_role values
(1,"student"),
(2,"staff"),
(3,"developer"),
(4,"admin"),
(5,"ceo");

insert into hanson_users values
(1,"h10005821","alpha123",1),
(2,"hs1000582","beta@123",2);

select * from hanson_users as h1 , hanson_role as h2
where h1.hanson_user_role_id = h2.hanson_user_role_id;