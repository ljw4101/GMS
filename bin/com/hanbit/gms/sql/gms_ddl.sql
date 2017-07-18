--id, pw, ssn, name, regdate

CREATE TABLE Member(
	id VARCHAR2(10), 
	name VARCHAR2(10),
	pw VARCHAR2(10), 
	ssn VARCHAR2(15), 
	regdate DATE,
	PRIMARY KEY(id)
);

DROP TABLE Member;

--제일 먼저 생성되어야 한다.
CREATE SEQUENCE article_seq
	START WITH 1000
	INCREMENT BY 1
	NOCACHE
	NOCYCLE;

CREATE TABLE board(
	article_seq NUMBER,
	id VARCHAR2(10),
	title VARCHAR2(20),
	content VARCHAR2(100),
	regdate DATE,
	hitcount NUMBER,
	PRIMARY KEY(article_seq),
	FOREIGN KEY(id) REFERENCES MEMBER(id) ON DELETE CASCADE
);


