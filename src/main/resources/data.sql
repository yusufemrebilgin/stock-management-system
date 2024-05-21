INSERT INTO user (username, password, enabled, first_name, last_name, email)
VALUES ('admin', '$2a$10$FemrUOH6LJXh1icexiYBPeyPBSEvslUt3w31uNog8DerUFJgILXSK', 1, 'Michael', 'Scott',
        'michael@example.com'),
       ('user', '$2a$10$BP5N6pvelSTHsZtDYKoNQ.WetxqxYyZSZvJcKLWlBz/ZTS2/u5IVi', 1, 'Jim', 'Halpert',
        'jim@example.com');

INSERT INTO role (name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');

INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1),
       (1, 2),
       (2, 1);

INSERT INTO message (sender_id, receiver_id, title, content, timestamp)
VALUES (1, 2, 'Suspendisse Eu', 'Nunc ac ultrices quam. Nulla a enim a dolor malesuada euismod. Curabitur lacinia viverra ligula et tincidunt. Aliquam ut rhoncus turpis. Duis rutrum venenatis condimentum. Curabitur semper odio sit amet turpis vestibulum, eu lacinia nulla rutrum. Nulla odio ex, sagittis ut risus mattis, volutpat viverra augue. Aliquam elementum ut quam nec varius. Aliquam eu felis sed orci tempus pellentesque. Sed a eleifend mi. Praesent euismod turpis ac orci pretium mollis. Duis pellentesque velit id laoreet dignissim. Quisque ultricies, nisl eget porta accumsan, est arcu tincidunt lorem, eu dictum ex metus.', '2023-08-19 16:35:22'),
       (1, 2, 'Quisque Faucibus', 'Aliquam accumsan mauris quam, eu facilisis lorem euismod eget. Nunc sit amet vestibulum lectus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus imperdiet mauris a scelerisque maximus. Suspendisse tortor libero, porttitor ultrices ante at, eleifend tempor orci. Curabitur magna lectus, congue quis magna vel, pulvinar sollicitudin orci. Etiam pellentesque, lacus id posuere malesuada, lorem turpis malesuada sapien, non dignissim dolor tortor nec nisl. Vivamus sit amet tristique velit, eu commodo sapien. Nullam tempor eu sem at consectetur. Fusce mi.', '2023-04-23 11:33:21'),
       (1, 2, 'Quisque Iaculis', 'Etiam vestibulum arcu in libero lacinia, sed tempor ligula convallis. Cras ut neque odio. Vestibulum sed luctus sem. Aenean varius consequat eros sit amet rhoncus. Curabitur laoreet arcu leo, in cursus orci suscipit ac. Maecenas ultrices felis sit amet ex venenatis, et placerat ipsum vulputate. Integer tristique quis lectus rhoncus viverra. Sed nisi mauris, mollis in imperdiet sed, consequat vel dolor. Nulla et porttitor felis. In consectetur sapien urna, ac tempor justo tempus vel. Aenean pulvinar quam nec odio fringilla dictum. Cras rhoncus, velit a pharetra imperdiet, odio tortor porttitor.', '2024-05-12 07:34:02'),
       (1, 2, 'Etiam Arcu', 'Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Sed consequat velit arcu, vitae convallis velit tempus quis. Curabitur auctor turpis urna, a volutpat justo varius nec. Donec tincidunt gravida sodales. Morbi quis posuere quam. Nulla volutpat erat eu sodales dictum. Suspendisse interdum velit nec eros commodo ornare. Phasellus laoreet tempor velit. Sed libero erat, iaculis quis pellentesque ut, imperdiet vel massa. Proin odio orci, mattis varius sem quis, volutpat euismod diam. Integer ac tincidunt eros. Maecenas ut tincidunt metus. Vivamus eleifend ex nec.', '2024-02-11 11:33:12'),
       (2, 1, 'Phasellus Dignissim', 'Curabitur in odio felis. Nulla venenatis aliquet scelerisque. Quisque vitae mi neque. Praesent sit amet ipsum arcu. Sed neque arcu, vulputate eget feugiat non, gravida eget enim. Mauris sit amet quam at odio rhoncus hendrerit id quis turpis. Suspendisse lorem ligula, varius nec sapien ut, finibus mattis dui. Aenean interdum vehicula arcu ac fringilla. Integer ut lacus et purus iaculis fermentum. Duis sed leo tincidunt, interdum ex id, vulputate ex. Proin ornare ut est eu luctus. Praesent accumsan auctor elit eget cursus. In tempus sed dui vel tincidunt. Vestibulum ante ipsum primis in gravida.', '2024-04-06 13:31:33'),
       (2, 1, 'Integer Commodo', 'Praesent faucibus diam libero. Duis rhoncus feugiat risus eu mattis. Sed sollicitudin sed urna vel convallis. Donec porttitor libero at dignissim ultricies. Morbi non nisi vel neque ullamcorper cursus. Sed in diam sed libero porta pellentesque. Donec tincidunt purus ac pellentesque fringilla. Nullam eros dolor, porttitor vitae tellus sed, euismod sollicitudin tortor. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vestibulum tincidunt massa nec tincidunt rhoncus. Aliquam erat volutpat. Sed aliquet sed leo eget cursus. Fusce quis ipsum non mi pulvinar non.', '2024-01-01 11:11:02'),
       (2, 1, 'Aliquam Erat', 'Donec porttitor, ex vitae molestie ultricies, nunc odio volutpat magna, sit amet pharetra purus felis id nibh. Nunc tempor sed metus non pharetra. Etiam blandit mauris ipsum, eu feugiat tortor venenatis sit amet. Suspendisse bibendum, tortor ac auctor fringilla, dui nunc imperdiet turpis, ac porttitor neque justo at magna. Quisque posuere nunc justo, viverra lobortis arcu consectetur ut. In at urna ullamcorper, egestas ex quis, suscipit mauris. Sed orci nibh, convallis ac iaculis eu, ullamcorper et felis. Maecenas tincidunt scelerisque orci. Pellentesque habitant morbi tristique senectus cras.', '2024-02-22 17:34:42');

