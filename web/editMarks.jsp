<%-- 
    Document   : editMarks
    Created on : Nov 18, 2018, 12:45:53 PM
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
		ArrayList <Courses> cl = new ArrayList <Courses> ();
        cl = tdao.showStudents((String)(session.getAttribute("uid")));
		CoursesDAO cdao = new CoursesDAO();
	%>
    <form style = "margin: 0px 20px 20px 20px;" action = "updateMarks">
		<fieldset>
		<legend><h2> Upload Marks : </h2></legend>
		<center>
        <table border = "1px solid grey" style = "border-collapse: collapse;margin: 0px 20px 20px 20px;">
		<h3>
		Choose course : <select type = "select" name = "courseSelecter">
							<option value = "<%=request.getParameter("courseSelecter")%>"> <%=request.getParameter("courseSelecter")%> </option>
						</select>
		<br><br>
		Choose student : <select type = "select" id = "studentSelecter" name = "studentSelecter">
							<option value = "<%=request.getParameter("studentSelecter")%>"> <%=request.getParameter("studentSelecter")%> </option>
						</select>
		<br><br>
		Enter marks : <input type = "number" name = "marks" value = "<%=cdao.getMarks(request.getParameter("courseSelecter"), Integer.parseInt(request.getParameter("studentSelecter")))%>" style = "width: 100px;" max = 40 min = 0 required>
		<br><br>
						<button type = "submit"> Go </button>
		</h3>
		<table>
		</fieldset>
		</form>
    </body>
</html>
<%
	}
%>