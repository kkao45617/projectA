web-study-10

환경
1.sts tool - Version: 3.9.17.RELEASE
2.oracle 11g
3.jdk11
4.windows
5.인코딩 utf-8
6.git
7.jstl.jar
8.ojdbc6.jar
9.standard.jar
10.cos.jar
11. xml 환경
<Resource auth="Container"
						driverClassName="oracle.jdbc.OracleDriver" maxIdle="10"
						maxTotal="20" maxWaitMillis="-1" name="jdbc/myoracle"
						password="tiger" type="javax.sql.DataSource"
						url="jdbc:oracle:thin:@127.0.0.1:1521:xe" username="scott" />

*cos.jar를 통한 파일 업로드 및 수정보안





mysql 테이블 생성

create table product(code number(5), name VARCHAR2(100), price number(8), pictureurl VARCHAR(50), description varchar(1000), PRIMARY KEY (code));


create SEQUENCE product_seq start with 1 INCREMENT by 1;


insert into product values(product_seq.nextval, '개념을 콕콕 잡아주는 데이터베이스', 27000, 'db.jpg', '데이터베이스에 관한 모든 것을 쉽고 재미있게 정리한 교재...');

insert into product values(product_seq.nextval, '웹표준을 위한 HTML5', 25000, 'html5.jpg', 'HTML5 가이드북. 홈페이지 제작을 위한 필수 선택 HTML 기본 문법...');

insert into product values(product_seq.nextval, 'Dynamic Programming book 시리즈-01 오라클 11g + PL/SQL', 25000, 'oracle.jpg','Dynamic 실무 코칭 프로그래밍 Book의 첫번째 책으로, 오라클 11g의 새로운 ...');

insert into product values(product_seq.nextval, 'Visual C++ MFC 윈도우 프로그래밍', 26000, 'mfc.jpg', 'Visual C++를 처음 시작하는 독자의 눈높이에 맞춘 Visual C++...');

insert into product values(product_seq.nextval, 'jQuery and jQuery Mobile : 이해하기 쉽게 풀어쓴', 25000, 'jquery.jpg', '소스 하나로 데스크탑과 모바일까지 HTML5와 함께 사용한다. 초보자들도 ...');



COMMIT;
select * from product;

