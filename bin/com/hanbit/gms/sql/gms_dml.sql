--dummy
INSERT INTO MEMBER(id, name, pw, ssn, regdate) VALUES ('hong','gildong','a','920615-234678',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('kang','Danel','1','940101-1234517',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('park','jihun','1','931230-1234527',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('lee','jihun','1','921230-1234537',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('kim','jihun','1','900201-1234547',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('ong','jihun','1','930301-1235567',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('ong2','sung','1','930301-1235567',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('la','kan','1','931230-2234517',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('jung', 'sehun','1','970101-2224567',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('you', 'sunho','1','940620-2235567',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('jung2', 'sehun','1','970101-2236567',SYSDATE);
insert into member(id, name, pw, ssn, regdate) values ('jun', 'jihun','1','970615-2234577',SYSDATE);

SELECT * FROM MEMBER;
select count(*) as count from MEMBER;
SELECT * FROM member WHERE id='hong';

update MEMBER set pw='2' where id='hong';

delete from MEMBER where id='test';


insert into board(article_seq, id, title, content, hitcount, regdate)values(article_seq.nextval, 'hong', 'title hong', '반짝이는 이상을 발휘하기 꽃이 말이다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(article_seq.nextval, 'park', 'title park', '얼음과 거선의 원대하고, 새가 작고 운다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(article_seq.nextval, 'kim', 'title kim', '보는 그들의 일월과 창공에 두손을 눈에 우리 아니다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(article_seq.nextval, 'jun', 'title jun', '열매를 있는 인간에 새가 옷을 봄바람이다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(article_seq.nextval, 'jung', 'title jung', '청춘이 그들의 철환하였는가 소담스러운 봄바람이다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(article_seq.nextval, 'jung2', 'title jung2', '우리의 이상의 피는 같으며, 속에 우리는 황금시대다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(article_seq.nextval, 'jung2', 'title jung2', '얼마나 크고 있는 뜨고, 이성은 싹이 대한 만물은 것이다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(article_seq.nextval, 'jun', 'title jun', '풍부하게 얼음에 끝까지 사막이다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(article_seq.nextval, 'la', 'title la', '것은 간에 인생에 피가 약동하다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(article_seq.nextval, 'kang', 'title kang', '피부가 있을 석가는 투명하되 모래뿐일 뿐이다',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(article_seq.nextval, 'ong', 'title ong', '우리 행복스럽고 청춘을 쓸쓸하랴?',0,SYSDATE);
insert into board(article_seq, id, title, content, hitcount, regdate)values(article_seq.nextval, 'kang', 'title kang2', '끝까지 그들의 그와 힘차게 자신과 구하지 위하여 황금시대다',0,SYSDATE);

select * from board;


