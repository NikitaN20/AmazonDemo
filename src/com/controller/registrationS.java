package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/registrationS")
public class registrationS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection = null;
	private RequestDispatcher rd=null;
	private UserDao dao = new UserDaoImpl();
    private HttpSession session = null;  
       
   
    public registrationS() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		connection =ConnectionManager.getConnection();
	
		 PrintWriter out = response.getWriter();
		 
		 String un = request.getParameter("uname");
		String pw = request.getParameter("password");
		User user = new User(un,pw);
			
			if(dao.AddUser(user))
			{
				session= request.getSession();
				session.setAttribute("user", user);
				
				
				rd = request.getRequestDispatcher("profile.jsp");
				rd.forward(request,response);
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
