<%-- 
    Document   : dashboardTeacher
    Created on : Nov 18, 2018, 0:36:29 AM
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
	else if(request.getSession().getAttribute("user").equals("student"))
    {
		%>
		<script>
			alert("Redirecting...");
			location = 'home_student.jsp';
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
			width: 200px;
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
		TeacherDAO tdao = new TeacherDAO();
		Teacher t = tdao.showData((String)(session.getAttribute("uid")));
		int cnt = tdao.countStudents((String)(session.getAttribute("uid")));
	%>
	<form style = "margin: 0px 20px 20px 20px;">
		<fieldset>
		<legend><h2> Your Details : </h2></legend>
		<a href = "dashboardTeacherEdit.jsp"><button type = "button" style = "float: right;"> Edit Details </button></a>
        <span id = "output" style = "visibility: hidden;color: red;float: left;">Hello</span>
		<center>
		<br><br><br>
        <table border = "1px solid grey" style = "width: 85%;border-collapse: collapse;margin: 0px 20px 20px 20px;">
			<tr>
				<th> ID : </th>
				<td> <%=t.getTid()%></td>
			</tr>
			<tr>
				<th> Name : </th>
				<td> <%=t.getName()%></td>
			</tr>
			<tr>
				<th> Email ID : </th>
				<td> <%=t.getEmail()%></td>
			</tr>
			<tr>
				<th> Contact No : </th>
				<td> <%=t.getContactNo()%></td>
			</tr>
			<tr>
				<th> Department : </th>
				<td> <%=t.getDept()%></td>
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