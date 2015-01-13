import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutSrervlet extends HttpServlet {

    static final long serialVersionUID = 1L;
    /**
		 * @brief 初期化処理を行う.
		 * labnavが未格納の場合は、入れる
		 */ 
		public void init() throws ServletException {
		 if(this.getServletContext().getAttribute("labnav") == null){
				this.getServletContext().setAttribute("labnav",new LabNav());
		 }
		}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	String loginId = request.getParameter("loginId");
	String password = request.getParameter("password");
	
	LabNav labnav = request.getServletContext().getAttribute("labnav");
	
	boolean isOK = labnav.login(loginId,password);

	// Jasnに変換
	response.setContentType("application/json");
	PrintWriter writer = response.getWriter();
	writer.append('{');
<<<<<<< HEAD
	if(isOK)writer.append("\"login\":\"").append(true).append("\"");
	else writer.append("\"login\":\"").append(false).append("\"");
=======
	if(isOK)writer.append("\"login\":\"").append("true").append("\"");
	else writer.append("\"login\":\"").append("false").append("\"");
>>>>>>> FETCH_HEAD

	writer.append('}');
	writer.flush();
	
    }
}
