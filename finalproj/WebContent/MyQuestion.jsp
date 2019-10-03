<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Questions</title>
</head>
<body>
<%@include  file="ProfileHome.html" %>


	<%@page import="com.vir.model.*,com.vir.service.*,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Question List</h1>
	< <%
		int empid = (Integer) session.getAttribute("empid");
	%> 
	<%
		QuestionServiceInterface qs = new QuestionInterfaceImpl();

		List<Question> list = qs.getQuestionByEmpid(empid);

		request.setAttribute("list", list);
	%>


	<table border="1" width="90%">
		<tr>
			<th>qid</th>
			
			<th>qdesc</th>
			<th>Edit</th>
		</tr>
		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.getQid()}</td>
				
				<td>${u.getQdesc()}</td>
				<td><a href="EditMyQuestionServlet?qid=${u.getQid()}">Edit</a></td>
		</c:forEach>
	</table>
	<br />
	<a href="addQuestion.jsp">Add Question</a>



	<%-- <table border="1" width="90%">  
<tr><th>qid</th><th>empid</th><th>qdesc</th></tr>  

<c:forEach items="${list}" var="u">  
<tr><td>${u.getQid()}</td><td>${u.getEmpid()}</td><td>${u.getAns_desc()}</td>   
  
</c:forEach>  
</table>   --%>
	<br />
	

</body>
</html>
