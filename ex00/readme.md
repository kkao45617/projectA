create SEQUENCE seq_board;----시퀀스 생성

create table tbl_board(bno number(10,0), title varchar2(200) not null, content varchar2(2000) not null, writer varchar2(50) not null, regdate date default sysdate, updatedate date default sysdate);
--테이블 생성

alter table tbl_board add CONSTRAINT pk_board primary key(bno);
--테이블 변경 및 키 변경




desc TBL_BOARD;

insert into TBL_BOARD(bno,title, content, writer) values(seq_board.nextval, '길동길동홍길동','섹시한','도둑질과 함께 모든걸');

