drop table answer;
create table answer (
	id int primary key auto_increment,
    user_id int not null,
    question_id int not null,
    title varchar(50),
    content varchar(256),
	created_time datetime default now(),
    foreign key(user_id) references user(id) on delete cascade,
	foreign key(question_id) references question(id) on delete cascade
);

insert into answer (user_id, question_id, title, content)
values (1,1,"answer 2", "질문 2번 입니다.");