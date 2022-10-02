package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class LoginPage{
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"signIn\"]/div/div/a")
	WebElement signIn;
	@FindBy(id="ap_email")
	WebElement txtEmail;	               //locate and declare web elements
	@FindBy(id="ap_password")
	WebElement txtPassword;	
	@FindBy(id="signInSubmit")
	WebElement button;	
	@FindBy(xpath="//*[@id=\"auth-error-message-box\"]/div/div")
	WebElement message;	
	@FindBy(xpath="//*[@id=\"auth-warning-message-box\"]/div/div/ul/li/span")
	WebElement importantMessage;
	@FindBy(xpath="/html/body/div[2]/div/header/div[2]/div/div[3]/ul/li[5]/div/a")
	WebElement profile;	
	@FindBy(xpath="/html/body/div[2]/div/header/div[2]/div/div[3]/ul/li[5]/div/div/div/span/span[2]")
	WebElement userName;	
	@FindBy(xpath="//*[@id=\"choices\"]/div/a[2]/button")
	WebElement signInWithEmail;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);  //initialize web elements
	}
	
	public void clickOnProfileIcon() {
		profile.click();
	}
	
	public void loginApplication(String email, String password) {
		signIn.click();
		signInWithEmail.click();                    //declare method for login
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		button.click();
	}
	
	public String getMessage() {   //method for returning
		return message.getText();  // the message of invalid login
	}
	public String getImportantMsg() {
		return importantMessage.getText();
		
	}
	
	public String getUserName() {
		return userName.getText();  //returning the user name
	}
}
