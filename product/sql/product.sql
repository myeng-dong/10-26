drop table product;
create table product(
    product_id  number(10),
    pname       varchar(30),
    quantity    number(10),
    price       number(10)
);
--�⺻Ű
alter table product add constraint product_product_id_pk primary key(product_id);

--����������
drop sequence product_product_id_seq;
create sequence product_product_id_seq;


--����--
insert into product(product_id,pname,quantity,price)
     values(product_product_id_seq.nextval, '��ǻ��', 5, 1000000);

insert into product(product_id,pname,quantity,price)
     values(product_product_id_seq.nextval, '�����', 5, 500000);

insert into product(product_id,pname,quantity,price)
     values(product_product_id_seq.nextval, '������', 1, 300000);

--��ȸ--
select product_id, pname, quantity, price
  from product
 where product_id = 2;

--����--
update product
   set pname = '��ǻ��2',
       quantity = 10,
       price = 1200000;

--����
delete from product where product_id = 1;

--��ü��ȸ-
select product_id,pname,quantity,price from product;

commit;