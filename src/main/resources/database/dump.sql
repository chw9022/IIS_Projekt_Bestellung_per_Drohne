CREATE Database groceryshop;
use groceryshop;

CREATE TABLE clienttype(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(40) NOT NULL
);

CREATE TABLE clients(
id int PRIMARY KEY AUTO_INCREMENT,
firstname varchar(50) NOT NULL,
lastname varchar(50) NOT NULL,
street varchar(60) NOT NULL,
place varchar(80) NOT NULL,
clienttype int DEFAULT 1,
FOREIGN KEY (clienttype) REFERENCES clienttype(id)
);

CREATE TABLE articles(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(50) NOT NULL,
weight decimal(10,2) NOT NULL,
price decimal(10,2) NOT NULL,
amount int NOT NULL
);

CREATE TABLE orders(
id int PRIMARY KEY AUTO_INCREMENT,
clientId int NOT NULL,
orderdate DATE,
FOREIGN KEY (clientId) REFERENCES clients(id)
);

CREATE TABLE bills(
id int PRIMARY KEY AUTO_INCREMENT,
clientId int NOT NULL,
billdate DATE,
FOREIGN KEY (clientId) REFERENCES clients(id)
);

CREATE TABLE orders_position(
id int PRIMARY KEY AUTO_INCREMENT,
articleId int NOT NULL,
amount int NOT NULL,
orderId int NOT NULL,
CHECK (amount > 0),
FOREIGN KEY (articleId) REFERENCES articles(id),
FOREIGN KEY (orderId) REFERENCES orders(id)
);

CREATE TABLE bills_position(
id int PRIMARY KEY AUTO_INCREMENT,
articleId int NOT NULL,
billId int NOT NULL,
amount int NOT NULL,
CHECK (amount > 0),
FOREIGN KEY (articleId) REFERENCES articles(id),
FOREIGN KEY (billId) REFERENCES bills(id)
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
