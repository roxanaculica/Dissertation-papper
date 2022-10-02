package Tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyBooks;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateShelves extends BaseClass{
	
	MyBooks myBooks;

	@Test(priority = 1)
	public void setCurrentlyReading() {
		myBooks = new MyBooks(driver);
		myBooks.accessMyBooksPage();
		myBooks.setCurrentlyReadingStatus();
		assertEquals(myBooks.getCurrentlyReadingText(),"currently-reading");
	}

	@Test(priority = 3)
	public void setRead() {
		myBooks = new MyBooks(driver);
		myBooks.accessMyBooksPage();
		myBooks.setReadStatus();
		assertEquals(myBooks.getCurrentlyReadingText(),"read");
	}
	
	@Test(priority = 2)
	public void setToRead() {	
		myBooks = new MyBooks(driver);
		myBooks.accessMyBooksPage();
		myBooks.setToReadStatus();;
		assertEquals(myBooks.getCurrentlyReadingText(),"to-read");
	}
}
