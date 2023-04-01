package leadsModule;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import generic_utilities.ExcelFileUtility;
import generic_utilities.JavaUtilities;
import generic_utilities.PropertyFileUtility;

public class GenericUtilityTesting {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		
		ExcelFileUtility eutil = new ExcelFileUtility();
	     String d = eutil.readDataFromExcelFile("Opportunity", 2, 0);
		System.out.println(d);
		
		PropertyFileUtility putil = new PropertyFileUtility();
		String URL = putil.readDataFromProperties("url");
		System.out.println(URL);
		
		JavaUtilities jutil = new JavaUtilities();
		
		System.out.print(jutil.getRandomNumber());
	}

}
