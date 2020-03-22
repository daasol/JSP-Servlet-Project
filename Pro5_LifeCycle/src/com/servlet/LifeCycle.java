package com.servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycle
 */
@WebServlet("/LC")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("--doGet()--");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	@PostConstruct
	private void funPC() {
		// TODO Auto-generated method stub
		System.out.println("--@PostConstruct--");
	}
	@Override
	public void init() throws ServletException{
		//�����Ǵ� �������� �۾��� �ϰ� ���� �� 
		//���� DB�κ��� �α��� ID, PW�� ���� ��
		System.out.println("--init()--");
	}
	@Override
	public void destroy() {
		//������ ���ҽ� �ڿ����� (�ݳ�)
		System.out.println("--destroy()--");
	}
	@PreDestroy
	public void preDestroy() {
		System.out.println("--@PreDestroy()--");
	}

}