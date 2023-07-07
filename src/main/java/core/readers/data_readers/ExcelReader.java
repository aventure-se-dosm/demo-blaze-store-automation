package core.readers.data_readers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import core.actions.ExcelActions;
import core.utils.enums.ScenarioContextKeys;
import core.utils.enums.ValidFileFormats.DataSourceFormats;
import test.context.TestContext;

public class ExcelReader {

	private static final int FIRST_DATA_ROW_INDEX = 1;
	private ExcelActions excelActions;
	private Workbook wb;

	public ExcelReader() {
		setExcelActions(new ExcelActions());
		wb = setupWorkBook();
	}

	private void setExcelActions(ExcelActions excelActions) {
		this.excelActions = excelActions;
	}

	public Workbook getWorkbook() {
		return wb;
	}

	private Workbook setupWorkBook() {

		try {
			File file = new File(TestContext.getConfigReader().getDataSetFullPath());

			String x = TestContext.getConfigReader().getDataSetFormat();
			switch (DataSourceFormats.valueOf(x.toUpperCase())) {
			case XLSX: {
				return new XSSFWorkbook(file);
			}
			case XLS: {
				return new HSSFWorkbook(new FileInputStream(file));
			}
			default: {
				// TODO: UNSUPPORTED DATA SOURCE TYPE EXCEPTION
				throw new RuntimeException(String.format("Formato '%s' não suportado."));
			}

			}
		} catch (InvalidFormatException | IOException exc) {
			// TODO: Custom Exceptions
			exc.printStackTrace();
			return null;
		}
	}

	private Sheet getSheet() {
		return getSheet(TestContext.getScenarioContext().getStringValue(ScenarioContextKeys.SCENARIO_ID));
	}

	private Sheet getSheet(String sheetName) {
		return getWorkbook().getSheet(sheetName);
	}

	public Row getRow(String sheetName, Integer rowIndex) {
		return getSheet(sheetName).getRow(rowIndex);
	}

	public Row getRow(Integer rowIndex) {
		return getSheet().getRow(rowIndex);
	}

	public Row getRow() {
		return getSheet().getRow(FIRST_DATA_ROW_INDEX);
	}

}
