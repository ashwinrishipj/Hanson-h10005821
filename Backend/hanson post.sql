use hanson_application;
select * from hanson_users;

desc hanson_users;

create table hanson_userDetails(
	hanson_userDetails_id int not null primary key,
    hanson_userDetails_name varchar(50) not null,
    hanson_userDetails_email varchar(60) not null,
    hanson_id int not null,
    foreign key (hanson_id) references hanson_users(hanson_id)
);
desc hanson_userDetails;

select * from hanson_userDetails;

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
values (6, "Hanson is one of the best schools ever.",
2,'2012-09-01',1,1);

select * from hanson_postDetails as h1 join hanson_userDetails as h2 where h1.hanson_id = h2.hanson_id and h1.hanson_id = 1;

create table hanson_tutors(
	tutor_id int not null primary key auto_increment,
    tutor_name varchar(40) not null,
    tutor_mail varchar(50) not null,
    tutor_join_date date not null,
    tutor_status boolean not null
);

drop table hanson_tutors;

insert into hanson_tutors values(2,"jacob","jacob@hanson.com","2018-08-02",true);

select * from hanson_tutors;

create table notifications(
	notification_id int primary key,
    notification_content varchar(50) not null,
    notification_date date not null,
    notification_type varchar(30) not null,
    notification_subject varchar(50) not null,
    tutor_id int not null,
    hanson_userDetails_id int not null,
    foreign key (hanson_userDetails_id) references hanson_userDetails(hanson_userDetails_id)
);

drop table notifications;

alter table notifications add constraint fk_tutor_id foreign key (tutor_id) references hanson_tutors(tutor_id);

desc notifications;

insert into notifications values
(1,"post-graduation work permit","2021-08-28","webinar","JAVA",2,1),
(2,"project proposal","2021-08-20","submission","JAVA",2,1),
(3,"project schema ","2021-08-26","submission","JAVA",2,1),
(4,"project code review","2021-10-02","submission","JAVA",2,1),
(5,"project final draft","2021-11-20","submission","JAVA",2,1);

select * from notifications;

create table hanson_courses(
	course_id int not null primary key,
    course_name varchar(70) not null,
    course_credits int not null,
    tutor_id int not null,
    foreign key (tutor_id) references hanson_tutors(tutor_id),
    hanson_userDetails_id int not null,
    foreign key (hanson_userDetails_id) references hanson_userDetails(hanson_userDetails_id)
);

desc hanson_courses;

select * from hanson_courses;

select * from hanson_tutors,hanson_courses as h1 join hanson_userDetails h2 where h1.hanson_userDetails_id = h2.hanson_userDetails_id and h1.hanson_userDetails_id = 1;

insert into hanson_courses values
(1213,"php",12,1,1),
(1214,"dbms",12,2,1);

SELECT hanson_id,hanson_user_role_id FROM hanson_users where hanson_password="Alpha@123";

select * from hanson_users;

select * from hanson_postDetails as h1 join hanson_userDetails as h2 where h1.hanson_id = h2.hanson_id and h1.hanson_id = 1;
select * from hanson_tutors,notifications as h1 join hanson_userDetails as h2 where h1.hanson_userDetails_id = h2.hanson_userDetails_id and h1.hanson_userDetails_id = 1;