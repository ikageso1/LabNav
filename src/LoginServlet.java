import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String loginId = request.getParameter("userId");
		String password = request.getParameter("Password");

		LabNav labnav = (LabNav)this.getServletContext().getAttribute("labnav");

		boolean isOK = labnav.login(loginId,password,request);

		System.out.println(loginId);
		System.out.println(password);

		if(isOK){
			String url = "http://localhost:8080/LabNav/B14/labNavi/main.html";
			response.sendRedirect(url);
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.append("<p>ID or Password is wrong.</p>");
			writer.flush();
		}
	}
}

