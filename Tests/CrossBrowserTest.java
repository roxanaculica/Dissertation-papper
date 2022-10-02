package Tests;

import static org.testng.Assert.assertEquals;

import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	WebDriver driver;
	
	@Parameters("browser")
	@Test
	public void launchApp(String browser){
		
		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\selemiunDrivers\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\selemiunDrivers\\geckodriver\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "D:\\Selenium\\selemiunDrivers\\edgedriver\\msedgedriver.exe");
			driver= new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://www.goodreads.com/");
		String title = driver.getTitle();
		String expectedTitle = "Goodreads | Meet your next favorite book";
		assertEquals(expectedTitle, title);
		driver.close();
	}
}