INSERT INTO category (name)
VALUES ('Laptops'),
       ('Monitors'),
       ('Mobile Phones'),
       ('Tablets'),
       ('Cameras'),
       ('Televisions');

INSERT INTO product (code, name, category_id, quantity_in_stock, cost_price, sale_price, created_at, modified_at)
VALUES ('LA-1225-APP860','Apple MacBook Air M1', 1, 850, 999.99, 1415.0 ,'2024-02-24 01:02:37' ,'2024-02-24 01:02:37'),
       ('LA-6719-APP441','Apple MacBook Pro 16-inch', 1, 950, 2399.99, 3398.0 ,'2024-02-14 18:47:37' ,'2024-02-14 18:47:37'),
       ('LA-4807-DEL570','Dell XPS 13', 1, 950, 1299.99, 1840.0 ,'2023-09-14 07:00:37' ,'2023-09-14 07:00:37'),
       ('LA-8480-DEL269','Dell XPS 15', 1, 900, 1699.99, 2407.0 ,'2024-02-02 07:06:37' ,'2024-02-02 07:06:37'),
       ('LA-5774-HP 833','HP Spectre x360 14', 1, 550, 1399.99, 1982.0 ,'2023-05-22 21:12:37' ,'2023-05-22 21:12:37'),
       ('LA-6794-HP 586','HP Envy 13', 1, 650, 899.99, 1274.0 ,'2023-12-29 04:16:37' ,'2023-12-29 04:16:37'),
       ('LA-6647-LEN254','Lenovo ThinkPad X1 Carbon', 1, 650, 1499.99, 2123.0 ,'2023-05-30 12:42:37' ,'2023-05-30 12:42:37'),
       ('LA-0590-LEN741','Lenovo Yoga 9i', 1, 900, 1249.99, 1769.0 ,'2023-11-10 16:10:37' ,'2023-11-10 16:10:37'),
       ('LA-2369-ASU834','Asus ROG Zephyrus G14', 1, 700, 1449.99, 2053.0 ,'2024-01-15 17:29:37' ,'2024-01-15 17:29:37'),
       ('LA-1878-ASU176','Asus ZenBook 14', 1, 600, 999.99, 1415.0 ,'2024-03-11 16:33:37' ,'2024-03-11 16:33:37'),
       ('LA-9673-MIC760','Microsoft Surface Laptop 4', 1, 950, 999.99, 1415.0 ,'2023-07-26 20:25:37' ,'2023-07-26 20:25:37'),
       ('LA-5266-MIC990','Microsoft Surface Pro 7', 1, 1000, 749.99, 1061.0 ,'2023-12-11 23:53:37' ,'2023-12-11 23:53:37'),
       ('LA-9469-ACE068','Acer Swift 3', 1, 850, 699.99, 991.0 ,'2023-11-01 11:06:37' ,'2023-11-01 11:06:37'),
       ('LA-7057-ACE821','Acer Aspire 5', 1, 600, 549.99, 778.0 ,'2024-02-27 00:29:37' ,'2024-02-27 00:29:37'),
       ('LA-2151-RAZ349','Razer Blade 15', 1, 700, 1999.99, 2831.0 ,'2024-05-06 15:19:37' ,'2024-05-06 15:19:37'),
       ('LA-8020-RAZ098','Razer Blade Stealth 13', 1, 700, 1799.99, 2548.0 ,'2023-12-17 18:58:37' ,'2023-12-17 18:58:37'),
       ('LA-9153-LG 326','LG Gram 17', 1, 500, 1499.99, 2123.0 ,'2023-12-05 02:49:37' ,'2023-12-05 02:49:37'),
       ('LA-6445-SAM956','Samsung Galaxy Book Pro 360', 1, 750, 1299.99, 1840.0 ,'2023-10-10 16:56:37' ,'2023-10-10 16:56:37'),
       ('LA-5072-MSI683','MSI GS66 Stealth', 1, 550, 1799.99, 2548.0 ,'2024-04-23 06:58:37' ,'2024-04-23 06:58:37'),
       ('LA-5980-MSI774','MSI Prestige 14', 1, 850, 1299.99, 1840.0 ,'2023-08-30 06:16:37' ,'2023-08-30 06:16:37'),
       ('LA-0092-ALI575','Alienware m15 R6', 1, 950, 2199.99, 3115.0 ,'2024-03-20 06:02:37' ,'2024-03-20 06:02:37'),
       ('LA-3897-GIG164','Gigabyte Aero 15', 1, 900, 1599.99, 2265.0 ,'2023-12-15 04:27:37' ,'2023-12-15 04:27:37'),
       ('LA-2361-HUA309','Huawei MateBook X Pro', 1, 700, 1499.99, 2123.0 ,'2023-11-30 02:25:37' ,'2023-11-30 02:25:37'),
       ('LA-3198-GOO122','Google Pixelbook Go', 1, 600, 649.99, 920.0 ,'2023-06-15 20:54:37' ,'2023-06-15 20:54:37'),
       ('LA-7616-ASU297','Asus Chromebook Flip C434', 1, 950, 599.99, 849.0 ,'2023-11-11 19:24:37' ,'2023-11-11 19:24:37'),
       ('LA-2562-HP 858','HP Elite Dragonfly', 1, 550, 1799.99, 2548.0 ,'2024-03-04 00:32:37' ,'2024-03-04 00:32:37'),
       ('LA-1451-LEN684','Lenovo Legion 5 Pro', 1, 850, 1399.99, 1982.0 ,'2023-06-13 18:06:37' ,'2023-06-13 18:06:37'),
       ('LA-8443-DEL851','Dell G5 15', 1, 750, 999.99, 1415.0 ,'2023-09-18 10:58:37' ,'2023-09-18 10:58:37'),
       ('LA-4124-ACE916','Acer Predator Helios 300', 1, 700, 1249.99, 1769.0 ,'2023-10-11 12:58:37' ,'2023-10-11 12:58:37'),
       ('LA-6396-ASU174','Asus TUF Dash F15', 1, 500, 1099.99, 1557.0 ,'2023-12-29 11:13:37' ,'2023-12-29 11:13:37');

