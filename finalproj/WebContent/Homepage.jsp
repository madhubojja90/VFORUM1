<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.vir.model.Question"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home</title>

<style>
/* Add a black background color to the top navigation */
.topnav {
  background-color: #333;
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
  
  color: white;
}


.welcome{
  padding-top:15%;
   
  text-align: center;

}
</style>

</head>
<body>
<%Question emp=(Question)request.getAttribute("info");
int empid=(Integer) request.getAttribute("empid");

%>
<h1 align="center">Vforum</h1>
 
 <hr>
<div class="topnav">
  <a class="active" href="Homepage.html">Home</a>
  <a href="addQuestion.jsp">addQuestion</a>
  <a href="EmpEditServlet">profile</a>
    <a href="MyQuestion.jsp">myquestions</a>
  <a href="ViewQuestion.jsp">View Questions</a>

  <a href="EmpLogoutServlet">Logout</a>
 
</div>

<div class= "welcome">
<h2>welcome  to virtusa!!</h2>
</div>
<%-- <form action="MyQuestion.jsp" method="post">
     
       <input type="hidden" name="qid" value="<%=emp.getEmpid()%>">
	   <input type="submit" value="ViewAllAnswers"/>
		
	  </form>	

 --%>

</body>
</html>