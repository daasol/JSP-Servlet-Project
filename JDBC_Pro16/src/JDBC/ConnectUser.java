package JDBC;
import java.sql.*;


public class ConnectUser {
	public static Connection makeconnection() {
		String url = "jdbc:mariadb://localhost:3308/testdb";
		String id = "root";
		String pw = "1234";
		
		Connection conn  = null;
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			//마리아DB드라이버 로드 마리아DB드라이버가 메모리에 로딩된다.
			System.out.println("드라이버 적재 성공");
			conn = DriverManager.getConnection(url, id, pw);
			//자바와 DB드라이버가 연결
			System.out.println("데이터베이스 연결 성공");
			
		}catch(ClassNotFoundException e1) {
			System.out.println("드라이버를 찾을 수 없음");
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			System.out.println("연결실패");
		}
		return conn;
	}
	
	public static void main(String[] args) throws SQLException {
		Connection conn = makeconnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from user");
		while(rs.next()) {
			int user_num = rs.getInt("user_num");
			String user_id = rs.getString("user_id");
			String user_name= rs.getString("user_name");
			String user_birth = rs.getString("user_birth");
			int user_age = rs.getInt("user_age");
			System.out.println("num : "+user_num+" id : "+user_id+" name : "+user_name+"birth : "+user_birth+" age : "+user_age);
		}
	}
}
