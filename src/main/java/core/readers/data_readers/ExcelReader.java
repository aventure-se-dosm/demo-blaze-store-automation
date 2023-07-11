package core.readers.data_readers;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import core.actions.ExcelActions;

public class ExcelReader {

	private ExcelActions excelActions;

	public ExcelReader() {
		setExcelActions();
	}

	public ExcelActions actions() {
		return this.excelActions;
	}
	
	public Sheet getSheet(String sheetName) {
		return getWorkbook().getSheet(sheetName);
	}

	private Workbook getWorkbook() {
		return excelActions.getWorkbook();
	}

	private void setExcelActions() {
		setExcelActions(new ExcelActions());
	}
	
	private void setExcelActions(ExcelActions excelActions) {
		this.excelActions = excelActions;
	}

}
