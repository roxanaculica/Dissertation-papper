package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class HomePage{
	
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div[4]/main/div[1]/section[2]/div/div/div/div[2]/div[2]/input")
	WebElement challenge;
	@FindBy(xpath="/html/body/div[4]/main/div[1]/section[2]/div/div/div/div[2]/div[2]/button")
	WebElement challengeButton;
	@FindBy(className="readingChallengeStatusBox__bookCount")                                //declare web elements for setting up
	WebElement challengeStatus;                                                              // a challenge
	@FindBy(xpath="/html/body/div[4]/main/div[1]/section[2]/div/div/div/div[2]/div[3]/a")
	WebElement viewChallengeButton;
	@FindBy(xpath="//*[@id=\"readingChallenge2022Dashboard\"]/div/div/div[2]/div[1]/div[1]/a")
	WebElement edit;
	@FindBy(id="user_challenge_goal")
	WebElement numberOfBooks;
	@FindBy(xpath="//*[@id=\"header_notice_container\"]/div/div")
	WebElement message;
	@FindBy(xpath="//*[@id=\"readingChallenge2022Dashboard\"]/div/div/div[2]/form/div[2]/button[2]")
	WebElement update;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);   //initialize web elements
	}
	
	public void setUpChallenge(Integer number) {
		challenge.sendKeys(String.valueOf(number));  //declare method for setting up challenge
		challengeButton.click();
	}

	public String getStatus() {
		return challengeStatus.getText();  //declare method for returning the status
	}
	
	public void editCahllenge(Integer number) {
		viewChallengeButton.click();
		edit.click();                      //declare method for updating challenge
		numberOfBooks.clear();
		numberOfBooks.sendKeys(String.valueOf(number));
		update.click();
	}
	
	public String getMessage() {
		return message.getText();  //declare method for returning the message
	}
	
	@FindBy(name="q")
	WebElement search;              //locate and declare web elements for book searching
	@FindBy(className="bookTitle")
	WebElement title;
	
	public void searchAction(String bookTitle) {
		search.sendKeys(bookTitle);        //declare method for book searching
		search.sendKeys(Keys.ENTER);
	}
	
	public String getTitle() {       //declare method for returning the message
		return title.getText();      //the title of book found
	}
}
