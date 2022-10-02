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
import Pages.LoginPage;
import Pages.MyBooks;
import Pages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateBookProgress extends BaseClass {
	
	MyBooks progress;

	@Test(priority=1)
	public void successfullyUpdateProgress() throws InterruptedException{
		progress = new MyBooks(driver);
		progress.updateProgress(82);
		Thread.sleep(1000);
		String text = "I'm on page 82 of 256 of Imperiul iadului";
		assertEquals(progress.getProgressMessage(),text);	
	}

	@Test(priority=2)
	public void shouldFailUpdateProgress() throws InterruptedException {
		progress = new MyBooks(driver);
		progress.updateProgress(-1);
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"user_status\\\"]/div")));
		Thread.sleep(1000);
		String txt = "[\"Page must be greater than or equal to 0\", \"Page must be greater than or equal to 0\"]";
		assertEquals(progress.getNoticeText(), txt);
	}
}  
