package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modal.*;

public final class passwordAdmin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!--\t-->\n");

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
      out.write("        input\n");
      out.write("\t\t{\n");
      out.write("\t\t\twidth: 250px;\n");
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
      out.write("\t\tfunction checkPwd() {\n");
      out.write("\t\t\tvar p1 = document.getElementById(\"pwd\").value;\n");
      out.write("\t\t\tvar p2 = document.getElementById(\"repwd\").value;\n");
      out.write("\t\t\tvar output = document.getElementById(\"output\");\n");
      out.write("\t\t\tvar submit = document.getElementById(\"submit\");\n");
      out.write("\t\t\tif(p1 != p2)\n");
      out.write("\t\t\t{\n");
      out.write("\t\t\t\toutput.innerHTML = \"Passwords don't match\";\n");
      out.write("\t\t\t\toutput.style.visibility = \"visible\";\n");
      out.write("\t\t\t\tsubmit.style.visibility = \"hidden\";\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\telse\n");
      out.write("\t\t\t{\n");
      out.write("\t\t\t\toutput.style.visibility = \"hidden\";\n");
      out.write("\t\t\t\tsubmit.style.visibility = \"visible\";\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}\n");
      out.write("\t\t</script>\n");
      out.write("\t</head>\n");
      out.write("    <body bgcolor = \"white\">\n");
      out.write("\t<form style = \"margin: 0px 20px 20px 20px;\" action=\"updatePwdAdmin\" method = \"POST\">\n");
      out.write("\t\t<fieldset>\n");
      out.write("\t\t<legend><h2> Change Password : </h2></legend>\n");
      out.write("\t\t<button type = \"submit\" id = \"submit\" style = \"float: right;\"> Update Password </button>\n");
      out.write("\t\t<a href = \"dashboardAdmin.jsp\"><button type = \"button\" style = \"float: right;\"> Cancel </button></a>\n");
      out.write("        <span id = \"output\" style = \"visibility: hidden;color: red;float: left;\">Hello</span>\n");
      out.write("\t\t<center>\n");
      out.write("        <br><br>\n");
      out.write("        <table style = \"width: 85%;border-collapse: collapse;margin: 0px 20px 20px 20px;\">\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<th> Current Password : </th>\n");
      out.write("\t\t\t\t<td> <input type=\"password\" placeholder=\"Current Password\" id = \"oldpwd\" name = \"oldpwd\" minlength=8 required></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<th> New Password : </th>\n");
      out.write("\t\t\t\t<td> <input type=\"password\" placeholder=\"Password (min 8 characters)\" id = \"pwd\" name = \"pwd\" onchange = \"checkPwd()\" minlength=8 required></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<th> Confirm New Password : </th>\n");
      out.write("\t\t\t\t<td> <input type=\"password\" placeholder=\"Retype Password\" id = \"repwd\" name = \"repwd\" onchange = \"checkPwd()\" minlength=8 required></td>\n");
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
