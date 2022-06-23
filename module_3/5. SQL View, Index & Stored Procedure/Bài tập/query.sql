create database demo;
use demo;

create table products
(
	id int auto_increment primary key,
    productCode varchar(20) not null,
    productName varchar(50) not null,
    productPrice int not null,
    productAmount int not null,
    productDescription varchar(50),
    productStatus varchar(10)
);
-- Thêm index
alter table products add index idx_productCode(productCode);

create index idx_productName_Price
on products(productName, productPrice);

explain select * from products
where productCode = 'C02';

 -- creat view
create view view_products
as select productCode, productName, productPrice, productStatus from products;


-- Sửa view
create or replace view view_products as
select productCode, productName, productPrice from products;

-- Xóa view
drop view view_products;

-- Tạo procedure lưu tất cả thông tin của products
delimiter //
create procedure getAllProducts()
begin
	select * from products;
end //
delimiter ;

call getAllProducts();

-- Tạo procedure khi thêm 1 sản phẩm mới
delimiter //
create procedure insert_products
(
    IN productCode varchar(20),
    IN productName varchar(50),
    IN productPrice int,
    IN productAmount int,
    IN productDescription varchar(50),
    IN productStatus varchar(10)
) 
begin
	insert into products(productCode, productName, productPrice, productAmount, productDescription, productStatus)
    values(productCode, productName, productPrice, productAmount, productDescription, productStatus);
end //
delimiter ;

call insert_products('C07', 'Oppo A52', 9999, 20, 'Ram 8GB, Rom 64GB', '70%');
select * from products;

-- Tạo procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure replace_product_by_id
(
	IN product_ID int,
	IN `code` varchar(20),
    IN `name` varchar(50),
    IN price int,
    IN amount int,
    IN `description` varchar(50),
    IN `status` varchar(10)
)
begin
	update products
    set productCode = `code`,
		productName = `name`,
        productPrice = price,
        productAmount = amount,
        productDescription = `description`,
        productStatus = `status`
	where id = product_ID;
end //
delimiter ;

call replace_product_by_id(1, 'C01', 'Oppo Reno6 5G', 1299000, 10, 'Ram 8GB, Rom 128GB', '100%');
select * from products;

-- Tạo procedure xóa sản phẩm theo id
delimiter //
create procedure delete_product_by_id
(
	IN product_ID int
)
begin
	delete from products
    where id = product_ID;
end //
delimiter ;

call delete_product_by_id(7);
select * from products;