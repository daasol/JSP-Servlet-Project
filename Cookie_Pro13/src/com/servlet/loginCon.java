package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginCon
 */
@WebServlet("/loginCon")
public class loginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String mId = request.getParameter("mID");
		String mPw = request.getParameter("mPW");
		
		out.print("<p>"+mId+"</p>");
		out.print("<p>"+mPw+"</p>");
		
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		
		for(Cookie c : cookies) {
			System.out.println("getName() : "+c.getName()+"geValue() : "+c.getValue());
			//사용자로부터 오는 쿠키를 전부 조회해서  memberId라는 내용이 있으면 쿠키에 담는다.
			if(c.getName().equals("memberId")) {
				cookie = c;
			}
		}
		//쿠키를 다 조회해 봤는데 없으면
		//처음 접속으로 간주하고 memberId라는 변수에 사용자가 입력한 아이디를 저장한다.
		if(cookie ==null) {
			System.out.println("cookie is null");
			cookie = new Cookie("memberId",mId );
		}
		
		
		response.addCookie(cookie);
		cookie.setMaxAge(60*60);
		
		response.sendRedirect("loginOk.jsp");
	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
