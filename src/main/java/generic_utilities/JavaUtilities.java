package generic_utilities;

import java.util.Random;

public class JavaUtilities {
	
	public int getRandomNumber()
	{
		Random r = new Random();
		int num = r.nextInt(1000);
		return num;
	}

}
