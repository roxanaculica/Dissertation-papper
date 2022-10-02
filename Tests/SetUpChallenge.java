package Tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUpChallenge extends BaseClass{
	
	HomePage challenge;

	@Test(priority=1)
	public void successfullySetUpChallenge() {
		challenge = new HomePage(driver);
		challenge.setUpChallenge(20);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("readingChallengeStatusBox__bookCount")));	
		assertEquals(challenge.getStatus(),"9");
	}
	
	@Test(priority=2)
	public void successfullyEditChallenge() {
		challenge = new HomePage(driver);
		challenge.editCahllenge(23);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header_notice_container\"]/div/div")));	
		assertEquals(challenge.getMessage(),"Your challenge has been updated!");		
	}	
}
