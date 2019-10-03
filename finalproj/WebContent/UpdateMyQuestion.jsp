<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.vir.model.Question"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Question emp=(Question)request.getAttribute("info");
int qid=(Integer) request.getAttribute("qid");
//int qid=(Integer) session.getAttribute("qid");

%><h1 align="center"><strong>Update My Question</strong></h1>
		<table>
	<tr><td>Qid:</td><td><input type="text" name="qid" value="<%= emp.getQid()%>"></td></tr>
	<%-- 	<tr><td>empid:</td><td><input type="number" name="empid" value="<%= emp.getEmpid()%>"readonly/></td></tr> --%>
		<tr><td>qdesc:</td><td><textarea rows="5" cols="80"><%= emp.getQdesc()%></textarea></td></tr>
		<br>
		<br>
		
	</table>
		
		<form action="UpdateMyQuestion" method="post">
		<tr><td colspan="2"><input type="submit" value="Update "/></td></tr>
		
		</form>
		
		

       

</body>
</html>