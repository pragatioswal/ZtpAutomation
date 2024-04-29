//This is login page for support portal
//@author : Praggati Oswal
package ztp.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ztp.qa.base.TestBase;
import ztp.qa.util.TestUtil;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	
	@FindBy(id="signInName")
	WebElement username;
	

	@FindBy(id="password")
	WebElement password;
	

	@FindBy(id="next")
	WebElement loginBtn;
	

	@FindBy(xpath = "//img[@alt='Company Logo']")
	WebElement mainlogo;
	
	@FindBy(xpath = "//h2[normalize-space()='Sign in with your existing account']")
	WebElement loginHeader;
	
	/**
	 * Initializing the Page Objects:
	 */
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Validates login page title
	 * @return title as string
	 */
	public String validateLoginPageTitle(){
	
		waitForVisibilityOf(loginHeader, 10);
		return driver.getTitle();
	}
	
	/**
	 * Validates Main logo image
	 * @return true if displayed else false
	 */
	public boolean validateMainLogoImage(){
		waitForElementToDisplay(mainlogo,10);
		return mainlogo.isDisplayed();
	}
	
	/**
	 * This function inputs username and password and clicks login button
	 * @return HomePage
	 */
	public HomePage login(String un, String pwd){
		log.info("Log into support portal");
		username.sendKeys(un);
		password.sendKeys(pwd);
		waitForElementToDisplay(loginBtn,20);
		TestUtil.sleep(2000);
		//loginBtn.click();	
		clickIt(loginBtn);
		return new HomePage();
	}

}
