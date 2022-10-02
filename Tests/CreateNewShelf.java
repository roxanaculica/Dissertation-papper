package Tests;

import org.testng.annotations.Test;

import Base.BaseClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.MyBooks;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewShelf extends BaseClass{
	
	MyBooks myBooks;

	@Test(priority = 1)
	public void successfullyCreateShelf() {
		myBooks = new MyBooks(driver);
		myBooks.accessMyBooksPage();
		myBooks.addNewShelf("my shelf");
		myBooks.waiting();
		assertEquals(myBooks.getNewShelfName(),"my-shelf (0)");
	}

	@Test(priority = 2)
	public void shouldFailCreatingAnIdenticShelf() throws InterruptedException {
		myBooks = new MyBooks(driver);
		myBooks.accessMyBooksPage();
		myBooks.addNewShelf("my shelf");
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		assertEquals(alert.getText(),"Shelf couldn't be created. Shelf name is either invalid or a duplicate.");
		alert.accept();
	}
}
