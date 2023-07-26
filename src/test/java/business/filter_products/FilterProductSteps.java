package business.filter_products;

import org.junit.Assert;

import business.login.LoginLogic;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class FilterProductSteps {

	private FilterProductLogic filterLogic;
	private LoginLogic loginLogic;

	@Dado("que estou logado na página para filtrar o produto")
	public void queEstouLogadoNaPáginaParaFiltrarOProduto() {
		filterLogic = new FilterProductLogic();
		loginLogic = new LoginLogic();
		loginLogic.startNavigation();
		loginLogic.startLogin();
		loginLogic.preencherUsuarioLogin();
		loginLogic.preencherSenhaLogin();
		loginLogic.sendLoginForm();
		Assert.assertTrue(loginLogic.isUserProperlyLoggedIn());
	}

	@Quando("clico na categoria desejada em ProductCategoryPage")
	public void clicoNaCategoriaDesejadaEmProductCategoryPage() {
		filterLogic = new FilterProductLogic();
		filterLogic.selectCategory();
	}

	@Então("Há pelo menos um produto com a marca desejada")
	public void realizoEFilterProduct() {
		filterLogic.isThereAtLeastOneProductOfTheGivenTrademark();
	}

}
