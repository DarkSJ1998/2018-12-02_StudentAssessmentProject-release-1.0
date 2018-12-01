<%-- 
    Document   : createCourses
    Created on : Nov 20, 2018, 10:57:41 AM
    Author     : Sarthak Jain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "modal.*, java.util.ArrayList" %>
<!--	-->
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
        <title>JSP Page</title>
		<style>
		*
		{
			font-family: Segoe UI;
		}
		legend
		{
			color: crimson;
		}
		td
		{	
			padding: 0px 10px 0px 10px;
			width: 300px;
		}
		h2
		{
			color: crimson;
			padding: 10px;
		}
		h3
		{
			text-align: right;
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
		CoursesDAO cdao = new CoursesDAO();
		ArrayList <Student> sl = cdao.getStudents();
	%>
    <form style = "margin: 0px 20px 20px 20px;" action = "addCourse">
		<fieldset>
		<legend><h2> Add a new Course : </h2></legend>
		<center>
        <table>
						<tr>
							<td>
								<h3>Course Code : </h3>
							</td>
							<td>
								<input type="text" placeholder="Course Code" name = "coursecode" id = "coursecode" autofocus required>
							</td>
						</tr>
						
						<tr>
							<td>
								<h3>Course Title : </h3>
							</td>
							<td>
								<input type="text" placeholder="Course Title" name = "title" id = "title" required>
							</td>
						</tr>
						
						<tr>
							<td>
								<h3>Credits : </h3>
							</td>
							<td>
								<select type="select" placeholder="Credits" name = "credits" id = "credits" required>
									<option selected> Select credits </option>
									<option value=1> 1 </option>
									<option value=2> 2 </option>
									<option value=3> 3 </option>
									<option value=4> 4 </option>
									<option value=5> 5 </option>
								</select>
							</td>
						</tr>
						
						<tr>
							<td>
								<h3>Student ID : </h3>
							</td>
							<td>
								<select type="select" placeholder="Select Student ID" id = "studentid" name = "studentid" required>
									<option value = "" selected> Select Student ID </option>
									<%
									for(Student s : sl)
									{
									%>
									<option value = "<%=s.getUid()%>"> <%=s.getUid()%> </option>
									<%
									}
									%>
								</select>
							</td>
						</tr>
						
						<tr>
							<td>
								<h3>Department : </h3>
							</td>
							<td>
								<select type="select" placeholder="Select Department" id = "dept" name = "dept" required>
									<option value = "" selected> Select Department </option>
									<option value = "CSE"> CSE </option>
									<option value = "ECE"> ECE </option>
									<option value = "CE"> CE </option>
								</select>
							</td>
						</tr>
					</table>
		<button type = "submit"> Add Course </button>
		</h3>
		</fieldset>
		</form>
    </body>
</html>
<%
	}
%>