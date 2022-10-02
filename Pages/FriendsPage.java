package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class FriendsPage{
	
	WebDriver driver;

	@FindBy(xpath="/html/body/div[2]/div[3]/div[1]/div[1]/div[3]/p/a")
	WebElement addSomeFriends;
	@FindBy(xpath="//*[@id=\"q\"]")                                             //locate and declare web elements
	WebElement friendName;
	@FindBy(xpath="/html/body/div[1]/div[3]/div[1]/div[1]/div[4]/form/input[4]")
	WebElement searchButton;
	@FindBy(xpath="/html/body/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/a")
	WebElement displayName;
	@FindBy(xpath="/html/body/div[2]/div/header/div[2]/div/div[3]/ul/li[4]/a/span")
	WebElement friendsButton;
	
	public FriendsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);     //initialize web elements
	}
	
	public void findFriend(String name) {
		friendsButton.click();
		addSomeFriends.click();          //declare method for finding a friend
		friendName.sendKeys(name);
		searchButton.click();
	}
	
	public String getName() {
		return displayName.getText();  //declare method for returning the name
	}
}
