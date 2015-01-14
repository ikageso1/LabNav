import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import com.sun.mail.smtp.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.security.MessageDigest;
import java.util.ArrayList;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LabNav{
	private ArrayList<User> students = new ArrayList<User>();
	//private ArrayList<Laboratory> laboratoryies = new ArrayList<Laboratory>();
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
			connection = DriverManager.getConnection("jdbc:sqlite:db/user.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.

			// 取得
			ResultSet rs = statement.executeQuery("SELECT * FROM user;");
			do{
				//  行からデータを取得
				String name = rs.getString("name");
				String email = rs.getString("email");
				String pass = rs.getString("password");	
				if(rs.getBoolean("isTeacher")){
					teachers.add(new Teacher(name,email,pass));
				}
				else{
					students.add(new Student(name,email,pass));
				}
			}while(rs.next());
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
	public void createUser(String key,HttpServletRequest request){
		try{
			// load
			Class.forName("org.sqlite.JDBC");
		}catch(ClassNotFoundException e){
			System.err.println(e);
			System.exit(-1);
		}
		Connection connection = null;

		try{
			connection = DriverManager.getConnection("jdbc:sqlite:db/tmpUser.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.

			// 取得
			ResultSet rs = statement.executeQuery("SELECT * FROM user WHERE key = '"+key+"';");

			if(!rs.wasNull()){
				//  行からデータを取得
				String name = rs.getString("name");
				String email = rs.getString("email");
				String pass = rs.getString("password");	
				boolean isTeacher = rs.getBoolean("isTeacher");
				User user;
				if(isTeacher){
					user = new Teacher(name,email,pass);
					teachers.add(user);
					((Teacher)user).create();
				}
				else{
					user = new Student(name,email,pass);
					students.add(user);
					((Student)user).create();
				}
				request.getSession().setAttribute("userId",name);
				request.getSession().setAttribute("isTeacher",isTeacher);
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
	
		public boolean registerAdditionalInfo(String userId,int assignedLab){
		try{
			// load
			Class.forName("org.sqlite.JDBC");
		}catch(ClassNotFoundException e){
			System.err.println(e);
			System.exit(-1);
		}
		Connection connection = null;

		try{
			connection = DriverManager.getConnection("jdbc:sqlite:db/user.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.

			// 取得
			ResultSet rs = statement.executeQuery("SELECT * FROM assignedLab WHERE name ='" +userId+ "';");
			if(!rs.wasNull()){
				statement.executeUpdate("update assignedLab set lab = " + assignedLab
						+ " where name = '"+userId+"';");
			}else{
				statement.executeUpdate("insert into assignedLab(name,lab)"
				+ "values('"+userId+"',"+assignedLab+")");
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
				if (d < 0) {//byte型では128～255が負値になっているので補正
					d += 256;
				}
				if (d < 16) {//0～15は16進数で1けたになるので、2けたになるよう頭に0を追加
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
			User tempUser = new User(name,email,password,key);
			tempUser.createTemporary(isTeacher,key);
			try {
				// プロパティの設定
				Properties props = System.getProperties();
				// ホスト
				props.put("mail.smtp.host", "smtp.gmail.com");
				// 認証（する）
				props.put("mail.smpt.auth", "true");
				// ポート指定（サブミッションポート）
				props.put("mail.smtp.port", "587");
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
				text += "localhost:8080:/LabNav/B14/labNavi/RegisterServlet?key=" + key;
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
			return true;
		}

		public boolean login(String email,String password){
			ArrayList<User> users = new ArrayList<User>(students);
			for(User user:users){
				if(email == user.getEmail()){
					if(password == user.getPassword()){
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
			System.out.println(test.confirm_usedname("三井"));
			System.out.println(test.confirm_usedname("三井い"));
		}
	}
