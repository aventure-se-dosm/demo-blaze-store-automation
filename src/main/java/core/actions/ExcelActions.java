package core.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.management.RuntimeErrorException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import core.utils.enums.ScenarioContextKeys;
import core.utils.enums.ValidFileFormats.DataSourceFormats;
import test.context.TestContext;

public class ExcelActions {

	private Workbook workbook;

	public ExcelActions() {
		setupWorkBook();
	}

	public Workbook getWorkbook() {
		return this.workbook;
	}

	String getCellValueText(Cell cell) {

		switch (cell.getCellType()) {
		case BOOLEAN: {
			return String.valueOf(cell.getBooleanCellValue());
		}
		case NUMERIC: {
			return String.valueOf(cell.getNumericCellValue());
		}
		case STRING:
		default: {
			return String.valueOf(cell.getStringCellValue());
		}
		}
	}

	private Sheet getSheet() {
		return getSheet(TestContext.getScenarioContext().getStringValue(ScenarioContextKeys.SCENARIO_ID));
	}

	public Sheet getSheet(String sheetName) {
		return getWorkbook().getSheet(sheetName);
	}

	public void getFistRow() {
		getSheet(TestContext.getScenarioContext().getStringValue(ScenarioContextKeys.SCENARIO_ID))
				.getRow(TestContext.FIRST_DATA_ROW_INDEX);
	}

	Integer indexOfAttribute(String attribute) {
		Iterator<Cell> rowIterator = getSheet().getRow(TestContext.HEADER_INDEX).cellIterator();
		while (rowIterator.hasNext()) {
			Cell cell;
			if (getCellValueText(cell = rowIterator.next()).equalsIgnoreCase(attribute)) {
				return cell.getColumnIndex();
			}
		}
		throw new RuntimeErrorException(null, String.format("Erro: attributo '%s' não encontrado!", attribute));
	}

	private void setupWorkBook() {

		try {
			File file = new File(TestContext.getConfigReader().getDataSetFullPath());

			String workbookFormat = TestContext.getConfigReader().getDataSetFormat();
			switch (DataSourceFormats.valueOf(workbookFormat.toUpperCase())) {
			case XLSX: {
				this.workbook = new XSSFWorkbook(new FileInputStream(file));
				break;
			}
			case XLS: {
				this.workbook = new HSSFWorkbook(new FileInputStream(file));
				break;
			}
			default: {
				throw new RuntimeException(String.format("Formato '%s' não suportado."));
			}

			}
		} catch (IOException exc) {
			exc.printStackTrace();
		}

	}

	public Row getRow(String sheetName, int index) {
		return getWorkbook().getSheet(sheetName).getRow(index);
	}

}
