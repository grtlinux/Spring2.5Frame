drop table ITEM;
drop table PAYMENT_INFO;
drop table PURCHASE_ORDER;

create table ITEM (
	ITEM_ID	INT	auto_increment,
	PRICE INT,
	PRIMARY KEY (ITEM_ID)
) ENGINE=InnoDB;

create table PAYMENT_INFO (
	PAYMENT_INFO_ID INT auto_increment,
	PRICE INT,
	PRIMARY KEY (PAYMENT_INFO_ID)
) ENGINE=InnoDB;

create table PURCHASE_ORDER (
	PURCHASE_ORDER_ID INT auto_increment,
	ITEM_ID	INT,
	PAYMENT_INFO_ID INT,
	ADDRESS VARCHAR(255),
	PRIMARY KEY (PURCHASE_ORDER_ID)
) ENGINE=InnoDB;

insert into ITEM values (1, 20000);