import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterTempServlet extends HttpServlet {

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
	String loginId = (String)request.getParameter("loginId");
	String password = (String)request.getParameter("password");
	String email = (String)request.getParameter("mail");
	LabNav labnav = (LabNav)this.getServletContext().getAttribute("labnav");
	boolean isTeacher = email.endsWith("@info.kindai.ac.jp");
	boolean isOK = labnav.createTemporaryUser(loginId,password,email,isTeacher);

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