INSERT INTO product (code, name, category_id, quantity_in_stock, cost_price, sale_price, created_at, modified_at)
VALUES ('MO-2263-DEL619','Dell UltraSharp U2720Q', 2, 700, 749.99, 1061.0 ,'2023-08-07 18:25:33' ,'2023-08-07 18:25:33'),
       ('MO-2440-LG 825','LG 27GN950-B', 2, 600, 799.99, 1132.0 ,'2024-03-08 11:31:33' ,'2024-03-08 11:31:33'),
       ('MO-7311-ASU381','Asus ROG Swift PG279Q', 2, 650, 699.99, 991.0 ,'2024-04-16 17:18:33' ,'2024-04-16 17:18:33'),
       ('MO-5265-SAM801','Samsung Odyssey G9', 2, 750, 1399.99, 1982.0 ,'2024-03-09 06:28:33' ,'2024-03-09 06:28:33'),
       ('MO-4420-ACE040','Acer Predator X34', 2, 550, 999.99, 1415.0 ,'2024-03-15 09:05:33' ,'2024-03-15 09:05:33'),
       ('MO-7811-BEN685','BenQ PD3220U', 2, 500, 1199.99, 1699.0 ,'2023-09-04 11:29:33' ,'2023-09-04 11:29:33'),
       ('MO-7472-HP 701','HP Omen 27i', 2, 1000, 499.99, 707.0 ,'2023-12-19 01:01:33' ,'2023-12-19 01:01:33'),
       ('MO-9462-VIE710','ViewSonic Elite XG270QG', 2, 900, 699.99, 991.0 ,'2024-03-09 16:52:33' ,'2024-03-09 16:52:33'),
       ('MO-9465-GIG897','Gigabyte Aorus FI27Q', 2, 900, 599.99, 849.0 ,'2023-06-10 15:55:33' ,'2023-06-10 15:55:33'),
       ('MO-9453-MSI813','MSI Optix MAG272QR', 2, 1000, 449.99, 637.0 ,'2024-04-13 08:25:33' ,'2024-04-13 08:25:33');

