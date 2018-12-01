/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
/**
 *
 * @author Sarthak Jain
 */
public class StudentDAO {
	String uname;
	int uid;
    public boolean validateUser(int uid, String pwd)
    {
		String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "SELECT * FROM student WHERE uid = ? AND pwd = ?;";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, uid);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				System.out.println("Checking the student table.<br>");
				
				this.uname = rs.getString(4);
				this.uid = rs.getInt(2);
				
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
	
	public boolean save(Student s)
    {
		String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "INSERT INTO student (uid, pwd, name, email, fathersName, mothersName, contactNo, dept) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, s.getUid());
			pstmt.setString(2, s.getPwd());
			pstmt.setString(3, s.getName());
			pstmt.setString(4, s.getEmail());
			pstmt.setString(5, s.getFathersName());
			pstmt.setString(6, s.getMothersName());
			pstmt.setLong(7, s.getContactNo());
			pstmt.setString(8, s.getDept());
                        
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
	
	public boolean update(Student s)
    {
		String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "UPDATE student SET name = ?, email = ?, fathersName = ?, mothersName = ?, contactNo = ? WHERE uid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(6, s.getUid());
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getEmail());
			pstmt.setString(3, s.getFathersName());
			pstmt.setString(4, s.getMothersName());
			pstmt.setLong(5, s.getContactNo());
			
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
	
	public boolean updatePwd(int uid, String oldpwd, String pwd)
    {
		String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query1 = "SELECT * FROM student WHERE uid = ? AND pwd = ?;";
			PreparedStatement pstmt1 = con.prepareStatement(query1);
			pstmt1.setInt(1, uid);
			pstmt1.setString(2, oldpwd);
			
			ResultSet rs = pstmt1.executeQuery();
			if(rs.next())
			{
				String query2 = "UPDATE student SET pwd = ? WHERE uid = ?";
				PreparedStatement pstmt2 = con.prepareStatement(query2);
				
				pstmt2.setInt(2, uid);
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
	
	public Student showData(int uid)
    {
		String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		Student s = new Student();
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "SELECT uid, name, email, fathersName, mothersName, contactNo, dept FROM student WHERE uid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			s.setUid(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setEmail(rs.getString(3));
			s.setFathersName(rs.getString(4));
			s.setMothersName(rs.getString(5));
			s.setContactNo(rs.getLong(6));
                        s.setDept(rs.getString(7));
		}
        catch(Exception e)
        {
            System.out.println(e + "<br>");
        }
        return s;
    }
	
	public ArrayList <Courses> showCourses(int uid)
	{
		ArrayList <Courses> cl = new ArrayList<>();
		
		String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "SELECT coursecode, title, credits, dept FROM courses WHERE studentid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, uid);
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
	
	public ArrayList <Courses> showMarks(int uid)
	{
		ArrayList <Courses> cl = new ArrayList<>();
		
		String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "SELECT coursecode, title, marks FROM courses WHERE studentid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				Courses c = new Courses();
				
				c.setCoursecode(rs.getString(1));
				c.setTitle(rs.getString(2));
				c.setMarks(rs.getInt(3));
				
				cl.add(c);
			}
		}
        catch(Exception e)
        {
            System.out.println(e + "<br>");
        }
        return cl;
	}
	
	public int countCourses(int uid)
	{
		String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		int cnt = 0;
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "SELECT count(*) FROM courses WHERE studentid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, uid);
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
	
	public String getUname()
	{
		return uname;
	}
	public int getUid()
	{
		return uid;
	}
}
