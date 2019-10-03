
package com.vir.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.vir.model.Employee;
import com.vir.service.EmployeeService;
import com.vir.service.EmployeeServiceImpl;
@WebServlet("/EmpEditServlet")
public class EmpEditServlet extends HttpServlet {
	  private static final Logger log=Logger.getRootLogger();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		request.getRequestDispatcher("Tab.jsp").include(request, response);  
		
		
		HttpSession session=request.getSession(false);  
        if(session!=null){  
        
         int empid=(Integer) session.getAttribute("empid"); 
        EmployeeService es = new EmployeeServiceImpl(); 
        Employee e=es.getEmployeeById(empid);
        log.trace(e);
        out.println("<h1 align=center><strong>Employee Profile</strong></h1>");
		out.print("<form action='UpdateEmpDetailsServlet' method='post'>");
		out.print("<table align=center>");
		out.print("<tr><td></td><td><input type='hidden' name='empid' value='"+e.getEmpid()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='fullname' value='"+e.getFullName()+"'/></td></tr>");
		out.print("<tr><td>email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
		out.print("<tr><td>username:</td><td><input type='text' name='username' value='"+e.getUserName()+"'/></td></tr>");
		out.print("<tr><td>password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
	
		out.close();
	}
}
}