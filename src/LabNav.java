import java.util.*;
import javax.mail.*;
import java.io.UnsupportedEncodingException;
import javax.mail.internet.*;
import com.sun.mail.smtp.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.crypto.*;
import java.security.*;

import java.util.ArrayList;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LabNav{
	private ArrayList<User> students = new ArrayList<User>();
	private ArrayList<Laboratory> laboratories = new ArrayList<Laboratory>();
	private ArrayList<User> teachers = new ArrayList<User>();
	public LabNav(){
		try{
			// load
			Class.forName("org.sqlite.JDBC");
		}catch(ClassNotFoundException e){
			System.err.println(e);
			System.exit(-1);
		}
		Connection connection = null;

		try{
			connection = DriverManager.getConnection("jdbc:sqlite:webdb/B14.sqlite3");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.

			// User
			ResultSet rs = statement.executeQuery("SELECT * FROM user;");
			while(rs.next()){
				// take out from colmun
				String name = rs.getString("name");
				String email = rs.getString("email");
				String pass = rs.getString("password");	
				if(rs.getBoolean("isTeacher")){
					teachers.add(new Teacher(name,email,pass));
				}
				else{
					students.add(new Student(name,email,pass));
				}
			}
			rs.close();
			// Laboratory
			rs = statement.executeQuery("SELECT * FROM laboratory;");
			while(rs.next()){
				// take out from colmun
				String name = rs.getString("name");
				// make a laboraotry
				laboratories.add(new Laboratory(name));
			}

		}catch(SQLException e){
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		finally{
			try{
				if(connection != null)
					connection.close();
			}catch(SQLException e){
				System.err.println(e);
				System.exit(-1);
			}
		}
	}

	public void calc_ranking(){
		for(int i=0;i<laboratories.size()-1;i++){
			System.out.println(laboratories.get(i).getName());
			for(int j=0;j<laboratories.size()-1-i;j++){
				if(laboratories.get(j).getAverage() < laboratories.get(j+1).getAverage()){
					Laboratory temp = laboratories.get(j);
					laboratories.set(j,laboratories.get(j+1));
					laboratories.set(j+1,temp);	
				}
			}
		}
	}
	public String getReviewRank(int rank){
		calc_ranking();
		return laboratories.get(rank-1).getName();
	}
	boolean confirm_usedname(String userId){
		for(User student :students){
			if(userId.equals(student.getName())){
				return false;	
			}
		}
		for(User teacher:teachers){
			if(userId.equals(teacher.getName())){
				return false;
			}
		}
		return true;
	}
	public boolean createUser(String key,HttpServletRequest request){
		try{
			// load
			Class.forName("org.sqlite.JDBC");
		}catch(ClassNotFoundException e){
			System.err.println(e);
			System.exit(-1);
		}
		Connection connection = null;
		try{
			connection = DriverManager.getConnection("jdbc:sqlite:webdb/B14.sqlite3");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.

			// 取得
			ResultSet rs = statement.executeQuery("SELECT * FROM tmpuser WHERE key = '"+key+"';");

			if(rs.next()){
				//  行からデータを取得
				String name = rs.getString("name");
				String email = rs.getString("email");
				String pass = rs.getString("password");	
				boolean isTeacher = rs.getBoolean("isTeacher");
				User user;
				
				// 閉じる
				connection.close();
				connection = null;
				
				if(isTeacher){
					user = new Teacher(name,email,pass);
					teachers.add(user);
					((Teacher)user).create(key);
				}
				else{
					user = new Student(name,email,pass);
					students.add(user);
					((Student)user).create(key);
				}
				request.getSession().setAttribute("userId",name);
				request.getSession().setAttribute("isTeacher",isTeacher);
			}else{
				return false;
			}
		}catch(SQLException e){
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		finally{
			try{
				if(connection != null)
					connection.close();
			}catch(SQLException e){
				System.err.println(e);
				System.exit(-1);
			}
		}
		return true;
	}
	
		public boolean registerAdditionalInfo(String userId,String assignedLab){
		try{
			// load
			Class.forName("org.sqlite.JDBC");
		}catch(ClassNotFoundException e){
			System.err.println(e);
			System.exit(-1);
		}
		Connection connection = null;

		try{
			connection = DriverManager.getConnection("jdbc:sqlite:webdb/B14.sqlite3");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.
			

			// 取得
			ResultSet rs = statement.executeQuery("SELECT * FROM assignedLab WHERE name ='" +userId+ "';");
			if(rs.next()){
				statement.executeUpdate("update assignedLab set lab = '" + assignedLab
						+ "' where name = '"+userId+"';");
			}else{
				statement.executeUpdate("insert into assignedLab(name,lab)"
				+ "values('"+userId+"','"+assignedLab+"');");
			}
		}catch(SQLException e){
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		finally{
			try{
				if(connection != null)
					connection.close();
			}catch(SQLException e){
				System.err.println(e);
				System.exit(-1);
			}
		}
	 return true;
	}
		public void setUser(int user_id){
		}
		public void getLaboratory(int laboratory_id){
		}
		/*
			 =======
			 >>>>>>> FETCH_HEAD
			 public static void main(String args[]){
			 LabNav labnav = new LabNav();
			 String email = "ikageso.201@gmail.com";
			 labnav.createTemporaryUser("天満",email,"1234");
			 <<<<<<< HEAD
			 }*/

		// 変換
		private String convertDigest(byte[] digest){	
			String retStr = "";
			for (int i = 0; i < digest.length; i++) {
				int d = digest[i];
				if (d < 0) {//byte型では128〜255が負値になっているので補正
					d += 256;
				}
				if (d < 16) {//0〜15は16進数で1けたになるので、2けたになるよう頭に0を追加
					retStr += "0";
				}
				retStr += Integer.toString(d, 16);//ダイジェスト値の1バイトを16進数2けたで表示
			}
			return retStr;
		}



		// JavaでGmailからメールを送信するサンプル（JavaMail使用）
		public boolean createTemporaryUser(String name,String email,String password,boolean isTeacher){
			// ユーザIDからダイジェストを生成する
		  String key = "";
			try{
				MessageDigest md = MessageDigest.getInstance("MD5");
				// ダイジェストを計算する
				md.update(name.getBytes());	
				// キー
				byte[] digest = md.digest();
				key = convertDigest(digest);
			}catch(java.security.NoSuchAlgorithmException e){

			}
			User tempUser;
			if(isTeacher)tempUser = new Teacher(name,email,password);
			else tempUser = new Student(name,email,password);
			tempUser.createTemporary(isTeacher,key);

			String ENCODE = "UTF-8";

			final Properties props = new Properties();

			// 基本情報。ここでは gmailへの接続例を示します。
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			// SSL用にポート番号を変更。
			props.setProperty("mail.smtp.port", "465");

			// タイムアウト設定
			props.setProperty("mail.smtp.connectiontimeout", "60000");
			props.setProperty("mail.smtp.timeout", "60000");

			// 認証
			props.setProperty("mail.smtp.auth", "true");

			// SSL関連設定
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.socketFactory.port", "465");

			final Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("kindailabnavi@gmail.com", "labn731avi");
				}
			});

			// デバッグを行います。標準出力にトレースが出ます。
			session.setDebug(true);

			// メッセージ内容の設定。
			final MimeMessage message = new MimeMessage(session);
			try {
				final Address addrFrom = new InternetAddress(
						"kindailabnavi@gmail.com", "ラボナビ運営部",ENCODE);
				message.setFrom(addrFrom);
				final Address addrTo = new InternetAddress(email);
				message.addRecipient(Message.RecipientType.TO, addrTo);

				// メールのSubject
				message.setSubject("ラボナビのご登録ありがとうございます",ENCODE );

				// メール本文。setTextを用いると 自動的に[text/plain]となる。
				String text = "ラボナビを登録していただき有り難う御座います。\n";
				text += "お手数ですが、登録を完了していただく為に、以下のURLにアクセスして下さい。\n";
				text += "http://ecl.info.kindai.ac.jp/14/isp2/warup/servlet/B14/RegisterServlet?key=" + key;
				message.setContent(text,"text/plain; charset="+ENCODE);

				// 仮対策: 開始
				// setTextを呼び出した後に、ヘッダーを 7bitへと上書きします。
				// これは、一部のケータイメールが quoted-printable を処理できないことへの対策となります。
				message.setHeader("Content-Transfer-Encoding", "7bit");
				// 仮対策: 終了

				// その他の付加情報。
				message.addHeader("X-Mailer", "blancoMail 0.1");
				message.setSentDate(new Date());
			} catch (MessagingException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			// メール送信。
			try {
				Transport.send(message);
			} catch (AuthenticationFailedException e) {
				// 認証失敗は ここに入ります。
				System.out.println("指定のユーザ名・パスワードでの認証に失敗しました。"
						+ e.toString());
			} catch (MessagingException e) {
				// smtpサーバへの接続失敗は ここに入ります。
				System.out.println("指定のsmtpサーバへの接続に失敗しました。" + e.toString());
				e.printStackTrace();
			}	
			/*
			try {
				// プロパティの設定
				Properties props = System.getProperties();
				// ホスト
				props.put("mail.smtp.host", "smtp.gmail.com");
				// 認証（する）
				props.put("mail.smpt.auth", "true");
				// ポート指定（サブミッションポート）
				props.put("mail.smtp.port", "465");
				// STARTTLSによる暗号化（する）
				props.put("mail.smtp.starttls.enable", "true");
				// セッションの取得
				Session session = Session.getInstance(props);
				// MimeMessageの取得と設定
				Message msg = new MimeMessage(session);
				// 送信者設定
				msg.setFrom(new InternetAddress("kindailabnavi@gmail.com"));
				// 宛先設定
				//msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("n4keitaro@gmail.com", false));
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email,false));
				// タイトル設定
				msg.setSubject("ラボナビ運営部:ご登録ありがとうございます");
				String text = "ラボナビを登録していただきありがとう御座います。\n";
				text += "お手数ですが、登録を完了していただく為に、以下のURLにアクセスして下さい。\n";
				text += "http://localhost:8080/LabNav/B14/labNavi/RegisterServlet?key=" + key;
				// 本文設定
				msg.setText(text);
				// 送信日時設定
				msg.setSentDate(new Date());

				// 送信
				SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

				try {
					t.connect("smtp.gmail.com", "kindailabnavi@gmail.com", "labn731avi");
					t.sendMessage(msg, msg.getAllRecipients());
					System.out.println("送信しました");
				} finally {
					t.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		*/

			return true;
		}

		public void submitReview(String userId,String labName,int review,String comment){
			for(Laboratory l:laboratories){
				if(l.getName().equals(labName)){
					l.addReview(userId,review,comment);
					l.calcAverage();
					break;
				}
			}
		}


		public boolean login(String name,String password,HttpServletRequest request){
			for(User user:students){
				if(name.equals(user.getName())){
					if(password.equals(user.getPassword())){
						request.getSession().setAttribute("userId",name);
						request.getSession().setAttribute("isTeacher",false);
						return true;
					}
					else{
						return false;
					}
				}
			}
			for(User user:teachers){
				if(name.equals(user.getName())){
					if(password.equals(user.getPassword())){
						request.getSession().setAttribute("userId",name);
						request.getSession().setAttribute("isTeacher",true);
						return true;
					}
					else{
						return false;
					}
				}
			}
			return false;
		}

		public static void main(String args[]){
			LabNav test = new LabNav();
			test.submitReview("ika","moriyama",5,"hello");
			test.submitReview("ika","tada",4,"hello");
			test.submitReview("ika","tunoda",3,"hello");
			System.out.println(test.getReviewRank(1));
		}
	}
