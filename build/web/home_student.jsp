<%-- 
    Document   : home_student
    Created on : Nov 9, 2018, 10:32:32 PM
    Author     : Sarthak Jain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--	-->
<%
	if(request.getSession().getAttribute("loggedIn") == null)
	{
		%>
		<script>
			alert("You need to be logged in!");
			location = 'index.html';
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
    else if(request.getSession().getAttribute("user").equals("admin"))
    {
		%>
		<script>
			alert("Redirecting...");
			location = 'home_admin.jsp';
		</script>
		<%
    }
	else
	{
%>
<html>
    <head>
        <title>ScoreBook | Home - Student Panel</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="sources\logo_circle.png">
		<style>
		@font-face
		{
			font-family: DS Digi;
			src: url('sources/DS-DIGI.TTF')
		}
		@font-face
		{
			font-family: Orange Juice;
			src: url('sources/orange juice 2.0.ttf');
		}
		*
		{
			font-family: Segoe UI;
		}
		legend
		{
			color: crimson;
		}
		iframe
		{
			border: 10px solid grey;
			border-radius: 10px;
		}
		button
		{
			padding: 10px 10px 10px 10px;
			border-radius: 5px;
			background-color: crimson;
			color: white;
			float: right;
			font-size: 20px;
			font-family: Impact;
			margin: 0px 5px 5px 0px;
		}
		button:hover
		{
			background-color: black;
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
		h2
		{
			float: right;
			color: crimson;
			font-family: Segoe Print;
			background-color: white;
			border-radius: 10px;
			padding: 10px;
		}
		h2:hover
		{
			color: black;
			cursor: default;
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
		</script>
    </head>
    <body background = "sources\grey-chevron-stripes-1920.png" style = "background-attachment: fixed;">
		<%
			String uname = (String)session.getAttribute("uname");
			Integer uid = (Integer)session.getAttribute("uid");
		%>
		<script>
		alert('Welcome <%=uname%> (<%=uid%>)!');
		
		setInterval(updateTime, 1000);
		</script>
		<div id = "timebox"> Time will load up here shortly... </div>
		<div style = "margin: 50px 100px 100px 100px;">
		<a href = "dashboardStudent.jsp" target = "output"><img src="sources/logo_horizontal.png" style = "height: 100px;float: left;" id="logo"></a>
		
		<a href = "logout.jsp" target = "_top"><button type="button"> Logout </button></a>
		<br><br>
		<h2> Welcome <%=uname%>! [<%=uid%>]</h2>
        <iframe src = "buttons_student.html" name = "tabs" width = "100%" height = "44px"> iframe1 </iframe><br><br>
		<iframe src = "dashboardStudent.jsp" name = "output" width = "100%" height = "600px"> iframe2 </iframe>
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