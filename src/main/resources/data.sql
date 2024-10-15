-- вставим данные в таблицу CUSTOMERS
INSERT INTO CUSTOMERS (id,name, surname, age, phone_number)
VALUES (nextval('customers_id'),'Alexey', 'Turner', 24, '911 221-12-12'),
       (nextval('customers_id'),'Michael', 'Dooley', 40, '921 740-77-77'),
       (nextval('customers_id'),'Sabrina', 'Spellman', 19, '911 555-01-17');

-- вставим данные в таблицу ORDERS
INSERT INTO ORDERS (id, date_order, customers_id, product_name, amount)
VALUES (nextval('orders_id'), current_date, 1, 'Мыло', 10),
       (nextval('orders_id'), current_date, 1, 'Мочалка', 1),
       (nextval('orders_id'), current_date, 1, 'Шампунь', 2),
       (nextval('orders_id'), current_date, 2, 'Порошок', 1),
       (nextval('orders_id'), current_date, 3, 'Тряпка', 10);
