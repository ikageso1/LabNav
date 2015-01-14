public class Teacher extends User{
	/**
	 * @override
	 * @brief 仮ユーザを登録する
	 */
	public boolean createTemporary(String key){
		return super.createTemporary(true,key);
	}

	public Teacher(String name,String email,String password){
		super(name,email,password);
	}
	public boolean create(String key){	
		return super.create(true,key);
	}
}
