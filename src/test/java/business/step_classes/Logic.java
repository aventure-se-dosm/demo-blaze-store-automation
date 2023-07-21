package business.step_classes;

import org.apache.poi.ss.usermodel.Row;

import core.actions.ExcelActions;
import test.context.TestContext;

public class Logic {

	// protected String[] tuple;
	protected Row tuple;
	ExcelActions excelActions;

	// ideia... fazer um detup d planilha, já t

	protected Logic(){
		this.excelActions = new ExcelActions();
		this.tuple = (TestContext.getRowByTaggedIdSheet());
	}
	
	protected String getValue(int attributeIndex){
		String s = excelActions.getCellValueText(tuple.getCell(attributeIndex));
		return s;
	}

	public void login() {
		// TODO Auto-generated method stub
		
	}

}
