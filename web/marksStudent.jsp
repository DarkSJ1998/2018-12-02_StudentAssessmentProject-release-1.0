<%-- 
    Document   : marksStudent
    Created on : Nov 16, 2018, 10:57:41 AM
    Author     : Sarthak Jain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "modal.*, java.util.ArrayList" %>
<!--


-->
<!DOCTYPE html>
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
        <title>JSP Page</title>
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
		h2
		{
			color: crimson;
			padding: 10px;
		}
		</style>
    </head>
    <body bgcolor = "white">
	<%
		StudentDAO sdao = new StudentDAO();
		ArrayList <Courses> cl = new ArrayList <Courses> ();
        cl = sdao.showMarks((Integer)(session.getAttribute("uid")));
	%>
    <form style = "margin: 0px 20px 20px 20px;">
		<fieldset>
		<legend><h2> Marks obtained : </h2></legend>
		<center>
		<%
		if(cl.size() == 0)
		{%>
			<h3> No course assigned yet </h3>
		<%
		}
		else
		{
		%>
        <table border = "1px solid grey" style = "border-collapse: collapse;margin: 0px 20px 20px 20px;">
		<tr>
			<th> S. No. </th>
			<th> Course Code </th>
			<th> Course Title </th>
			<th> Marks Obtained </th>
			<th> Max Marks</th>
		</tr>
		<%
			int i=1;
			for(Courses c : cl)
			{
		%>
			<tr>
				<td> <%=i%> </td>
				<td> <%=c.getCoursecode()%></td>
				<td> <%=c.getTitle()%></td>
				<td> <% if(c.getMarks() == 0)
						{
							out.println("NA");
						}
						else
						{
							out.println(c.getMarks());
						}
					%></td>
				<td> 40 </td>
			</tr>
		<%
			i++;
			}
		%>
		<table>
		<%
		}
		%>
		</fieldset>
		</form>
    </body>
</html>
<%
	}
%>