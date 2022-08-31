**********DB
create user trip identified by 1234;
grant connect, resource, dba to trip;
commit;

CREATE TABLE users (
   usernum number NOT NULL primary key,
   userid varchar2(50) NOT NULL UNIQUE,
   username varchar2(20) NOT NULL,
   nickname varchar2(20) NOT NULL,
   userpass varchar2(16) NOT NULL,
   phone char(13),  
   birth char(8),
   gender varchar2(8) NOT NULL, 
   joindate date default sysdate,
   email varchar2(50) NOT NULL,
   admin number(1) NOT NULL, 
   question varchar2(50),
   answer varchar2(30)
);

CREATE TABLE festival (
   festival_num number NOT NULL primary key,
   festival_title varchar2(50) NOT NULL,
   festival_content varchar2(4000) NOT NULL,
   festival_image varchar2(4000) NULL,
   festival_schedule varchar2(30) NULL,
   festival_city varchar2(10) not null,
   --fk 
   usernum number not null,
   CONSTRAINT fk_user_to_festival foreign key(usernum) references users(usernum)
);

-- 축제 데이터(api)
create table festivaldata (
    num number(5) not null primary key,
    title varchar2(200),
    address varchar2(300),
    firstimg varchar2(2000),
    startdate varchar2(8),
    enddate varchar2(8),
    mapx varchar2(100),
    mapy varchar2(100),
    mlevel number(5)
);

CREATE TABLE board (
   board_num number NOT NULL primary key,
   board_title varchar2(50) NOT NULL,
   board_content varchar2(4000) not null,
   board_date date default sysdate,
   hits number NOT NULL,
   board_image varchar2(4000) NULL,
   board_like number not null,
   --fk 
   usernum number not null,
   CONSTRAINT fk_user_to_board foreign key(usernum) references users(usernum)
);

CREATE TABLE board_comment (
   board_comm_num number NOT NULL primary key,
   board_comm_date date default sysdate,
   board_comm_reply varchar2(1000) NOT NULL,
   --fk
   board_num number not null,
   CONSTRAINT fk_board_to_comment foreign key(board_num) references board(board_num)
);

create table destination (
    destinationNum number not null primary key,
    destinationTitle varchar2(150) not null,
    destinationAddress varchar2(200),
    destinationFirstImg varchar2(4000),
    destinationSecondImg varchar2(4000),
    destinationMapX varchar2(50),
    destinationMapY varchar2(50),
    destinationContent varchar2(4000),
    --FK 
    usernum number not null,
    CONSTRAINT fk_user_to_destination foreign key(usernum) references users(usernum)
);
--역순으로 리스트 조회를 위한 인덱스 생성
create index indexNum on destination(destinationNum desc);



CREATE TABLE course (
   coursenum number NOT NULL primary key,
   coursetitle varchar2(150) NOT NULL,
   coursecontent varchar2(4000) NOT NULL,
   courseimage varchar2(4000) NULL,
   courselike number NOT NULL,
   coursecity varchar2(50) not null
);

-- 코스 안에 여행지 목록
create table des_course(
    pathnum number not null,
    destinationnum number not null,
    --pk 외래키
    CONSTRAINT fk_destination_to foreign key(destinationnum) 	references destination(destinationNum),
    coursenum number not null,
    CONSTRAINT fk_course_to foreign key(coursenum) references course(coursenum)
);

-- 
create sequence users_seq
START with 1 INCREMENT by 1 MINVALUE 1;
-- 
create sequence festival_seq
START with 1 INCREMENT by 1 MINVALUE 1;
-- 
create sequence fesdata_num
START with 1 INCREMENT by 1 MINVALUE 1;
-- 
create sequence board_seq
START with 1 INCREMENT by 1 MINVALUE 1;
-- 
create sequence board_comment_seq
START with 1 INCREMENT by 1 MINVALUE 1;
-- 
create sequence destination_seq
START with 1 INCREMENT by 1 MINVALUE 1;
-- 
create SEQUENCE desdata_seq 
START with 1 INCREMENT by 1 MINVALUE 1;
--
create sequence des_comment_seq
START with 1 INCREMENT by 1 MINVALUE 1;
-- 
create sequence course_seq
START with 1 INCREMENT by 1 MINVALUE 1;

commit;
