<%-- 
    Document   : dashboardAdmin
    Created on : Nov 19, 2018, 0:36:29 AM
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
	else if(request.getSession().getAttribute("user").equals("student"))
    {
		%>
		<script>
			alert("Redirecting...");
			location = 'home_student.jsp';
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
		AdminDAO adao = new AdminDAO();
		Admin a = adao.showData((String)session.getAttribute("uid"));
	%>
	<form style = "margin: 0px 20px 20px 20px;">
		<fieldset>
		<legend><h2> Your Details : </h2></legend>
		<a href = "dashboardAdminEdit.jsp"><button type = "button" style = "float: right;"> Edit Details </button></a>
        <span id = "output" style = "visibility: hidden;color: red;float: left;">Hello</span>
		<center>
		<br><br><br>
        <table border = "1px solid grey" style = "width: 85%;border-collapse: collapse;margin: 0px 20px 20px 20px;">
			<tr>
				<th> Admin ID : </th>
				<td> <%=a.getUid()%></td>
			</tr>
			<tr>
				<th> Name : </th>
				<td> <%=a.getName()%></td>
			</tr>
			<tr>
				<th> Email ID : </th>
				<td> <%=a.getEmail()%></td>
			</tr>
			<tr>
				<th> Contact No : </th>
				<td> <%=a.getContactNo()%></td>
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