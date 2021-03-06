import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmUsedNameServlet extends HttpServlet {

	static final long serialVersionUID = 1L;
	public void init() throws ServletException {
		if(this.getServletContext().getAttribute("labnav")==null){
		   this.getServletContext().setAttribute("labnav",new LabNav());
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String loginId = request.getParameter("fieldValue");

		LabNav labnav = (LabNav)getServletContext().getAttribute("labnav");

		boolean isOK = labnav.confirm_usedname(loginId);

		// Jasnに変換
	String fieldId = (String)request.getAttribute("fieldId");
	response.setContentType("application/json");
	PrintWriter writer = response.getWriter();
	writer.append('[');
  writer.append("\"userId\"").append(",");
	if(isOK)writer.append("true,\"\""); //,\"you can use this name.\"");
	else writer.append("false,\"\""); // ,\"your name has been used.\"");
	writer.append(']');
	writer.flush();
	
    }
}
