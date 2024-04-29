//This is watcher clients page
//@author : Praggati Oswal
package ztp.qa.pages;
import java.io.File;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import ztp.qa.base.TestBase;
import ztp.qa.util.TestUtil;

public class WatcherPage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "//a[contains(text(),' Services ')]")
	WebElement ServicesLink;

	@FindBy(xpath = "//a[contains(text(),' Processes ')]")
	WebElement ProcessesLink;

	@FindBy(xpath = "//a[contains(text(),' Files ')]")
	WebElement FilesLink;

	@FindBy(xpath = "//span[@class='inner-label']")
	WebElement RefreshServicesLink;

	@FindBy(xpath = "//mat-icon[normalize-space()='search']")
	WebElement SearchIcon;

	@FindBy(xpath = "//input[@data-placeholder='Process Name']")
	WebElement SearchProcessInputBox;

	@FindBy(xpath = "//input[@data-placeholder='Service Name']")
	WebElement SearchInputBox;

	@FindBy(xpath = "//div[@class='mat-dialog-content styles-custom-scroll dialog-wrapper-content']//p")
	WebElement AlertMessage;
	
	@FindBy(xpath = "//mat-card")
	WebElement PageReload;
	
	@FindBy(xpath = "//mat-icon[normalize-space()='arrow_back']")
	WebElement BackArrowLink;

	@FindBy(xpath = "//button[@class='mat-focus-indicator font-weight-bold mat-stroked-button mat-button-base']")
	WebElement ConfirmBtn;

	@FindBy(xpath = "//div[@class='brand-ed-body my-2 row ml-0 mr-0 ng-star-inserted']//table/tbody/child::tr[2]/td[1]")
	WebElement FirstService;

	@FindBy(xpath = "//span[@class='mat-select-min-line ng-tns-c154-14 ng-star-inserted']")
	WebElement ItemsPerPage;

	@FindAll({ @FindBy(xpath = "//mat-select") })
	List<WebElement> DropDowns;

	@FindBy(xpath = "//div[@class='mat-paginator-range-label']")
	WebElement TotalNumOfServices;

	@FindBy(xpath = "//mat-select[@aria-controls='mat-select-0-panel']")
	WebElement DropDownforModType;

	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'5')]")
	WebElement NoOfService5;

	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'10')]")
	WebElement NoOfService10;

	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'25')]")
	WebElement NoOfService25;

	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'100')]")
	WebElement NoOfService100;

	@FindBy(xpath = "//mat-select[@aria-label='Items per page:']")
	WebElement DropDownNoOfServices;

	@FindBy(xpath = "//div[(text()=' Display Name ')]")
	WebElement DisplayNameLink;

	@FindBy(xpath = "//div[@class='ngx-spinner-overlay ng-tns-c91-9 ng-trigger ng-trigger-fadeIn ng-star-inserted']")
	WebElement Spinner;

	@FindBy(xpath = "//div[(text()=' Service Name ')]")
	WebElement ServiceNameLink;

	@FindBy(xpath = "//div[(text()=' Status ')]")
	WebElement StatusLink;

	@FindBy(xpath = "//div[(text()=' Process Name ')]")
	WebElement ProcessNameLink;

	@FindBy(xpath = "//div[@class='mat-sort-header-stem ng-tns-c239-30']")
	WebElement DisplayNameSortArrow;

	@FindBy(xpath = "//button[@aria-label='Last page']")
	WebElement LastPageBtn;

	@FindBy(xpath = "//button[@aria-label='First page']")
	WebElement FirstPageBtn;

	@FindBy(xpath = "//button[@aria-label='Next page']")
	WebElement NextPageBtn;

	@FindBy(xpath = "//button[@aria-label='Previous page']")
	WebElement PreviousPageBtn;

	@FindBy(xpath = "//mat-select[@aria-label='Items per page:']//span[contains(@class,'mat-select-min-line')]")
	WebElement CurrentItemsPerPage;

	@FindAll({ @FindBy(xpath = "//span[@class='d-flex' and @style='color: rgb(124, 233, 189);']") })
	List<WebElement> CurrentOpenGreenFolders;

	@FindAll({ @FindBy(xpath = "//span[@class='inner-label']") })
	List<WebElement> TopLinksonFilesTab;

	@FindAll({ @FindBy(xpath = "//span[contains(text(),'free')]") })
	List<WebElement> FileDrives;

	@FindBy(xpath = "//mat-select//span[contains(@class,'mat-select-min-line')]")
	WebElement CurrentTool;

	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'RM Portal')]")
	WebElement Tool_RMPortal;
	
	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'POS Tester')]")
	WebElement Tool_POSTester;
	
	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'QR Code')]")
	WebElement Tool_QRCode;
	
	@FindBy(xpath = "//mat-icon[normalize-space()='arrow_drop_down']")
	WebElement MainPageDropdown;
	
	@FindBy(xpath = "//span[@class='mat-button-wrapper' and text()=' Apply ']")
	WebElement ApplyBtn;
	
	@FindBy(xpath = "//div[@class='text-center warning-text']")
	WebElement WarningText;
	
	@FindBy(xpath = "//simple-snack-bar/span")
	WebElement SystemMsg;
	
	@FindAll({ @FindBy(xpath = "//div[@class='brand-ed-body my-2 row ml-0 mr-0 ng-star-inserted']//table//tbody//tr") })
	List<WebElement> AllRows;
	
	@FindAll({ @FindBy(xpath = "//input") })
	List<WebElement> AllTextBoxes;
	
	@FindAll({ @FindBy(xpath = "//mat-icon[text()='close']") })
	List<WebElement> Crosses;
	
	public static String ServicePerPageXpath = "//div[@class='brand-ed-body my-2 row ml-0 mr-0 ng-star-inserted']//table//tr//td[1]";
	SupportToolsPage supportToolsPage;
	public static String baseURL ="https://restwatcherclient-test.azurewebsites.net/api/v1/";
	public static String siteID = prop.getProperty("siteID");
	
	// Initializing the Page Objects:
	public WatcherPage() {
		PageFactory.initElements(driver, this);
	}

	
	/**
	 * Verify that 4 ziosk services are present under services tab on watcher client page
	 * @return true when all services as per ZioskServiceArray are present on page
	 */
	public boolean SearchZioskServices() {

		boolean fourZServicepresent = true;
		String[] ZioskServiceArray = { "ziosk online ordering bridge", "ziosk pos agent service", "ziosk virtual dms",
				"ziosk watcher client" };
		waitForElementContentToDisplay(FirstService, 10);
		waitForElementToDisplay(PageReload, 10);
		super.addLog("Click on search icon and type ziosk");
		log.info("Click on search icon and type ziosk");
		waitForVisibilityOf(SearchIcon, 10);
		clickIt(SearchIcon);
		clickIt(SearchInputBox);
		SearchInputBox.sendKeys("ziosk");
		waitForElementContentToDisplay(FirstService, 10);
		waitForElementToDisplay(PageReload, 10);
		List<String> ZioskServices = GetListOfAllCurrentRowsForCol(1);
		int i = 0;
		super.addLog("Confirm 4 ziosk services are displayed");
		log.info("Confirm 4 ziosk services are displayed");
		for (String ServiceName : ZioskServices) {
			if (!ZioskServiceArray[i].equals(ServiceName)) {

				fourZServicepresent = false;
				break;
			}
			i++;
		}
		waitForVisibilityOf(TotalNumOfServices, 10);
		return fourZServicepresent;
	}


	/**
	 * Verify that search icon populates on watcher client page
	 * @return true when first service is displayed
	 */
	public boolean ValidateServicesTablePopulated() {
		
		super.addLog("Verify that all the data is loaded");
		log.info("Verify that all the data is loaded");
		IsSpinningComplete();
		return FirstService.isDisplayed();

	}

	
	/**
	 * This method verifies that Ziosk Online Ordering Bridge is always on and cannot be stopped
	 * @return true when Stop and start button on Ziosk Online Ordering Bridge is disabled
	 */
	public boolean ZOOBServiceStopDisabled() {

		waitForElementContentToDisplay(FirstService, 10);
		waitForElementToDisplay(PageReload, 10);
		super.addLog("Click on search icon and type ziosk");
		log.info("Click on search icon and type ziosk");
		clickIt(SearchIcon);
		SearchInputBox.clear();
		SearchInputBox.sendKeys(" ");
		clickIt(SearchInputBox);
		SearchInputBox.sendKeys("ziosk");
		waitForElementContentToDisplay(FirstService, 10);
		waitForElementToDisplay(PageReload, 10);
		waitForelementToBeClickable(DisplayNameLink, 10);
		String ZOOBServiceName = "Ziosk Online Ordering Bridge";
		boolean serviceIsRunning = true;
		String FirstHalfXpath = "//div[@class='brand-ed-body my-2 row ml-0 mr-0 ng-star-inserted']//table/tbody/child::tr[";
		String LastHalfXpath = "]/td[5]//button[3]";
		String LastHalfStartXpath = "]/td[5]//button[1]";
		List<WebElement> ZioskServices = driver.findElements(By.xpath(ServicePerPageXpath));
		
		int p = 1;
		int i = 1;
		for (WebElement ServiceName : ZioskServices) {
			if (ZOOBServiceName.equals(ServiceName.getText()))
				p = i;
			else
				i++;
		}
		String FinalXpathStop = FirstHalfXpath + p + LastHalfXpath;
		String FinalXpathStart = FirstHalfXpath + p + LastHalfStartXpath;
		// Stop and start button on Ziosk Online Ordering Bridge is enabled, then fail the test
		// else pass the test
		super.addLog("Verify that stop and start buttons are disabled for Ziosk Online Ordering Bridge ");
		log.info("Verify that stop and start buttons are disabled for Ziosk Online Ordering Bridge ");
		waitForElementContentToDisplay(FirstService, 10);
		waitForElementToDisplay(PageReload, 10);
		if (driver.findElement(By.xpath(FinalXpathStop)).isEnabled()
				|| driver.findElement(By.xpath(FinalXpathStart)).isEnabled())
			serviceIsRunning = false;
		clickIt(SearchIcon);
		SearchInputBox.clear();
		SearchInputBox.sendKeys(" ");
		return serviceIsRunning;

	}

	
	/**
	 * This method finds the first service that is stopped in the list of services
	 * @return index of first stopped service
	 */
	public int FindFirstStoppedService() {
		int i = 1;
		String firsthalf = "//div[@class='brand-ed-body my-2 row ml-0 mr-0 ng-star-inserted']//table/tbody/child::tr[";
		int n = 10;
		while (i <= n) {
			String FirstServiceStartBtn = firsthalf + i + "]/td[5]//button[3]";
			if (!driver.findElement(By.xpath(FirstServiceStartBtn)).isEnabled())
				break;
			i++;
		}
		super.addLog("Find first service that is stopped in the list of services");
		log.info("Find first service that is stopped in the list of services");
		return i;
	}

	/**
	 * This method verifies the start to stop functionality
	 * @param i
	 * @return
	 */
	public boolean StartToStopServiceFuncationality(int i) {

		boolean stopstart = false;
		boolean correctMsg = false;
		String firsthalf = "//div[@class='brand-ed-body my-2 row ml-0 mr-0 ng-star-inserted']//table/tbody/child::tr[";
		String FirstServiceStopBtn = firsthalf + i + "]/td[5]//button[3]";
		String FirstServiceRestartBtn = firsthalf + i + "]/td[5]//button[2]";
		String FirstServiceStartBtn = firsthalf + i + "]/td[5]//button[1]";
		super.addLog("Click on pop confirmation about changing status of service");
		log.info("Click on pop confirmation about changing status of service");
		if (!driver.findElement(By.xpath(FirstServiceStopBtn)).isEnabled()) {
			clickIt(driver.findElement(By.xpath(FirstServiceStartBtn)));
			if (ConfirmBtn.isDisplayed()) {
				correctMsg = AlertMessage.getText().contains("Are you sure you want to Start the service");
				clickIt(ConfirmBtn);
			}
		}
		IsSpinningComplete();
		super.addLog("Verify the start to stop status change");
		log.info("Verify the start to stop status change");
		if (driver.findElement(By.xpath(FirstServiceStopBtn)).isEnabled()
				&& driver.findElement(By.xpath(FirstServiceRestartBtn)).isEnabled() && correctMsg) {
			stopstart = true;
		}
		return stopstart;

	}

	/**
	 * This method finds the first service that is running in the list of services
	 * @return index of that service
	 */
	public int FindFirstRunningService() {

		int i = 1;
		String firsthalf = "//div[@class='brand-ed-body my-2 row ml-0 mr-0 ng-star-inserted']//table/tbody/child::tr[";
		int n = 10;
		while (i <= n) {
			String FirstServiceStartBtn = firsthalf + i + "]/td[5]//button[1]";
			if (!driver.findElement(By.xpath(FirstServiceStartBtn)).isEnabled())
				break;
			i++;
		}
		super.addLog("Find first service that is running in the list of services");
		log.info("Find first service that is running in the list of services");

		return i;
	
	}

	/**
	 * This method verifies the stop to start functionality
	 * @param i is returned from FindFirstRunningService method
	 * @return true if stop to start works as expected
	 */
	public boolean StopToStartServiceFuncationality(int i) {

		boolean stopstart = false;
		boolean correctMsg = false;
		String firsthalf = "//div[@class='brand-ed-body my-2 row ml-0 mr-0 ng-star-inserted']//table/tbody/child::tr[";
		String FirstServiceStopBtn = firsthalf + i + "]/td[5]//button[3]";
		String FirstServiceStartBtn = firsthalf + i + "]/td[5]//button[1]";
		super.addLog("Click on pop confirmation about changing status of service");
		log.info("Click on pop confirmation about changing status of service");
		if (!driver.findElement(By.xpath(FirstServiceStartBtn)).isEnabled()) {
			clickIt(driver.findElement(By.xpath(FirstServiceStopBtn)));
			if (ConfirmBtn.isDisplayed()) {
				correctMsg = AlertMessage.getText().contains("Are you sure you want to Stop the service");
				clickIt(ConfirmBtn);
			}
		}
		IsSpinningComplete();
		super.addLog("Verify the stop to start status change");
		log.info("Verify the stop to start status change");
		if (driver.findElement(By.xpath(FirstServiceStartBtn)).isEnabled() && correctMsg) {
			stopstart = true;
		}
		return stopstart;

	}

	 /**
	  *  This method confirms the total number of services is correct
	  * @return true if total number of rows matches what is displayed below table
	  */
	public boolean ConfirmTotalNoOfServices() {
		waitForAllDataToLoad();
		clickOnFirstPageBtn();
		waitForAllDataToLoad();
		super.addLog("Set number of items to 100");
		log.info("Set number of items to 100");
		setNoOfItemsTo100();
		List<String> TotalList = GetListOfAllCurrentRowsForCol(1);
		String t = TotalNumOfServices.getText();
		super.addLog("Verify that total matches what is displayed on screen");
		log.info("Verify that total matches what is displayed on screen");
		int n = Integer.parseInt(t.split("of")[1].trim());
		if (n == TotalList.size())
			return true;
		else
			return false;

	}

	/**
	 *  This method verifies that the next button exists on the page depending on total number of services and items per page
	 * @return true if next button is displayed correctly
	 */
	public boolean ClickNextBtn() {
		clickOnFirstPageBtn();
		super.addLog("Verify that next button is dislayed until there are items in the list");
		log.info("Verify that next button is dislayed until there are items in the list");
		int ip = Integer.parseInt(CurrentItemsPerPage.getText());
		int tp = Integer.parseInt(TotalNumOfServices.getText().split("of")[1].trim());
		int q = tp / ip;
		int r = tp % ip;
		int NoOfNext;
		if (q < 1) {
			NoOfNext = 0;
		} else {
			if (r == 0) {
				NoOfNext = q - 1;
			} else {
				NoOfNext = q;
			}
		}
		if (NoOfNext == 0) {
			if ((!NextPageBtn.isEnabled()) && (!LastPageBtn.isEnabled())) {
				return true;
			}
		} else {
			for (int i = 0; i < NoOfNext; i++) {
				super.addLog("Click on next page button of pagination");
				log.info("Click on next page button of pagination");
				clickIt(NextPageBtn);
				IsSpinningComplete();
			}
			return true;
		}
		return false;

	}

	/**
	 * This method verifies that the previous button exists on the page depending on total number of services and items per page
	 * @return true if previous page button is displayed as expected
	 */
	public boolean ClickPreviousBtn() {
		waitForElementContentToDisplay(FirstService, 10);
		waitForElementToDisplay(PageReload, 10);
		super.addLog("Click last button if not on last page");
		log.info("Click last button if not on last page");
		if (LastPageBtn.isEnabled()) {
			clickIt(LastPageBtn);
			waitForElementContentToDisplay(FirstService, 10);
			waitForElementToDisplay(PageReload, 10);
		}
		super.addLog("Verify that previous button appears until there are more than 1 rows remaining");
		log.info("Verify that previous button appears until there are more than 1 rows remaining");
		int ip = Integer.parseInt(CurrentItemsPerPage.getText());
		int tp = Integer.parseInt(TotalNumOfServices.getText().split("of")[1].trim());
		int q = tp / ip;
		int r = tp % ip;
		int NoOfPrevious;
		if (q < 1) {
			NoOfPrevious = 0;
		} else {
			if (r == 0) {
				NoOfPrevious = q - 1;
			} else {
				NoOfPrevious = q;
			}
		}
		if (NoOfPrevious == 0) {
			if ((!PreviousPageBtn.isEnabled()) && (!FirstPageBtn.isEnabled())) {
				return true;
			}
		} else {
			for (int i = 0; i < NoOfPrevious; i++) {
				super.addLog("Click on previous page button of pagination");
				log.info("Click on previous page button of pagination");
				clickIt(PreviousPageBtn);
				IsSpinningComplete();
			}
			return true;
		}
		return false;

	}

	
	/**
	 * This method verifies that refresh functionality works
	 * @param SorP Services or Processes
	 * @return if refresh works
	 */
	public boolean ClickRefreshLink(String SorP) {
		waitForElementContentToDisplay(FirstService, 10);
		waitForElementToDisplay(PageReload, 10);
		if (SorP.equals("Services")) {
			if (!ServicesLink.getAttribute("class").contains("design-active")) {
				clickIt(ServicesLink);
			}
		}
		if (SorP.equals("Processes")) {
			if (!ProcessesLink.getAttribute("class").contains("design-active")) {
				clickIt(ProcessesLink);
			}
		}
		setNoOfItemsTo100();
		if (FirstPageBtn.isEnabled()) {
			waitForElementToDisplay(FirstPageBtn, 10);
			waitForelementToBeClickable(FirstPageBtn, 10);
			super.addLog("Click on first page button of pagination");
			log.info("Click on first page button of pagination");
			clickIt(FirstPageBtn);
			waitForElementContentToDisplay(FirstService, 10);
			waitForElementToDisplay(PageReload, 10);
		}

		List<String> BeforeRefreshList = GetListOfAllCurrentRowsForCol(1);
		super.addLog("Click Refresh link");
		log.info("Click Refresh link");

		waitForElementToDisplay(RefreshServicesLink,10);
		clickIt(RefreshServicesLink);
		waitForElementContentToDisplay(FirstService, 10);
		waitForElementToDisplay(PageReload, 10);
		List<String> AfterRefreshList = GetListOfAllCurrentRowsForCol(1);
		super.addLog("Verify that list of items displayed is same after refresh");
		log.info("Verify that list of items displayed is same after refresh");
		System.out.print(BeforeRefreshList);
		System.out.print(AfterRefreshList);
		if (BeforeRefreshList.equals(AfterRefreshList))
			return true;
		else
			return false;
	}

	/**
	 * This method verifies that services are loaded on watcher page
	 * @return true if method works
	 */ 
	public boolean ValidateWatcherServicesLoaded() {

		waitForVisibilityOf(FirstService, 10);
		if (FirstService.isDisplayed())
			return true;
		else
			return false;
	}

	/**
	 * This method verifies the same number of services as set for items per page 5,10,25,100
	 * @return true if all cases pass
	 */
	public boolean ItemsPerPageFunctionality() {
		boolean b5 = false;
		boolean b10 = false;
		boolean b25 = false;
		boolean b100 = false;
		TestUtil.sleep(4000);
		
		// verify 5 services are displayed when 5 is set for items per page
		List<WebElement> elementsList;
		waitForElementContentToDisplay(FirstService, 10);
		waitForelementToBeClickable(DropDownNoOfServices, 10);
		clickIt(DropDownNoOfServices);
		
		waitForelementToBeClickable(NoOfService5, 10);
		clickIt(NoOfService5);
		waitForElementContentToDisplay(FirstService, 10);
		waitForElementToDisplay(PageReload, 10);
		elementsList = driver.findElements(By.xpath(ServicePerPageXpath));
		super.addLog("Verify number of services is correctly displayed for 5");
		log.info("Verify number of services is correctly displayed for 5");
		if (elementsList.size() == 5)
			b5 = true;
		else
			b5 = false;
	
		TestUtil.sleep(3000);
		// verify 10 services are displayed when 10 is set for items per page
		waitForElementToDisplay(DropDownNoOfServices, 10);
		clickIt(DropDownNoOfServices);
		waitForelementToBeClickable(NoOfService10, 10);
		clickIt(NoOfService10);
		waitForElementContentToDisplay(FirstService, 10);
		waitForElementToDisplay(PageReload, 10);
		elementsList = driver.findElements(By.xpath(ServicePerPageXpath));
		super.addLog("Verify number of services is correctly displayed for 10");
		log.info("Verify number of services is correctly displayed for 10");
		if (elementsList.size() == 10)
			b10 = true;
		else
			b10 = false;

		// verify 25 services are displayed when 25 is set for items per page
		TestUtil.sleep(4000);
		waitForElementToDisplay(DropDownNoOfServices, 10);
		clickIt(DropDownNoOfServices);
		waitForelementToBeClickable(NoOfService5, 10);
		clickIt(NoOfService25);
		waitForElementContentToDisplay(FirstService, 10);
		waitForElementToDisplay(PageReload, 10);
		elementsList = driver.findElements(By.xpath(ServicePerPageXpath));
		super.addLog("Verify number of services is correctly displayed for 25");
		log.info("Verify number of services is correctly displayed for 25");
		if (elementsList.size() == 25)
			b25 = true;
		else
			b25 = false;
		TestUtil.sleep(4000);

		// verify 100 services are displayed when 10 is set for items per page
		waitForElementToDisplay(DropDownNoOfServices, 10);
		clickIt(DropDownNoOfServices);
		waitForelementToBeClickable(NoOfService100, 10);
		clickIt(NoOfService100);
		waitForElementContentToDisplay(FirstService, 10);
		waitForElementToDisplay(PageReload, 10);
		elementsList = driver.findElements(By.xpath(ServicePerPageXpath));
		super.addLog("Verify number of services is correctly displayed for 100");
		log.info("Verify number of services is correctly displayed for 100");
		TestUtil.sleep(4000);
		if (elementsList.size() == 100)
			b100 = true;
		else
			b100 = false;
		if (b5 && b10 && b25 && b100)
			return true;
		else
			return false;
	}

	/**
	 * This method gets a list of rows on the current page based on argument passed
	 * @param ColumnNumber that needs to be sorted
	 * @return list of all values displayed in the table for the given column
	 */
	public List<String> GetListOfAllCurrentRowsForCol(int ColumnNumber) {
		String firstHalf = "//div[@class='brand-ed-body my-2 row ml-0 mr-0 ng-star-inserted']//table//tr//td[";
		String lastHalf = "]";
		String ServiceNamesPerPageXpath = firstHalf + ColumnNumber + lastHalf;
		List<String> tempList = new ArrayList<String>();
		
		waitForAllDataToLoad() ;
		
		log.info("Get data from all pages");
		super.addLog("Get data from all pages");
		List<WebElement> elementsList = driver.findElements(By.xpath(ServiceNamesPerPageXpath));
		List<String> originalList = elementsList.stream().map(s -> s.getText().toLowerCase())
				.collect(Collectors.toList());	
		boolean b = true;
		if (!LastPageBtn.isEnabled())
			b = false;	
		while (b) {
			waitForElementToDisplay(NextPageBtn, 10);
			waitForelementToBeClickable(NextPageBtn, 10);
			TestUtil.sleep(6000);
			super.addLog("Click on next page button of pagination");
			log.info("Click on next page button of pagination");
			clickIt(NextPageBtn);
			waitForAllDataToLoad() ;
			elementsList = driver.findElements(By.xpath(ServiceNamesPerPageXpath));
			tempList = elementsList.stream().map(s -> s.getText().toLowerCase()).collect(Collectors.toList());
			originalList.addAll(originalList.size(), tempList);
			if (!LastPageBtn.isEnabled())
				b = false;
		}
		return originalList;
	}
	
	/**
	 * This method waits for the services page to load completely
	 */
	public void waitForAllDataToLoad() {	
		waitForElementContentToDisplay(FirstService, 10);
		waitForElementToDisplay(PageReload, 10);
		TestUtil.sleep(2000);
	}

	/**
	 * This method clicks on the first page button if the first page button is enabled
	 */
	public void clickOnFirstPageBtn() {
		
		if(FirstPageBtn.isEnabled()) {
			super.addLog("Click on first page button of pagination");
			log.info("Click on first page button of pagination");
			clickIt(FirstPageBtn);
			waitForElementContentToDisplay(FirstService, 10);
			waitForElementToDisplay(PageReload, 10);
		}
	}
	
	/**
	 * This method sets no of items to 100
	 */
	public void setNoOfItemsTo100() {
		waitForelementToBeClickable(DropDownNoOfServices, 10);
		clickIt(DropDownNoOfServices);
		waitForVisibilityOf(NoOfService100, 10);
		clickIt(NoOfService100);
	}
	
	/**
	 * 	This method clicks the process link
	 */
	public void clickProcessLink() {
		waitForelementToBeClickable(ProcessesLink, 10);
		clickIt(ProcessesLink);
	}

	/**
	 * This method sorts the watcher client service table by the given column
	 * @param c 1:Display Name , 2:Status , 3:Service Name
	 * @return true if programmatically sorted list matches what is displayed on the page
	 */
	public boolean SortByCategory(int c) {

		log.info("Wait for data to load");
		super.addLog("Wait for data to load");
		waitForAllDataToLoad();
		super.addLog("Check if first page is displayed, else click on first page button");
		log.info("Check if first page is displayed, else click on first page button");
		clickOnFirstPageBtn();
		super.addLog("Set number of items to 100");
		log.info("Set number of items to 100");
		setNoOfItemsTo100();
		super.addLog("Get current list and sort programmatically");
		log.info("Get current list and sort programmatically");	
		List<String> BeforeSortList = GetListOfAllCurrentRowsForCol(c);	
		List<String> AfterSortList = BeforeSortList.stream().sorted().collect(Collectors.toList());	
		waitForAllDataToLoad();
		log.info("Check if first page is displayed, else click on first page button");
		super.addLog("Check if first page is displayed, else click on first page button");
		clickOnFirstPageBtn();	
		TestUtil.sleep(4000);
		if(c==1){
		super.addLog("Click on Display Name link to sort ");	
		log.info("Click on Display Name link to sort ");	
		waitForelementToBeClickable(DisplayNameLink, 10);
		clickIt(DisplayNameLink);	
		}else if(c==2){
		super.addLog("Click on Status link to sort");
		log.info("Click on Status link to sort");
		waitForelementToBeClickable(StatusLink, 10);
		clickIt(StatusLink);
		}else if(c==3){
		super.addLog("Click on Service link to sort");	
		log.info("Click on Service link to sort");	
		waitForelementToBeClickable(ServiceNameLink, 10);
		clickIt(ServiceNameLink);	
		}
		List<String> AfterSortListFromWebsite = GetListOfAllCurrentRowsForCol(c);
		super.addLog("Verify that list displayed on screen matches sorted list in program");
		log.info("Verify that list displayed on screen matches sorted list in program");
		System.out.println(AfterSortList);
		System.out.println(AfterSortListFromWebsite);
		if (AfterSortList.equals(AfterSortListFromWebsite))
			return true;
		else
			return false;
	}

	/**
	 *  This method sorts the watcher client process table by the given column
	 */
	public boolean SortByProcessName() {
		waitForAllDataToLoad();
		super.addLog("Click on Process link");
		log.info("Click on Process link");
		clickProcessLink();
		super.addLog("Wait for all data to load");
		log.info("Wait for all data to load");
		waitForAllDataToLoad();
		super.addLog("Set number of items to 100");
		log.info("Set number of items to 100");
		setNoOfItemsTo100();
		log.info("Get current list of process names and sort programmatically");
		super.addLog("Get current list of process names and sort programmatically");
  		List<String> BeforeSortList = GetListOfAllCurrentRowsForCol(1);
		List<String> AfterSortList = BeforeSortList.stream().sorted().collect(Collectors.toList());	
		waitForAllDataToLoad();	
		if(BeforeSortList.size()>100) {
			clickOnFirstPageBtn();
			waitForAllDataToLoad();
		}		
		log.info("Click on Process link to sort");
		super.addLog("Click on Process link to sort");
		clickIt(ProcessNameLink);	
		List<String> AfterSortListFromWebsite = GetListOfAllCurrentRowsForCol(1);
		log.info("Verify that list displayed on screen matches sorted list in program");
		super.addLog("Verify that list displayed on screen matches sorted list in program");
		System.out.println(AfterSortList);
		System.out.println(AfterSortListFromWebsite);
		if (AfterSortList.equals(AfterSortListFromWebsite))
			return true;
		else
			return false;
  }
  
  
	/**
	 * This method switches between services, processes and files tab and confirm switch happens correctly
	 * @return true if all three scenarios pass
	 */
	public boolean SwitchingBetTabs() {
		boolean b1 = false;
		boolean b2 = false;
		boolean b3 = false;
		waitForElementContentToDisplay(FirstService, 10);
		waitForElementToDisplay(PageReload, 10);
		// services to processes
		super.addLog("Verify services to processes tab switch");
		log.info("Verify services to processes tab switch");
		if (ServicesLink.getAttribute("class").contains("ng-star-inserted")) {
			clickIt(ProcessesLink);
			b1 = true;
			waitForElementContentToDisplay(FirstService, 10);
			waitForElementToDisplay(PageReload, 10);
		}
		//processes to files 
		super.addLog("Verify processes to files tab switch");
		log.info("Verify processes to files tab switch");
		if (ProcessesLink.getAttribute("class").contains("ng-star-inserted")) {
			clickIt(FilesLink);
			b2 = true;
			waitForElementToDisplay(FileDrives.get(0), 10);
		}
		//files to services
		super.addLog("Verify files to services tab switch");
		log.info("Verify files to services tab switch");
		if (FilesLink.getAttribute("class").contains("ng-star-inserted")) {
			clickIt(ServicesLink);
			b3 = true;
			waitForElementContentToDisplay(FirstService, 10);
			waitForElementToDisplay(PageReload, 10);
		}
		if (b1 && b2 && b3)
			return true;
		else
			return false;
	}

	/**
	 * This method verifies that the size of the file and color matches
	 * @param size is file size, fileColor is color seen on page
	 * @param FileColor
	 * @return true if criteria for file size and color displayed matches
	 */
	public boolean ConfirmColorForFileSize(float size, String FileColor) {
		boolean b = false;
		// white color	
		if (size <= 5) {
			super.addLog("Verify if file size is less than 5MB, color is white");
			log.info("Verify if file size is less than 5MB, color is white");
			if (FileColor.isEmpty())
				b = true;
		}
		// yellow color	
		else if (size > 5 && size <= 20) {
			super.addLog("Verify if file size is between 5 to 20 MB, color is yellow");
			log.info("Verify if file size is between 5 to 20 MB, color is yellow");
			if (FileColor.contains("yellow"))
				b = true;
		}
		// orange color
		else if (size > 20 && size <= 100) {
			super.addLog("Verify if file size is between 20 to 100 MB, color is orange");
			log.info("Verify if file size is between 20 to 100 MB, color is orange");
			if (FileColor.contains("orange"))
				b = true;
		}
		// red color
		else if (size > 100) {
			super.addLog("Verify if file size is more than 100 MB, color is red");
			log.info("Verify if file size is more than 100 MB, color is red");
			if (FileColor.contains("rgb(255, 117, 130)"))
				b = true;
		}
		return b;
	}
	
	/**
	 * This function traverses through the files structure to get to ColorValidation folder
	 */
	public void FileStructureSetup() {
		waitForVisibilityOf(FilesLink, 10);
		waitForElementToDisplay(FilesLink, 10);
		if (!FilesLink.getAttribute("class").contains("design-active"))
			clickIt(FilesLink);
		TestUtil.sleep(3000);
		String IdivFileXpath = "//span[@class='pl-1 pointer']";
		List<WebElement> elementsList = driver.findElements(By.xpath(IdivFileXpath));

		clickIt(elementsList.get(0));
		TestUtil.sleep(3000);
		elementsList = driver.findElements(By.xpath(IdivFileXpath));
		TestUtil.sleep(5000);
		super.addLog("Traverse file structure until ColorValidation folder is reached");
		log.info("Traverse file structure until ColorValidation folder is reached");
		for(int i=0;i<elementsList.size();i++) {
			if(elementsList.get(i).getText().contains("ColorValidation"))
			{
				clickIt(elementsList.get(i));
				TestUtil.sleep(5000);
				break;
			}
		}
	}

	/**
	 * This function open the directory structure to get ready for testing expand functionality
	 */
	public void FileStructureOpen() {	
		waitForVisibilityOf(FilesLink, 10);
		waitForElementToDisplay(FilesLink, 10);
		if (!FilesLink.getAttribute("class").contains("design-active"))
			clickIt(FilesLink);
		clickIt(TopLinksonFilesTab.get(0));
		TestUtil.sleep(3000);
		super.addLog("Traverse file structure and open a few folders");
		log.info("Traverse file structure and open a few folders");
		String IdivFileXpath = "//span[@class='pl-1 pointer']";
		List<WebElement> elementsList = driver.findElements(By.xpath(IdivFileXpath));

		clickIt(elementsList.get(0));
		TestUtil.sleep(5000);

		elementsList = driver.findElements(By.xpath(IdivFileXpath));
		clickIt(elementsList.get(28));
		TestUtil.sleep(5000);

		elementsList = driver.findElements(By.xpath(IdivFileXpath));
		clickIt(elementsList.get(53));
		TestUtil.sleep(5000);

		elementsList = driver.findElements(By.xpath(IdivFileXpath));
		clickIt(elementsList.get(56));
		TestUtil.sleep(5000);
	}

	/**
	 * This function traverses the file structure and verifies file size and color matches the criteria a per ConfirmColorForFileSize method
	 * @return true if all file in the ColorValidation folder match the criteria
	 */
	public boolean TraverseFiles() {
		FileStructureSetup();
		String IdivFileXpath1 = "//span[@class='pl-1']/parent::span";
		List<WebElement> elementsList1 = driver.findElements(By.xpath(IdivFileXpath1));
		String[] FullFileNames = new String[4];
		String[] FileNames = new String[4];
		String[] ActualFileColors = new String[4];
		float[] FileSizes = new float[4];
		boolean b = false;
		for (int i = 0; i < 4; i++) {
			FullFileNames[i] = elementsList1.get(i).getText();
			ActualFileColors[i] = elementsList1.get(i).getAttribute("style");
			FileSizes[i] = Float.parseFloat(FullFileNames[i].split("-")[2].trim().split(" ")[0].trim());
			FileNames[i] = FullFileNames[i].split("-")[1].trim();
			if (ConfirmColorForFileSize(FileSizes[i], ActualFileColors[i]))
				b = true;
			else
				b = false;
		}
		return b;	
	}

	/**
	 * This method makes sure that the 4 ziosk services are displayed on searching for ziosk on the process tab
	 * @return true if all 4 services are present
	 */
	public boolean SearchZioskProcesses() {
		if (!ProcessesLink.getAttribute("class").contains("design-active")) {
			waitForVisibilityOf(ProcessesLink, 10);
			clickIt(ProcessesLink);
		}
		String[] ZioskServiceArray = { "zioskiotbridge", "zioskposagentservice", "zioskvirtualdmsapi",
				"zioskwatcherclient" };
		waitForElementContentToDisplay(FirstService, 10);
		waitForElementToDisplay(PageReload, 10);
		waitForVisibilityOf(SearchIcon, 10);
		super.addLog("Click on search icon and type ziosk");
		log.info("Click on search icon and type ziosk");
		clickIt(SearchIcon);
		clickIt(SearchProcessInputBox);
		SearchProcessInputBox.sendKeys("ziosk");
		waitForElementContentToDisplay(FirstService, 10);
		waitForElementToDisplay(PageReload, 10);
		List<String> ZioskServices = GetListOfAllCurrentRowsForCol(1);
		int j=0;
		super.addLog("Verify 4 Ziosk Processes are displayed");
		log.info("Verify 4 Ziosk Processes are displayed");
		for(String ServiceName : ZioskServiceArray) {
			for(int i=0;i<ZioskServices.size();i++) {
				if(ServiceName.equals(ZioskServices.get(i).toString())) {
					j++;
					break;
				}		
			}
		}
		if(j==4)
			return true;
		else
			return false;
	}

	/**
	 * This function confirms that restart functionality for service provided works as expected
	 * @param i is passed by FindFirstRunningService() function
	 * @return true if functionality works
	 */
	public boolean RestartServiceFuncationality(int i) {
		boolean restart = false;
		boolean correctMsg = false;
		String firsthalf = "//div[@class='brand-ed-body my-2 row ml-0 mr-0 ng-star-inserted']//table/tbody/child::tr[";
		String FirstServiceStopBtn = firsthalf + i + "]/td[5]//button[3]";
		String FirstServiceRestartBtn = firsthalf + i + "]/td[5]//button[2]";
		String FirstServiceStartBtn = firsthalf + i + "]/td[5]//button[1]";
		super.addLog("Click on pop confirmation about changing status of service");
		log.info("Click on pop confirmation about changing status of service");
		if (!driver.findElement(By.xpath(FirstServiceStartBtn)).isEnabled()) {
			clickIt(driver.findElement(By.xpath(FirstServiceRestartBtn)));

			if (ConfirmBtn.isDisplayed()) {
				correctMsg = AlertMessage.getText().contains("Are you sure you want to Restart the service");
				clickIt(ConfirmBtn);
			}

		}
	IsSpinningComplete();
	super.addLog("Validate service is restarted");
	log.info("Validate service is restarted");
		if (!driver.findElement(By.xpath(FirstServiceStartBtn)).isEnabled()
				&& driver.findElement(By.xpath(FirstServiceRestartBtn)).isEnabled()
				&& driver.findElement(By.xpath(FirstServiceStopBtn)).isEnabled() && correctMsg) {
			restart = true;
		}
		return restart;
	}

	/**
	 * This method verifies that expand functionality works for files tab
	 * @return true on success
	 */
	public boolean ExpandAllFiles() {
		FileStructureOpen();
		List<String> originalList = CurrentOpenGreenFolders.stream().map(s -> s.getText().split("-")[1].trim())
				.collect(Collectors.toList());
		// System.out.println(CurrentOpenGreenFolders.get(0).getText());
		TestUtil.sleep(4000);
		if (TopLinksonFilesTab.get(3).getText().trim().equals("Expand All")) {
			clickIt(TopLinksonFilesTab.get(3));
			TestUtil.sleep(3000);
			clickIt(TopLinksonFilesTab.get(3));
			TestUtil.sleep(3000);
			clickIt(TopLinksonFilesTab.get(3));
		}
		List<String> AfterCollapseList = CurrentOpenGreenFolders.stream().map(s -> s.getText().split("-")[1].trim())
				.collect(Collectors.toList());
		super.addLog("Verify that list of files open before expanding matches what shows after expanding");
		log.info("Verify that list of files open before expanding matches what shows after expanding");
		if (originalList.equals(AfterCollapseList))
			return true;
		else
			return false;
	}

	/**
	 * This method verifies that download file functionality works for WhiteColorSoftware.zip
	 * @return true on success
	 */
	public boolean DownloadFile() {
		boolean b = false;
		String CheckboxXpath = "//span[normalize-space()='WhiteColorSoftware.zip   -  3.57 MB']/parent::*/preceding-sibling::mat-checkbox";
		super.addLog("Select white color file and click on download link");
		log.info("Select white color file and click on download link");
		WebElement chkbx = driver.findElement(By.xpath(CheckboxXpath));
		clickIt(chkbx);
		clickIt(TopLinksonFilesTab.get(1));
		clickIt(ConfirmBtn);
		TestUtil.sleep(40000);
		File file = new File(System.getProperty("user.dir"));
		File ff[] = file.listFiles();
		super.addLog("Verify that a file with 'download' in its name is downloaded in the script folder");
		log.info("Verify that a file with 'download' in its name is downloaded in the script folder");
		for (File f : ff) {
			if (f.getName().contains("download")) {
				// System.out.println(f.getName());
				String filePath = System.getProperty("user.dir") + "\\" + f.getName();
				// System.out.println(filePath);
				File delfile = new File(filePath);
				delfile.delete();
				b = true;
			}
		}
		return b;
	}

	/**
	 * This method verifies that back button shows support portal page
	 * @return true on success
	 */
	public boolean BackwardNavigate() {	
		supportToolsPage = GotoSupportToolsPage();
		super.addLog("Verify Support Tools page is displayed correctly");
    	log.info("Verify Support Tools page is displayed correctly");
		if (supportToolsPage.WatcherClientSelection.isDisplayed())
			return true;
		else
			return false;
	}
	
	/**
	 * This method verifies go to support tool page functionality works
	 * @return true on success
	 */
	public SupportToolsPage GotoSupportToolsPage() {
		waitForElementToDisplay(PageReload, 10);
		waitForElementToDisplay(BackArrowLink, 10);
		waitForVisibilityOf(BackArrowLink, 10);
		super.addLog("Click on back arrow to go back to support tools page");
		log.info("Click on back arrow to go back to support tools page");
		clickIt(BackArrowLink);
		return new SupportToolsPage();
	}

	/**
	 * This method verifies that spinner is not displayed anymore confirming page is loaded successfully
	 * @return true is spinner is hidden
	 */
	public boolean IsSpinningComplete() {
	
		String spinnerXpath = "//div[contains(@class,'ngx-spinner-overlay')]";	
		WebElement spinner = driver.findElement(By.xpath(spinnerXpath));
		return waitForElementToHide(spinner, 20);
	}

	/**
	* This method verifies go to RM portal page functionality works
	 * @return true on success
	 */
	public RMPage WatcherToRM() {
		waitForElementToDisplay(CurrentTool, 10);
		waitForVisibilityOf(CurrentTool, 10);
		clickIt(CurrentTool);
		super.addLog("Click on RM portal on tool");
		log.info("Click on RM portal on tool");
		waitForVisibilityOf(Tool_RMPortal, 10);
		clickIt(Tool_RMPortal);
		return new RMPage();
	}
	
	/**
	* This method verifies go to QR code page functionality works
	 * @return true on success
	 */
	public QRCodePage WatcherToQRcode() {
		waitForElementToDisplay(CurrentTool, 10);
		waitForVisibilityOf(CurrentTool, 10);
		clickIt(CurrentTool);
		super.addLog("Click on QRCode on tool");
		log.info("Click on QRCode on tool");
		waitForVisibilityOf(Tool_QRCode, 10);
		clickIt(Tool_QRCode);
		return new QRCodePage();
	}
	
	/**
	 * This function verifies switching between various pages works from the tools drop down
	 * @return true on success
	 */
	public boolean SwitchBetPageswithTool() {
		boolean b1,b2,b3,b4,b5;
		RMPage rmPage = WatcherToRM();
		b1= rmPage.VerifyRMPage();	
		POSPage posPage = rmPage.RMtoPOS();
		b2= posPage.VerifyPOSPage();	
		WatcherPage watcherPage = posPage.POStoWatcher();
		b3= watcherPage.ValidateServicesTablePopulated();	
		QRCodePage qrPage = watcherPage.WatcherToQRcode();
		b4= qrPage.VerifyQRPage();	
		WatcherPage watcherPage1 = qrPage.QRtoWatcher();
		b5= watcherPage1.ValidateServicesTablePopulated();
		super.addLog("Verify switching between pages works");
		log.info("Verify switching between pages works");
		if(b1&& b2 && b3 && b4 &&b5)
			return true;
		else
			return false;
	}

	/**
	 * This function verifies switching to different store works
	 * @return true on success
	 */
	public boolean SwitchStore() {
		String store= "Starlink 2";
		String storeXpath= "//span[@class='mat-option-text' and contains(text(),'"+ store +"')]";
		super.addLog("Attempt to switch store");
		log.info("Attempt to switch store");
		waitForElementToDisplay(MainPageDropdown, 10);
		waitForVisibilityOf(MainPageDropdown, 10);
		clickIt(MainPageDropdown);
		clickIt(AllTextBoxes.get(2));
		clickIt(Crosses.get(2));
		clickIt(AllTextBoxes.get(2));
		waitForVisibilityOf(AllTextBoxes.get(2), 10);
		WebElement storeNameOrNumber = driver.findElement(By.xpath(storeXpath));
		clickIt(storeNameOrNumber);
		clickIt(ApplyBtn);
		super.addLog("Verify appropriate message is displayed");
		log.info("Verify appropriate message is displayed");
		if(WarningText.getText().contains("This service is temporarily down."))
			return true;
		else
			return false;
	}

	/**
	 * This method parses through the JSON data from API calls and confirm that it matches with what is displayed on the given page:Service
	 * @param p is the page number
	 * @param AuthorizationCode is dynamically captured and passed here
	 * @return
	 */
	public boolean AllServicePerPage(int p, String AuthorizationCode) {
		
		String xpath1 = "//div[@class='brand-ed-body my-2 row ml-0 mr-0 ng-star-inserted']//table//tr//td[1]";
		String xpath2 = "//div[@class='brand-ed-body my-2 row ml-0 mr-0 ng-star-inserted']//table//tr//td[2]";
		String xpath3 = "//div[@class='brand-ed-body my-2 row ml-0 mr-0 ng-star-inserted']//table//tr//td[3]";
		String xpath4 = "//div[@class='brand-ed-body my-2 row ml-0 mr-0 ng-star-inserted']//table//tr//td[4]";
		List<WebElement> AllDisplayName = driver.findElements(By.xpath(xpath1));
		List<WebElement> AllStatus = driver.findElements(By.xpath(xpath2));
		List<WebElement> AllServiceName = driver.findElements(By.xpath(xpath3));
		List<WebElement> AllStartupType = driver.findElements(By.xpath(xpath4));
		RestAssured.baseURI = baseURL + "getservices/" + siteID;
		Response response =RestAssured.given().header("Authorization",AuthorizationCode).
				queryParam("CurrentPage",p)
				.queryParam("PageSize", 100).get();
		JsonPath js = response.jsonPath();
		List<String> APList1= new ArrayList<String>();
		List<String> APList2= new ArrayList<String>();
		List<String> APList3= new ArrayList<String>();
		List<String> APList4= new ArrayList<String>();
		List<String> WebsiteList1= new ArrayList<String>();
		List<String> WebsiteList2= new ArrayList<String>();
		List<String> WebsiteList3= new ArrayList<String>();
		List<String> WebsiteList4= new ArrayList<String>();
		String init1 ="result.results.displayName[";
		String init2 ="result.results.status[";
		String init3 ="result.results.serviceName[";
		String init4 ="result.results.startupType[";
		String end = "]";
		super.addLog("Compare values of Display name, Status, Service Name and StartupType from API call with watcher page# " + p);
		log.info("Compare values of Display name, Status, Service Name and StartupType from API call with watcher page# " + p);
		for(int i=0;i<AllRows.size();i++) {
			String jsonIndex1 = init1 + i+end;
			String jsonIndex2 = init2 + i+end;
			String jsonIndex3 = init3 + i+end;
			String jsonIndex4 = init4 + i+end;
			APList1.add(i, js.get(jsonIndex1).toString());
			WebsiteList1.add(i,AllDisplayName.get(i).getText());
			APList2.add(i, js.get(jsonIndex2).toString());
			WebsiteList2.add(i,AllStatus.get(i).getText());
			APList3.add(i, js.get(jsonIndex3).toString());
			WebsiteList3.add(i,AllServiceName.get(i).getText());
			APList4.add(i, js.get(jsonIndex4).toString());
			WebsiteList4.add(i,AllStartupType.get(i).getText());
		}
		for(int i=0;i<AllRows.size();i++) {
			System.out.println("*********** "+ APList1.get(i) + " " + APList2.get(i) + " " + APList3.get(i) + " " + APList4.get(i));
			System.out.println("@@@@@@@@@@ "+ WebsiteList1.get(i) + " " + WebsiteList2.get(i) + " " + WebsiteList3.get(i) + " " + WebsiteList4.get(i));

		}
		if(APList1.equals(WebsiteList1) && APList2.equals(WebsiteList2) 
				&& APList3.equals(WebsiteList3) && APList4.equals(WebsiteList4)) {
			System.out.println("**********************************************************************");
			super.addLog("All columns data matches API data for Services Tab Page " + p);
			log.info("All columns data matches API data for Services Tab Page " + p);
			System.out.println("All columns data matches API data for Services Tab Page " + p);
			System.out.println("**********************************************************************");
			return true;
		}
		else {
			super.addLog("All columns data does not match API data for Services Tab Page " + p);
			log.info("All columns data does not match API data for Services Tab Page " + p);
			System.out.println("**********************************************************************");
			System.out.println("All columns data matches API data for Services Tab Page " + p);
			System.out.println("**********************************************************************");
			return false;
		}
	}

	/**
	 * This method validates all services data on the page against the data from API calls
	 * @param AuthorizationCode which is captured dynamically in the BeforeClass method of WatcherTest
	 * @return if data matches API data matches what is displayed
	 */
	public boolean AllService(String Authorization) {
		setNoOfItemsTo100();
		TestUtil.sleep(3000);
		boolean b1 = AllServicePerPage(1, Authorization);
		super.addLog("Click on next page button of pagination");
		log.info("Click on next page button of pagination");
		clickIt(NextPageBtn);
		TestUtil.sleep(6000);
		boolean b2 = AllServicePerPage(2, Authorization);
		super.addLog("Click on next page button of pagination");
		log.info("Click on next page button of pagination");
		clickIt(NextPageBtn);
		TestUtil.sleep(6000);
		boolean b3 = AllServicePerPage(3, Authorization);
		TestUtil.sleep(6000);
		super.addLog("Click on first page button of pagination");
		log.info("Click on first page button of pagination");
		clickIt(FirstPageBtn);
		TestUtil.sleep(6000);
		if(b1 && b2 && b3)
			return true;
		else
			return false;
	}

	/**
	 * This method parses through the JSON data from API calls and confirm that it matches with what is displayed on the given page: Files
	 * @param p is the page number
	 * @param AuthorizationCode is dynamically captured and passed here
	 * @return
	 */
	public boolean ValidateAllFiles(String AuthorizationCode) {
		
		waitForVisibilityOf(FilesLink, 10);
		waitForElementToDisplay(FilesLink, 10);
		if (!FilesLink.getAttribute("class").contains("design-active"))
			clickIt(FilesLink);
		TestUtil.sleep(3000);	
		RestAssured.baseURI = baseURL + "getdriveitems/" + siteID;	
		Response response =RestAssured.given().header("Authorization",AuthorizationCode).get();
		JsonPath js = response.jsonPath();
		String API_name = js.get("result.name").toString();
		String API_driveFormat = js.get("result.driveFormat").toString();
		String API_totaSize = js.get("result.totalSize").toString();
		String API_availableFreeSpace = js.get("result.availableFreeSpace").toString();
		String IdivFileXpath = "//span[@class='pl-1 pointer']";
		String fullinfo = driver.findElement(By.xpath(IdivFileXpath)).getText();
		String totalSize = fullinfo.split(" free of ")[1].trim().split(" ")[0].trim();
		String availableFreeSpace = fullinfo.split(" free of ")[0].trim().split(" ")[2].trim();
		String driveFormat = fullinfo.split(" - ")[1].trim();
		String name = fullinfo.split(" ")[0].trim();
		super.addLog("Verify that name, driveFormat, availableFreeSpace, totalSize is as per API data" );
		log.info("Verify that name, driveFormat, availableFreeSpace, totalSize is as per API data" );
		/*System.out.println(totalSize + "********************" + API_totaSize);
		System.out.println(availableFreeSpace+ "********************" + API_availableFreeSpace);
		System.out.println(driveFormat+ "********************" + API_driveFormat);
		System.out.println(name+ "********************" + API_name);*/
		if(API_totaSize.contains(totalSize) && API_availableFreeSpace.contains(availableFreeSpace)
				&&API_driveFormat.contains(driveFormat) && API_name.contains(name)) 
			return true;
		else
			return false;
	}

	/**
	 * This method parses through the JSON data from API calls and confirm that it matches with what is displayed on the given page:Process
	 * @param p is the page number
	 * @param AuthorizationCode is dynamically captured and passed here
	 * @return
	 */
	public boolean AllProcessPerPage(int p, String AuthorizationCode) {
		
		String xpath1 = "//div[@class='brand-ed-body my-2 row ml-0 mr-0 ng-star-inserted']//table//tr//td[1]";
		String xpath2 = "//div[@class='brand-ed-body my-2 row ml-0 mr-0 ng-star-inserted']//table//tr//td[2]";
		List<WebElement> AllProcessName = driver.findElements(By.xpath(xpath1));
		List<WebElement> AllDescription = driver.findElements(By.xpath(xpath2));
		RestAssured.baseURI = baseURL + "getprocesses/" + siteID;	
		Response response =RestAssured.given().header("Authorization",AuthorizationCode)
				.queryParam("CurrentPage",p)
				.queryParam("PageSize", 100).get();
		JsonPath js = response.jsonPath();
		List<String> APList1= new ArrayList<String>();
		List<String> APList2= new ArrayList<String>();
		List<String> WebsiteList1= new ArrayList<String>();
		List<String> WebsiteList2= new ArrayList<String>();
		String init1 ="result.results.processName[";
		String init2 ="result.results.description[";
		String end = "]";		
		super.addLog("Gather all data from API and website for page " + p);
		log.info("Gather all data from API and website for page " + p);
		for(int i=0;i<AllRows.size();i++) {
			String jsonIndex1 = init1 + i+end;
			String jsonIndex2 = init2 + i+end;
			APList1.add(i, js.get(jsonIndex1).toString());
			WebsiteList1.add(i,AllProcessName.get(i).getText());
			APList2.add(i, js.get(jsonIndex2).toString());
			WebsiteList2.add(i,AllDescription.get(i).getText());
			
		}
		/*for(int i=0;i<AllRows.size();i++) {
			System.out.println("*********** "+ APList1.get(i) + " " + APList2.get(i) );
			System.out.println("@@@@@@@@@@ "+ WebsiteList1.get(i) + " " + WebsiteList2.get(i) );

		}*/
		if(APList1.equals(WebsiteList1) && APList2.equals(WebsiteList2) ) {
			System.out.println("**********************************************************************");
			super.addLog("All columns data matches API data for Process Tab Page " + p);
			log.info("All columns data matches API data for Process Tab Page " + p);
			System.out.println("All columns data matches API data for Process Tab Page " + p);
			System.out.println("**********************************************************************");
			return true;
		}
		else {
			System.out.println("**********************************************************************");
			System.out.println("All columns data matches API data for Process Tab Page " + p);
			System.out.println("**********************************************************************");
			return false;
		}
	}

	/**
	 * This method validates all processes data on the page against the data from API calls
	 * @param AuthorizationCode which is captured dynamically in the BeforeClass method of WatcherTest
	 * @return if data matches API data matches what is displayed
	 */
	public boolean ValidateAllProcess(String AuthorizationCode) {
		clickProcessLink();
		TestUtil.sleep(3000);
		setNoOfItemsTo100();
		TestUtil.sleep(3000);
		boolean b1 = AllProcessPerPage(1,AuthorizationCode);	
		if(b1)
			return true;
		else
			return false;
	}
}