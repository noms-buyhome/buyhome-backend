drop table if exists vote;
create table vote(
     id int primary key auto_increment,
     question_id int not null,
     user_id int not null,
     foreign key(user_id) references user(id) on delete cascade,
     foreign key(question_id) references question(id) on delete cascade
);
