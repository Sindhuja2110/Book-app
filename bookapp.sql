create table book_2612(book_id number,book_name varchar(200),publish_date date);
insert into book_2612 values(101,' Core Java Volume I',DATE '2000-04-21');
insert into book_2612 values(102,'Effective Java',DATE '2003-07-06');
insert into book_2612 values(103,'Head First Java',DATE '2005-11-01');
commit;
select * from book_2612;