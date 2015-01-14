import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String key = (String)request.getParameter("key");
		LabNav labnav = (LabNav)this.getServletContext().getAttribute("labnav");

		labnav.createUser(key,request);
		String url;
		if(request.getSession().getAttribute("isTeacher").equals("true")){
			url = "http://localhost:8080/LabNav/B14/labNavi/register_teacher.html";
		}
		else{
			url = "http://localhost:8080/LabNav/B14/labNavi/register_student.html";
		}
    response.sendRedirect(url);
		
		// htmlを出力
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.append("<html>");
		writer.append("<p>確認メールを送信しました。</p>");
		writer.append("</html>");
		writer.flush();
	}
}