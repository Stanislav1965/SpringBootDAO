-- создадим таблицу
CREATE TABLE CUSTOMERS(
    id int not null,
    name VARCHAR(100),
    surname VARCHAR(100),
    age int,
    phone_number VARCHAR(20),
    CONSTRAINT customers_pk PRIMARY KEY (id)
);

-- создаем последовательность для формирования id  в таблице CUSTOMERS
create sequence customers_id;

-- создадим таблицу ORDERS
CREATE TABLE ORDERS(
    id int not null,
    date_order date,
    customers_id int not null,
    product_name VARCHAR(100) not null,
    amount int,
    CONSTRAINT orders_pk PRIMARY KEY (id),
    CONSTRAINT fk_customers FOREIGN KEY (customers_id) REFERENCES customers(id)
);

-- создаем последовательность для формирования id  в таблице ORDERS
create sequence orders_id;