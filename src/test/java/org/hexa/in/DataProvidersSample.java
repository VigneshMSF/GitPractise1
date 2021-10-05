package org.hexa.in;

import org.testng.annotations.DataProvider;

public class DataProvidersSample {
	
	
	@DataProvider(name = "test")
	public Object[][] data(){
		
		Object obj[][] = new Object[][] {{"Vignesh234" , "123456789"}, {"Vignesh245", "123456789"},
			{"Vignesh234", "123456790"}, {"Vignesh245", "123456790"}, {"Vignesh234",""},
			{"","123456789"}, {"Vignesh245",""}, {"","123456790"}, {"",""}};
		return obj;
		
	}

}
