select * from books;


select id,name,author from books
where name = 'Clean Code' and author='Robert C.Martin'
order by id desc;