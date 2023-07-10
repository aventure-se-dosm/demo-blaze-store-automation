package core.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.management.RuntimeErrorException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import core.utils.enums.ScenarioContextKeys;
import core.utils.enums.ValidFileFormats.DataSourceFormats;
import test.context.TestContext;

public class ExcelActions {

	private static final int FIRST_DATA_ROW_INDEX = 1;
	private static final int HEADER_INDEX = 0;
	private Workbook workbook;

	public ExcelActions() {
		setupWorkBook();
	}

	public Workbook getWorkbook() {
		return this.workbook;
	}

	private void setupWorkBook() {

		try {
			File file = new File(TestContext.getConfigReader().getDataSetFullPath());

			String x = TestContext.getConfigReader().getDataSetFormat();
			switch (DataSourceFormats.valueOf(x.toUpperCase())) {
			case XLSX: {
				this.workbook = new XSSFWorkbook(new FileInputStream(file));
				break;
			}
			case XLS: {
				this.workbook = new HSSFWorkbook(new FileInputStream(file));
				break;
			}
			default: {
				// TODO: UNSUPPORTED DATA SOURCE TYPE EXCEPTION
				throw new RuntimeException(String.format("Formato '%s' não suportado."));
			}

			}
		} catch (IOException exc) {
			// TODO: Custom Exceptions
			exc.printStackTrace();
		}

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

	Integer indexOfAttribute(String attribute) {
		Iterator<Cell> rowIterator = getSheet().getRow(HEADER_INDEX).cellIterator();
		while (rowIterator.hasNext()) {
			Cell cell;
			if (getCellValueText(cell = rowIterator.next()).equalsIgnoreCase(attribute)) {
				return cell.getColumnIndex();
			}
		}
		// TODO: Custom Exception
		throw new RuntimeErrorException(null, String.format("Erro: attributo '%s' não encontrado!", attribute));
	}

	private Sheet getSheet() {
		return getSheet(TestContext.getScenarioContext().getStringValue(ScenarioContextKeys.SCENARIO_ID));
	}

	public Sheet getSheet(String sheetName) {
		return getWorkbook().getSheet(sheetName);
	}

}
