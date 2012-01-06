package edu.ecm.blog.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    			   throws ServletException, IOException {
	   String name = request.getParameter("name");
	   response.getWriter().write("Hello " + name + " !");
	   
	   request.setAttribute("name", request.getParameter("name"));

       request.getRequestDispatcher("/WEB-INF/jsp/hello.jsp")
          .forward(request, response);
   }
}