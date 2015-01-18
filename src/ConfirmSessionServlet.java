import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmSessionServlet extends HttpServlet {

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
			String name = (String)request.getSession().getAttribute("loginId");
			if(name ==null){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.append("<p>セッションが不正です</p>");
				writer.flush();
			}
		}
}
