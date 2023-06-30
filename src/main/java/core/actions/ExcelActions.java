package core.actions;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelActions {

	private final int HEADER_ROW_INDEX = 0;
	// private Iterator<Cell> cellIterator;

	void searchForAttribute(Sheet sheet, String attribute) {
		Iterator<Cell> cellIterator = sheet.getRow(HEADER_ROW_INDEX).cellIterator();

		while (cellIterator.hasNext()) {
			if (getCellStringValue(cellIterator.next()).equals(attribute)) {

			}
		}

	}

	private String getCellStringValue(Cell cell) {
		switch (cell.getCellType()) {
		case NUMERIC: {
			return Double.toString(cell.getNumericCellValue());
		}
		case BOOLEAN: {
			Boolean.toString(cell.getBooleanCellValue());
		}
		case ERROR: {
			return Byte.toString(cell.getErrorCellValue());
		}
		case FORMULA: 
		case STRING:
		case _NONE: {
			return cell.getStringCellValue();
		}
		default: {
			// TODO: oportunidade de Exceção personalizada
			throw new RuntimeException("Tipo de célula não suportado!");
		}
		}

		// Se esse actions está no core
		// ele não deveria ser usado pelo
		// leitor no core

		// a conversão acontece lá embaixo

		// forçar com ignoreCase?
	}

	public static Row getRow(Object value) {
		// TODO Auto-generated method stub
		return null;
	}
}
