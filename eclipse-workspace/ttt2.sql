create table movies(
id varchar2(21),
name varchar2(21),
title varchar2(21),
theater varchar2(21),
day varchar2(22),
howmany varchar2(21),
cost  number(10),
seatNumber varchar2(21)
)

drop table movies

create table member(
mid varchar2(21),
mname varchar2(21)
)
ALTER TABLE movies ADD mid varchar2(21);
ALTER TABLE movies DROP COLUMN id;
constraint pk_movies_mid primary key(mid)
select from 