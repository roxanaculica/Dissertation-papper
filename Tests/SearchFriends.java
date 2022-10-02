package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseClass;

import static org.testng.AssertJUnit.assertEquals;

import java.text.Normalizer.Form;

import org.jsoup.internal.Normalizer;

import Pages.FriendsPage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchFriends extends BaseClass{
	
	FriendsPage friends ; 
	
	@Test
	public void successfullyFindFriend() {
		friends = new FriendsPage(driver);
		friends.findFriend("Roxana Culica");
		String name= friends.getName();
		assertEquals(name,"Roxana Culica");	
	}
}
