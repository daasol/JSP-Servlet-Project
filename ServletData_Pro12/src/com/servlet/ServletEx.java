package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServeltEx
 */
@WebServlet("/ServeltEx")
public class ServletEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String Id = getServletConfig().getInitParameter("adminId");
		String Pw = getServletConfig().getInitParameter("adminPw");
				
		PrintWriter out = response.getWriter();
		out.print("<p> adminId :" + Id +"</p>");
		out.print("<p> adminPw :" + Pw+"</p>");
				
	
		String testServer=getServletContext().getInitParameter("testServer");
		out.print("<p>testServer : "+testServer+"</p>");
		
		getServletContext().setAttribute("connectedIP", "127.0.1.0");
		getServletContext().setAttribute("connectedUser", "hwang");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
