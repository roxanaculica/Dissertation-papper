package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;

public class MyBooks{
	
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div[2]/div/header/div[2]/div/nav/ul/li[2]")
	WebElement myBooksPage;
	@FindBy(xpath="//*[@id=\"review_4646849367\"]/td[15]/div/a")
	WebElement editButton;                                        //locate and declare web elements
	@FindBy(id="shelfChooser0shelf_currently-reading")            // for setting up currently reading status
	WebElement currentlyReadingButton;
	@FindBy(xpath="//*[@id=\"shelfList149433406_41147630\"]/a")
	WebElement readingText;
	@FindBy(xpath="//*[@id=\"shelfChooser0chooser\"]/a[1]")
	WebElement closeBtn;
	
	@FindBy(id="shelfChooser0shelf_read")  // locate and declare web elements
	WebElement readButton;                 //for setting up read status
	@FindBy(id="shelfChooser0shelf_to-read")
	WebElement toReadButton;

	@FindBy(xpath="//*[@id=\"review_4742685096\"]/td[4]/div/a")
	WebElement title;
	@FindBy(xpath="//*[@id=\"reading_current_status\"]/a")
	WebElement updateBtn;                                 // locate and declare web elements
	@FindBy(xpath="//*[@id=\"user_status_page\"]")       // for updating progress
	WebElement progress;
	@FindBy(id="reading_submit")
	WebElement saveProgressBtn;
	@FindBy(xpath="//*[@id=\"reading_current_status\"]/div")
	WebElement progressText;
	@FindBy(xpath="//*[@id=\"user_status\"]/div")
	WebElement notice;
	
	@FindBy(xpath="//*[@id=\"side\"]/div[2]/a")
	WebElement addShelfBtn;                      // locate and declare web elements
	@FindBy(id="user_shelf_name")               // add new shelf
	WebElement newShelfAdd;
	@FindBy(className="gr-form--compact__submitButton")        	
	WebElement addBtn;
	@FindBy(xpath="//*[@id=\"paginatedShelfList\"]/div[6]/a")
	WebElement newShelfText;
	
	public MyBooks(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);   //initialize web elements
	}
		
	public void accessMyBooksPage(){
		myBooksPage.click();
	}
	
	public void setCurrentlyReadingStatus(){
		editButton.click();               //set currently reading status
		currentlyReadingButton.click();
		closeBtn.click();
	}

	public String getCurrentlyReadingText(){
		return readingText.getText();      //returning status name
	}
	
	public void setReadStatus(){
		editButton.click();       //set read status
		readButton.click();
		closeBtn.click();
	}
	
	public void setToReadStatus(){
		editButton.click();        //set to read status
		toReadButton.click();
		closeBtn.click();
	}
	
	public void addNewShelf(String name){
		addShelfBtn.click();            // add new shelf
		newShelfAdd.sendKeys(name);
		addBtn.click();		
	}
	
	public void waiting() {   
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(newShelfText));
	}
	
	public void waitForMyBooks() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(myBooksPage));
	}
	
	public String getNewShelfName() {
		return newShelfText.getText();
	}
	
	public void updateProgress(Integer pageNumber) {
		myBooksPage.click();
		title.click();                       	// method for updating progress
		updateBtn.click();
		progress.clear();
		progress.sendKeys(String.valueOf(pageNumber));
		saveProgressBtn.click();
	}
	
	public String getProgressMessage() {
		return progressText.getText();   //returning progress message
	}
	
	public String getNoticeText() {
		return notice.getText();    //returning notice for failed progress setting
	}
}
