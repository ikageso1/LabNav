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

	private String[] getLabInfomation(String temp){
		String[] ret = new String[3];
		if(temp.equals("moriyama")){
			ret[0] = "電子商取引研究室";
			ret[1] = "https://www.kindai.ac.jp/data/images/professor/242.jpg";
			ret[2] = "lab_moriyama.html";
		}else if(temp.equals("habe")){
			ret[0] = "コンピュータビジョン研究室";
			ret[1] = "https://www.kindai.ac.jp/data/images/professor/473.jpg";
			ret[2] = "lab_habe.html";
		}else if(temp.equals("tada")){
			ret[0] = "交通情報学研究室";
			ret[1] = "https://www.kindai.ac.jp/data/images/professor/468.jpg";
			ret[2] = "lab_tada.html";
		}else if(temp.equals("tsunoda")){
			ret[0] = "ソフトウェア研究室";
			ret[1] = "https://www.kindai.ac.jp/data/images/professor/469.jpg";
			ret[2] = "lab_tsunoda.html";
		}else if(temp.equals("tagawa")){
			ret[0] = "数理情報工学研究室";
			ret[1] = "https://www.kindai.ac.jp/data/images/professor/439.jpg";
			ret[2] = "lab_tagawa.html";
		}else if(temp.equals("mizobuchi")){
			ret[0] = "自然言語処理研究室";
			ret[1] ="https://www.kindai.ac.jp/data/images/professor/458.jpg";
			ret[2] = "lab_mizobuchi.html";
		}else if(temp.equals("hamasuna")){
			ret[0] = "知能情報基礎研究室";
			ret[1] = "https://www.kindai.ac.jp/data/images/professor/479.jpg";
			ret[2] = "lab_hamasuna.html";
		}else if(temp.equals("sano")){
			ret[0] = "環境情報科学研究室";
			ret[1] = "https://www.kindai.ac.jp/data/images/professor/868.jpg";
			ret[2] = "lab_sano.html";
		}else if(temp.equals("higuchi")){
			ret[0] = "分散ソフトウェア研究室";
			ret[1] ="https://www.kindai.ac.jp/data/images/professor/443.jpg";
			ret[2] = "lab_higuchi.html";
		}else if(temp.equals("sasano")){
			ret[0] = "情報通信研究室";
			ret[1] ="https://www.kindai.ac.jp/data/images/professor/438.jpg";
			ret[2] = "lab_sasano.html";
		}else if(temp.equals("moriya")){
			ret[0] = "分散アルゴリズム研究室";
			ret[1] = "https://www.kindai.ac.jp/data/images/professor/476.jpg";
			ret[2] = "lab_moriya.html";
		}else if(temp.equals("ishimizu")){
			ret[0] = "情報論理工学研究室";
			ret[1] = "https://www.kindai.ac.jp/data/images/professor/461.jpg";	
			ret[2] = "lab_ishimizu.html";
		}else if(temp.equals("yamamoto")){
			ret[0] = "音声言語研究室";
			ret[1] = "https://www.kindai.ac.jp/data/images/professor/449.jpg";
			ret[2] = "lab_yamamoto.html";
		}else if(temp.equals("iguchi")){
			ret[0] = "ネットワーク研究室";
			ret[1] = "https://www.kindai.ac.jp/data/images/professor/238.jpg";
			ret[2] = "lab_iguchi.html";
		}else if(temp.equals("takada")){
			ret[0] = "マルチエージェント研究室";
			ret[1] = "https://www.kindai.ac.jp/data/images/professor/1169.jpg";
			ret[2] = "lab_takata.html";
		}else if(temp.equals("abe")){
			ret[0] = "人間情報科学研究室";
			ret[1] = "https://www.kindai.ac.jp/data/images/professor/450.jpg";
			ret[2] = "lab_abe.html";
		}else if(temp.equals("kato")){
			ret[0] = "並行計算理論研究室";
			ret[1] ="https://www.kindai.ac.jp/data/images/professor/519.jpg";
			ret[2] = "lab_kato.html";
		}else if(temp.equals("handa")){
			ret[0] = "計算知能研究室";
			ret[1] = "https://www.kindai.ac.jp/data/images/professor/456.jpg";
			ret[2] = "lab_handa.html";
		}else if(temp.equals("hironaga")){
			ret[0] = "画像処理研究室";
			ret[1] = "https://www.kindai.ac.jp/data/images/professor/480.jpg";
			ret[2] = "lab_hironaga.html";
		}else if(temp.equals("oboshi")){
			ret[0] = "医療情報研究室";
			ret[1] = "http://profsci.kudos.kindai.ac.jp/moodle/file.php/2/moddata/data/1/18/162/%E6%83%85%E5%A0%B1%E5%AD%A6%E7%A7%91%E5%A4%A7%E6%98%9F_fmt.jpeg";
			ret[2] = "lab_oboshi.html";
		}else if(temp.equals("taniguchi")){
			ret[0] = "知的通信網研究室";
			ret[1] = "https://www.kindai.ac.jp/data/images/professor/1230.jpg";
			ret[2] = "lab_taniguchi.html";
		}
		return ret;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		LabNav labnav = (LabNav)this.getServletContext().getAttribute("labnav");
		String[] first = new String[3];
		String[] second = new String[3];
		String[] third = new String[3];
		
		String temp = labnav.getReviewRank(1);
		first = getLabInfomation(temp);
		temp = labnav.getReviewRank(2);
		second = getLabInfomation(temp);
		temp = labnav.getReviewRank(3);
		third = getLabInfomation(temp);
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.append('{');
		writer.append("\"url1\":\"").append(first[2]).append("\",");
		writer.append("\"labName1\":\"").append(first[0]).append("\",");
		writer.append("\"imageURL1\":\"").append(first[1]).append("\",");
		writer.append("\"url2\":\"").append(second[2]).append("\",");
		writer.append("\"labName2\":\"").append(second[0]).append("\",");
		writer.append("\"imageURL2\":\"").append(second[1]).append("\",");
		writer.append("\"url3\":\"").append(third[2]).append("\",");
		writer.append("\"labName3\":\"").append(third[0]).append("\",");
		writer.append("\"imageURL3\":\"").append(third[1]).append("\",");

		temp = labnav.getPopRank(1);
		first = getLabInfomation(temp);
		temp = labnav.getPopRank(2);
		second = getLabInfomation(temp);
		temp = labnav.getPopRank(3);
		third = getLabInfomation(temp);

		writer.append("\"pUrl1\":\"").append(first[2]).append("\",");
		writer.append("\"pLabName1\":\"").append(first[0]).append("\",");
		writer.append("\"pImageURL1\":\"").append(first[1]).append("\",");
		writer.append("\"pUrl2\":\"").append(second[2]).append("\",");
		writer.append("\"pLabName2\":\"").append(second[0]).append("\",");
		writer.append("\"pImageURL2\":\"").append(second[1]).append("\",");
		writer.append("\"pUrl3\":\"").append(third[2]).append("\",");
		writer.append("\"pLabName3\":\"").append(third[0]).append("\",");
		writer.append("\"pImageURL3\":\"").append(third[1]).append("\",");

		temp = labnav.getSatisfyRank(1);
		first = getLabInfomation(temp);
		temp = labnav.getSatisfyRank(2);
		second = getLabInfomation(temp);
		temp = labnav.getSatisfyRank(3);
		third = getLabInfomation(temp);
		
		writer.append("\"sUrl1\":\"").append(first[2]).append("\",");
		writer.append("\"sLabName1\":\"").append(first[0]).append("\",");
		writer.append("\"sImageURL1\":\"").append(first[1]).append("\",");
		writer.append("\"sUrl2\":\"").append(second[2]).append("\",");
		writer.append("\"sLabName2\":\"").append(second[0]).append("\",");
		writer.append("\"sImageURL2\":\"").append(second[1]).append("\",");
		writer.append("\"sUrl3\":\"").append(third[2]).append("\",");
		writer.append("\"sLabName3\":\"").append(third[0]).append("\",");
		writer.append("\"sImageURL3\":\"").append(third[1]).append("\"");



		writer.append('}');
		writer.flush();
	}
}
