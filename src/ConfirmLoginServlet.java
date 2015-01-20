import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmLoginServlet extends HttpServlet {

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

		response.setContentType("application/json;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.append('{');
		if(userId != null){
			writer.append("\"login\":\"").append("true").append("\"");
		}else{
			writer.append("\"login\":\"").append("false").append("\"");
		}
		writer.append('}');
		writer.flush();
	}
}

