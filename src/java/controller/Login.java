/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modal.Student;
import modal.StudentDAO;
import modal.Admin;
import modal.AdminDAO;
import modal.*;
/**
 *
 * @author Sarthak Jain
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
		PrintWriter out = response.getWriter();
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		
		try
		{
			int uid_num = Integer.parseInt(uid);
			StudentDAO sdao = new StudentDAO();
			
			if(sdao.validateUser(uid_num, pwd))
			{
				HttpSession session = request.getSession();
				
				session.setAttribute("uname",sdao.getUname());
				session.setAttribute("uid",sdao.getUid());
				
				session.setAttribute("loggedIn","true");
				session.setAttribute("user","student");
				
				RequestDispatcher rd = request.getRequestDispatcher("home_student.jsp");
				rd.forward(request, response);
			}
			else
			{
				out.println("<script> alert('Invalid student ID.'); location = 'index.html'; </script>");
			}
		}
		catch(NumberFormatException e)
		{
			boolean admin = true;				// false indicates teacher & true indicates admin
			for(int i=0;i<uid.length();i++)
			{
				if(uid.charAt(i) >= '0' && uid.charAt(i) <= '9')
				{
					admin = false;
					break;
				}
			}
			if(admin == true)
			{
				AdminDAO adao = new AdminDAO();
				/*
                                for normal JDBC
				if(adao.validateUser(uid, pwd))
				{
					HttpSession session = request.getSession();
					
					session.setAttribute("uname",adao.getUname());
					session.setAttribute("id",adao.getId());
					
					session.setAttribute("loggedIn","true");
					session.setAttribute("user","admin");
					
					RequestDispatcher rd = request.getRequestDispatcher("home_admin.jsp");
					rd.forward(request, response);
				}
                                */
                                // for Hibernate
                                Admin a = new Admin();
                                a.setUid(uid);
                                a.setPwd(pwd);
                                if(adao.validateUser(a))
                                {
                                    HttpSession session = request.getSession();
                                    
                                    session.setAttribute("uname",adao.getUname());
                                    session.setAttribute("uid",adao.getUid());
                                    
                                    session.setAttribute("loggedIn","true");
                                    session.setAttribute("user","admin");
				
                                    RequestDispatcher rd = request.getRequestDispatcher("home_admin.jsp");
                                    rd.forward(request, response);
                                }
				else
				{
					out.println("<script> alert('Invalid Admin ID'); location = 'index.html'; </script>");
				}
			}
			else
			{
				TeacherDAO tdao = new TeacherDAO();
				
				if(tdao.validateUser(uid, pwd))
				{
					HttpSession session = request.getSession();
					
					session.setAttribute("uname",tdao.getUname());
					session.setAttribute("uid",tdao.getUid());
					
					session.setAttribute("loggedIn","true");
					session.setAttribute("user","teacher");
					
					RequestDispatcher rd = request.getRequestDispatcher("home_teacher.jsp");
					rd.forward(request, response);
				}
				else
				{
					out.println("<script> alert('Invalid Teacher ID'); location = 'index.html'; </script>");
				}
			}
		}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
