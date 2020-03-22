package JDBC;

import java.io.IOException;
import java.sql.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PreaparedStatement
 */
@WebServlet("/PreaparedStatement")
public class PreaparedStatement extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String url="jdbc:mariadb://localhost:3308/testdb";
		String id = "root";
		String pw = "1234";
		
		Connection con = null;
		PreparedStatement pstmt =null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw);
			String sql = "UPDATE books SET price = ? WHERE title=? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "23000" );
			pstmt.setString(2, "math");
			
			int result = pstmt.executeUpdate();
			
			if(result ==1 ) {
				out.print("UPDATE seccess!");
				
			}else {
				out.print("UPDATE fail!");
			}
		}catch(SQLException e2) {
			System.out.println("연결실패");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("드라이버를 찾을 수 없음");
		}finally {
			try {
				if(pstmt!=null )pstmt.close();
				if(con !=null ) con.close();
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
