public class Teacher extends User{
	/**
	 * @override
	 * @brief 仮ユーザを登録する
	 */
	public boolean createTemporary(){
		return createTemporary(true);
	}

	public Teacher(String name,String email,String password){
		super(name,email,password);
	}
}
