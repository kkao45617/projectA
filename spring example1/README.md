<!-- 롬복 -->
	<dependency>
	    <groupId>org.projectlombok</groupId>
	    <artifactId>lombok</artifactId>
	    <version>1.18.24</version>
	    <scope>provided</scope>
	</dependency>
	

	<!-- 오라클 -->
	
	<dependency>
	    <groupId>com.oracle.database.jdbc</groupId>
	    <artifactId>ojdbc8</artifactId>
	    <version>21.6.0.0.1</version>
	</dependency>
	
	<!--히카리 cp-->
	<dependency>
	    <groupId>com.zaxxer</groupId>
	    <artifactId>HikariCP</artifactId>
	    <version>5.0.1</version>
	</dependency>
	
	<!-- spring test 버젼 추가 -->
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-test</artifactId>
		<version>${org.springframework-version}</version>
	</dependency>
	
	<!--log4j jdbc-->
	<dependency>
	    <groupId>org.bgee.log4jdbc-log4j2</groupId>
	    <artifactId>log4jdbc-log4j2-jdbc4.1</artifactId>
	    <version>1.16</version>
	</dependency>
	
/실행계획, 인덱스+힌트/ 속도향상 쪽 sql문 select /*+ index_desc(tbl_board pk_board) */ * from tbl_board where bno>0; select * from TBL_BOARD order by bno+1 desc;

/포트 조회/ select dbms_xdb.gethttpport() from dual; /포트수정/ exec dbms_xdb.sethttpport(9090);

/book 테이블 생성 조건/ /테이블 생성 관련 조건/ create user book1 identified by 1234 default tablespace users TEMPORARY tablespace temp;

/테이블 권한 부여/ grant connect, dba to book1;

*오라클 시퀀스 및 테이블 생성과 키변경 조건 create sequence seq_board;

create table tbl_board(bno number(10,0), title varchar2(200)not null, content varchar2(2000) not null, writer varchar2(20) not null, regdate date default sysdate, updatedate date default sysdate);

alter table tbl_board add CONSTRAINT pk_board primary key(bno);

insert into TBL_BOARD (bno, title, content, writer) values(seq_board.nextval, 'java','아..싫어.그만할래','살려주세요' );

select *from TBL_BOARD; commit;