package com.bookapp.testing;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDBServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// setup connection variable
		
		String jdbcUrl="jdbc:mysql://localhost:3306/newbook";
		String user="root";
		String pass="root";
		String driver="com.mysql.jdbc.Driver";
		
		//get connection from db
		
		try {
			PrintWriter out=response.getWriter();
			out.println("Connecting to:"+ jdbcUrl);
			
			Class.forName(driver);
			Connection myCon= DriverManager.getConnection(jdbcUrl,user,pass);
			
			out.println("Connection succeeded...");
			
			myCon.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