INSERT INTO product (code, name, category_id, quantity_in_stock, cost_price, sale_price, created_at, modified_at)
VALUES ('MO-1682-APP295','Apple iPhone 14 Pro Max', 3, 900, 1099.99, 1557.0 ,'2023-08-08 05:30:00' ,'2023-08-08 05:30:00'),
       ('MO-8137-SAM687','Samsung Galaxy S23 Ultra', 3, 950, 1199.99, 1699.0 ,'2024-03-29 21:07:00' ,'2024-03-29 21:07:00'),
       ('MO-8132-GOO834','Google Pixel 7 Pro', 3, 500, 899.99, 1274.0 ,'2024-04-27 08:40:00' ,'2024-04-27 08:40:00'),
       ('MO-9781-ONE985','OnePlus 11', 3, 850, 699.99, 991.0 ,'2024-04-22 02:27:00' ,'2024-04-22 02:27:00'),
       ('MO-8503-XIA658','Xiaomi Mi 13', 3, 600, 799.99, 1132.0 ,'2023-08-24 09:51:00' ,'2023-08-24 09:51:00'),
       ('MO-3871-OPP620','Oppo Find X6 Pro', 3, 900, 999.99, 1415.0 ,'2024-01-28 05:01:00' ,'2024-01-28 05:01:00'),
       ('MO-4457-SON817','Sony Xperia 1 IV', 3, 900, 1299.99, 1840.0 ,'2023-10-15 20:34:00' ,'2023-10-15 20:34:00'),
       ('MO-1400-NOK614','Nokia X30', 3, 850, 499.99, 707.0 ,'2024-01-16 00:37:00' ,'2024-01-16 00:37:00'),
       ('MO-6193-HUA291','Huawei P50 Pro', 3, 1000, 1199.99, 1699.0 ,'2023-07-30 12:36:00' ,'2023-07-30 12:36:00'),
       ('MO-7397-ASU557','Asus ROG Phone 6', 3, 600, 899.99, 1274.0 ,'2024-02-27 08:25:00' ,'2024-02-27 08:25:00'),
       ('MO-0004-MOT373','Motorola Edge+ (2023)', 3, 1000, 799.99, 1132.0 ,'2023-06-06 03:58:00' ,'2023-06-06 03:58:00'),
       ('MO-6657-APP816','Apple iPhone SE (2022)', 3, 950, 429.99, 608.0 ,'2023-06-01 08:09:00' ,'2023-06-01 08:09:00'),
       ('MO-6028-SAM547','Samsung Galaxy Z Fold 4', 3, 550, 1799.99, 2548.0 ,'2023-06-07 23:19:00' ,'2023-06-07 23:19:00'),
       ('MO-1579-GOO544','Google Pixel 6a', 3, 1000, 449.99, 637.0 ,'2023-09-15 16:16:00' ,'2023-09-15 16:16:00'),
       ('MO-2434-ONE960','OnePlus Nord N20', 3, 700, 299.99, 424.0 ,'2024-04-11 15:18:00' ,'2024-04-11 15:18:00'),
       ('MO-0420-XIA411','Xiaomi Redmi Note 12', 3, 750, 249.99, 353.0 ,'2024-01-28 06:05:00' ,'2024-01-28 06:05:00'),
       ('MO-6420-VIV119','Vivo X80 Pro', 3, 550, 999.99, 1415.0 ,'2023-08-29 21:34:00' ,'2023-08-29 21:34:00'),
       ('MO-6315-REA627','Realme GT 2 Pro', 3, 600, 699.99, 991.0 ,'2023-10-20 07:59:00' ,'2023-10-20 07:59:00'),
       ('MO-3395-LEN289','Lenovo Legion Phone Duel 2', 3, 550, 999.99, 1415.0 ,'2023-06-04 07:33:00' ,'2023-06-04 07:33:00'),
       ('MO-7393-ZTE040','ZTE Axon 40 Ultra', 3, 550, 799.99, 1132.0 ,'2024-03-21 10:05:00' ,'2024-03-21 10:05:00');

