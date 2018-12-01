<%-- 
    Document   : dashboardAdminEdit
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
		<script type="text/javascript">
		function checkTel()
		{
			var tel = document.getElementById("tel").value;
			if(tel > 9999999999 || tel < 1000000000 || isNaN(tel))
			{
				document.getElementById("output").innerHTML = "*Invalid Phone number.";
				document.getElementById("output").style.visibility = 'visible';
				document.getElementById('submit').style.visibility = 'hidden';
			}
			else
			{
				document.getElementById("output").innerHTML = "";
				document.getElementById("output").style.visibility = 'hidden';
				document.getElementById('submit').style.visibility = 'visible';
			}
		}
		</script>
	</head>
    <body bgcolor = "white">
	<%
		AdminDAO adao = new AdminDAO();
		Admin a = adao.showData((String)session.getAttribute("uid"));
	%>
	<form style = "margin: 0px 20px 20px 20px;" action="updateAdminData" method = "POST">
		<fieldset>
		<legend><h2> Your Details : </h2></legend>
		<button type = "submit" id = "submit" style = "float: right;"> Update Details </button>
		<a href = "dashboardAdmin.jsp"><button type = "button" style = "float: right;"> Cancel </button></a>
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
				<td> <input type="text" name = "aname" id = "aname" value = "<%=a.getName()%>" autofocus required></td>
			</tr>
			<tr>
				<th> Email ID : </th>
				<td> <input type="email" name="email" id="email" value="<%=a.getEmail()%>" required></td>
			</tr>
			<tr>
				<th> Contact No : </th>
				<td> <input type="tel" id = "tel" name = "tel" onchange = "checkTel()" minlength=10 value = "<%=a.getContactNo()%>" required></td>
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