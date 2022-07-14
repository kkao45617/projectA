	<!-- �Һ� -->
		<dependency>
		    <groupId>org.projectlombok</groupId>
		    <artifactId>lombok</artifactId>
		    <version>1.18.24</version>
		    <scope>provided</scope>
		</dependency>
		

		<!-- ����Ŭ -->
		
		<dependency>
		    <groupId>com.oracle.database.jdbc</groupId>
		    <artifactId>ojdbc8</artifactId>
		    <version>21.6.0.0.1</version>
		</dependency>
		
		<!--��ī�� cp-->
		<dependency>
		    <groupId>com.zaxxer</groupId>
		    <artifactId>HikariCP</artifactId>
		    <version>5.0.1</version>
		</dependency>
		
		<!-- spring test ���� �߰� -->
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
		
		
/*��Ʈ ��ȸ*/
select dbms_xdb.gethttpport() from dual;
/*��Ʈ����*/
exec dbms_xdb.sethttpport(9090);

/*book ���̺� ���� ����*/
/*���̺� ���� ���� ����*/
create user book1 identified by 1234 default tablespace users TEMPORARY tablespace temp;


/*���̺� ���� �ο�*/
grant connect, dba to book1;





*����Ŭ ������ �� ���̺� ������ Ű���� ����
create sequence seq_board;

create table tbl_board(bno number(10,0), title varchar2(200)not null, content varchar2(2000) not null, writer varchar2(20) not null, regdate date default sysdate, updatedate date default sysdate);

alter table tbl_board add CONSTRAINT pk_board primary key(bno);


insert into TBL_BOARD (bno, title, content, writer) values(seq_board.nextval, 'java','��..�Ⱦ�.�׸��ҷ�','����ּ���' );

select *from TBL_BOARD;
commit;