CREATE TABLE GREETINGS (
    id INT PRIMARY KEY AUTO_INCREMENT, 
    receiver VARCHAR(255), 
    sender VARCHAR(255) 
);
insert into GREETINGS (receiver, sender) values('Foo', 'Bar');
insert into GREETINGS (receiver, sender) values('Bar', 'Foo');
CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(255), 
    company VARCHAR(255) 
);
insert into customers (name, company) values('Sam', 'Wal-Mart');
insert into customers (name, company) values('Larry', 'Oracle');
insert into customers (name, company) values('Bill', 'Microsoft');
insert into customers (name, company) values('Sam', 'Butchershop');
insert into customers (name, company) values('Richard', 'GnuCo');
