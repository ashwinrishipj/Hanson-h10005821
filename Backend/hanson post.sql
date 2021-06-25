use hanson_application;
select * from hanson_users;

create table hanson_userDetails(
	hanson_userDetails_id int not null primary key,
    hanson_userDetails_name varchar(50) not null,
    hanson_userDetails_email varchar(60) not null,
    hanson_id int not null,
    foreign key (hanson_id) references hanson_users(hanson_id)
);

create table hanson_postdetails(
	hanson_post_id int not null primary key auto_increment,
    hanson_post_content LONGTEXT not null,
    hanson_post_likes int not null default(0),
    hanson_post_createdDate datetime not null,
    hanson_id int not null,
    hanson_userDetails_id int not null,
    foreign key (hanson_id) references hanson_users(hanson_id),
    foreign key (hanson_userDetails_id) references hanson_userDetails(hanson_userDetails_id)
);

insert into hanson_userDetails values
(1,"William Oxford","williamoxford@hanson.com",1),
(2,"George Winston","georgewinston@gmail.com",2);

insert into hanson_postDetails
values (2, "American sculptor Daniel Chester French created 92 public sculptures from 1871 until his death in 1931. In 1876, he accepted a contract to produce a set of statues for the United States Post Office Department. He created statues for the Post Office throughout the 1880s. In 1883, French was commissioned to create John Harvard. For the rest of his career, French produced commissions for state, federal, and private groups as well as private individuals.",
2,'2012-02-01',1,1);




