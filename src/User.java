import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class User{
	protected int user_id;
	protected String name;
	protected String email;
	protected String password;
	protected String key;
	protected String time;

	/**
	 * @brief コンストラクタ
	 */ 
	public User(String name,String email,String password){
		this.name = name;
		this.email = email;
		this.password = password;
		// this.time = (new Date()).toString();
	}
	/**
	 * @brief 仮ユーザを登録する
	 */
	public boolean createTemporary(boolean isTeacher,String key){
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
				
				int temp;
				if(isTeacher)temp = 1;
				else temp = 0;
				// 登録
				statement.executeUpdate("insert into tmpuser(name,email,password,isTeacher,date,key)"
					  +	"values('"+name+"','"+email+"','"+password+"',"+temp+",'"+new Date()+"','"+key+"');");
		}catch(SQLException e){
			System.err.println(e.getMessage());
			return false;
		}
		finally{
			try{
					if(connection != null)
						connection.close();
			}catch(SQLException e){
				System.err.println(e);
				return false;
			}
		}
		return true;
	}
	public boolean create(boolean isTeacher,String key){
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

			int temp;
			if(isTeacher)temp = 1;
			else temp = 0;
			// 登録
			statement.executeUpdate("insert into user(name,email,password,isTeacher)"
					+	"values('"+name+"','"+email+"','"+password+"',"+temp+");");
		}catch(SQLException e){
			System.err.println(e.getMessage());
			return false;
		}
		finally{
			try{
				if(connection != null)
					connection.close();
			}catch(SQLException e){
				System.err.println(e);
				return false;
			}
		}
		return true;
	}
	public boolean create(){
		 return true;
	}
	public static void main(String args[]){
		//User user = new User("mitui","1210370052g@kindai.ac.jp","34673467");
		//user.create(false,"6b22b8116ed8d37f24626d2ba5ab05e0");
	}
	public int getUser_id(){
		return user_id;
	}
	public String getName(){
		return name;
	}
	public String getEmail(){
		return email;
	}
	public String getPassword(){
		return password;
	}
}
