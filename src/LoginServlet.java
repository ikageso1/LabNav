import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutSrervlet extends HttpServlet {

    static final long serialVersionUID = 1L;
    public void init() throws ServletException {
	// this.getServletContext().setAttribute("visitNum","0");
	
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	Number number = new Number();
	String loginId = request.getParameter("loginId");
	String password = request.getParameter("password");
	
	LabNav labnav = request.getServletContext().getAttribute("labnav");
	
	boolean isOK = labnav.login(loginId,password);

	// Jasnに変換
	response.setContentType("application/json");
	PrintWriter writer = response.getWriter();
	writer.append('{');
	if(isOK)writer.append("\"ok\":\"").append("true").append("\"");
	else writer.append("\"ok\":\"").append("false").append("\"");

	writer.append('}');
	writer.flush();
	
    }
}
