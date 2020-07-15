drop table customer
drop table movie
drop table rsv

create table customer (
id varchar2(21),
pwd varchar2(21),
name varchar2(21),
birthDate varchar2(21),
age number(3),
tel varchar2(21),
constraint pk_customer_id primary key(id)
)

create table movie(
mvId varchar2(12),
title varchar2(21),
dir varchar2(21),
act varchar2(50),
genre varchar2(21),
age varchar2(12),
playTime varchar2(12),
constraint pk_movie_mvId primary key(mvId)
)

create table rsv(
rsv_id varchar2(21) primary key,
cus_id varchar2(21),
mv_mvId varchar2(12),
th_thId varchar2(21),
day varchar2(21),
rsvTime varchar2(21),
num number(2),
paymentMethod varchar2(12),
total number(7),
constraint fk_rsv_cus_id foreign key(cus_id) references customer(id),
constraint fk_rsv_mv_MvId foreign key(mv_MvId) references movie(MvId),
constraint fk_rsv_th_thId foreign key(th_thId) references theater(thId)
)


create table theater(
thId varchar2(21) primary key,
thName varchar2(21),
thLocation varchar2(21),
thTel varchar2(21)

)

insert into customer (id, pwd, name, birthDate, age, tel) values('c001', '2020', '배수지', '20.04.20', 30, '010-3333-2038')
insert into customer (id, pwd, name, birthDate, age, tel) values('c002', '2030', '한수지', '20.04.30', 20, '010-3343-2038')

insert into movie (mvId,title,dir,act,genre,age,playTime) values ('m001','신세계','박훈정','이정재,최민식','범죄,드라마','19세','134분')
insert into movie (mvId,title,dir,act,genre,age,playTime) values ('m002','기생충','봉준호','송강호,조여정','범죄,드라마','15세','131분')
insert into movie (mvId,title,dir,act,genre,age,playTime) values ('m003','타짜1','최동훈','조승우,김혜수','범죄,드라마','19세','139분')

insert into theater (thId,thName,thLocation,thTel) values('th01','강남CGV','강남구', '02-1234-1234')
insert into theater (thId,thName,thLocation,thTel) values('th02','강변CGV','광진구', '02-5678-5678')
insert into theater (thId,thName,thLocation,thTel) values('th03','안양CGV','안양구', '031-9999-9999')


commit

select * from theater
select * from movie
select * from customer
select * from rsv

--select c.id, m.MvId,  from customer c, movie m, theater t

