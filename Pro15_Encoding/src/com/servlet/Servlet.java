package com.servlet;

import java.io.IOException;
import java.io.*;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		String servlet_id;
		String servlet_pw;
		
		String url = "jdbc:/mariadb://localhost:3308/testdb";
		String id = "root";
		String pw = "1234";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			
			String sql = "insert into user(id, pw) value('"+m_id+"','"+m_pw+"',');";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				//servlet_id=	(String)rs.getString("m_id");
				servlet_pw = rs.getString("m_pw");
			}
			//out.print("<p> ID: "+servlet_id+<"</p>");
			
			
		}catch(SQLException e1) {
			System.out.println("연결실패");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 적재 실패");
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
