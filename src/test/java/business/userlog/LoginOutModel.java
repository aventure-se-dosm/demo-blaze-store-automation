package business.userlog;

public class LoginOutModel {

	enum LoginAttributes {

		PASSWORD(1), USERNAME(0);

		int index;

		LoginAttributes(int index) {
			this.index = index;
		}

		int getIndex(LoginAttributes attribute) {
			return this.index;
		}
	}

	private String password;
	private String username;

	public LogoutModel(String username, String password) {
		setUsuario(username);
		setSenha(password);
	}

	protected String getPassword() {
		return password;
	}

	protected String getUsername() {
		return username;
	}

	protected void setSenha(String password) {
		this.password = password;
	}

	protected void setUsuario(String username) {
		this.username = username;
	}
}
