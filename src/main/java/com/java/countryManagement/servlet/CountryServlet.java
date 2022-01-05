package com.java.countryManagement.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.countryManagement.model.Country;


public class CountryServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession httpsession = request.getSession(false);
		int id = Integer.parseInt(request.getParameter("id"));
		
		RequestDispatcher requestd = request.getRequestDispatcher("country_detail.jsp?id="+id+"");
		requestd.forward(request, response);
	
		
		
		
	
	
	}

}
