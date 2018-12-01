<%-- 
    Document   : dashboardStudent
    Created on : Nov 14, 2018, 8:36:29 PM
    Author     : Sarthak Jain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "modal.*" %>
<!DOCTYPE html>
<!--	-->
<%
	if(request.getSession().getAttribute("loggedIn") == null)
	{
		session.invalidate();
		%>
		<body bgcolor = "white">
		<h2 style = "color: crimson;padding: 10px;"> Session expired. Please reload the page.</h2>
		</body>
		<%
	}
	else if(request.getSession().getAttribute("user").equals("admin"))
    {
		%>
		<script>
			alert("Redirecting...");
			location = 'home_admin.jsp';
		</script>
		<%
    }
	else if(request.getSession().getAttribute("user").equals("teacher"))
    {
		%>
		<script>
			alert("Redirecting...");
			location = 'home_teacher.jsp';
		</script>
		<%
    }
	else
	{
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style>
		*
		{
			font-family: Segoe UI;
		}
		table,th,td
		{
			font-family: Calibri;
			font-size: 20px;
			padding: 20px;
		}
		th
		{
			text-align: right;
		}
		h2
		{
			color: crimson;
			padding: 10px;
		}
        input
		{
			width: 250px;
		}
		button
		{
			border-radius: 20px;
			background-color: crimson;
			color: white;
			font-size: 20px;
			padding: 10px;
			margin: 0px 5px 5px 0px;
		}
		button:hover
		{
			background-color: green;
		}
		</style>
	</head>
    <body bgcolor = "white">
	<%
		StudentDAO sdao = new StudentDAO();
		Student s = sdao.showData((Integer)(session.getAttribute("uid")));
		int cnt = sdao.countCourses((Integer)(session.getAttribute("uid")));
	%>
	<form style = "margin: 0px 20px 20px 20px;">
		<fieldset>
		<legend><h2> Student Details : </h2></legend>
        <a href = "dashboardStudentEdit.jsp"><button type = "button" style = "float: right;"> Edit Details </button></a>
        <span id = "output" style = "visibility: hidden;color: red;float: left;">Hello</span>
		<center>
        <br><br>
		<h3>
		You are enrolled in <%=cnt%> courses.
		</h3>
        <table border = "1px solid grey" style = "width: 85%;border-collapse: collapse;margin: 0px 20px 20px 20px;">
			<tr>
				<th> ID : </th>
				<td> <%=s.getUid()%></td>
			</tr>
			<tr>
				<th> Name : </th>
				<td> <%=s.getName()%></td>
			</tr>
			<tr>
				<th> Email ID : </th>
				<td> <%=s.getEmail()%></td>
			</tr>
			<tr>
				<th> Father's Name : </th>
				<td> <%=s.getFathersName()%></td>
			</tr>
			<tr>
				<th> Mother's Name : </th>
				<td> <%=s.getMothersName()%></td>
			</tr>
			<tr>
				<th> Contact No : </th>
				<td> <%=s.getContactNo()%></td>
			</tr>
			<tr>
				<th> Department : </th>
				<td> <%=s.getDept()%></td>
			</tr>
		<table>
		</center>
		</fieldset>
		</form>
    </body>
</html>
<%
	}
%>