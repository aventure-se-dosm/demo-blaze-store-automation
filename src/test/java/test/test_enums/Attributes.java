package test.test_enums;

public class Attributes {

	public enum FilterProductAtttributes {

		USERNAME(0),
		USUARIO(0),
		PASSWORD(1), 
		SENHA(1), 
		PRODUCT_CATEGORY(2), 
		CATEGORIA(2), 
		FIRST_PRODUCT_CATEGORY(2), 
		CATEGORIA_1(2), 
		SECOND_PRODUCT_CATEGORY(3),
		CATEGORIA_2(3),
		MARCA(3),
		PRODUCT_BRAND(3);
		private int index;

		FilterProductAtttributes(int index) {
			this.index = index;
		}

		public int getIndex() {
			return this.index;
		}
	}
}