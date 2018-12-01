package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modal.*;

public final class dashboardAdminEdit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");

	if(request.getSession().getAttribute("loggedIn") == null)
	{
		session.invalidate();
		
      out.write("\n");
      out.write("\t\t<body bgcolor = \"white\">\n");
      out.write("\t\t<h2 style = \"color: crimson;padding: 10px;\"> Session expired. Please reload the page.</h2>\n");
      out.write("\t\t</body>\n");
      out.write("\t\t");

	}
	else
	{

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t\t<style>\n");
      out.write("\t\t*\n");
      out.write("\t\t{\n");
      out.write("\t\t\tfont-family: Segoe UI;\n");
      out.write("\t\t}\n");
      out.write("\t\ttable,th,td\n");
      out.write("\t\t{\n");
      out.write("\t\t\tfont-family: Calibri;\n");
      out.write("\t\t\tfont-size: 20px;\n");
      out.write("\t\t\tpadding: 20px;\n");
      out.write("\t\t}\n");
      out.write("\t\tth\n");
      out.write("\t\t{\n");
      out.write("\t\t\ttext-align: right;\n");
      out.write("\t\t}\n");
      out.write("\t\th2\n");
      out.write("\t\t{\n");
      out.write("\t\t\tcolor: crimson;\n");
      out.write("\t\t\tpadding: 10px;\n");
      out.write("\t\t}\n");
      out.write("\t\tinput\n");
      out.write("\t\t{\n");
      out.write("\t\t\twidth: 200px;\n");
      out.write("\t\t}\n");
      out.write("\t\tbutton\n");
      out.write("\t\t{\n");
      out.write("\t\t\tborder-radius: 20px;\n");
      out.write("\t\t\tbackground-color: crimson;\n");
      out.write("\t\t\tcolor: white;\n");
      out.write("\t\t\tfont-size: 20px;\n");
      out.write("\t\t\tpadding: 10px;\n");
      out.write("\t\t\tmargin: 0px 5px 5px 0px;\n");
      out.write("\t\t}\n");
      out.write("\t\tbutton:hover\n");
      out.write("\t\t{\n");
      out.write("\t\t\tbackground-color: green;\n");
      out.write("\t\t}\n");
      out.write("\t\t</style>\n");
      out.write("\t\t<script type=\"text/javascript\">\n");
      out.write("\t\tfunction checkTel()\n");
      out.write("\t\t{\n");
      out.write("\t\t\tvar tel = document.getElementById(\"tel\").value;\n");
      out.write("\t\t\tif(tel > 9999999999 || tel < 1000000000 || isNaN(tel))\n");
      out.write("\t\t\t{\n");
      out.write("\t\t\t\tdocument.getElementById(\"output\").innerHTML = \"*Invalid Phone number.\";\n");
      out.write("\t\t\t\tdocument.getElementById(\"output\").style.visibility = 'visible';\n");
      out.write("\t\t\t\tdocument.getElementById('submit').style.visibility = 'hidden';\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\telse\n");
      out.write("\t\t\t{\n");
      out.write("\t\t\t\tdocument.getElementById(\"output\").innerHTML = \"\";\n");
      out.write("\t\t\t\tdocument.getElementById(\"output\").style.visibility = 'hidden';\n");
      out.write("\t\t\t\tdocument.getElementById('submit').style.visibility = 'visible';\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}\n");
      out.write("\t\t</script>\n");
      out.write("\t</head>\n");
      out.write("    <body bgcolor = \"white\">\n");
      out.write("\t");

		AdminDAO adao = new AdminDAO();
		Admin a = adao.showData((String)session.getAttribute("id"));
	
      out.write("\n");
      out.write("\t<form style = \"margin: 0px 20px 20px 20px;\" action=\"updateAdminData\" method = \"POST\">\n");
      out.write("\t\t<fieldset>\n");
      out.write("\t\t<legend><h2> Your Details : </h2></legend>\n");
      out.write("\t\t<button type = \"submit\" id = \"submit\" style = \"float: right;\"> Update Details </button>\n");
      out.write("\t\t<a href = \"dashboardAdmin.jsp\"><button type = \"button\" style = \"float: right;\"> Cancel </button></a>\n");
      out.write("\t\t<span id = \"output\" style = \"visibility: hidden;color: red;float: left;\">Hello</span>\n");
      out.write("\t\t<center>\n");
      out.write("\t\t<br><br><br>\n");
      out.write("        <table border = \"1px solid grey\" style = \"width: 85%;border-collapse: collapse;margin: 0px 20px 20px 20px;\">\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<th> Admin ID : </th>\n");
      out.write("\t\t\t\t<td> ");
      out.print(a.getUid());
      out.write("</td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<th> Name : </th>\n");
      out.write("\t\t\t\t<td> <input type=\"text\" name = \"aname\" id = \"aname\" value = \"");
      out.print(a.getName());
      out.write("\" autofocus required></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<th> Email ID : </th>\n");
      out.write("\t\t\t\t<td> <input type=\"email\" name=\"email\" id=\"email\" value=\"");
      out.print(a.getEmail());
      out.write("\" required></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<th> Contact No : </th>\n");
      out.write("\t\t\t\t<td> <input type=\"tel\" id = \"tel\" name = \"tel\" onchange = \"checkTel()\" minlength=10 value = \"");
      out.print(a.getContactNo());
      out.write("\" required></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t<table>\n");
      out.write("\t\t</center>\n");
      out.write("\t\t</fieldset>\n");
      out.write("\t\t</form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");

	}

    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
