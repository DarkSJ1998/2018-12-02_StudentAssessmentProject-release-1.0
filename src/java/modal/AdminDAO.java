/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;
import java.sql.*;
import javax.servlet.*;

import org.hibernate.cfg.*;
import org.hibernate.*;
/**
 *
 * @author Sarthak Jain
 */
public class AdminDAO {
	String uname;
	String uid;
	
	// For Hibernate
	public boolean validateUser(Admin a)
	{
		Admin aa = null;
		
        try
		{
			Configuration cf = new Configuration();
			
			cf.configure("hibernatecfg/hibernate.cfg.xml");
			
			SessionFactory sf = cf.buildSessionFactory();
			
			Session s = sf.openSession();
			
			aa = (Admin)s.get(Admin.class, a.getUid());
			
			s.close();
			
			sf.close();
			
			this.uname = aa.getName();
			this.uid = aa.getUid();
				
			if(aa == null)
				return false;
			else if(aa.getUid().equals(a.getUid()) && aa.getPwd().equals(a.getPwd()))
				return true;
			else
				return false;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
		return false;
	}
	
        // For normal JDBC
	/*
    public boolean validateUser(String uid, String pwd)
    {
        String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "SELECT * FROM admin WHERE uid = ? AND pwd = ?;";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, uid);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				System.out.println("Checking the admin table.<br>");
				
				this.uname = rs.getString(4);
				this.id = rs.getInt(1);
				
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
	*/
	public boolean update(Admin a)
    {
		String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "UPDATE admin SET name = ?, email = ?, contactNo = ? WHERE uid = ?;";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(4, a.getUid());
			pstmt.setString(1, a.getName());
			pstmt.setString(2, a.getEmail());
			pstmt.setLong(3, a.getContactNo());
                        System.out.println(a.getUid() + " " + a.getName() + " " + a.getEmail() + " " + a.getContactNo());
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
    
	public boolean updatePwd(String uid, String oldpwd, String pwd)
    {
		String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query1 = "SELECT * FROM admin WHERE uid = ? AND pwd = ?;";
			PreparedStatement pstmt1 = con.prepareStatement(query1);
			pstmt1.setString(1, uid);
			pstmt1.setString(2, oldpwd);
			
			ResultSet rs = pstmt1.executeQuery();
			if(rs.next())
			{
				String query2 = "UPDATE admin SET pwd = ? WHERE uid = ?";
				PreparedStatement pstmt2 = con.prepareStatement(query2);
				
				pstmt2.setString(2, uid);
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
	
	public Admin showData(String uid)
    {
		String url = "jdbc:mysql://localhost:3306/projectdb?useSSL=false";
		Admin a = new Admin();
		
        try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, MyAccount.UNAME, MyAccount.PWD);
			
			String query = "SELECT uid, name, contactNo, email FROM admin WHERE uid = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, uid);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			System.out.println("Setting instance values");
			a.setUid(rs.getString(1));
			a.setName(rs.getString(2));
			a.setContactNo(rs.getLong(3));
			a.setEmail(rs.getString(4));
		}
        catch(Exception e)
        {
            System.out.println(e + "<br>");
            e.printStackTrace();
        }
        return a;
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
