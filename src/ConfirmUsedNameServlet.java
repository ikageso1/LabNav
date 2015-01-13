import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmUsedNameServlet extends HttpServlet {

    static final long serialVersionUID = 1L;
    public void init() throws ServletException {
	// this.getServletContext().setAttribute("visitNum","0");
	
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	String loginId = request.getParameter("loginId");
	
	LabNav labnav = (LabNav)getServletContext().getAttribute("labnav");
	
	boolean isOK = labnav.confirm_usedname(loginId);

	// Jasnに変換
	response.setContentType("application/json");
	PrintWriter writer = response.getWriter();
	writer.append('{');
	if(isOK)writer.append("\"login\":\"").append("true").append("\"");
	else writer.append("\"login\":\"").append("false").append("\"");
	writer.append('}');
	writer.flush();
	
    }
}
