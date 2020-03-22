package JDBC;

import java.sql.*;

public class ConnectionDB {
	public static Connection makeconnection() {
		String url="jdbc:mariadb://localhost:3308/testdb";
		//나는 포트번호 3306에 MySql을 할당하였기 때문에 MariaDB는 3308로 할당함
		String id = "root";
		String pw="1234";
		Connection conn = null;
		
		try {
			
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 적재 성공");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("데이터 베이스 연결 성공");
		}catch(ClassNotFoundException e1) {
			System.out.println("드라이버를 찾을 수 없음");
			
		}catch(SQLException e2) {
			System.out.println("연결실패");
		}
		
		return conn;
		
	}
	public static void main(String[] args) throws SQLException {
		Connection con = makeconnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * From books");
		
		while(rs.next()) {
			int book_id = rs.getInt("book_id");
			System.out.println("book_id : "+book_id);
			String title = rs.getString("title");
			System.out.println("title : "+title);
			String publisher = rs.getString("publisher");
			System.out.println("publisher : "+publisher);
			String year = rs.getString("year");
			System.out.println("year : "+year);
			int price = rs.getInt("price");
			System.out.println("price : "+ price);
			System.out.println("------------------------------------");
			
		}
		
	}
}
