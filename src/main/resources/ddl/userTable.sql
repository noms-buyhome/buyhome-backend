drop table user;
create table user (
	id int primary key auto_increment,
    username varchar(50) not null,
    nickname varchar(50),
    password varchar(50),
    email varchar(50),
    authority varchar(16) default "user",
	created_time datetime default now()
);
insert into user (username, nickname, password, email)
values ("ssafy","김싸피","ssafy","ssafy@ssafy.com");