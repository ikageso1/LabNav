public class Student extends User{
	/**
	 * @override
	 * @brief 仮ユーザを登録する
	 */
	public boolean createTemporary(){
		return createTemporary(false);
	}
	public Student(String name,String email,String password){
		super(name,email,password);
	}
}
