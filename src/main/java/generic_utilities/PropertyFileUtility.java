package generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	
	public String readDataFromProperties(String data) throws IOException
	{
		FileInputStream fis = new FileInputStream(IconstantUtility.propertyfilepath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String propertydata=pobj.getProperty(data);
		
		return propertydata;
	}

}
