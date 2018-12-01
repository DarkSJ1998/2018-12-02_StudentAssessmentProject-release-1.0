<%-- 
    Document   : logout
    Created on : Nov 12, 2018, 9:13:18 PM
    Author     : Sarthak Jain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // HttpSession session = request.getSession();
    session.invalidate();
    %>
    <script>
	alert("Log out successful!");
	location = 'index.html';
    </script>
    <%
%>