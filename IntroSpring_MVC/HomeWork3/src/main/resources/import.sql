DROP TABLE IF EXISTS product;
CREATE TABLE product (
    id bigserial primary key,
    title varchar(255) NOT NULL,
    cost numeric (9, 2) NOT NULL
                     );
INSERT INTO product VALUES (1, 'bread', 20.0);
INSERT INTO product VALUES (2, 'milk', 21.5);
INSERT INTO product VALUES (3, 'eggs', 22.0);
INSERT INTO product VALUES (4, 'cheese', 22.5);
INSERT INTO product VALUES (5, 'butter', 23.0);
INSERT INTO product VALUES (6, 'cottage cheese', 23.5);
INSERT INTO product VALUES (7, 'sunflower oil', 24.0);
INSERT INTO product VALUES (8, 'flour', 24.5);
INSERT INTO product VALUES (9, 'salt', 25.0);
INSERT INTO product VALUES (10, 'sugar', 25.5);