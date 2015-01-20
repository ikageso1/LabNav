import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;



public class Laboratory{
	private String name;
	private double average;
	private String comment;

	public Laboratory(String name){
		this.name = name;
		calcAverage();
	}

	public void addReview(String userId,int point,String reviewComment){
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
			System.out.println(name);
			// get data
			ResultSet rs = statement.executeQuery("SELECT * FROM lab_review"
					+ " where userId = '"+userId+"' and labName = '"+name+ "';");
			if(rs.next()){
				statement.executeUpdate("update lab_review set"
						+ " point = " + point + ","
						+ " reviewComment = '" + reviewComment + "'"
						+ " where userId = '"+userId+"' and labName = '"+name+ "';");
			}else{
				statement.executeUpdate("insert into lab_review(userId,labName,point,reviewComment)"
						+ "values('"+userId+"','"+name+"',"+point+",'"+reviewComment+"');");
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
	public void calcAverage(){
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
			// get data
			ResultSet rs = statement.executeQuery("SELECT point FROM lab_review WHERE labName = '"+name+"';");
			int sum=0;	// sum of the point
			int num=0;	// number of the point
			while(rs.next()){
				// take out from column
				sum += rs.getInt("point");
				num++;
			}
			if(num!=0){
				this.average = (double)sum/(double)num;
			}else{
				this.average = 0;
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
	public double getAverage(){
		return average;
	}
	public String getName(){
		return name;
	}
}
