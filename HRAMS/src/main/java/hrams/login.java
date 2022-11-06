package hrams;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet(urlPatterns="/index")

public class login extends HttpServlet{

	public void init(){} 
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException { 
		String username=req.getParameter("username"); 
		String Pass=req.getParameter("password"); 
		Connection con; 
		try { 
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hrams","root","nbu241409"); 
			Statement st=con.createStatement(); 
			int f=0; 
			String q="select * from userdata"; 
			ResultSet rs=st.executeQuery(q); 
			while(rs.next()){ 
				if(rs.getString(1).equals(username) && rs.getString(2).equals(Pass)) { 
					f=1; 
					break; 
				} 
			} 
			if(f==1) {  
				res.sendRedirect("index.html");
				
				} 
			else if(f==0) { 
				res.sendRedirect("login.html");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void destroy() { }

}
