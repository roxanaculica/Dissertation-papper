package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{
	
	public static WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void initialize() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goodreads.com/");
		login = new LoginPage(driver);
		login.loginApplication("roxanaculica@yahoo.com","test123");	
	}
	@AfterMethod
	public void closeDriver() {
		driver.close();
	} 
}
