/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;
import java.sql.*;
import javax.servlet.*;
import java.util.ArrayList;
/**
 *
 * @author Sarthak Jain
 */
public class TeacherDAO {
    String uname;
	String uid;
    public boolean validateUser(String uid, String pwd)
    {
		String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "SELECT * FROM teacher WHERE tid = ? AND pwd = ?;";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, uid);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				System.out.println("Checking the teacher table.<br>");
				
				this.uname = rs.getString(4);
				this.uid = rs.getString(2);
				
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
	
	public boolean save(Teacher t)
    {
		String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "INSERT INTO teacher (tid, pwd, name, email, contactNo, dept, coursecode) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, t.getTid());
			pstmt.setString(2, t.getPwd());
			pstmt.setString(3, t.getName());
			pstmt.setString(4, t.getEmail());
			pstmt.setLong(5, t.getContactNo());
			pstmt.setString(6, t.getDept());
			pstmt.setString(7, t.getCoursecode());
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
	
    public boolean update(Teacher t)
    {
		String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "UPDATE teacher SET name = ?, email = ?, contactNo = ? WHERE tid = ?;";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(4, t.getTid());
			pstmt.setString(1, t.getName());
			pstmt.setString(2, t.getEmail());
			pstmt.setLong(3, t.getContactNo());
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
        
	public boolean updatePwd(String tid, String oldpwd, String pwd)
    {
		String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query1 = "SELECT * FROM teacher WHERE tid = ? AND pwd = ?;";
			PreparedStatement pstmt1 = con.prepareStatement(query1);
			pstmt1.setString(1, tid);
			pstmt1.setString(2, oldpwd);
			
			ResultSet rs = pstmt1.executeQuery();
			if(rs.next())
			{
				String query2 = "UPDATE teacher SET pwd = ? WHERE tid = ?";
				PreparedStatement pstmt2 = con.prepareStatement(query2);
				
				pstmt2.setString(2, tid);
				pstmt2.setString(1, pwd);
				
				if(pstmt2.executeUpdate() > 0)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
				return false;
		}
        catch(Exception e)
        {
            System.out.println(e + "<br>");
        }
        return false;
    }
	
	public Teacher showData(String uid)
    {
		String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		Teacher t = new Teacher();
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "SELECT tid, name, email, contactNo, dept FROM teacher WHERE tid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, uid);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			t.setTid(rs.getString(1));
			t.setName(rs.getString(2));
			t.setEmail(rs.getString(3));
			t.setContactNo(rs.getLong(4));
                        t.setDept(rs.getString(5));
		}
        catch(Exception e)
        {
            System.out.println(e + "<br>");
        }
        return t;
    }
	
        public ArrayList <Courses> showCourses(String uid)
    {
		String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
                ArrayList <Courses> cl = new ArrayList<>();
		Teacher t = new Teacher();
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "SELECT coursecode FROM teacher WHERE tid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, uid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
                        {
                            String coursecode = rs.getString(1);
                            
                            String query2 = "SELECT DISTINCT coursecode, title, credits, dept FROM courses WHERE coursecode = ?";
                            PreparedStatement pstmt2 = con.prepareStatement(query2);
                            pstmt2.setString(1, coursecode);
                            ResultSet rs2 = pstmt2.executeQuery();
                            while(rs2.next())
                            {
                                Courses c = new Courses();
                                c.setCoursecode(rs2.getString(1));
                                c.setTitle(rs2.getString(2));
                                c.setCredits(rs2.getInt(3));
                                c.setDept(rs2.getString(4));
                                cl.add(c);
                            }
                        }
		}
        catch(Exception e)
        {
            System.out.println(e + "<br>");
        }
        return cl;
    }
        
        public int countStudents(String coursecode)
        {
                int cnt = 0;
                String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "SELECT count(studentid) FROM courses WHERE coursecode = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, coursecode);
			ResultSet rs = pstmt.executeQuery();
                        rs.next();
			cnt = rs.getInt(1);
		}
        catch(Exception e)
        {
            System.out.println(e + "<br>");
        }
            return cnt;
        }
        
        public ArrayList <Courses> showStudents(String uid)
    {
            String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
                ArrayList <Courses> cl = new ArrayList<>();
		Teacher t = new Teacher();
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "SELECT coursecode FROM teacher WHERE tid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, uid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
                        {
                            String coursecode = rs.getString(1);
                            
                            String query2 = "SELECT * FROM courses WHERE coursecode = ?";
                            PreparedStatement pstmt2 = con.prepareStatement(query2);
                            pstmt2.setString(1, coursecode);
                            ResultSet rs2 = pstmt2.executeQuery();
                            while(rs2.next())
                            {
                                Courses c = new Courses();
                                c.setCoursecode(rs2.getString(2));
                                c.setTitle(rs2.getString(3));
                                c.setCredits(rs2.getInt(4));
                                c.setStudentid(rs2.getInt(5));
                                c.setMarks(rs2.getInt(6));
                                c.setDept(rs2.getString(7));
                                cl.add(c);
                            }
                        }
		}
        catch(Exception e)
        {
            System.out.println(e + "<br>");
        }
        return cl;
    }
        
	public String getUname()
	{
		return uname;
	}
	public String getUid()
	{
		return uid;
	}
}
