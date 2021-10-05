package org.hexa.in;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class AdactinHotel {
	static WebDriver driver;
	@BeforeClass
	private void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://adactinhotelapp.com/");
	}
	@Parameters({"userName", "password"})
	@Test(priority = -5)
	private void loginPage(String userName, String password) {
		WebElement txtUserName = driver.findElement(By.name("username"));
		txtUserName.sendKeys(userName);
		WebElement txtPassword = driver.findElement(By.name("password"));
		txtPassword.sendKeys(password);
		WebElement btnLogin = driver.findElement(By.name("login"));
		btnLogin.click();
	}
	@Parameters({"location", "hotels", "roomTypes"})
	@Test(priority = -2)
	private void searchHotel(String location, String hotels, String roomTypes) {
		WebElement ddLocation = driver.findElement(By.name("location"));
		Select loc = new Select (ddLocation);
		loc.selectByVisibleText(location);
		WebElement ddHotels = driver.findElement(By.name("hotels"));
		Select hotel = new Select(ddHotels);
		hotel.selectByVisibleText(hotels);
		WebElement ddRoomType = driver.findElement(By.name("room_type"));
		Select roomType = new Select (ddRoomType);
		roomType.selectByVisibleText(roomTypes);
		WebElement btnSearch = driver.findElement(By.name("Submit"));
		btnSearch.click();
	}
	@Test
	private void selectHotel() {
		WebElement btnRadio = driver.findElement(By.name("radiobutton_0"));
		btnRadio.click();
		WebElement btnContinue = driver.findElement(By.name("continue"));
		btnContinue.click();
	}
	@Parameters({"firstName", "lastName", "billingAddress", "creditNo", 
		"creditcardType", "expMonth", "expYear", "cvv"})
	@Test(priority = 2)
	private void bookAHotel(String firstName, String lastName, String billingAddress,
			String creditNo, String creditcardType, String expMonth,String expYear, String cvv) {
		WebElement txtFirstName = driver.findElement(By.name("first_name"));
		txtFirstName.sendKeys(firstName);
		WebElement txtLastName = driver.findElement(By.name("last_name"));
		txtLastName.sendKeys(lastName);
		WebElement txtAddress = driver.findElement(By.id("address"));
		txtAddress.sendKeys(billingAddress);
		WebElement txtCreditCardNo = driver.findElement(By.name("cc_num"));
		txtCreditCardNo.sendKeys(creditNo);
		WebElement ddCreditType = driver.findElement(By.id("cc_type"));
		Select creditType = new Select (ddCreditType);
		creditType.selectByVisibleText(creditcardType);
		WebElement ddExpiryMonth = driver.findElement(By.name("cc_exp_month"));
		Select month  = new Select (ddExpiryMonth);
		month.selectByVisibleText(expMonth);
		WebElement ddExpiryYear = driver.findElement(By.name("cc_exp_year"));
		Select year = new Select (ddExpiryYear);
		year.selectByVisibleText(expYear);
		WebElement txtCVVNo = driver.findElement(By.name("cc_cvv"));
		txtCVVNo.sendKeys(cvv);
		WebElement btnBookNow = driver.findElement(By.name("book_now"));
		btnBookNow.click();
	}
	@Test(priority = 5)
	private void bookingConfirmation() throws InterruptedException {
		Thread.sleep(5000);
		WebElement orderNumber = driver.findElement(By.name("order_no"));
		String orderNo = orderNumber.getAttribute("value");
		System.out.println("Order Number is " + orderNo);
	}
    
	

}
