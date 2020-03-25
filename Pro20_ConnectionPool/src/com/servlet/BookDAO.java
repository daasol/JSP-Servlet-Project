package com.servlet;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.*;
import java.sql.*;
import java.util.*;

public class BookDAO {
	DataSource dataSource;
	 
	public BookDAO() {
		try {
			Context context = new InitialContext();		
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc_maria");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public ArrayList<BookDTO> select() throws Exception{
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM books";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int book_id = rs.getInt("book_id");
				String title = rs.getString("title");
				String publisher = rs.getString("publisher");
				String year = rs.getString("year");
				int price = rs.getInt("price");
				
				BookDTO dto = new BookDTO(book_id, title, publisher, year, price);
				list.add(dto);
				
			}
		
		}catch(Exception e) {
			
		}finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt !=null ) pstmt.close();
				if(conn !=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace(); 
			}
		}
		return list;
		
	}

}
