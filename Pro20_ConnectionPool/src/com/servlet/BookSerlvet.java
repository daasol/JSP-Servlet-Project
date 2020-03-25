package com.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookSerlvet
 */
@WebServlet("/bs")
public class BookSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("test/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		BookDAO bookDAO = new BookDAO();
		ArrayList<BookDTO> list;
		try {
			list = bookDAO.select();
			for(int i = 0; i<list.size(); i++){
				BookDTO dto = list.get(i);
				
				int book_id = dto.getBook_id();
				String title = dto.getTitle();
				String publisher = dto.getPublisher();
				String year = dto.getYear();
				int price = dto.getPrice();
					
				out.println("book_id"+book_id+",");
				out.println("title"+title+",");
				out.println("publisher"+publisher+",");
				out.println("year"+year+",");
				out.println("price"+price+"");
				
					
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
