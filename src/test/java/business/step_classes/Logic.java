package business.step_classes;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;

import core.actions.ExcelActions;
import test.context.TestContext;
import test.test_enums.Attributes.FilterProductAtttributes;

public class Logic {

	// protected String[] attributeHeaderRow;
	protected Row attributeHeaderRow;
	ExcelActions excelActions;

	// ideia... fazer um detup d planilha, já t

	protected Logic() {
		this.excelActions = new ExcelActions();
		this.attributeHeaderRow = (TestContext.getRowByTaggedIdSheet());
	}

	private Row getattributeHeaderRow() {
		return this.attributeHeaderRow;
	}

	protected String getValue(Integer attributeIndex) {
		String s = excelActions.getCellValueText(attributeHeaderRow.getCell(attributeIndex));
		return StringUtils.capitalize(s.toLowerCase());
	}

	protected Integer getAttributeIndex(String category) {
		return excelActions.indexOfAttribute(category);
	}

	protected String getValue(FilterProductAtttributes attribute, String category) {
		
		excelActions.indexOfAttribute(attribute.name());
		
		
		
		
		return null;
		
	}

}
