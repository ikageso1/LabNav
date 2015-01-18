import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAddtionalInfoServlet extends HttpServlet {

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
		String assignedLabStr = (String)request.getParameter("assignedLab");
		if(assignedLabStr != null){
			int assignedLab = Integer.parseInt(assignedLabStr);
			String userId = (String)request.getSession().getAttribute("userId");
			LabNav labnav = (LabNav)this.getServletContext().getAttribute("labnav");

			System.out.println(userId +":"+String.valueOf(assignedLab));
			labnav.registerAdditionalInfo(userId,assignedLab);
		}
		String url = "http://localhost:8080/LabNav/B14/labNavi/registered.html";
    response.sendRedirect(url);
	}
}

