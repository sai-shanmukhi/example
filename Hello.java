import java.io.IOException;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		 response.setContentType("text/html");
	        PrintWriter printWriter  = response.getWriter();
	        //printWriter.println("<h1>Hello World!</h1>");
	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver");
	        }
	        catch(ClassNotFoundException e)
	        {
	            System.out.println(e.getMessage());
	        }
	        try
	        {
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","mylife@123");
	            Statement st = con.createStatement();
	            ResultSet rs= st.executeQuery("select * FROM employ");
	            response.setContentType("text/html");
	            PrintWriter pw = response.getWriter();
	            pw.println("<h1> Employee table </h1>");
	            String str = "<table><tr><th>Emp-id </th><th> Name </th><th> Department</th></tr>";
	            while(rs.next())
	            {
	                /*String id1 = rs.getString(1);
	                String id2 = rs.getString(2);
	                String id3 = rs.getString(3);
	                System.out.println(id1);
	                System.out.println(id2);*/
	                str += "<tr><td>"+rs.getString(1)+" </td><td> "+rs.getString(2)+" </td><td> "+ rs.getString(3)+"</td></tr>";
	                
	            }
	            str += "</table>";
	            pw.println(str);
	            st.close();
	            con.close();
	        }
	        catch(SQLException e)
	        {
	            System.out.println(e.getMessage());    
	        }
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
