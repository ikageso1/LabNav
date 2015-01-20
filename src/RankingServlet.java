import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RankingServlet extends HttpServlet {

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		LabNav labnav = (LabNav)this.getServletContext().getAttribute("labnav");
		String[] rank = new String[3];	
		String[] labName = new String[3];
		String[] imageURL = new String[3];
	  String[] labURL = new String[3];
		for(int i=0;i<3;i++){
			String temp = labnav.getReviewRank(i+1);
			System.out.println(temp);
			if(temp.equals("moriyama")){
				labName[i] = "電子商取引研究室";
				imageURL[i] = "https://www.kindai.ac.jp/data/images/professor/242.jpg";
				labURL[i] = "lab_moriyama.jsp";
			}else if(temp.equals("habe")){
				labName[i] = "コンピュータビジョン研究室";
				imageURL[i] = "https://www.kindai.ac.jp/data/images/professor/473.jpg";
				labURL[i] = "lab_habe.jsp";
			}else if(temp.equals("tada")){
				labName[i] = "交通情報学研究室";
				imageURL[i] = "https://www.kindai.ac.jp/data/images/professor/468.jpg";
				labURL[i] = "lab_tada.jsp";
			}else if(temp.equals("tunoda")){
				labName[i] = "ソフトウェア研究室";
				imageURL[i] = "https://www.kindai.ac.jp/data/images/professor/469.jpg";
				labURL[i] = "lab_tsunoda.jsp";
			}else if(temp.equals("tagawa")){
				labName[i] = "数理情報工学研究室";
				imageURL[i] = "https://www.kindai.ac.jp/data/images/professor/439.jpg";
				labURL[i] = "lab_tagawa.jsp";
			}else if(temp.equals("mizobuti")){
				labName[i] = "自然言語処理研究室";
				imageURL[i] ="https://www.kindai.ac.jp/data/images/professor/458.jpg";
				labURL[i] = "lab_mizobuchi.jsp";
			}else if(temp.equals("hamasuna")){
				labName[i] = "知能情報基礎研究室";
				imageURL[i] = "https://www.kindai.ac.jp/data/images/professor/479.jpg";
				labURL[i] = "lab_hamasuna.jsp";
			}else if(temp.equals("sano")){
				labName[i] = "環境情報科学研究室";
				imageURL[i] = "https://www.kindai.ac.jp/data/images/professor/868.jpg";
				labURL[i] = "lab_sano.jsp";
			}else if(temp.equals("higuti")){
				labName[i] = "分散ソフトウェア研究室";
				imageURL[i] ="https://www.kindai.ac.jp/data/images/professor/443.jpg";
				labURL[i] = "lab_higuchi.jsp";
			}else if(temp.equals("sasano")){
				labName[i] = "情報通信研究室";
				imageURL[i] ="https://www.kindai.ac.jp/data/images/professor/438.jpg";
				labURL[i] = "lab_sasano.jsp";
			}else if(temp.equals("moriya")){
				labName[i] = "分散アルゴリズム研究室";
				imageURL[i] = "https://www.kindai.ac.jp/data/images/professor/476.jpg";
				labURL[i] = "lab_moriya.jsp";
			}else if(temp.equals("isimizu")){
				labName[i] = "情報論理工学研究室";
				imageURL[i] = "https://www.kindai.ac.jp/data/images/professor/461.jpg";	
				labURL[i] = "lab_ishimizu.jsp";
			}else if(temp.equals("yamamoto")){
				labName[i] = "音声言語研究室";
				imageURL[i] = "https://www.kindai.ac.jp/data/images/professor/449.jpg";
				labURL[i] = "lab_yamamoto.jsp";
			}else if(temp.equals("iguti")){
				labName[i] = "ネットワーク研究室";
				imageURL[i] = "https://www.kindai.ac.jp/data/images/professor/238.jpg";
				labURL[i] = "lab_iguchi.jsp";
			}else if(temp.equals("takata")){
				labName[i] = "マルチエージェント研究室";
				imageURL[i] = "https://www.kindai.ac.jp/data/images/professor/1169.jpg";
				labURL[i] = "lab_takata.jsp";
			}else if(temp.equals("abe")){
				labName[i] = "人間情報科学研究室";
				imageURL[i] = "https://www.kindai.ac.jp/data/images/professor/450.jpg";
				labURL[i] = "lab_abe.jsp";
			}else if(temp.equals("kato")){
				labName[i] = "並行計算理論研究室";
				imageURL[i] ="https://www.kindai.ac.jp/data/images/professor/519.jpg";
				labURL[i] = "lab_kato.jsp";
			}else if(temp.equals("handa")){
				labName[i] = "計算知能研究室";
				imageURL[i] = "https://www.kindai.ac.jp/data/images/professor/456.jpg";
				labURL[i] = "lab_handa.jsp";
			}else if(temp.equals("hironaga")){
				labName[i] = "画像処理研究室";
				imageURL[i] = "https://www.kindai.ac.jp/data/images/professor/480.jpg";
			}else if(temp.equals("ohosi")){
				labName[i] = "医療情報研究室";
				imageURL[i] = "http://profsci.kudos.kindai.ac.jp/moodle/file.php/2/moddata/data/1/18/162/%E6%83%85%E5%A0%B1%E5%AD%A6%E7%A7%91%E5%A4%A7%E6%98%9F_fmt.jpeg";
				labURL[i] = "lab_oboshi.jsp";
			}else if(temp.equals("taniguti")){
				labName[i] = "知的通信網研究室";
				imageURL[i] = "https://www.kindai.ac.jp/data/images/professor/1230.jpg";
				labURL[i] = "lab_taniguchi.jsp";
			}
		}
		System.out.println(labName[0]);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.append('{');
		writer.append("\"url1\":\"").append(labURL[0]).append("\",");
		writer.append("\"labName1\":\"").append(labName[0]).append("\",");
		writer.append("\"imageURL1\":\"").append(imageURL[0]).append("\",");
		writer.append("\"url2\":\"").append(labURL[1]).append("\",");
		writer.append("\"labName2\":\"").append(labName[1]).append("\",");
		writer.append("\"imageURL2\":\"").append(imageURL[1]).append("\",");
		writer.append("\"url3\":\"").append(labURL[2]).append("\",");
		writer.append("\"labName3\":\"").append(labName[2]).append("\",");
		writer.append("\"imageURL3\":\"").append(imageURL[2]).append("\"");
		writer.append('}');
		writer.flush();
	}
}