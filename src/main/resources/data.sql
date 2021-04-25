-- CATEGORIES
INSERT INTO categories (description) VALUES ('Frutas y verduras');
INSERT INTO categories (description) VALUES ('Pastelería');
INSERT INTO categories (description) VALUES ('Carnes y pescados');
INSERT INTO categories (description) VALUES ('Lácteos y huevos');
INSERT INTO categories (description) VALUES ('Bebidas');
INSERT INTO categories (description) VALUES ('Licores');
INSERT INTO categories (description) VALUES ('Cuidado personal');
INSERT INTO categories (description) VALUES ('Despensa');

-- PRODUCTS
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Guayaba Feijoa', 2, '7029 A42 23', 300, 500);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Mango', 2, '0316 R56 01', 2100, 250);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Manzana', 2, '7923 T23 19', 700, 130);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Tortilla', 2, '4335 Z33 84', 6400, 87);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Tostadas', 2, '6584 M19 25', 4000, 45);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Chocorramo', 2, '4487 S00 97', 2000, 105);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Salmón', 3, '4546 A00 01', 28000, 55);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Punta de anca', 3, '3678 E57 22', 12000, 32);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Posta', 3, '8893 O01 03', 7800, 40);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Leche de vaca', 4, '2323 T56 33', 2500, 500);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Queso', 4, '7786 K19 56', 4000, 300);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Huevos de gallina feliz', 4, '3478 M74 01', 400, 1000);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Gaseosa Colombiana', 5, '3434 R34 63', 3100, 175);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Jugo de Lulo', 5, '9753 W33 19', 8250, 630);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Tea', 5, '9836 F35 69', 1900, 450);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Cerveza', 6, '3432 G67 21', 2100, 800);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Tequila', 6, '9529 E45 98', 65000, 764);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Ron', 6, '1947 R07 53', 55000, 240);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Enjuague bucal', 7, '1942 T68 01', 12000, 105);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Shampoo', 7, '6789 W01 23', 9300, 200);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Desodorante', 7, '7333 S21 36', 6900, 85);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Cereal', 8, '4673 K53 98', 7000, 75);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Frijol', 8, '2745 F40 45', 8200, 270);
INSERT INTO products (name, category_id, barcode, price ,stock) VALUES ('Café', 8, '6351 R33 92', 7200, 400);

-- CLIENTS
INSERT INTO clients (client_id, fullname, address) VALUES ('12345', 'Accenture Test', 'Carrera 11#14-08');
INSERT INTO clients (client_id, fullname, address) VALUES ('2552243', 'Galileo Galilei', 'Cl 1 # 11 - 11');
INSERT INTO clients (client_id, fullname, address) VALUES ('983824', 'Nicolás Copernico', 'Cl 2 # 22 - 22');

-- PURCHASES
INSERT INTO purchases (client_id, date, payment_method, total, delivery_charges, iva, grand_total, comment, active) VALUES ('12345', TO_TIMESTAMP('10/08/1992 17:30:00','DD/MM/YYYY HH24:MI:SS'), 'E',72400, 10000,13756,96156, 'CompraRealizada', true);
INSERT INTO product_purchases (purchase_id, product_id, quantity, total) VALUES (1, 1, 10, 3000);
INSERT INTO product_purchases (purchase_id, product_id, quantity, total) VALUES (1, 4, 1, 40000);
INSERT INTO product_purchases (purchase_id, product_id, quantity, total) VALUES (1, 7, 1, 9000);
INSERT INTO product_purchases (purchase_id, product_id, quantity, total) VALUES (1, 10, 2, 16400);
INSERT INTO product_purchases (purchase_id, product_id, quantity, total) VALUES (1, 24, 1, 4000);
