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

		if(labnav.createUser(key,request)){
			String url;
			Boolean isTeacher = (Boolean)request.getSession().getAttribute("isTeacher");
			if(isTeacher.booleanValue()){
				url = "http://ecl.info.kindai.ac.jp/14/isp2/warup/servlet/B14/register_teacher.html";
				// ローカルテスト用
				// url = "http://localhost:8080/B14/register_teacher.html";
			}
			else{
				url = "http://ecl.info.kindai.ac.jp/14/isp2/warup/servlet/B14/register_student.html";
			  // ローカルテスト用
				// url = "http://localhost:8080/B14/register_student.html";
			}
			response.sendRedirect(url);
		}
		else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.append("<p>不正なKey valueです。</p>");
			writer.flush();
		}
	}
}
