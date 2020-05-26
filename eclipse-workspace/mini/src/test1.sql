create table movieTest(
id varchar2(21)primary key,
name varchar2(21) primary key,
title varchar2(21),
theater varchar2(21),
day varchar2(21),
howmany number(2),
cost number(10),
seatNumber varchar2(21)
)

create table member(
mid varchar2(21),
mname varchar2(21),
constraint fk_rsv_mid foreign key (mid)references movieTest(id)
constraint fk_rsv_mid foreign key (mid)references movieTest(id)
)