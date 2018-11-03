show databases ;
create database if not exists store_40 charset = utf8;
use store_40;

drop table if exists account;
create table account (
  id int primary key auto_increment,
  name varchar(20),
  money double
);

insert into account (name, money)
values ('xiaoma', 2200),
       ('xiaowang', 3000);

