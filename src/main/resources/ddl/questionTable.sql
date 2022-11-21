drop table question;
create table question (
	id int primary key auto_increment,
    user_id int not null,
    title varchar(50),
    content varchar(256),
	created_time datetime default now(),
    foreign key(user_id) references user(id)
);

insert into question (user_id, title, content)
values (1,"question 1", "질문 1번 입니다.");