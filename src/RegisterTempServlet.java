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
		String loginId = (String)request.getParameter("userId");
		String password = (String)request.getParameter("password");
		String email = (String)request.getParameter("mail");
		LabNav labnav = (LabNav)this.getServletContext().getAttribute("labnav");
		boolean isTeacher = email.endsWith("@info.kindai.ac.jp");
    if(email.equals("1210370051g@kindai.ac.jp")){
			isTeacher = true;
		}
		labnav.createTemporaryUser(loginId,email,password,isTeacher);

		// htmlを出力
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.append("<html>");
		writer.append("<p>確認メールを送信しました。</p>");
		writer.append("</html>");
		writer.flush();
	}
}
