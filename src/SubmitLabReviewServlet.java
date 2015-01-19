import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubmitLabReviewServlet extends HttpServlet {

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String labName = request.getParameter("labName");
		String review = request.getParameter("review");
		String comment = request.getParameter("comment");
		
		String userId = (String)request.getSession().getAttribute("userId");

		LabNav labnav = (LabNav)this.getServletContext().getAttribute("labnav");

		boolean isOK = labnav.submitReview(userId,labName,review,comment);

		if(isOK){
			// String url = "http://ecl.info.kindai.ac.jp/14/isp2/warup/servlet/B14/main.html";
			// ローカルテスト用
			String url = "http://localhost:8080/B14/main.html";
			response.sendRedirect(url);
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.append("<p>ID or Password is wrong.</p>");
			writer.flush();
		}
	}
}

