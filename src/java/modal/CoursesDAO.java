/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Sarthak Jain
 */
public class CoursesDAO {
    public boolean updateMarks(String title, int studentid, int marks)
    {
        String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "UPDATE courses SET marks = ? WHERE title = ? AND studentid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, marks);
			pstmt.setString(2, title);
			pstmt.setInt(3, studentid);
			
			if(pstmt.executeUpdate() > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
        catch(Exception e)
        {
            System.out.println(e + "<br>");
        }
        return false;
    }
    
    public int getMarks(String title, int studentid)
    {
        String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "SELECT marks FROM courses WHERE title = ? AND studentid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, title);
			pstmt.setInt(2, studentid);
			ResultSet rs = pstmt.executeQuery();
            rs.next();
			return rs.getInt(1);
		}
        catch(Exception e)
        {
            System.out.println(e + "<br>");
        }
        return 0;
    }
    
    public ArrayList <Student> getStudents()
    {
        ArrayList <Student> sl = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
        
        try
        {
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			String query = "SELECT * FROM student;";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				Student s = new Student();
				s.setUid(rs.getInt(2));
				sl.add(s);
			}
        }
        catch(Exception e)
        {
            System.out.println(e + "<br>");
        }
        return sl;
    }
    
    public ArrayList <Courses> getCourses()
    {
        ArrayList <Courses> cl = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
        
        try
        {
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			String query = "SELECT DISTINCT coursecode, title, credits, dept FROM courses;";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				Courses c = new Courses();
				c.setCoursecode(rs.getString(1));
				c.setTitle(rs.getString(2));
				c.setCredits(rs.getInt(3));
				c.setDept(rs.getString(4));
				cl.add(c);
			}
        }
        catch(Exception e)
        {
            System.out.println(e + "<br>");
        }
        return cl;
    }
	
	public boolean assignCourse(String title, int studentid)
    {
        String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query1 = "SELECT coursecode, credits, dept FROM courses WHERE title = ?;";
			PreparedStatement pstmt1 = con.prepareStatement(query1);
			
			pstmt1.setString(1, title);
			ResultSet rs = pstmt1.executeQuery();
			rs.next();
			String coursecode = rs.getString(1);
			int credits = rs.getInt(2);
			String dept = rs.getString(3);
			
			String query2 = "INSERT INTO courses (coursecode, title, credits, studentid, dept) VALUES (?, ?, ?, ?, ?);";
			PreparedStatement pstmt2 = con.prepareStatement(query2);
			
			pstmt2.setString(1, coursecode);
			pstmt2.setString(2, title);
			pstmt2.setInt(3, credits);
			pstmt2.setInt(4, studentid);
			pstmt2.setString(5, dept);
			
			if(pstmt2.executeUpdate() > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
        catch(Exception e)
        {
            System.out.println(e + "<br>");
        }
        return false;
    }
        
        public boolean save(Courses c)
    {
        String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "INSERT INTO courses (coursecode, title, credits, studentid, dept) VALUES (?, ?, ?, ?, ?);";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, c.getCoursecode());
			pstmt.setString(2, c.getTitle());
			pstmt.setInt(3, c.getCredits());
			pstmt.setInt(4, c.getStudentid());
			pstmt.setString(5, c.getDept());
			
			if(pstmt.executeUpdate() > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
        catch(Exception e)
        {
            System.out.println(e + "<br>");
        }
        return false;
    }
}
