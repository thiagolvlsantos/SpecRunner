insert into ORD.customers (name,date,description,genre) values ('Vieira',CURRENT_TIME,'','F');

delete from ORD.customers where name = 'Thiago';

update ORD.customers set name = 'Vieira de Lima', description = '' where name = 'Luiz';