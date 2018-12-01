<%-- 
    Document   : createStudent
    Created on : Nov 19, 2018, 10:57:41 AM
    Author     : Sarthak Jain
--%>

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
	else if(request.getSession().getAttribute("user").equals("teacher"))
    {
		%>
		<script>
			alert("Redirecting...");
			location = 'home_teacher.jsp';
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
        <title>ERP - Beta Version | New Student Registration</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
		function checkId()
		{
			var sid = document.getElementById('sid').value;
			if(sid > 1811981999 || sid < 1511981000 || isNaN(sid))
			{
				document.getElementById("output").innerHTML = "*Invalid Student ID";
				document.getElementById("output").style.visibility = 'visible';
				document.getElementById('submit').style.visibility = 'hidden';
			}
			else
			{
				document.getElementById("output").innerHTML = "";
				document.getElementById('submit').style.visibility = 'visible';
			}
		}
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
        <div style = "background-color:white;padding: 0px 20px 20px 20px;">
			<form id = "new-student-form" action = "addStudent" method="POST">
				<fieldset>
					<legend align="center">
						<h1> Create New Student Account </h1>
					</legend>
					<center>
					<table>
						<tr>
							<td>
								<h3>Name : </h3>
							</td>
							<td>
								<input type="text" placeholder="Name" name = "sname" id = "sname" autofocus required>
							</td>
						</tr>
						
						<tr>
							<td>
								<h3>College ID : </h3>
							</td>
							<td>
								<input type="text" placeholder="ID" name = "sid" id = "sid" onchange = "checkId()" required>
							</td>
						</tr>
						
						<tr>
							<td>
								<h3>Email ID : </h3>
							</td>
							<td>
								<input type="email" placeholder="E-mail ID here" name = "email" id = "email" required>
							</td>
						</tr>
						
						<tr>
							<td>
								<h3>Father's Name : </h3>
							</td>
							<td>
								<input type="text" placeholder="Father's Name" name = "fname" required>
							</td>
						</tr>
						
						<tr>
							<td>
								<h3>Mother's Name : </h3>
							</td>
							<td>
								<input type="text" placeholder="Mother's Name" name = "mname" required>
							</td>
						</tr>
						
						<tr>
							<td>
								<h3>Set Password : </h3>
							</td>
							<td>
								<input type="password" placeholder="Password (min 8 characters)" id = "pwd" name = "pwd" onchange = "checkPwd()" minlength=8 required>
							</td>
						</tr>
						
						<tr>
							<td>
								<h3>Confirm Password : </h3>
							</td>
							<td>
								<input type="password" placeholder="Retype Password" id = "repwd" name = "repwd" onchange = "checkPwd()" minlength=8 required>
							</td>
						</tr>
						
						<tr>
							<td>
								<h3>Contact No : </h3>
							</td>
							<td>
								<input type="tel" placeholder="Contact No." id = "tel" name = "tel" onchange = "checkTel()" minlength=10 required>
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
					<br>
                    <span id = "output" style = "visibility: hidden;color: red;">Hello</span>
					<br>
					<button type = "submit" id = "submit"> Submit </button><br>
					<button type = "reset" id = "reset"> Reset Form </button><br>
					
					</center>
				</fieldset>
			</form>
		</div>
    </body>
</html>
<%
	}
%>