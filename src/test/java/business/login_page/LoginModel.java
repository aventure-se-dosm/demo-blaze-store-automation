package business.login_page;

import org.apache.poi.ss.usermodel.Row;

import test.context.TestContext;

public class LoginModel {

	private String username;
	private String password;

	public LoginModel(String username, String password) {
		setUsuario(username);
		setSenha(password);
	}

	public LoginModel() {
		Row row = TestContext.getRowByTaggedIdSheet();

		//TODO: ExcelActions class
		setUsuario(row.getCell(0).getStringCellValue());
		setUsuario(row.getCell(1).getStringCellValue());

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
