CREATE Database IF NOT EXISTS groceryshop;
use groceryshop;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `groceryshop`.`clienttype`;
CREATE TABLE IF NOT EXISTS clienttype(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(40) NOT NULL
);

DROP TABLE IF EXISTS `groceryshop`.`clients`;
CREATE TABLE IF NOT EXISTS clients(
id int PRIMARY KEY AUTO_INCREMENT,
firstname varchar(50) NOT NULL,
lastname varchar(50) NOT NULL,
street varchar(60) NOT NULL,
place varchar(80) NOT NULL,
clienttype int DEFAULT 1,
FOREIGN KEY (clienttype) REFERENCES clienttype(id)
);

DROP TABLE IF EXISTS `groceryshop`.`articles`;
CREATE TABLE IF NOT EXISTS articles(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(50) NOT NULL,
weight decimal(10,2) NOT NULL,
price decimal(10,2) NOT NULL,
amount int NOT NULL
);

DROP TABLE IF EXISTS `groceryshop`.`orders`;
CREATE TABLE IF NOT EXISTS orders(
id int PRIMARY KEY AUTO_INCREMENT,
clientId int NOT NULL,
droneId int DEFAULT -1,
orderdate DATE,
FOREIGN KEY (clientId) REFERENCES clients(id),
FOREIGN KEY (droneId) REFERENCES drones(id)
);

DROP TABLE IF EXISTS `groceryshop`.`bills`;
CREATE TABLE IF NOT EXISTS bills(
id int PRIMARY KEY AUTO_INCREMENT,
clientId int NOT NULL,
billdate DATE,
FOREIGN KEY (clientId) REFERENCES clients(id)
);

DROP TABLE IF EXISTS `groceryshop`.`orders_position`;
CREATE TABLE IF NOT EXISTS orders_position(
id int PRIMARY KEY AUTO_INCREMENT,
articleId int NOT NULL,
amount int NOT NULL,
orderId int NOT NULL,
CHECK (amount > 0),
FOREIGN KEY (articleId) REFERENCES articles(id),
FOREIGN KEY (orderId) REFERENCES orders(id)
);

DROP TABLE IF EXISTS `groceryshop`.`bills_position`;
CREATE TABLE IF NOT EXISTS bills_position(
id int PRIMARY KEY AUTO_INCREMENT,
articleId int NOT NULL,
billId int NOT NULL,
amount int NOT NULL,
CHECK (amount > 0),
FOREIGN KEY (articleId) REFERENCES articles(id),
FOREIGN KEY (billId) REFERENCES bills(id)
);

DROP TABLE IF EXISTS `groceryshop`.`drone_status`;
CREATE TABLE IF NOT EXISTS drone_status(
id int PRIMARY KEY AUTO_INCREMENT,
status varchar(50) NOT NULL
);

DROP TABLE IF EXISTS `groceryshop`.`drones`;
CREATE TABLE IF NOT EXISTS drones(
id int PRIMARY KEY AUTO_INCREMENT,
status int DEFAULT 1,
FOREIGN KEY (status) REFERENCES drone_status(id)
);

INSERT INTO clienttype(name) VALUES("Normal");
INSERT INTO clienttype(name) VALUES("Premium");
INSERT INTO clienttype(name) VALUES("Super");
INSERT INTO articles (name, weight, price, amount) VALUES("Tomaten",500,10.50, 300);
INSERT INTO articles (name, weight, price, amount) VALUES("Bananen",100,7.50, 30);
INSERT INTO articles (name, weight, price, amount) VALUES("Fraenkische Bratwuerste",200,5.50, 130);
INSERT INTO clients (firstname, lastname, street, place, clienttype) VALUES("Hans","Schmidt", "Erlangerstr. 1a","Erlangen",1);
INSERT INTO clients (firstname, lastname, street, place, clienttype) VALUES("Peter","Maier", "Nürnbergerstr. 1b","Fürth",2);
INSERT INTO clients (firstname, lastname, street, place, clienttype) VALUES("Andreas","Meister", "Fürtherstr. 1c","Nürnberg",3);
INSERT INTO drone_status (status) VALUES("READY_TO_START");
INSERT INTO drone_status (status) VALUES("FLYING_TO_CLIENT");
INSERT INTO drone_status (status) VALUES("FLYING_FROM_CLIENT");
INSERT INTO drone_status (status) VALUES("CHARGING");
INSERT INTO drone_status (status) VALUES("ERROR");
INSERT INTO drones (status) VALUES(1);
INSERT INTO drones (status) VALUES(1);
INSERT INTO drones (status) VALUES(1);