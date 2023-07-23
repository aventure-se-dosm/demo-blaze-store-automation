package business.step_classes;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;

import core.actions.ExcelActions;
import test.context.TestContext;
import test_enums.Attributes.FilterProductAtttributes;

public class Logic {

	protected Row attributeHeaderRow;
	ExcelActions excelActions;

	protected Logic() {
		this.excelActions = new ExcelActions();
		this.attributeHeaderRow = (TestContext.getRowByTaggedIdSheet());
	}


	protected String getValue(Integer attributeIndex) {
		String s = excelActions.getCellValueText(attributeHeaderRow.getCell(attributeIndex));
		return StringUtils.capitalize(s.toLowerCase());
	}

	protected Integer getAttributeIndex(String category) {
		return excelActions.indexOfAttribute(category);
	}

	protected Integer getValue(FilterProductAtttributes attribute, String category) {

		return excelActions.indexOfAttribute(attribute.name());


	}

}
