package com.servlet;

import java.sql.*;
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.BooksDAO;
import com.servlet.dto.BooksDTO;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BS")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		/*
		String driver = "org.mariadb.jdbc.Driver";
		String url="jdbc:mariadb://localhost:3308/testdb";
		String id="root";
		String pw = "1234";
		
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "Select * From books";
			pstmt = conn.prepareStatement(sql);
			
			rs= pstmt.executeQuery(sql);
			
			while(rs.next()) {
				int book_id = rs.getInt("book_id");
				String title = rs.getString("title");
				String publisher = rs.getString("publisher");
				String year = rs.getString("year");
				int price = rs.getInt("price");
				
				out.println("book_id "+book_id+", ");
				out.println("title "+title+", ");
				out.println("publisher "+publisher+", ");
				out.println("year "+year+", ");
				out.println("price "+price+" ");
				
			}
		}catch(ClassNotFoundException e3) {
			System.out.println("드라이버를 찾을 수 없음");
		}catch(SQLException e4) {
			e4.printStackTrace();
		} finally {
			try {
				if( pstmt !=null ) pstmt.close();
				if (conn !=null) conn.close();
				
			}catch(Exception e5) {
				e5.printStackTrace();
			}
		}
		
		*/
		
		BooksDAO booksDAO = new BooksDAO();
		//아알았어 드라이버 로딩하고 기다리고 있읅
		ArrayList<BooksDTO> list = booksDAO.select();
		
		
		for(int i=0; i<list.size(); i++) {
			BooksDTO dto = list.get(i);
			int book_id = dto.getBook_id();
			String title = dto.getTitle();
			String publisher = dto.getPublisher();
			String year = dto.getYear();
			int price = dto.getPrice();
			out.print("book_id"+book_id+",");
			out.print("title"+title+",");
			out.print("publisher"+publisher+",");
			out.print("year"+year+",");
			out.print("price"+price+"");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
