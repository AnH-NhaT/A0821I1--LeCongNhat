use classicmodels;
-- Thực hành 1
SELECT * FROM customers 
WHERE customerName = 'Land of Toys Inc.'; 

EXPLAIN SELECT * FROM customers 
WHERE customerName = 'Land of Toys Inc.'; 

-- Thêm index vào customerName
ALTER TABLE customers 
ADD INDEX idx_customerName(customerName);

-- Xóa index customer
ALTER TABLE customers
DROP INDEX idx_customerName;

/* Thực hành 2 */
-- Tạo stored procedure
DELIMITER //
create procedure findAllCustomers()
begin
	select * from customers;
end //
DELIMITER ;
-- Gọi procedure
call findAllCustomers();

-- my sql không cung cấp lệnh sửa stored 
-- Do đó phai chạy lệnh tạo mới
DELIMITER //
DROP PROCEDURE IF EXISTS `findAllCustomers`//
CREATE PROCEDURE findAllCustomers()
BEGIN
SELECT * FROM customers where customerNumber = 175;
END //

call findAllCustomers();

-- Thực hành 3
-- Tham số loại IN
delimiter //
create procedure getCusById
(IN cusNum int(11))
begin
	select * from customers where customerNumber = cusNum;
end //
delimiter ;

call getCusById(175);

-- Tham số loại OUT
delimiter //
create procedure GetCustomersCountByCity
(
	IN in_city varchar(50),
    OUT total int
)
begin
	select count(customerNumber)
    into total 
    from customers
    where city = in_city;
end //
delimiter ;

CALL GetCustomersCountByCity('Lyon', @total);
SELECT @total;

-- Tham số loại INOUT

-- Thực hành 4
create view customer_views as
select customerNumber, customerName, phone
from customers;

select * from customer_views;

CREATE OR REPLACE VIEW customer_views AS
SELECT customerNumber, customerName, contactFirstName, contactLastName, phone
FROM customers
WHERE city = 'Nantes';

select * from customer_views;
drop view customer_views;