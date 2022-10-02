package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class ProfilePage {

	WebDriver driver;

	@FindBy(xpath="/html/body/div[2]/div/header/div[2]/div/div[3]/ul/li[5]/div/a")
	WebElement profileIcon;
	@FindBy(xpath="/html/body/div[2]/div/header/div[2]/div/div[3]/ul/li[5]/div/div/div/ul/li[9]/a")
	WebElement favoriteGenres;
	@FindBy(id="genre_Historical fiction")                     //locate and declare web elements 
	WebElement historicalFiction;                              //for adding a favorite genre
	@FindBy(xpath="//*[@id=\"fav_genres_form\"]/div[3]/input")
	WebElement continueBtn;
	@FindBy(xpath="//*[@id=\"nav_to_historical-fiction\"]")
	WebElement text;
	
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); //initialize web elements
	}
	
	public void addFavoriteGenre() {
		profileIcon.click();          //declare method for adding a a favorite genre
		favoriteGenres.click();
		historicalFiction.click();
		continueBtn.click();
	}
	
	public String getGenreName() {
		return text.getText();    //returning genre name
	}
	
	//locate and declare web elements for adding quotes
	@FindBy(xpath="/html/body/div[2]/div/header/div[2]/div/div[3]/ul/li[5]/div/div/div/ul/li[8]")
	WebElement quotes;
	@FindBy(xpath="/html/body/div[2]/div[3]/div[1]/div[1]/div[3]/a[2]")
	WebElement addAQuote;
	@FindBy(id="quote_body")
	WebElement quoteBody;
	@FindBy(id="quote_author_name")
	WebElement quoteAuthorName;
	@FindBy(id="quote_tags_string")
	WebElement quoteTag;
	@FindBy(xpath="/html/body/div[1]/div[3]/div[1]/div[1]/div[2]/form/input[4]")
	WebElement saveBtn;
	@FindBy(xpath="//*[@id=\"header_notice_container\"]/div")
	WebElement message;

	public void addQuote(String quote, String author, String tag) {
		profileIcon.click();
		quotes.click();
		addAQuote.click();                            //declare method for adding a quote
		quoteBody.sendKeys(quote);
		quoteAuthorName.sendKeys(author);
		quoteTag.sendKeys(tag);
		saveBtn.click();   
	}
	
	public String getMessage() {
		return message.getText(); //returning message of successfully adding quote
	}
}
