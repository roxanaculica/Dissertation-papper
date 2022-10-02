package Tests;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTests {
	
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void initialize() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		login = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.get("https://www.goodreads.com/");	
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.close();
	} 
	
	@Test(priority=1, groups = {"TS_001"})
	public void shouldLoginSuccessfully() {
		
		login.loginApplication("roxanaculica@yahoo.com","test123");
		login.clickOnProfileIcon();
		assertEquals(login.getUserName(),"ROX");	
		System.out.println(driver.getTitle());
	}
	
	@Test(priority=2, groups = {"TS_001"})
	public void shouldFailLoginWithInvalidEmail() {	
		login.loginApplication("roxana@yahoo.com","test123");
		//assertEquals(login.getMessage(),"We cannot find an account with that email address");
		String text = "To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below.";
		assertEquals(login.getImportantMsg(),text);
		System.out.println(driver.getTitle());
	}
	
	@Test(priority=3, groups = {"TS_001"})
	public void shouldFailLoginWithInvalidPass() {
		login.loginApplication("roxanaculica@yahoo.com","p@ss");
		assertEquals(login.getMessage(),"Your password is incorrect");
		//String text = "To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below.";
		//assertEquals(login.getImportantMsg(),text);
	}
}
