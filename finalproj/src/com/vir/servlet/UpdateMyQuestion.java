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
import com.vir.service.EmployeeService;
import com.vir.service.EmployeeServiceImpl;
import com.vir.service.QuestionInterfaceImpl;
import com.vir.service.QuestionServiceInterface;

@WebServlet("/UpdateMyQuestion")
public class UpdateMyQuestion extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);  
		if(session!=null){  

			//int empid=(Integer) session.getAttribute("empid"); 
			//int qid=(Integer) session.getAttribute("qid");
		int qid=(Integer) request.getAttribute("qid");
		String qdesc = request.getParameter("qdesc");
		/*String email = request.getParameter("email");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");*/

		Question question = new Question();
		question.setQid(qid);
		question.setQdesc(qdesc);
		

		QuestionServiceInterface qs= new QuestionInterfaceImpl();
	

		int status=qs.update(question);
		if(status>0){
			 request.getRequestDispatcher("/Tab.jsp").include(request, response);
			out.println("update successfully");
			
		}else{
			 request.getRequestDispatcher("/Tab.jsp").include(request, response);
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}
	

}
}
