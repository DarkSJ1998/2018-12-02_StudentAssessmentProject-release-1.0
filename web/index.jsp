<%-- 
    Document   : index
    Created on : Nov 12, 2018, 10:59:37 PM
    Author     : Sarthak Jain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%
	if(request.getSession().getAttribute("loggedIn") == "true")
	{
		%>
		<script>
		alert("Redirecting back to your logged in session...");
		<%
		if(request.getSession().getAttribute("user").equals("admin"))
        {
			%>
			location = "home_admin.jsp";
			<%
        }
        else if(request.getSession().getAttribute("user").equals("student"))
        {
			%>
			location = "home_student.jsp";
            <%
        }
		else if(request.getSession().getAttribute("user").equals("teacher"))
        {
			%>
			location = "home_teacher.jsp";
            <%
        }
        %>
		</script>
		<%
	}
	else
	{
%>
<html>
    <head>
        <title>ScoreBook | Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="sources\logo_circle.png">
		<style>
		*
		{
			font-family: Segoe UI;
		}
		legend
		{
			color: crimson;
		}
		@font-face
		{
			font-family: DS Digi;
			src: url('sources/DS-DIGI.TTF')
		}
		#timebox
		{
			background-color: black;
			color: white;
			font-family: DS Digi;
			font-size: 20px;
			text-align: right;
			padding: 12px;
			border-radius: 10px;
		}
		</style>
		<script type = "text/javascript">
			function updateTime()
			{
				var d = new Date();
				var tt = "AM"
				var hh = d.getHours();
				var mm = d.getMinutes();
				var ss = d.getSeconds();

				if(parseInt(hh/10) == 0)
					hh = "0"+hh;

				if(hh > 12)
				{
					hh = hh - 12;
					tt = "PM";
				}

				if(parseInt(mm/10) == 0)
					mm = "0"+mm;

				if(parseInt(ss/10) == 0)
					ss = "0"+ss;

				document.getElementById("timebox").innerHTML = "#Time: " + hh+":"+mm+":"+ss+" "+tt+" #Date: "+d.getDate()+"/"+(d.getMonth()+1)+"/"+d.getFullYear();
			}
			function load()
			{
				var uid = document.getElementById("uid").value;
				var pwd = document.getElementById("pwd").value;
				if(uid != "" && pwd != "")
					document.getElementById("loading").style.visibility = "visible";
			}
		</script>
    </head>
    <body background = "sources\grey-chevron-stripes-1920.png" style = "background-attachment: fixed;">
		<script>
		setInterval(updateTime, 1000);
		</script>
		
		<div id = "timebox"> Time will load up here shortly... </div>
        <div style = "border: 10px solid grey;border-radius: 10px;background-color:white;margin: 200px 200px 200px 200px;padding: 0px 20px 20px 20px;">
			<form id = "login-form" action = "Login" method="POST">
				<fieldset>
					<legend align="center">
						<h1>LOGIN</h1>
					</legend>
					<center>
					<table>
						<tr>
						<td style="padding: 30px;width: 45%;"><center><img src="sources/logo.png" style = "height: 300px;width: 300px;"></center></td>
						<td>
						<center>
						<!-- <img src = "sources\ajax-loader.gif" style="width:150px;"> -->
						<span id = "loading" style = "visibility: hidden;"><video src = "sources\loading.mp4" style = "height: 150px;" autoplay loop></video><br>loading...</span>
						</center>
						</td>
						<td style="padding: 40px;width: 45%;">
						<h2>
						Login ID : <input type="text" placeholder="ID" id = "uid" name = "uid" autofocus required><br>
						Password : <input type="password" placeholder="password" id = "pwd" name = "pwd" required><br><br>
						<button type="submit" style="background-color: crimson;color: white;border: 2px dotted grey; height: 40px; width: 80px;" onclick = "load()"> Login </button>
						<br>
						
						</h2>
						</td>
						</tr>
					</table>
					</center>
				</fieldset>
			</form>
		</div>
		
		<footer>
			<center>
				<div style = "padding: 20px;color: crimson;background-color: white;width: 30%;border-radius: 20px;">
					All rights reserved | ScoreBook © 2018
				</div>
			<center>
		</footer>
    </body>
</html>
<%
	}
%>