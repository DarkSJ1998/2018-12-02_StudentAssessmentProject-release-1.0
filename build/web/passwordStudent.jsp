<%-- 
    Document   : passwordStudent
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
		<script type="text/javascript">
		function checkPwd() {
			var p1 = document.getElementById("pwd").value;
			var p2 = document.getElementById("repwd").value;
			var output = document.getElementById("output");
			var submit = document.getElementById("submit");
			if(p1 != p2)
			{
				output.innerHTML = "Passwords don't match";
				output.style.visibility = "visible";
				submit.style.visibility = "hidden";
			}
			else
			{
				output.style.visibility = "hidden";
				submit.style.visibility = "visible";
			}
		}
		</script>
	</head>
    <body bgcolor = "white">
	<form style = "margin: 0px 20px 20px 20px;" action="updatePwdStudent" method = "POST">
		<fieldset>
		<legend><h2> Change Password : </h2></legend>
		<button type = "submit" id = "submit" style = "float: right;"> Update Password </button>
		<a href = "dashboardStudent.jsp"><button type = "button" style = "float: right;"> Cancel </button></a>
        <span id = "output" style = "visibility: hidden;color: red;float: left;">Hello</span>
		<center>
        <br><br>
        <table style = "width: 85%;border-collapse: collapse;margin: 0px 20px 20px 20px;">
			<tr>
				<th> Current Password : </th>
				<td> <input type="password" placeholder="Current Password" id = "oldpwd" name = "oldpwd" minlength=8 required></td>
			</tr>
			<tr>
				<th> New Password : </th>
				<td> <input type="password" placeholder="Password (min 8 characters)" id = "pwd" name = "pwd" onchange = "checkPwd()" minlength=8 required></td>
			</tr>
			<tr>
				<th> Confirm New Password : </th>
				<td> <input type="password" placeholder="Retype Password" id = "repwd" name = "repwd" onchange = "checkPwd()" minlength=8 required></td>
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