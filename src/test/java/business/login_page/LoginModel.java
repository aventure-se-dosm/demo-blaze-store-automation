package business.login_page;

import org.apache.poi.ss.usermodel.Row;

import test.context.TestContext;

public class LoginModel {

	// fixar na aplicação os índices dos atributos?
	// [1] -> eu não tenho um elastic search
	// pode vir reclamações e problemas com maiúsculas, separadores...
	// por isso, indexar aqui seria mais intreressante
	// não gasto tempo com busca!
	// simplesmenta a planilha respeita a aplicação
	// o teste fica mais rápido
	// o Se o POO aceitar, beleza
	// senão implementa depois

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

	// ou permitir a busca, que abrirá a chance de
	// algum atributo faltar... levando a mais complexidade?

	private String username;
	private String password;

	public LoginModel(String username, String password) {
		setUsuario(username);
		setSenha(password);
	}

	public LoginModel() {
		this(TestContext.getRowByTaggedIdSheet());
	}

	
	//não queremos manipulação de excel aqui neste nível
	//porque não usaremos nada estático....
	
	public LoginModel(Row row) {
		// ok, mas os índices já deveria estar prontos?
		// ou por que já não retornar o valor?
		
		
		setUsuario(
				
				//o ruim de retornar um ROW é precisar de um utils de excel aqui
				//para pegar o valor String independentemente do tipo
				row.getCell(LoginAttributes.USERNAME.index)
				.getStringCellValue()
		);
		
		
		setSenha(row.getCell(LoginAttributes.PASSWORD.index)
				.getStringCellValue())
		;
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
