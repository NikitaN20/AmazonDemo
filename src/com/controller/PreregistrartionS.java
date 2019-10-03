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

import com.controller.UserDao;
import com.controller.UserDaoImpl;


@WebServlet("/PreregistrartionS")
public class PreregistrartionS extends HttpServlet {
	private Connection connection = null;
	private RequestDispatcher rd=null;
	private UserDao dao = new UserDaoImpl();
    
    
    public PreregistrartionS() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		connection =ConnectionManager.getConnection();
		 PrintWriter out = response.getWriter();
		 rd = request.getRequestDispatcher("registration.jsp");
			rd.forward(request,response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
