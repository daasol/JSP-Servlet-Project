package com.servlet.dao;

import java.util.*;
import java.sql.*;
import java.io.*;

import com.servlet.dto.BooksDTO;

public class BooksDAO {
	String url="jdbc:mariadb://localhost:3308/testdb";
	String id = "root";
	String pw = "1234";
	
	public BooksDAO() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		}catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("드라이버를 찾을 수 없음");
		}
		
	}
	
	public ArrayList<BooksDTO> select(){
		
		ArrayList<BooksDTO> list = new ArrayList<BooksDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "select * from books";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int book_id = rs.getInt("book_id");
				String title = rs.getString("title");
				String publisher = rs.getString("publisher");
				String year = rs.getString("year");
				int price = rs.getInt("price");
				
				BooksDTO booksDTO = new BooksDTO(book_id, title, publisher, year, price);
				list.add(booksDTO);
			}
		}catch(Exception e) {
			e.printStackTrace();
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
