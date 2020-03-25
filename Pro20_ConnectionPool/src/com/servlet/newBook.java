package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class newBook
 */
@WebServlet("/newBook")
public class newBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("test/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		String publisher = request.getParameter("publisher");
		String year = request.getParameter("year");
		String price = request.getParameter("price");
		int price_num = Integer.valueOf(price);
		
		String driver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3308/testdb";
		String id = "root";
		String pw = "1234";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			String sql = "INSERT INTO books(title, publisher, year, price)";
			sql+=" VALUES ('"+title+"', '"+publisher+"', '"+year+"', "+price_num+");";
			
			int result = stmt.executeUpdate(sql);
			if(result ==1) out.print("INSERT success!");
			else out.print("INSERT fail!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn !=null) conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
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
