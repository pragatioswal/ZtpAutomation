//This is QR Code page for support portal
//@author : Praggati Oswal
package ztp.qa.pages;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ztp.qa.base.TestBase;
import ztp.qa.util.TestUtil;

public class QRCodePage extends TestBase {

	// Page Factory - OR:

	@FindBy(xpath = "//b[normalize-space()='Generate QR Code']")
	WebElement GenerateQRLabel;

	@FindBy(xpath = "//input[@formcontrolname='ssid']")
	WebElement SSID;

	@FindBy(xpath = "//input[@formcontrolname='psk']")
	WebElement Pwd;

	@FindBy(xpath = "//button[@class='mat-focus-indicator qr-button mat-button mat-button-base']")
	WebElement Submitbtn;

	@FindBy(xpath = "//mat-card-title[@class='mat-card-title arrow_box pl-4 pr-4 pt-2 pb-2 ng-star-inserted']")
	WebElement ScanLabel;

	@FindBy(css = "img[src^='data:image/png']")
	WebElement QRCodeImage;

	@FindBy(xpath = "//mat-slide-toggle")
	WebElement QRCheckbox;

	@FindBy(xpath = "//span[@class='mat-button-wrapper' and text()=' Download ']")
	WebElement Downloadbtn;

	@FindBy(xpath = "//span[@class='mat-button-wrapper' and text()='Print QR']")
	WebElement PrintQRbtn;

	@FindBy(xpath = "//mat-select//span[contains(@class,'mat-select-min-line')]")
	WebElement CurrentTool;
	
	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'RM Portal')]")
	WebElement Tool_RMPortal;
	
	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'POS Tester')]")
	WebElement Tool_POSTester;
	
	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'QR Code')]")
	WebElement Tool_QRCode;
	
	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'Watcher Client')]")
	WebElement Tool_WatcherClient;
	
	// Initializing the Page Objects:
	public QRCodePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean VerifyQRPage() {
		super.addLog("Verify QR code page is displayed correctly");
    	log.info("VerifyQR code page is displayed correctly");
		return GenerateQRLabel.isDisplayed();
	}

	/**
	 * This function puts SSID and password and clicks on Submit
	 */
	public void QRCodeCreation() {
		super.addLog("Create QR code");
    	log.info("Create QR code");
    	clickIt(SSID);
    	//SSID.click();
		SSID.sendKeys("aaa");
		clickIt(Pwd);
		//Pwd.click();
		Pwd.sendKeys("aaa");
		clickIt(Submitbtn);
		//Submitbtn.click();
		
	}
	/**
	 * This function verifies that QR page is displayed correctly
	 */
	public boolean verifyQRImage() {
		
		waitForVisibilityOf(QRCodeImage, 10);
		super.addLog("Verify QR code page is displayed correctly");
    	log.info("Verify QR code page is displayed correctly");
		return QRCodeImage.isDisplayed();
	}

	/**
	 * This function verifies that QR code image is downloaded
	 * @param i
	 * 1 : Old ZTP
	 * 2 : New ZTP
	 * @return true if download works successfully
	 */
	public boolean DownloadQRImage(int i) {
		if(i==2) {
			clickIt(QRCheckbox);
			//QRCheckbox.click();
			QRCodeCreation();
			
		}
		
		TestUtil.sleep(2000);
		String filePath = System.getProperty("user.dir")+"\\qr-code.png";
		File file = new File(filePath);
		boolean fileExists = file.exists();
		if(fileExists) {
			file.delete();
		}
		super.addLog("Click Download button");
    	log.info("Click Download button");
    	clickIt(Downloadbtn);
		//Downloadbtn.click();
		
		TestUtil.sleep(5000);
		super.addLog("Verify file named 'qr-code.png' is donwloaded in the scripts folder");
    	log.info("Verify file named 'qr-code.png' is donwloaded in the scripts folder");
		return file.exists();
	}

	
	/**
	 * This function verifies that QR code image print dialogue opens 
	 * @param i
	 * 1 : Old ZTP
	 * 2 : New ZTP
	 * @return true if download works successfully
	 */
	public boolean PrintQRImage(int i) {	
	
		QRCodeCreation();
		TestUtil.sleep(2000);
		boolean b=false;
		super.addLog("Click Print button");
    	log.info("Click Print button");
    	clickIt(PrintQRbtn);
		//PrintQRbtn.click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentid = (String) it.next();
		String childid= (String) it.next();
		driver.switchTo().window(childid);
		super.addLog("Verify tht print window shows up");
    	log.info("Verify tht print window shows up");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement PrintBtn =  (WebElement) jse.executeScript("return document.querySelector('print-preview-app').shadowRoot.querySelector('print-preview-sidebar#sidebar').shadowRoot.querySelector('print-preview-button-strip').shadowRoot.querySelector('div > cr-button.action-button')");
		WebElement CancelBtn =  (WebElement) jse.executeScript("return document.querySelector('print-preview-app').shadowRoot.querySelector('print-preview-sidebar#sidebar').shadowRoot.querySelector('print-preview-button-strip').shadowRoot.querySelector('div > cr-button.cancel-button')");
		b = PrintBtn.isDisplayed();
		super.addLog("Click Cancel button");
    	log.info("Click Cancel button");
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", CancelBtn);
		driver.switchTo().window(parentid);
		 return b;
	}
	
	/**
	 * This function selects watcher from the tools drops downs
	 * @return watcher page
	 */
	public WatcherPage QRtoWatcher() {
		waitForElementToDisplay(CurrentTool, 10);
		waitForVisibilityOf(CurrentTool, 10);
		super.addLog("Click on WatcherClient on tool");
		log.info("Click on WatcherClient on tool");
		clickIt(CurrentTool);
		//CurrentTool.click();
		
		waitForVisibilityOf(Tool_WatcherClient, 10);
		clickIt(Tool_WatcherClient);

		//Tool_WatcherClient.click();
		
		return new WatcherPage();
	}
		
}
