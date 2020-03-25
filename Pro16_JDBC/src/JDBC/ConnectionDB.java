package JDBC;

import java.sql.*;

public class ConnectionDB {
	public static Connection makeconnection() {
		String url="jdbc:mariadb://localhost:3308/testdb";
		//���� ��Ʈ��ȣ 3306�� MySql�� �Ҵ��Ͽ��� ������ MariaDB�� 3308�� �Ҵ���
		String id = "root";
		String pw="1234";
		Connection conn = null;
		
		try {
			
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("����̹� ���� ����");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("������ ���̽� ���� ����");
		}catch(ClassNotFoundException e1) {
			System.out.println("����̹��� ã�� �� ����");
			
		}catch(SQLException e2) {
			System.out.println("�������");
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
