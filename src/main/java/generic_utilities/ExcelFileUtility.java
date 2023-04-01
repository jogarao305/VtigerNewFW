package generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Joga rao
 * this class reads data from the excel file
 * 
 */
public class ExcelFileUtility {

	public String readDataFromExcelFile(String SheetName, int rownum, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IconstantUtility.Excelfilepath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(SheetName);
		DataFormatter df = new DataFormatter();
		String testdata = df.formatCellValue(sh.getRow(rownum).getCell(cell));
		book.close();
		return testdata;
	}
}
