package core.readers.data_readers;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import core.actions.ExcelActions;

public class ExcelReader {

	private ExcelActions excelActions;

	public ExcelReader() {
		setExcelActions();
	}

	private void setExcelActions(ExcelActions excelActions) {
		this.excelActions = excelActions;
	}
	
	private void setExcelActions() {
		setExcelActions(new ExcelActions());
	}

	private Workbook getWorkbook() {
		return excelActions.getWorkbook();
	}

	public Sheet getSheet(String sheetName) {
		return getWorkbook().getSheet(sheetName);
	}
	
	public ExcelActions actions() {
		return this.excelActions;
	}

}
