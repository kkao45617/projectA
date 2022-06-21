무비의 예제를 보면서 작성한 코드

오라클 연결 톰캣 설정
<Resource auth="Container"
						driverClassName="oracle.jdbc.OracleDriver" maxIdle="10"
						maxTotal="20" maxWaitMillis="-1" name="jdbc/myoracle"
						password="tiger" type="javax.sql.DataSource"
						url="jdbc:oracle:thin:@127.0.0.1:1521:xe" username="scott" />