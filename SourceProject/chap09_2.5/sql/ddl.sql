create table GUESTBOOK_MESSAGE (
	GUESTBOOK_MESSAGE_ID	INT	auto_increment,
	GUEST_NAME	varchar(20) not null,
	CONTENT	text not null,
	PRIMARY KEY (GUESTBOOK_MESSAGE_ID)
) ENGINE=InnoDB;