INSERT INTO product (code, name, category_id, quantity_in_stock, cost_price, sale_price, created_at, modified_at)
VALUES ('TA-2006-APP249','Apple iPad Pro 12.9', 4, 950, 1099.99, 1557.0 ,'2023-09-07 06:35:26' ,'2023-09-07 06:35:26'),
       ('TA-4650-SAM315','Samsung Galaxy Tab S8 Ultra', 4, 750, 1099.99, 1557.0 ,'2024-01-26 17:44:27' ,'2024-01-26 17:44:27'),
       ('TA-1297-MIC093','Microsoft Surface Pro 8', 4, 950, 1199.99, 1699.0 ,'2024-02-29 18:47:27' ,'2024-02-29 18:47:27'),
       ('TA-7026-APP123','Apple iPad Air', 4, 850, 599.99, 849.0 ,'2023-12-30 00:33:27' ,'2023-12-30 00:33:27'),
       ('TA-0195-AMA618','Amazon Fire HD 10', 4, 650, 149.99, 212.0 ,'2023-07-24 21:58:27' ,'2023-07-24 21:58:27'),
       ('TA-0629-LEN678','Lenovo Tab P11 Pro', 4, 1000, 499.99, 707.0 ,'2024-04-12 07:56:27' ,'2024-04-12 07:56:27'),
       ('TA-9886-SAM656','Samsung Galaxy Tab A8', 4, 500, 229.99, 325.0 ,'2024-03-08 18:47:27' ,'2024-03-08 18:47:27'),
       ('TA-5399-ASU132','Asus ZenPad 3S 10', 4, 650, 299.99, 424.0 ,'2023-09-20 14:19:27' ,'2023-09-20 14:19:27'),
       ('TA-0527-HUA893','Huawei MatePad Pro', 4, 850, 799.99, 1132.0 ,'2023-05-29 13:28:27' ,'2023-05-29 13:28:27'),
       ('TA-9454-GOO116','Google Pixel Slate', 4, 700, 799.99, 1132.0 ,'2023-12-03 05:47:27' ,'2023-12-03 05:47:27');

