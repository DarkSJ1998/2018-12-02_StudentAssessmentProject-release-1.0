/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import modal.Teacher;
import modal.TeacherDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sarthak Jain
 */
@WebServlet(name = "addTeacher", urlPatterns = {"/addTeacher"})
public class addTeacher extends HttpServlet {

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
		Teacher t = new Teacher();
		t.setName(request.getParameter("tname"));
		t.setTid(request.getParameter("tid"));
		t.setEmail(request.getParameter("email"));
		t.setPwd(request.getParameter("pwd"));
		t.setContactNo(Long.parseLong(request.getParameter("tel")));
		t.setDept(request.getParameter("dept"));
		t.setCoursecode(request.getParameter("coursecode"));
		TeacherDAO tdao = new TeacherDAO();
        
		out.println("<script>");
		if(tdao.save(t))
		{
			out.println("alert('Teacher account created successfully.');");
		}
		else
		{
			out.println("alert('Something happened...Account could not be created.');");
		}
		out.println("location = 'createTeacher.jsp';");
		out.println("</script>");
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
