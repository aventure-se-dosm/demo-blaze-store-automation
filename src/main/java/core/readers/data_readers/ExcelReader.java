package core.readers.data_readers;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import core.actions.ExcelActions;

public class ExcelReader {

	private ExcelActions excelActions;
	private Workbook wb;
	private Sheet sheet;

	// sem construtor: usa as configurações
	// default: definidas no config.properties
	// qual SHEET será escolhida dependerá
	// obviamente dda tag definida
	public ExcelReader() {
		setupWorkBook();
	}

	private void setupWorkBook() {
		// TODO: get the full path built prom config properties
	}

}
