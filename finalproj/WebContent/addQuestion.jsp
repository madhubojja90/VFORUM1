<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%@include  file="Tab.jsp" %>
 <script>
function validate()
{  
	
	alert("succesfully submitted");
	
}

	
</script> 
<title>Insert title here</title>
</head>
<body>

<%  
		int empid1=(Integer)session.getAttribute("empid");
%>

<form name="form" action="AddQuestionServlet" method="post" onsubmit="return validate()">
<h1 align=center>Add Question</h1>
<table align=center>
<tr><td>empid:</td><td><input type="text" name="empid" value=<%=empid1%> readonly/></td></tr>
<tr><td></td><td><input type="hidden" name="qid"/></td></tr>
<tr><td>qdesc:</td><td><textarea rows="5" cols="80" name="qdesc" required></textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="post Question" /></td></tr>


</form>
</body>
</html>