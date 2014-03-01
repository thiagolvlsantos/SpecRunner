create schema ORD authorization dba

create table ORD.customers (
	id BIGINT generated by default as identity, 
	name VARCHAR(255),
	time date not null, 
	status smallint, 
	gender VARCHAR(255) not null, 
		primary key (id))
