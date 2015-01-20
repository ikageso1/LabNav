import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

public class ProfileServlet	extends HttpServlet {

	static final long serialVersionUID = 1L;
	/**
	 *	  @brief
	 *
	 */ 
	public void init() throws ServletException {
		if(this.getServletContext().getAttribute("labnav") == null){
			this.getServletContext().setAttribute("labnav",new LabNav());
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String userId = (String)request.getSession().getAttribute("userId");
    Boolean isTeacher = (Boolean)request.getSession().getAttribute("isTeacher");
		

		try{
			// load
			Class.forName("org.sqlite.JDBC");
		}catch(ClassNotFoundException e){
			System.err.println(e);
			System.exit(-1);
		}
		Connection connection = null;

		try{
			connection = DriverManager.getConnection("jdbc:sqlite:webdb/B14.sqlite3");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.

			if(!isTeacher.booleanValue()){
				ResultSet rs = statement.executeQuery("SELECT * FROM assignedLab WHERE name ='" +userId+ "';");
				if(rs.next()){
					String url = "http://ecl.info.kindai.ac.jp/14/isp2/warup/servlet/B14/profile_after.html";
					//String url = "./profile_after.html";
					response.sendRedirect(url);
				}else{
					String url = "http://ecl.info.kindai.ac.jp/14/isp2/warup/servlet/B14/profile_before.html";	
					//String url = "./profile_before.html";	
					response.sendRedirect(url);
				}
			}else{
				String url = "http://ecl.info.kindai.ac.jp/14/isp2/warup/servlet/B14/profile_lab.html";	
				//String url = "./profile_lab.html";	
				response.sendRedirect(url);
			}
		}catch(SQLException e){
			System.err.println(e.getMessage());
			System.exit(-1);
		}finally{
			try{
				if(connection != null)
					connection.close();
			}catch(SQLException e){
				System.err.println(e);
				System.exit(-1);
			}
		}
	}
}

