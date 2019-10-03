package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.UserDao;
import com.controller.UserDaoImpl;
import com.controller.User;
import com.controller.ConnectionManager;



@WebServlet("/loginS")
public class loginS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection = null;
	private RequestDispatcher rd=null;
	private UserDao dao = new UserDaoImpl();
    private HttpSession session = null;  
   
    public loginS() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		connection =ConnectionManager.getConnection();
		 PrintWriter out = response.getWriter();
		 
		String un = request.getParameter("uname");
		String pw = request.getParameter("password");
		User user = new User(un,pw);
		
		if(dao.ValidateUser(user))
		{
			session= request.getSession();
			session.setAttribute("user", user);
			
			
			rd = request.getRequestDispatcher("profile.jsp");
			rd.forward(request,response);
		}
		else {
			
			out.println("<h1>Invalid Credentials....Try Again</h1>");
			rd = request.getRequestDispatcher("index.jsp");
			rd.include(request,response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
