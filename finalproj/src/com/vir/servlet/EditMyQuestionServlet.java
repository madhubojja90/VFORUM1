
package com.vir.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vir.model.Employee;
import com.vir.model.Question;

import com.vir.service.QuestionInterfaceImpl;
import com.vir.service.QuestionServiceInterface;
@WebServlet("/EditMyQuestionServlet")
public class EditMyQuestionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		request.getRequestDispatcher("ProfileHome.html").include(request, response);  
		
		out.println("<h1>Question </h1>");
		HttpSession session=request.getSession(false);  
        if(session!=null){  
        
         int qid=(Integer) session.getAttribute("qid"); 
         QuestionServiceInterface qs= new QuestionInterfaceImpl();
        Question e=qs.getEmployeeById(qid);
		
        
        
     
        
		out.print("<form action='UpdateQuestionServlet' method='post'>");
		
		
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='empid' value='"+e.getEmpid()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='fullname' value='"+e.getQdesc()+"'/></td></tr>");
	//	out.print("<tr><td>email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
		
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
	
		out.close();
	}
}
}