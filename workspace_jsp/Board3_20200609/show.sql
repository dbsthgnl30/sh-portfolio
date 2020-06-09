select *from (select rownum rnum,title,writer,writeday,readcnt,repIndent from(select * from board order by repRoot desc, repStep asc))where rnum>=? and rnum<=?

