package Tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.FriendsPage;
import Pages.LoginPage;
import Pages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProfileTests extends BaseClass{
	
	ProfilePage profile; 
	
	@Test(priority =1)
	public void successfullyAddGenre() {
		profile = new ProfilePage(driver);
		profile.addFavoriteGenre();
		assertEquals(profile.getGenreName(),"Historical Fiction");
	}
	
	@Test(priority =2)
	public void successfullyAddQuote() {
		profile = new ProfilePage(driver);
		profile.addQuote("Un cosmar e un vis care a imbatranit urat", "Marc Levy", "inspirational");
		assertEquals(profile.getMessage(),"That quote has been saved.");
	}
}
