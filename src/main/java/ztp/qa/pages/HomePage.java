//This is home page for support portal
//@author : Praggati Oswal
package ztp.qa.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ztp.qa.base.TestBase;
import ztp.qa.util.TestUtil;

public class HomePage extends TestBase {

	LoginPage loginPage;
	// Page Factory - OR:

	@FindBy(xpath = "//mat-card-title[normalize-space()='Support Portal']")
	WebElement SPLabel;

	@FindBy(xpath = "//button[@class='mat-menu-trigger btn btn-light rounded-circle initial-button']")
	WebElement LogoutMenu;
	
	@FindBy(xpath = "//button[normalize-space()='Log Out']")
	WebElement LogoutBtn;

	@FindBy(xpath = "//div[@role='listbox']")
	WebElement StoreListBox;
	
	@FindAll({ @FindBy(xpath = "//input") })
	List<WebElement> AllTextBoxes;
	
	@FindBy(xpath = "//span[@class='mat-option-text']")
	WebElement Value;
	
	@FindBy(xpath = "//button[@class='mat-focus-indicator search-button mat-flat-button mat-button-base']")
	WebElement RM_SearchBtn;
	
	/**
	 * Initializing the Page Objects:
	 */
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Validates the Support portal lable to confirm that page is loaded
	 * @return true when label is displayed
	 */
	public boolean validateSPLabel() {
		waitForVisibilityOf(SPLabel, 10);
		return SPLabel.isDisplayed();
	}

	/**
	 * This function logs out from the support portal
	 * @return login page
	 */
	public LoginPage Logout() {

		waitForVisibilityOf(LogoutMenu, 10);
		TestUtil.sleep(2000);
		clickIt(LogoutMenu);
		//LogoutMenu.click();
		clickIt(LogoutBtn);
		//LogoutBtn.click();
		return new LoginPage();
	}
	
	/**
	 * This function sets the values of brand, franchise and store name and click on search button
	 * @return supportTools page
	 */
	public SupportToolsPage RMSearch() {
		String store= prop.getProperty("store");
		String storeXpath= "//span[@class='mat-option-text' and contains(text(),'"+ store +"')]";
		clickIt(AllTextBoxes.get(0));
		//AllTextBoxes.get(0).click();
		clickIt(Value);
		//Value.click();
		clickIt(AllTextBoxes.get(1));
		//AllTextBoxes.get(1).click();
		clickIt(Value);
		//Value.click();
		clickIt(AllTextBoxes.get(2));
		//AllTextBoxes.get(2).click();
	

		waitForVisibilityOf(StoreListBox, 10);
		WebElement storeNameOrNumber = driver.findElement(By.xpath(storeXpath));
		clickIt(storeNameOrNumber);
		//storeNameOrNumber.click();
		waitForVisibilityOf(RM_SearchBtn, 10);
		clickIt(RM_SearchBtn);
	//	RM_SearchBtn.click();
		return new SupportToolsPage();
	}
}