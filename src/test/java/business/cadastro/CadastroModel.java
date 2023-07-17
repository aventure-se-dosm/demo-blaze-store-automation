package business.cadastro;

import org.apache.poi.ss.usermodel.Row;

import test.context.TestContext;

public class CadastroModel {

	enum LoginAttributes {
		USERNAME(0), PASSWORD(1);

		private int index;

		LoginAttributes(int index) {
			this.index = index;
		}

		public int getIndex() {
			return this.index;
		}

	}

	private String username;
	private String password;

	public CadastroModel(String username, String password) {
		setUsuario(username);
		setSenha(password);
	}

	public CadastroModel() {
		this(TestContext.getRowByTaggedIdSheet());
	}

	public CadastroModel(Row row) {

		setUsuario(row.getCell(LoginAttributes.USERNAME.getIndex()).getStringCellValue());

		setSenha(row.getCell(LoginAttributes.PASSWORD.getIndex()).getStringCellValue());

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
