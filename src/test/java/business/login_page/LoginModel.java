package business.login_page;

import org.apache.poi.ss.usermodel.Row;

import test.context.TestContext;

public class LoginModel {

	enum LoginAttributes {
		USERNAME(0), PASSWORD(1);

		private int index;

		LoginAttributes(int index) {
			this.index = index;
		}

		int getIndex(LoginAttributes attribute) {
			return this.index;
		}

	}

	private String username;
	private String password;

	public LoginModel(String username, String password) {
		setUsuario(username);
		setSenha(password);
	}

	public LoginModel() {
		this(TestContext.getRowByTaggedIdSheet());
	}

	public LoginModel(Row row) {

		setUsuario(row.getCell(LoginAttributes.USERNAME.index).getStringCellValue());
		setSenha(row.getCell(LoginAttributes.PASSWORD.index).getStringCellValue());
	}

	protected String getUsername() {
		return username;
	}

	protected void setUsuario(String username) {
		this.username = username;
	}

	protected String getPassword() {
		return password;
	}

	protected void setSenha(String password) {
		this.password = password;
	}

}
