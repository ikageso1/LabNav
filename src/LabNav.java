import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import com.sun.mail.smtp.*;

public class LabNav{
    //private ArrayList<Student> students;
    //private ArrayList<Laboratory> laboratoryies;
    //private ArrayList<Teacher> teachers;
    public LabNav(){
    }
    public void createNewUser(String name,String email,String password){
    }
    public void setUser(int user_id){
    }
    public void getLaboratory(int laboratory_id){
    }
    public static void main(String args[]){
	LabNav labnav = new LabNav();
	String email = "humble6513@gmail.com";
	labnav.createTempolararyUser("三井",email,"1234");
    }
    public boolean createTempolararyUser(String name,String email,String password){
	   //User tempUser = new User(name,email,password);
	 	 // JavaでGmailからメールを送信するサンプル（JavaMail使用）
	
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
}

/*
    public boolean login(String email,String password){
	ArrayList<User> users = ArrayList<User>(students);
	for(teacher Teacher:teachers){
	    users.add(teacher);
	}
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
    }*/