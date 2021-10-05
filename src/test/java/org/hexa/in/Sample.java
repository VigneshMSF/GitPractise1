package org.hexa.in;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
	
	@Test(dataProvider = "test", dataProviderClass = DataProvidersSample.class)
	private void test1(String userName, String password ) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://adactinhotelapp.com/");
		WebElement txtUserName = driver.findElement(By.name("username"));
		txtUserName.sendKeys(userName);
		WebElement txtPassword = driver.findElement(By.name("password"));
		txtPassword.sendKeys(password);
		WebElement btnLogin = driver.findElement(By.name("login"));
		btnLogin.click();
		
	}
	

}
