public class Student extends User{
	/**
	 * @override
	 * @brief 仮ユーザを登録する
	 */
	public boolean createTemporary(String key){
		return createTemporary(false,key);
	}
	public Student(String name,String email,String password){
		super(name,email,password);
	
	}
	public boolean create(String key){
		return super.create(false,key);
	}
}
