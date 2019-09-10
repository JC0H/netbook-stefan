INSERT INTO PRODUCT (id,brand) VALUES (1,'Lenovo');
INSERT INTO PRODUCT (id,brand)
VALUES (2,'HP');
INSERT INTO PRODUCT (id,brand)
VALUES (3,'Dell');
INSERT INTO PRODUCT (id,brand)
VALUES (4,'Apple');
INSERT INTO PRODUCT (id,brand)
VALUES (5,'Fujitsu');
INSERT INTO PROPERTIES (id, MODEL, PROCESSOR, GRAPHICS, MEMORY, SCREEN, RAM, NETWORK, COLOR, WEIGHT, OPERATING_SYSTEM,
                        USB, ADDITIONAL_INFORMATION, PRICE)
VALUES (1, 'A1', 'Intel Core i5', 'Intel Integrated', 'HD 250', '15.6in 1920x1080', '8GB', 'Wi-Fi|Wi-Fi 80', 'Black',
        3.200, 'Windows 10',
        'USB x3', 'Very good', 1000.00);
INSERT INTO PROPERTIES (id,MODEL,PROCESSOR,GRAPHICS,MEMORY,SCREEN,RAM,NETWORK,COLOR,WEIGHT,OPERATING_SYSTEM,USB
                          ,ADDITIONAL_INFORMATION ,PRICE)
  VALUES (2,'A2','Intel Core i7','Intel x4','SSD 126','12.6in 1600x1280','16GB','Wi-Fi 80/76ZIntegral','Black', 3.500,'Windows 10',
           'USB x3','Very good',1454.00);
INSERT INTO PROPERTIES (id,MODEL,PROCESSOR,GRAPHICS,MEMORY,SCREEN,RAM,NETWORK,COLOR,WEIGHT,OPERATING_SYSTEM,USB
                          ,ADDITIONAL_INFORMATION ,PRICE)
  VALUES (3,'A3','Intel Core i3','Intel Integrated','HD 500','15.6in 1920x1080','8GB','Wi-Fi|Wi-Fi 80|LP15h','Grey',2.200,'Windows 10',
           'USB x3','Very good', 2040.00);

INSERT INTO PROPERTIES (id,MODEL,PROCESSOR,GRAPHICS,MEMORY,SCREEN,RAM,NETWORK,COLOR,WEIGHT,OPERATING_SYSTEM,USB
                          ,ADDITIONAL_INFORMATION ,PRICE)
  VALUES (4,'A4','AMD x4','Intel Root l5','SSD 126','15.6in 1920x1080','8GB','Wi-Fi|Wi-Fi 80','Black',1.200,'Linux',
           'USB x3','Very good', 1540.00);
INSERT INTO PRODUCT_PROPERTIES_LIST (product_id, properties_list_id)
VALUES (1, 1);
INSERT INTO PRODUCT_PROPERTIES_LIST (product_id, properties_list_id)
VALUES (1, 2);
INSERT INTO PRODUCT_PROPERTIES_LIST (product_id, properties_list_id)
VALUES (3, 3);
INSERT INTO PRODUCT_PROPERTIES_LIST (product_id, properties_list_id)
VALUES (4, 4);
INSERT INTO Orders (id, order_date) VALUES (1, '2019-08-20');
INSERT INTO Orders (id, order_date) VALUES (2, '2019-08-20');
INSERT INTO Orders_Products(orders_id ,products_id) VALUES (1, 1);
INSERT INTO Orders_Products(orders_id, products_id) VALUES (1, 2);
INSERT INTO Orders_Products(orders_id, products_id) VALUES (2, 4);
INSERT INTO Orders_Products(orders_id, products_id) VALUES (2, 5);