INSERT INTO product (code, name, category_id, quantity_in_stock, cost_price, sale_price, created_at, modified_at)
VALUES ('CA-3095-CAN845','Canon EOS R5', 5, 950, 3899.99, 5522.0 ,'2023-10-27 04:45:50' ,'2023-10-27 04:45:50'),
       ('CA-2159-NIK679','Nikon Z7 II', 5, 600, 2999.99, 4247.0 ,'2023-09-22 17:09:50' ,'2023-09-22 17:09:50'),
       ('CA-2274-SON909','Sony Alpha a7 III', 5, 550, 1999.99, 2831.0 ,'2024-04-23 23:24:50' ,'2024-04-23 23:24:50'),
       ('CA-6299-FUJ912','Fujifilm X-T4', 5, 550, 1699.99, 2407.0 ,'2024-01-08 10:53:50' ,'2024-01-08 10:53:50'),
       ('CA-1156-PAN756','Panasonic Lumix S5', 5, 700, 1999.99, 2831.0 ,'2023-08-17 21:08:50' ,'2023-08-17 21:08:50'),
       ('CA-8226-OLY132','Olympus OM-D E-M1 Mark III', 5, 650, 1799.99, 2548.0 ,'2024-05-10 16:29:50' ,'2024-05-10 16:29:50'),
       ('CA-6650-CAN183','Canon EOS M50 Mark II', 5, 500, 699.99, 991.0 ,'2023-09-14 09:24:50' ,'2023-09-14 09:24:50'),
       ('CA-7041-SON566','Sony Alpha a6400', 5, 850, 899.99, 1274.0 ,'2024-02-25 05:00:50' ,'2024-02-25 05:00:50'),
       ('CA-1490-NIK254','Nikon D850', 5, 750, 2999.99, 4247.0 ,'2024-05-14 06:30:50' ,'2024-05-14 06:30:50'),
       ('CA-6262-GOP488','GoPro Hero 10 Black', 5, 950, 499.99, 707.0 ,'2023-10-20 11:35:50' ,'2023-10-20 11:35:50');

INSERT INTO product (code, name, category_id, quantity_in_stock, cost_price, sale_price, created_at, modified_at)
VALUES ('TE-3024-SAM148','Samsung QN90A Neo QLED', 6, 950, 1599.99, 2265.0 ,'2023-08-17 19:52:57' ,'2023-08-17 19:52:57'),
       ('TE-5268-LG 612','LG C1 OLED', 6, 700, 1399.99, 1982.0 ,'2023-10-15 02:48:57' ,'2023-10-15 02:48:57'),
       ('TE-4158-SON270','Sony A80J OLED', 6, 1000, 1799.99, 2548.0 ,'2023-09-14 04:18:57' ,'2023-09-14 04:18:57'),
       ('TE-6181-TCL988','TCL 6-Series Roku TV', 6, 600, 999.99, 1415.0 ,'2023-08-12 01:23:57' ,'2023-08-12 01:23:57'),
       ('TE-1090-VIZ093','Vizio P-Series Quantum', 6, 700, 1199.99, 1699.0 ,'2023-12-17 09:24:57' ,'2023-12-17 09:24:57'),
       ('TE-9973-SAM512','Samsung The Frame', 6, 850, 1299.99, 1840.0 ,'2023-07-19 16:45:57' ,'2023-07-19 16:45:57'),
       ('TE-1215-LG 519','LG NanoCell 90 Series', 6, 750, 1099.99, 1557.0 ,'2023-06-21 01:54:57' ,'2023-06-21 01:54:57'),
       ('TE-4222-SON460','Sony X90J', 6, 500, 1299.99, 1840.0 ,'2023-12-05 17:51:57' ,'2023-12-05 17:51:57'),
       ('TE-4144-HIS640','Hisense U8G', 6, 750, 999.99, 1415.0 ,'2023-06-14 11:57:57' ,'2023-06-14 11:57:57'),
       ('TE-7441-PHI243','Philips OLED 806', 6, 600, 1899.99, 2690.0 ,'2023-08-27 09:01:57' ,'2023-08-27 09:01:57');