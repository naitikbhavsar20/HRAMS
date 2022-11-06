package hrams;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/r")

public class r extends HttpServlet{
	

    public void init()
    {
    }
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, jakarta.servlet.ServletException {
    	Connection con;
		try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrams","root","nbu241409");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String pos = req.getParameter("pos");
		String fname = req.getParameter("fname");
		String mname = req.getParameter("mname");
		String lname = req.getParameter("lname");
		String Gender = req.getParameter("flexRadioDefault");
		String Phone_no = req.getParameter("number");
		String Email = req.getParameter("email");
		String Address = req.getParameter("address");
		
		String query = "insert into application values("+"'"+pos+"',"+"'"+fname+"',"+"'"+mname+"',"+"'"+lname+"',"+"'"+Gender+"',"+"'"+Email+"',"+"'"+Phone_no+"',"+"'"+Address+"'"+")";
		Statement st = con.createStatement();
		int f=st.executeUpdate(query);
		st.close();
		con.close();
		
		if(f>0) {
			
			out.println("<h1>Application sent Succesfully</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("/r.html");  
	        rd.include(req, resp);  
			
		}
		else {
			
			out.println("<h1>Some Error Occured<br>Please Try Again</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("/r.html");  
	        rd.include(req, resp);  
			
		}
		} catch (SQLException e) {
			PrintWriter out1 = resp.getWriter();
			out1.println(e);
		}

}
}