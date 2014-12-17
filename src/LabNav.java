public class LabNav{
	private ArrayList<Student> students;
	private ArrayList<Laboratory> laboratoryies;
	private ArrayList<Teacher> teachers;
	public LabNav{
	}
	public void createNewUser(String name,String email,String password){
	}
	public void setUser(int user_id){
	}
	public void getLaboratory(int laboratory_id){
	}
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
	}
}
