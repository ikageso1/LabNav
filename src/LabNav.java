import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import com.sun.mail.smtp.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.ArrayList;

public class LabNav{
	private ArrayList<Student> students = new ArrayList<Student>();
	//private ArrayList<Laboratory> laboratoryies = new ArrayList<Laboratory>();
	private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
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
		for(Student student :students){
			if(userId.equals(student.getName())){
		  	return false;	
			}
		}
		for(Teacher teacher:teachers){
		  if(userId.equals(teacher.getName())){
				return false;
			}
		}
		return true;
	}
	public void createNewUser(String name,String email,String password){
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
	
	// JavaでGmailからメールを送信するサンプル（JavaMail使用）
	public boolean createTemporaryUser(String name,String email,String password,boolean isTeacher){
		User tempUser = new User(name,email,password);
		tempUser.createTemporary(isTeacher);
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
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			// タイトル設定
			msg.setSubject("ラボナビ運営部:ご登録ありがとうございます");
			String text = "ラボナビを登録していただきありがとう御座います。\n";
			text += "お手数ですが、登録を完了していただく為に、以下のURLにアクセスして下さい。\n";
			text += "http://hogehoge";
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
