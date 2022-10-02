package Tests;


import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchBook extends BaseClass{
	
	HomePage search; 

	@Test
	public void successfullySearchBook() {
		search = new HomePage(driver);
		search.searchAction("Mizerabilii");
		assertEquals(search.getTitle(),"Mizerabilii");
		System.out.println("Book found");
	}	
}
