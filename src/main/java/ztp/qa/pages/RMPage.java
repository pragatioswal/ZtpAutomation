//@author : Praggati Oswal

package ztp.qa.pages;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import ztp.qa.base.TestBase;
import ztp.qa.util.TestUtil;

public class RMPage extends TestBase {

	// Page Factory - OR:

	// 8
	@FindAll({ @FindBy(xpath = "//div[@class='nav-links d-flex']/a") })
	List<WebElement> TopLinks;

	@FindAll({ @FindBy(xpath = "//span[@class='health-label']") })
	List<WebElement> SiteDetailsKey;

	// 15
	@FindAll({ @FindBy(xpath = "//div[@class='health-text']") })
	List<WebElement> SiteDetailsValue;

	@FindAll({ @FindBy(xpath = "//th") })
	List<WebElement> AllHeaders;

	@FindAll({ @FindBy(xpath = "//th/div[@role='button']/div[contains(@class,'mat-sort-header-content')]") })
	List<WebElement> AllHeadersSortingLink;

	@FindAll({ @FindBy(xpath = "//div[@class='dialog-wrapper']//div[contains(@class,'mat-select-arrow-wrapper')]") })
	List<WebElement> ScriptsDropDown;

	@FindAll({ @FindBy(xpath = "//span[@class='mat-option-text']") })
	List<WebElement> AllBookMarks;

	@FindAll({ @FindBy(xpath = "//tbody//tr") })
	List<WebElement> AllRows;

	@FindBy(xpath = "//div[@class='health-text']/child::a")
	WebElement SDGroupsLink;

	@FindBy(xpath = "//simple-snack-bar/span")
	WebElement SiteSelectionMsg;

	@FindBy(xpath = "//div[@class='mat-slide-toggle-bar mat-slide-toggle-bar-no-side-margin']")
	WebElement SiteElectionRadioBtn;

	@FindBy(xpath = "//button[@color='primary']")
	WebElement SyncBtn;

	@FindBy(xpath = "//input")
	WebElement AllowSiteElectionWE;

	@FindBy(xpath = "//mat-icon[text()='arrow_back']")
	WebElement BackArrow;

	@FindBy(xpath = "//mat-slide-toggle")
	WebElement CombinedScroll;

	@FindAll({ @FindBy(xpath = "//div[@class='view-container styles-custom-scroll p-4']") })
	List<WebElement> ViewContainers;

	@FindBy(xpath = "//div[@role='alertdialog']")
	WebElement AlertMessage;

	@FindBy(xpath = "//button[@aria-label='Close']")
	WebElement AlertMessageClose;

	@FindAll({ @FindBy(xpath = "//button[@class='ml-1 count-circle']") })
	List<WebElement> SearchBubbleGroupsInt;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[1]") })
	List<WebElement> AllGroupNames;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[7]") })
	List<WebElement> AllSerialNumbers;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[3]") })
	List<WebElement> AllCategories;

	@FindAll({ @FindBy(xpath = "//table[contains(@class,'script-list')]//tbody/tr//td[3]") })
	List<WebElement> AllNonScheduledScriptNames;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[2]") })
	List<WebElement> AllMacAddresses;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[8]") })
	List<WebElement> AllIPaddresses;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[5]/span") })
	List<WebElement> AllStatuses;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[5]") })
	List<WebElement> AllCompletedBy;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[6]") })
	List<WebElement> AllActivityStatuses;

	@FindAll({ @FindBy(xpath = "//mat-panel-title") })
	List<WebElement> ScriptManagerTabs;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[1]") })
	List<WebElement> AllTLMacAddresses;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[3]") })
	List<WebElement> AllTLSizes;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[4]") })
	List<WebElement> AllTLFilenames;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[2]") })
	List<WebElement> AllTLUploadDates;

	@FindAll({ @FindBy(xpath = "//tbody/tr[1]/td[5]//mat-icon") })
	List<WebElement> FirstRowTLMatIcons;

	@FindBy(xpath = "//div[contains(@class,'mat-dialog-title')]")
	WebElement TLViewFile;

	@FindBy(xpath = "//span[normalize-space()='×']")
	WebElement TLViewFileClose;

	@FindBy(xpath = "//mat-icon[@class='mat-icon notranslate mt-n1 material-icons mat-icon-no-color']")
	WebElement TLPeriodDropDownArrow;

	@FindAll({ @FindBy(xpath = "//button[@role='menuitem']") })
	List<WebElement> TLPeriodDropDown;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[1]") })
	List<WebElement> AllMCGroups;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[2]") })
	List<WebElement> AllMCMacAddresses;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[3]") })
	List<WebElement> AllMCIPAddresses;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[7]") })
	List<WebElement> AllMCActions;

	@FindAll({ @FindBy(xpath = "//span[@class='mat-button-wrapper']") })
	List<WebElement> AllMCLinks;

	@FindAll({ @FindBy(xpath = "//div[@class='d-flex justify-content-between']/span") })
	List<WebElement> AllMCViewWinNames;

	@FindBy(xpath = "//span[@class='font-weight-bolder']")
	WebElement NewScriptLink;

	@FindBy(xpath = "//div[@class='dialog-wrapper']//input[contains(@class,'mat-input-element')]")
	WebElement ScriptName;

	@FindBy(xpath = "//mat-error")
	WebElement DuplicateScriptError;

	@FindBy(xpath = "//span[contains(@class,'error-font')]")
	WebElement ScriptDescriptionError;

	@FindBy(xpath = "//span[@class='mat-checkbox-inner-container']")
	WebElement UploadFileChkBox;

	@FindBy(xpath = "//img[@class='brand-logo-upload-icon mb-n2']")
	WebElement UploadImage;

	@FindAll({ @FindBy(xpath = "//span[contains(@class,'mat-expansion-indicator')]") })
	List<WebElement> MatExpanders;

	@FindAll({ @FindBy(xpath = "//div[@class='mat-paginator-range-label']") })
	List<WebElement> TotalNumOfRows;

	@FindAll({ @FindBy(xpath = "//div[contains(@class,'mat-select-arrow') ]") })
	List<WebElement> AllDropDownArrows;

	@FindBy(xpath = "//textarea[contains(@class,'script-textarea')]")
	WebElement ScriptDetails;

	@FindBy(xpath = "//textarea[contains(@class,'script-description-textarea')]")
	WebElement ScriptDescription;

	@FindBy(xpath = "//simple-snack-bar[@class='mat-simple-snackbar ng-star-inserted']")
	WebElement ScriptInfoMsg;

	@FindBy(xpath = "//mat-icon[normalize-space()='download']")
	WebElement DownloadScriptBtn;

	@FindBy(xpath = "//mat-icon[normalize-space()='bookmark']")
	WebElement BookMarkScriptBtn;

	@FindBy(xpath = "//mat-icon[normalize-space()='delete']")
	WebElement DeleteScriptBtn;

	@FindBy(xpath = "//span[normalize-space()='Delete Script']")
	WebElement DeleteScriptAlertBtn;

	@FindAll({ @FindBy(xpath = "//span[@class='mat-option-text']") })
	List<WebElement> RepeatOptions;

	@FindBy(xpath = "//span[@class='mat-button-wrapper' and contains(text(),'Add')]")
	WebElement AddScheduleButton;

	@FindBy(xpath = "//span[@class='mat-button-wrapper' and contains(text(),'Send')]")
	WebElement SendButton;

	@FindAll({ @FindBy(xpath = "//table[contains(@class,'scheduled-list')]//tbody/tr/td[3]") })
	List<WebElement> AllScriptNames;

	// 1 view 2 download 3 delete
	@FindAll({ @FindBy(xpath = "//button[@role='menuitem']") })
	List<WebElement> ScriptActions;

	@FindBy(xpath = "//h2")
	WebElement ViewScriptHeading;

	@FindBy(xpath = "//mat-icon[@mattooltip='Close']")
	WebElement ViewScriptClose;

	@FindBy(xpath = "//button[@class='close']")
	WebElement GroupsScriptClose;

	@FindBy(xpath = "//span[@class='mat-option-text' and text()='New']")
	WebElement GroupsDropDownClose;

	@FindBy(xpath = "//mat-dialog-container//mat-icon[@mattooltip='Delete Script']")
	WebElement ViewScriptDelete;

	@FindBy(xpath = "//mat-dialog-container//mat-icon[@mattooltip='Download Script']")
	WebElement ViewScriptDownload;

	@FindBy(xpath = "//mat-dialog-container//mat-icon[@mattooltip='Bookmark script']")
	WebElement ViewScriptBookmark;

	@FindBy(xpath = "//span[@class='mat-button-wrapper' and contains(text(),'Occurence')]")
	WebElement ViewScriptOccurenceBtn;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[15]") })
	List<WebElement> AllGoLiveDates;

	@FindAll({ @FindBy(xpath = "//mat-chip") })
	List<WebElement> SearchBubbleGroupsNames;

	@FindBy(xpath = "//mat-icon[normalize-space()='search']")
	WebElement SearchIcon;

	@FindBy(xpath = "//span[@class='ml-1 mr-1 search-outline ng-star-inserted']//input")
	WebElement SearchInputBox;

	@FindBy(xpath = "//thead//span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']")
	WebElement MainCheckbox;

	@FindBy(xpath = "//div[@class='mat-paginator-range-label']")
	WebElement TotalNumOfServices;

	@FindBy(xpath = "//tbody/tr/td")
	WebElement FirstRow;

	@FindBy(xpath = "//mat-select[@aria-label='Items per page:']")
	WebElement DropDownNoOfServices;

	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'5')]")
	WebElement NoOfService5;

	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'10')]")
	WebElement NoOfService10;

	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'25')]")
	WebElement NoOfService25;

	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'100')]")
	WebElement NoOfService100;

	@FindBy(xpath = "//span[normalize-space()='Activity']")
	WebElement ActivityLink;

	@FindAll({
			@FindBy(xpath = "//thead//span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']") })
	List<WebElement> ScriptsMainCheckboxes;

	@FindAll({ @FindBy(xpath = "//span[contains(@class,'ml-1 pointer')]") })
	List<WebElement> GroupsOnlineOfflineLinks;

	@FindAll({ @FindBy(xpath = "//mat-chip") })
	List<WebElement> GroupsSearchCriteria;

	@FindAll({ @FindBy(xpath = "//tr[contains(@class,'device-on')]") })
	List<WebElement> AllOnDevices;

	@FindAll({ @FindBy(xpath = "//tr[contains(@class,'device-off')]") })
	List<WebElement> AllOffDevices;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[15]//span[@class='mat-tooltip-trigger pointer']") })
	List<WebElement> FourHoverOptionsList;

	@FindAll({
			@FindBy(xpath = "//div[@class='row mr-1 top-header icon-header ng-star-inserted']//span[@class='mat-tooltip-trigger pointer mt-1 ng-star-inserted']") })
	List<WebElement> HDFourHoverOptionsList;

	@FindAll({ @FindBy(xpath = "//mat-panel-description/span") })
	List<WebElement> ScriptsHDFourHoverOptionsList;

	@FindAll({
			@FindBy(xpath = "//tbody/tr//span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']") })
	List<WebElement> AllCheckboxesSpan;

	@FindAll({
			@FindBy(xpath = "//tbody/tr//span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']/input") })
	List<WebElement> AllCheckboxesInput;

	@FindAll({
			@FindBy(xpath = "//tbody/tr//span[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']/input[@tabindex='0']") })
	List<WebElement> AllEnabledCheckboxesInput;

	@FindAll({ @FindBy(xpath = "//tbody//mat-checkbox") })
	List<WebElement> AllMatCheckboxes;

	@FindBy(xpath = "//h2")
	WebElement ScriptsWindow;

	@FindBy(xpath = "//button[@class='close']")
	WebElement ScriptClose;

	@FindBy(xpath = "//button[@class='mat-focus-indicator font-weight-bold mat-stroked-button mat-button-base']")
	WebElement BoldActionBtn;

	@FindBy(xpath = "//span[@class='mat-button-wrapper' and text()='Cancel']")
	WebElement HoverCancelBtn;

	@FindBy(xpath = "//span[@class='mat-button-wrapper' and text()='Screenshot']")
	WebElement HoverScreenShotBtn;

	@FindBy(xpath = "//span[@class='mat-button-wrapper' and text()='Pull Manifest']")
	WebElement HoverPullManifestBtn;

	@FindBy(xpath = "//span[@class='mat-button-wrapper' and text()='Reboot']")
	WebElement HoverRebootBtn;

	@FindBy(xpath = "//p")
	WebElement HoverAlertMsg;

	@FindBy(xpath = "//button[@aria-label='Last page']")
	WebElement LastPageBtn;

	@FindBy(xpath = "//button[@aria-label='First page']")
	WebElement FirstPageBtn;

	@FindBy(xpath = "//button[@aria-label='Next page']")
	WebElement NextPageBtn;

	@FindBy(xpath = "//button[@aria-label='Previous page']")
	WebElement PreviousPageBtn;

	@FindBy(xpath = "//mat-select//span[contains(@class,'mat-select-min-line')]")
	WebElement CurrentTool;

	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'RM Portal')]")
	WebElement Tool_RMPortal;

	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'POS Tester')]")
	WebElement Tool_POSTester;

	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'QR Code')]")
	WebElement Tool_QRCode;

	@FindBy(xpath = "//mat-icon[contains(text(),'sort')]")
	WebElement ActivityDropDown;

	@FindBy(xpath = "//button[text()='Today']")
	WebElement ActivityToday;

	@FindBy(xpath = "//button[text()='Last7Days']")
	WebElement ActivityLast7Days;

	@FindBy(xpath = "//button[text()='Last14Days']")
	WebElement ActivityLast14Days;

	@FindBy(xpath = "//button[text()='Last30Days']")
	WebElement ActivityLast30Days;

	@FindBy(xpath = "//button[text()='Last90Days']")
	WebElement ActivityLast90Days;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[1]") })
	List<WebElement> ActivityColumn1;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[2]") })
	List<WebElement> ActivityColumn2;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[3]") })
	List<WebElement> ActivityColumn3;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[4]") })
	List<WebElement> ActivityColumn4;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[5]") })
	List<WebElement> ActivityColumn5;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[6]") })
	List<WebElement> ActivityColumn6;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[7]") })
	List<WebElement> ActivityColumn7;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[8]") })
	List<WebElement> ActivityColumn8;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[8]/a") })
	List<WebElement> ActivityColumn8Links;

	@FindBy(xpath = "//div[contains(@class,'mat-sort-header-content') and text()=' Status ']")
	WebElement StatusLink;

	@FindBy(xpath = "//div[contains(@class,'mat-sort-header-content') and text()=' Date ']")
	WebElement DateLink;

	@FindAll({ @FindBy(xpath = "//tbody/tr/td[8]/a") })
	List<WebElement> AllActivityColumn8;

	@FindBy(xpath = "//mat-icon[contains(text(),'download')]")
	WebElement ScreenShotDownload;

	@FindBy(xpath = "//button//mat-icon[contains(text(),'close')]")
	WebElement ScreenShotClose;

	@FindBy(xpath = "//span[@class='status ng-star-inserted']")
	WebElement ButtonOnWindow;

	@FindAll({ @FindBy(xpath = "//div[@class='mat-tab-label-content']") })
	List<WebElement> ActivityWindowTabs;

	@FindBy(xpath = "//input[@placeholder='SiteCode / HostName']")
	WebElement SiteSync_txtbox;

	@FindBy(xpath = "//span[text()='Search']")
	WebElement SiteSync_Searchbtn;

	public int NoOfGroups;
	SoftAssert softAssert = new SoftAssert();

	// Initializing the Page Objects:
	public RMPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method goes to POS plugin page
	 * @return true on success
	 */
	public POSPage RMtoPOS() {
		waitForElementToDisplay(CurrentTool, 10);
		waitForVisibilityOf(CurrentTool, 10);
		clickIt(CurrentTool);
		waitForVisibilityOf(Tool_POSTester, 10);
		clickIt(Tool_POSTester);
		return new POSPage();
	}

	/**
	 * This function gets the number of groups from Site details page
	 * @return no of groups
	 */
	public int GetNoOfGroups() {
		NoOfGroups = Integer.parseInt(SiteDetailsValue.get(10).getText());
		return NoOfGroups;
	}

	/**
	 * This method verifies that RM page shows up correctly
	 * @return true on success
	 */
	public boolean VerifyRMPage() {
		super.addLog("Verify RM portal page is displayed correctly");
		log.info("Verify RM portal page is displayed correctly");
		if (SiteDetailsKey.size() == 15)
			return true;
		else
			return false;
	}

	/**
	 * This method connects with the database and confirm that values for the page match the database
	 *  @return true on success
	 */
	public boolean SiteDetails() {

		byte[] un = Base64.getDecoder().decode(prop.getProperty("DBuser"));
		byte[] pwd = Base64.getDecoder().decode(prop.getProperty("DBpass"));

		Statement stmt;
		ResultSet rs;
		String s;
		try {
			super.addLog("Connect with the Database and get all site details");
			log.info("Connect with the Database and get all site details");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(prop.getProperty("DBConnectionString"), new String(un),
					new String(pwd));
			
			stmt = conn.createStatement();
			s = "select a.Address1,a.Address2, a.City, a.State, a.Zip, a.Phone1, a.Phone2 from Address a, "
					+ "site s where a.AddressId=s.AddressId and \r\n"
					+ "s.SiteId='9807ed24-e684-4429-a808-f391be68c8a2'";
			rs = stmt.executeQuery(s);
			while (rs.next()) {
				super.addLog("Verifying Address1 from page with database value");
				log.info("Verifying Address1 from page with database value");
				String Address1 = rs.getString(1);
				softAssert.assertEquals(SiteDetailsValue.get(2).getText(), Address1,
						"Address1 does not match value in DB");

				super.addLog("Verifying Address2 from page with database value");
				log.info("Verifying Address2 from page with database value");
				String Address2 = rs.getString(2);
				softAssert.assertEquals(SiteDetailsValue.get(3).getText(), Address2,
						"Address2 does not match value in DB");

				super.addLog("Verifying City from page with database value");
				log.info("Verifying City from page with database value");
				String City = rs.getString(3);
				softAssert.assertEquals(SiteDetailsValue.get(4).getText(), City, "City does not match value in DB");

				super.addLog("Verifying State from page with database value");
				log.info("Verifying State from page with database value");
				String State = rs.getString(4);
				softAssert.assertEquals(SiteDetailsValue.get(5).getText(), State, "State does not match value in DB");

				super.addLog("Verifying Zip from page with database value");
				log.info("Verifying Zip from page with database value");
				String Zip = rs.getString(5);
				softAssert.assertEquals(SiteDetailsValue.get(6).getText(), Zip, "Zip does not match value in DB");

				super.addLog("Verifying Phone1 from page with database value");
				log.info("Verifying Phone1 from page with database value");
				String Phone1 = rs.getString(6);
				softAssert.assertEquals(SiteDetailsValue.get(7).getText(), Phone1, "Phone1 does not match value in DB");

				super.addLog("Verifying Phone2 from page with database value");
				log.info("Verifying Phone2 from page with database value");
				String Phone2 = rs.getString(7);
				softAssert.assertEquals(SiteDetailsValue.get(8).getText(), Phone2, "Phone2 does not match value in DB");
			}
			stmt = conn.createStatement();
			s = "select count (groupid) as no_of_groups from [group] where siteid='9807ed24-e684-4429-a808-f391be68c8a2'";
			rs = stmt.executeQuery(s);
			while (rs.next()) {
				super.addLog("Verifying number of Groups  from page with database value");
				log.info("Verifying number of Groups from page with database value");
				String NGroups = rs.getString(1);
				softAssert.assertEquals(SiteDetailsValue.get(10).getText(), NGroups,
						"number of Groups does not match value in DB");
			}

			stmt = conn.createStatement();
			s = "select UseNoDMS, AllowSiteElection, TimeZone from Site where siteid='9807ed24-e684-4429-a808-f391be68c8a2'";
			rs = stmt.executeQuery(s);
			while (rs.next()) {

				super.addLog("Verifying UseNoDMS  from page with database value");
				log.info("Verifying UseNoDMS  from page with database value");
				String UseNoDMS = rs.getString(1);
				if (UseNoDMS.equals("1"))
					softAssert.assertEquals(SiteDetailsValue.get(11).getText(), "Yes",
							"UseNoDMS does not match value in DB");

				super.addLog("Verifying AllowSiteElection from page with database value");
				log.info("Verifying AllowSiteElection from page with database value");
				String AllowSiteElection = rs.getString(2);
				if (AllowSiteElectionWE.getAttribute("aria-checked").toString().equals("true"))
					softAssert.assertEquals("1", AllowSiteElection, "AllowSiteElection does not match value in DB");

				super.addLog("Verifying TimeZone from page with database value");
				log.info("Verifying TimeZone from page with database value");
				String TimeZone = rs.getString(3);
				softAssert.assertEquals(SiteDetailsValue.get(9).getText(), TimeZone,
						"TimeZone does not match value in DB");
			}

			stmt = conn.createStatement();
			s = "select rm.instancename from ResilioManagement rm, SiteSetting ss where ss.ResilioManagementId=rm.ResilioManagementId and\r\n"
					+ "ss.SiteId='9807ed24-e684-4429-a808-f391be68c8a2'";
			rs = stmt.executeQuery(s);
			while (rs.next()) {
				super.addLog("Verifying instance name from page with database value");
				log.info("Verifying instance name from page with database value");
				String instance = rs.getString(1);
				softAssert.assertEquals(SiteDetailsValue.get(12).getText(), instance,
						"instance name does not match value in DB");
			}

			stmt = conn.createStatement();
			s = "select cs.cloudstoragename from CloudStorage cs, SiteSetting ss where ss.CloudStorageId=cs.CloudStorageId and\r\n"
					+ "ss.SiteId='9807ed24-e684-4429-a808-f391be68c8a2'";
			rs = stmt.executeQuery(s);
			while (rs.next()) {
				super.addLog("Verifying cloudstoragename from page with database value");
				log.info("Verifying cloudstoragename from page with database value");
				String cloudstoragename = rs.getString(1);
				softAssert.assertEquals(SiteDetailsValue.get(13).getText(), cloudstoragename,
						"cloudstoragename does not match value in DB");
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		softAssert.assertAll();
		super.addLog("Verifying Franchise and Site Name from page with database value");
		log.info("Verifying Franchise and Site Name from page with database value");
		if (SiteDetailsValue.get(1).getText().equals(prop.getProperty("store"))
				&& SiteDetailsValue.get(0).getText().equals(prop.getProperty("franchise")))
			return true;
		else
			return false;
	}

	/**
	 * This method confirms that the groups link from Site details goes to groups page on clicking
	 * @return true on success
	 */
	public boolean SiteDetailsGroupsLink() {
		boolean b;
		int n = Integer.parseInt(SDGroupsLink.getText());
		if (n > 0) {
			waitForelementToBeClickable(SDGroupsLink, 10);
			clickIt(SDGroupsLink);
			waitForelementToBeClickable(GroupsSearchCriteria.get(1), 10);
			if (GroupsSearchCriteria.size() == n + 2)
				b = true;
			else
				b = false;
		} else
			b = false;
		IsSpinningComplete();
		waitForelementToBeClickable(TopLinks.get(0), 10);
		clickIt(TopLinks.get(0));
		return b;
	}

	/**
	 * This method confirm that the siteelection toggle works as exepcted
	 * @param i 1:on to off , 2:off to on
	 * @return true on success
	 */
	public boolean SDSiteElectionOnOff(int i) {
		TestUtil.sleep(2000);
		waitForelementToBeClickable(SiteElectionRadioBtn, 10);
		clickIt(SiteElectionRadioBtn);
		IsSpinningComplete();
		waitForVisibilityOf(SiteSelectionMsg, 10);
		if (i == 1) {
			if (SiteSelectionMsg.getText().equals("Site election for site has been disabled"))
				return true;
			else
				return false;
		} else {
			if (SiteSelectionMsg.getText().equals("Site election for site has been enabled"))
				return true;
			else
				return false;
		}
	}

	/**
	 * This function validates that Site Sync functionality works
	 * @return true on success
	 */
	public boolean SDSiteSync() {
		TestUtil.sleep(2000);
		waitForelementToBeClickable(SyncBtn, 10);
		clickIt(SyncBtn);
		super.addLog("Check whether confirmation alert is present");
		log.info("Check whether confirmation alert is present");
		TestUtil.sleep(2000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		try {
			if (BoldActionBtn.isDisplayed())
				clickIt(BoldActionBtn);
		} catch (Exception e) {
			System.out.println("Confirmation alert not displayed");
		}
		TestUtil.sleep(2000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		if (AlertMessage.getText().contains("Sync Has Been Initiated Successfully for Site")) {
			clickIt(AlertMessageClose);
			TestUtil.sleep(2000);
			return true;
		} else {
			TestUtil.sleep(2000);
			return false;
		}

	}

	/**
	 * This function returns the index of the first groups which is empty
	 * @return index
	 */
	public int FindEmptyGroup() {
		int n = SearchBubbleGroupsInt.size();
		int b = 9999;
		for (int i = 0; i < n; i++) {
			if (Integer.parseInt(SearchBubbleGroupsInt.get(i).getText()) == 0) {
				b = i;
				break;
			}
		}
		return b;
	}

	/**
	 * This method sets no of items to 100
	 */
	public void setNoOfItemsTo100() {
		waitForelementToBeClickable(DropDownNoOfServices, 10);
		TestUtil.sleep(2000);
		clickIt(DropDownNoOfServices);
		waitForVisibilityOf(NoOfService100, 10);
		clickIt(NoOfService100);
	}
	
	/**
	 * This function returns the index of the first groups which is non empty
	 * @return index
	 */
	public int FindNonEmptyGroup() {
		int n = SearchBubbleGroupsInt.size();
		int b = 9999;
		for (int i = 1; i < n; i++) {
			if (Integer.parseInt(SearchBubbleGroupsInt.get(i).getText()) != 0) {
				b = i;
				break;
			}
		}
		return b;
	}

	/**
	 * This function calculates the number of groups displayed when multiple non empty groups are selected
	 * @return total
	 */
	public int TotalFromCombinedGroups() {
		int n = SearchBubbleGroupsInt.size();
		int b = 0;
		int c;
		super.addLog("Calculate total of all groups for search criteria selected");
		log.info("Calculate total of all groups for search criteria selected");
		for (int i = 1; i < n; i++) {
			c = Integer.parseInt(SearchBubbleGroupsInt.get(i).getText());
			if (c != 0) {
				b = b + c;
				clickIt(SearchBubbleGroupsInt.get(i));
				IsSpinningComplete();
			}
		}
		return b;
	}

	/**
	 * this function returns the index of the last button which is ungrouped
	 * @return index
	 */
	public int FindUnGroupedButton() {
		int n = SearchBubbleGroupsInt.size();
		return n - 1;
	}

	/**
	 * This function confirm that the number of services displayed matches what group is selected
	 * @param i is the index of the groups button
	 * @return true on success
	 */
	public boolean SearchBySelectedCriteria(int i) {
		int n;
		TestUtil.sleep(4000);
		clickIt(TopLinks.get(1));
		softAssert.assertEquals(AllHeaders.size(), 15);
		n = Integer.parseInt(SearchBubbleGroupsInt.get(i).getText());
		super.addLog("Click group button as per test criteria");
		log.info("Click group button as per test criteria");
		clickIt(SearchBubbleGroupsInt.get(i));
		TestUtil.sleep(2000);
		waitForVisibilityOf(TotalNumOfServices, 10);
		String t = TotalNumOfServices.getText();
		super.addLog("Verify number of Groups displayed on All button matches total number of rows of table");
		log.info("Verify number of Groups displayed on All button matches total number of rows of table");
		int m = Integer.parseInt(t.split("of")[1].trim());
		clickIt(SearchBubbleGroupsInt.get(i));
		softAssert.assertAll();
		if (m == n)
			return true;
		else
			return false;
	}

	/**
	 * This function confirms that group names match the group selected at the top
	 * @return true on success
	 */
	public boolean SearchGroupNamesWithCriteria() {
		boolean b = true;
		TestUtil.sleep(4000);
		clickIt(TopLinks.get(1));
		Assert.assertEquals(AllHeaders.size(), 15);
		setNoOfItemsTo100();
		TestUtil.sleep(2000);
		int n = SearchBubbleGroupsInt.size();
		int c;
		for (int i = 1; i < n - 1; i++) {
			c = Integer.parseInt(SearchBubbleGroupsInt.get(i).getText());
			if (c != 0) {
				clickIt(SearchBubbleGroupsInt.get(i));
				TestUtil.sleep(2000);
				for (int j = 0; j < AllGroupNames.size(); j++) {
					if (!(AllGroupNames.get(j).getText()
							.equals(SearchBubbleGroupsNames.get(i).getText().split("\\R")[0].trim())))
						b = false;
				}
				break;
			}
		}
		clickIt(SearchBubbleGroupsInt.get(0));
		return b;
	}

	/**
	 * this function verifies that the number displayed on individual groups matches what is displayed for the table when multiple groups 
	 * are selected
	 * @return true on succeess
	 */
	public boolean SearchCombinedGroups() {
		TestUtil.sleep(2000);
		clickIt(TopLinks.get(1));
		Assert.assertEquals(AllHeaders.size(), 15);
		int n = TotalFromCombinedGroups();
		waitForVisibilityOf(TotalNumOfServices, 10);
		String t = TotalNumOfServices.getText();
		int m = Integer.parseInt(t.split("of")[1].trim());
		clickIt(SearchBubbleGroupsInt.get(0));
		if (m == n)
			return true;
		else
			return false;
	}

	/**
	 * This function searches groups table with the value 22
	 * @return true on success
	 */
	public boolean SearchBySerialNo() {
		boolean b = true;
		TestUtil.sleep(2000);
		waitForelementToBeClickable(TopLinks.get(1), 10);
		clickIt(TopLinks.get(1));
		Assert.assertEquals(AllHeaders.size(), 15);
		super.addLog("Click on search icon and type 22");
		log.info("Click on search icon and type 22");
		waitForVisibilityOf(SearchIcon, 10);
		clickIt(SearchIcon);
		clickIt(SearchInputBox);
		SearchInputBox.sendKeys("22");
		TestUtil.sleep(4000);
		for (int i = 0; i < AllSerialNumbers.size(); i++) {
			if (!(AllSerialNumbers.get(i).getText().contains("22")))
				b = false;
		}
		SearchInputBox.sendKeys(Keys.BACK_SPACE);
		SearchInputBox.sendKeys(Keys.BACK_SPACE);
		return b;
	}

	/**
	 * This function searches groups table with the value 164
	 * @return true on success
	 */
	public boolean SearchByIp() {
		boolean b = true;
		clickIt(TopLinks.get(1));
		Assert.assertEquals(AllHeaders.size(), 15);
		super.addLog("Click on search icon and type 164");
		log.info("Click on search icon and type 164");
		waitForVisibilityOf(SearchIcon, 10);
		clickIt(SearchIcon);
		clickIt(SearchInputBox);
		SearchInputBox.sendKeys("164");
		TestUtil.sleep(4000);
		for (int i = 0; i < AllIPaddresses.size(); i++) {
			if (!(AllIPaddresses.get(i).getText().contains("164")))
				b = false;
		}
		SearchInputBox.sendKeys(Keys.BACK_SPACE);
		SearchInputBox.sendKeys(Keys.BACK_SPACE);
		SearchInputBox.sendKeys(Keys.BACK_SPACE);
		return b;
	}

	/**
	 * This function confirms that when all groups button is selected, all selected groups are de-selected
	 * @return true on success
	 */
	public boolean ResetSearchwithAllBtn() {
		boolean b = true;
		clickIt(TopLinks.get(1));
		Assert.assertEquals(AllHeaders.size(), 15);
		super.addLog("Click first three search buttons");
		log.info("Click first three search buttons");
		clickIt(SearchBubbleGroupsInt.get(1));
		IsSpinningComplete();
		clickIt(SearchBubbleGroupsInt.get(2));
		IsSpinningComplete();
		clickIt(SearchBubbleGroupsInt.get(3));
		IsSpinningComplete();
		super.addLog("Click All button");
		log.info("Click All button");
		TestUtil.sleep(5000);
		clickIt(SearchBubbleGroupsInt.get(0));
		IsSpinningComplete();
		for (int i = 1; i < SearchBubbleGroupsNames.size(); i++) {
			if (SearchBubbleGroupsNames.get(i).getAttribute("ng-reflect-selected").equals("true")) {
				b = false;
				break;
			}

		}
		return b;
	}

	/**
	* This function click resets the groups page
	*/
	public void resetRMPage() {
		clickIt(TopLinks.get(0));
		TestUtil.sleep(2000);
		clickIt(TopLinks.get(1));
		Assert.assertEquals(AllHeaders.size(), 15);
		setNoOfItemsTo100();
		TestUtil.sleep(2000);
	}

	/**
	 * This function verifies that only online groups are displayed when online button is selected
	 * and only offline groups are displayed when offline button is selected
	 * @param i online 0; offline 1
	 * @return true on success
	 */
	public boolean OnlineOfflineGroups(int i) {
		boolean b = true;
		TestUtil.sleep(2000);
		clickIt(TopLinks.get(1));
		Assert.assertEquals(AllHeaders.size(), 15);
		setNoOfItemsTo100();
		TestUtil.sleep(2000);
		clickIt(GroupsOnlineOfflineLinks.get(i));
		TestUtil.sleep(2000);
		if (i == 0) {
			for (int j = 0; j < AllRows.size(); j++) {
				if (!(AllRows.get(j).getAttribute("class").contains("device-on"))) {
					b = false;
					break;
				}
			}
		}
		if (i == 1) {
			for (int j = 0; j < AllRows.size(); j++) {
				if (!(AllRows.get(j).getAttribute("class").contains("device-off"))) {
					b = false;
					break;
				}
			}
		}
		clickIt(GroupsOnlineOfflineLinks.get(i));
		return b;
	}

	/**
	 * This function is called from HoverOptions function 
	 * @param i is the option that needs to be verified
	 * @return true on success
	 */
	public boolean VerifyHoverAction(int i) {
		boolean b = false;

		if (i == 0) {
			super.addLog("Verify that action button is Capture Screenshot");
			log.info("Verify that action button is Capture Screenshot");
			Assert.assertTrue(FourHoverOptionsList.get(i).getAttribute("mattooltip").contains("Capture Screenshot"));
		} else if (i == 1) {
			super.addLog("Verify that action button is Pull Manifest");
			log.info("Verify that action button is Pull Manifest");
			Assert.assertTrue(FourHoverOptionsList.get(i).getAttribute("mattooltip").contains("Pull Manifest"));
		} else if (i == 2) {
			super.addLog("Verify that action button is Reboot");
			log.info("Verify that action button is Reboot");
			Assert.assertTrue(FourHoverOptionsList.get(i).getAttribute("mattooltip").contains("Reboot"));
		} else if (i == 3) {
			super.addLog("Verify that action button is Scripts");
			log.info("Verify that action button is Scripts");
			Assert.assertTrue(FourHoverOptionsList.get(i).getAttribute("mattooltip").contains("Scripts"));
		}
		clickIt(FourHoverOptionsList.get(i));
		TestUtil.sleep(2000);
		super.addLog("Verify that action alert opens");
		log.info("Verify that action alert opens");
		if (i == 0) {
			if (BoldActionBtn.isDisplayed()
					&& HoverAlertMsg.getText().contains("Are you sure you want to capture the screenshot?")) {
				waitForElementToDisplay(HoverCancelBtn, 10);
				clickIt(HoverCancelBtn);
				b = true;
			}
		} else if (i == 1) {
			if (BoldActionBtn.isDisplayed() && HoverAlertMsg.getText()
					.contains("Are you sure you want to pull the package manifest from the device(s)?")) {
				waitForElementToDisplay(HoverCancelBtn, 10);
				clickIt(HoverCancelBtn);
				b = true;
			}
		} else if (i == 2) {
			if (BoldActionBtn.isDisplayed()
					&& HoverAlertMsg.getText().contains("Are you sure you want to reboot the device(s)")) {
				waitForElementToDisplay(HoverCancelBtn, 10);
				clickIt(HoverCancelBtn);
				b = true;
			}
		} else if (i == 3) {
			if (ScriptsWindow.getText().contains("Script")) {
				TestUtil.sleep(4000);
				clickIt(ScriptClose);
				b = true;
			}
		}
		return b;
	}

	/**
	 * This function confirms that 4 options exist for the row that has checkbox enabled
	 * @return true on success
	 */
	public void HoverOptions() {
		
		int i;
		TestUtil.sleep(2000);
		clickIt(TopLinks.get(1));
		Assert.assertEquals(AllHeaders.size(), 15);
		setNoOfItemsTo100();
		TestUtil.sleep(2000);
		super.addLog("Hover over the last column of the first row with checkbox enabled in the table");
		log.info("Hover over the last column of the first row with checkbox enabled in the table");
		for (i = 0; i < AllCheckboxesSpan.size(); i++) {
			if (AllCheckboxesInput.get(i).getAttribute("tabindex").toString().equals("0")) {
				clickIt(AllCheckboxesSpan.get(i));
				break;
			}

		}
		TestUtil.sleep(2000);

		Actions act = new Actions(driver);
		super.addLog("Capture screenshot");
		log.info("Capture screenshot");
		act.moveToElement(AllGoLiveDates.get(i)).perform();
		softAssert.assertTrue(VerifyHoverAction(0),"Display of option Capture screenshot on hovering on last column does not work");
		super.addLog("Pull manifest");
		log.info("Pull manifest");
		act.moveToElement(AllGoLiveDates.get(i)).perform();
		softAssert.assertTrue(VerifyHoverAction(1),"Display of option Pull manifest on hovering on last column does not work");
		super.addLog("Reboot");
		log.info("Reboot");
		act.moveToElement(AllGoLiveDates.get(i)).perform();
		softAssert.assertTrue(VerifyHoverAction(2),"Display of option Reboot on hovering on last column does not work");
		super.addLog("Scripts");
		log.info("Scripts");
		act.moveToElement(AllGoLiveDates.get(i)).perform();
		softAssert.assertTrue(VerifyHoverAction(3),"Display of option Scripts on hovering on last column does not work");
		softAssert.assertAll();
	
	}

	/**
	 * This function verifies that device is not onboarded device appears correctly
	 * @return true on success
	 */
	public boolean NotOnboardedDevices() {
		int i;
		TestUtil.sleep(2000);
		super.addLog("Find the first disabled checkbox");
		log.info("Find the first disabled checkbox");
		for (i = 0; i < AllCheckboxesSpan.size(); i++) {
			if (AllCheckboxesInput.get(i).getAttribute("tabindex").toString().equals("-1")) {
				break;
			}

		}
		TestUtil.sleep(2000);
		super.addLog("Hover over the first disabled checkbox");
		log.info("Hover over the first disabled checkbox");
		Actions act = new Actions(driver);
		act.moveToElement(AllMatCheckboxes.get(i)).perform();
		super.addLog("Verify whether 'Device is not onboarded message' is displayed");
		log.info("Verify whether 'Device is not onboarded message' is displayed");
		if (AllMatCheckboxes.get(i).getAttribute("ng-reflect-message").equals("Device is not onboarded"))
			return true;
		else
			return false;
	}

	/**
	 * this function scrolls the table on the groups tab
	 * @return
	 */
	public boolean ScrollTable() {
		clickIt(TopLinks.get(1));
		Assert.assertEquals(AllHeaders.size(), 15);
		setNoOfItemsTo100();
		TestUtil.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", AllRows.get(AllRows.size() - 1));
		return true;
	}

	/**
	 * This function selects  a groups with some number of rows and verifies that group sync works
	 * @return success on return
	 */
	public boolean GroupSync() {
		TestUtil.sleep(2000);
		clickIt(TopLinks.get(1));
		Assert.assertEquals(AllHeaders.size(), 15);
		clickIt(SearchBubbleGroupsInt.get(FindNonEmptyGroup()));
		IsSpinningComplete();
		waitForelementToBeClickable(SyncBtn, 10);
		clickIt(SyncBtn);
		super.addLog("Check whether confirmation alert is present");
		log.info("Check whether confirmation alert is present");
		TestUtil.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		try {
			if (BoldActionBtn.isDisplayed())
				clickIt(BoldActionBtn);
		} catch (Exception e) {
			System.out.println("Confirmation alert not displayed");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		TestUtil.sleep(2000);
		if (AlertMessage.getText().contains("Sync Has Been Initiated Successfully for Group")) {
			clickIt(AlertMessageClose);
			TestUtil.sleep(2000);
			return true;
		} else {
			TestUtil.sleep(2000);
			return false;
		}
	}

	/**
	 * This function makes sure that when checkbox is slected, 4 options are available for that row
	 * @return true on success
	 */
	public boolean HeaderHoverDisplay() {
		clickIt(TopLinks.get(1));
		Assert.assertEquals(AllHeaders.size(), 15);
		setNoOfItemsTo100();
		TestUtil.sleep(2000);
		super.addLog("Click on checkbox");
		log.info("Click on checkbox");
		clickIt(MainCheckbox);
		if (HDFourHoverOptionsList.size() == 4)
			return true;
		else
			return false;
	}

	/**
	 * This function gets the values of all the rows for the given column
	 * @param ColumnNumber
	 * @return true on success
	 */
	public List<String> GetListOfAllCurrentRowsForCol(int ColumnNumber) {
		String firstHalf = "//tbody/tr/td[";
		String lastHalf = "]";
		String ColumnItemsXpath = firstHalf + ColumnNumber + lastHalf;
		List<String> tempList = new ArrayList<String>();
		log.info("Get data from table");
		super.addLog("Get data from table");
		List<WebElement> elementsList = driver.findElements(By.xpath(ColumnItemsXpath));
		List<String> originalList = elementsList.stream().map(s -> s.getText().toLowerCase())
				.collect(Collectors.toList());
		boolean b = true;
		if (!LastPageBtn.isEnabled())
			b = false;
		while (b) {
			waitForElementToDisplay(NextPageBtn, 10);
			waitForelementToBeClickable(NextPageBtn, 10);
			super.addLog("Click on next button of pagination");
			log.info("Click on next button of pagination");
			clickIt(NextPageBtn);
			TestUtil.sleep(4000);
			elementsList = driver.findElements(By.xpath(ColumnItemsXpath));
			tempList = elementsList.stream().map(s -> s.getText().toLowerCase()).collect(Collectors.toList());
			originalList.addAll(originalList.size(), tempList);
			if (!LastPageBtn.isEnabled())
				b = false;
		}
		return originalList;
	}

	/**
	 * This function sorts the groups table by the column number given as param
	 * @param c = index of column to sort
	 * @return true on success
	 */
	public boolean SortByGivenColumn(int c) {

		TestUtil.sleep(2000);
		List<String> BeforeSortList = GetListOfAllCurrentRowsForCol(c);
		List<String> AfterSortList = BeforeSortList.stream().sorted().collect(Collectors.toList());
		clickIt(AllHeadersSortingLink.get(c - 2));
		IsSpinningComplete();
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
	 * This function sorts the groups table by the ModifiedDate column number given as param
	 * @param c = index of column to sort
	 * @return true on success
	 */
	public boolean SortByModifiedDateGivenCol(int c) {

		TestUtil.sleep(2000);
		clickIt(AllHeadersSortingLink.get(c - 2));
		TestUtil.sleep(4000);
		List<String> BeforeSortList = GetListOfAllCurrentRowsForCol(c);
		Collections.sort(BeforeSortList, new Comparator<String>() {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");

			@Override
			public int compare(String o1, String o2) {
				try {
					return dateFormat.parse(o1).compareTo(dateFormat.parse(o2));
				} catch (ParseException e) {
					throw new IllegalArgumentException(e);
				}

			}
		});

		TestUtil.sleep(2000);
		List<String> AfterSortListFromWebsite = GetListOfAllCurrentRowsForCol(c);
		super.addLog("Verify that list displayed on screen matches sorted list in program");
		log.info("Verify that list displayed on screen matches sorted list in program");
		System.out.println(BeforeSortList);
		System.out.println(AfterSortListFromWebsite);
		if (BeforeSortList.equals(AfterSortListFromWebsite))
			return true;
		else
			return false;
	}

	/**
	 * This function sorts the groups table by the column number given as param
	 * @param c = index of column to sort
	 * @return true on success
	 */
	public boolean SpSortByGivenColumn(int c) {

		super.addLog("Click on the header link to sort");
		log.info("Click on the header link to sort");
		clickIt(AllHeadersSortingLink.get(c - 2));
		IsSpinningComplete();
		List<String> BeforeSortList = GetListOfAllCurrentRowsForCol(c);
		System.out.println(BeforeSortList);

		Collections.sort(BeforeSortList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {

				if (!(o1.equals("") || o2.equals("") || o1.equals(" ") || o2.equals(" "))) {
					String[] ip1 = o1.split("\\.");
					String ipFormatted1 = String.format("%3s.%3s.%3s.%3s", ip1[0], ip1[1], ip1[2], ip1[3]);
					String[] ip2 = o2.split("\\.");
					String ipFormatted2 = String.format("%3s.%3s.%3s.%3s", ip2[0], ip2[1], ip2[2], ip2[3]);
					return ipFormatted1.compareTo(ipFormatted2);
				} else {
					return 0;
				}
			}
		});
		List<String> AfterSortListFromWebsite = GetListOfAllCurrentRowsForCol(c);
		super.addLog("Verify that list displayed on screen matches sorted list in program");
		log.info("Verify that list displayed on screen matches sorted list in program");
		System.out.println(BeforeSortList);
		System.out.println(AfterSortListFromWebsite);
		if (BeforeSortList.equals(AfterSortListFromWebsite))
			return true;
		else
			return false;
	}

	/**
	 * This function verifies EventsDisplay tab displays correctly
	 * @return
	 */
	public boolean EventsDisplay() {
		clickIt(TopLinks.get(0));
		int n = GetNoOfGroups();
		IsSpinningComplete();
		clickIt(TopLinks.get(3));
		IsSpinningComplete();
		super.addLog("Verify Number of Columns displayed is 5");
		log.info("Verify Number of Columns displayed is 5");
		Assert.assertEquals(AllHeaders.size(), 5);
		super.addLog("Verify if number of rows is zero, 'No Record Found!' is displayed");
		log.info("Verify if number of rows is zero, 'No Record Found!' is displayed");
		if (!TotalNumOfServices.isDisplayed())
			Assert.assertEquals(FirstRow.getText(), "No Record Found!");
		super.addLog("Verify Number of Groups button matches the number on Site Details");
		log.info("Verify Number of Groups button matches the number on Site Details");
		if (SearchBubbleGroupsNames.size() == n + 1)
			return true;
		else
			return false;
	}

	/**
	 * This function verifies SiteHealth tab displays correctly
	 */
	public void SiteHealth() {
		clickIt(TopLinks.get(2));
		super.addLog("Verify Number of Columns displayed is 3");
		log.info("Verify Number of Columns displayed is 3");
		Assert.assertEquals(AllHeaders.size(), 3);
		super.addLog("Verify if number of rows is zero, 'No Record Found!' is displayed");
		log.info("Verify if number of rows is zero, 'No Record Found!' is displayed");
		if (TotalNumOfServices.getText().trim().equals("0 of 0")) {
			Assert.assertEquals(FirstRow.getText(), "No Record Found!");
		}
	}

	/**
	 * This function confirms that checking the checkbox on the top, selects all enabled checkboxes in the Logs table
	 * @return true on success
	 */
	public boolean LogsCheckbox() {
		int i;
		clickIt(TopLinks.get(4));
		Assert.assertEquals(AllHeaders.size(), 7);
		setNoOfItemsTo100();
		TestUtil.sleep(2000);
		super.addLog("Click on top checkbox");
		log.info("Click on top checkbox");
		clickIt(MainCheckbox);
		int n = AllEnabledCheckboxesInput.size();
		for (i = 0; i < n; i++) {
			if (!(AllEnabledCheckboxesInput.get(i).getAttribute("aria-checked").toString().equals("true"))) {
				break;
			}
		}
		super.addLog("Verify that all enabled checkboxes are selected");
		log.info("Verify that all enabled checkboxes are selected");
		if (i == n)
			return true;
		else
			return false;
	}

	/**
	 * This function searches logs by given param
	 * @param j=0 for category, j=1 for MAC address
	 * @return true on success
	 */
	public boolean LogsSearch(int j) {
		boolean b = true;
		String s = null;
		clickIt(TopLinks.get(4));
		Assert.assertEquals(AllHeaders.size(), 7);
		setNoOfItemsTo100();
		TestUtil.sleep(2000);
		if (j == 0) {
			s = AllCategories.get(0).getText();
			super.addLog("Click on search icon and type " + s);
			log.info("Click on search icon and type " + s);
		} else if (j == 1) {
			s = AllMacAddresses.get(0).getText();
			super.addLog("Click on search icon and type " + s);
			log.info("Click on search icon and type " + s);
		}
		waitForVisibilityOf(SearchIcon, 10);
		clickIt(SearchIcon);
		clickIt(SearchInputBox);
		SearchInputBox.sendKeys(s);
		IsSpinningComplete();
		super.addLog("Verify that table displays only rows with " + s);
		log.info("Verify that table displays only rows with " + s);
		if (j == 0) {
			for (int i = 0; i < AllCategories.size(); i++) {
				if (!(AllCategories.get(i).getText().contains(s)))
					b = false;
			}
		} else if (j == 1) {
			for (int i = 0; i < AllMacAddresses.size(); i++) {
				if (!(AllMacAddresses.get(i).getText().contains(s)))
					b = false;
			}
		}
		SearchInputBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		SearchInputBox.sendKeys(Keys.DELETE);
		IsSpinningComplete();
		return b;
	}

	/**
	 * This function verifies that only logs with complete status have download option
	 * @return true on success
	 */
	public boolean CompletedLogsShowDownload() {
		boolean b1 = false;
		boolean b2 = false;
		String rowxpathinit = "//tbody/tr[";
		String rowxpathfin = "]/td[7]/mat-icon";
		clickIt(TopLinks.get(4));
		Assert.assertEquals(AllHeaders.size(), 7);
		setNoOfItemsTo100();
		TestUtil.sleep(2000);
		int n = AllStatuses.size();
		super.addLog("Verify that only logs with complete status have download option");
		log.info("Verify that only logs with complete status have download option");
		for (int i = 0; i < n; i++) {
			if (AllStatuses.get(i).getText().equals("Completed")) {
				int j = i + 1;
				String rowxpath = rowxpathinit + j + rowxpathfin;
				if (driver.findElement(By.xpath(rowxpath)).getText().equals("download")) {
					b1 = true;
					break;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (!AllStatuses.get(i).getText().equals("Completed")) {
				int j = i + 1;
				String rowxpath = rowxpathinit + j + rowxpathfin;
				if (driver.findElements(By.xpath(rowxpath)).size() == 0) {
					b2 = true;
					break;
				}
			}
		}
		if (b1 && b2)
			return true;
		else
			return false;
	}

	/**
	 * This function verifies that download works for logs tab
	 * @return true on success
	 */
	public boolean DownloadLogfile() {
		boolean b = false;
		String rowxpathinit = "//tbody/tr[";
		String rowxpathfin = "]/td[7]/mat-icon";
		clickIt(TopLinks.get(4));
		Assert.assertEquals(AllHeaders.size(), 7);
		setNoOfItemsTo100();
		TestUtil.sleep(2000);
		int n = AllStatuses.size();
		super.addLog("Click on download for first row with status complete");
		log.info("Click on download for first row with status complete");
		for (int i = 0; i < n; i++) {
			if (AllStatuses.get(i).getText().equals("Completed")) {
				int j = i + 1;
				String rowxpath = rowxpathinit + j + rowxpathfin;
				clickIt(driver.findElement(By.xpath(rowxpath)));
				break;
			}
		}
		TestUtil.sleep(5000);
		super.addLog("Verify that file is downloaded");
		log.info("Verify that file is downloaded");
		File file = new File(System.getProperty("user.dir"));
		File ff[] = file.listFiles();
		for (File f : ff) {
			if (f.getName().contains("script_")) {
				String filePath = System.getProperty("user.dir") + "\\" + f.getName();
				File delfile = new File(filePath);
				delfile.delete();
				b = true;
			}
		}
		return b;
	}

	/**
	 * Verifies number of tabs on scriptmanager page
	 */
	public boolean ScriptManager() {
		clickIt(TopLinks.get(5));
		if (ScriptManagerTabs.get(0).getText().contains("Scheduled Scripts")
				&& ScriptManagerTabs.get(1).getText().contains("Scripts"))
			return true;
		else
			return false;
	}

	/**
	 * Verifies number of columns on trace logs page
	 */
	public void TraceLogs() {
		clickIt(TopLinks.get(6));
		super.addLog("Verify Number of Columns displayed is 5");
		log.info("Verify Number of Columns displayed is 5");
		Assert.assertEquals(AllHeaders.size(), 5);

	}

	/**
	 * This function verifies that search works on trace logs page
	 * @param j=0 for MAC address, j=1 for filename
	 * @return true on success
	 */
	public boolean TraceLogsSearch(int j) {
		boolean b = true;
		TestUtil.sleep(2000);
		String s = null;
		clickIt(TopLinks.get(6));
		TestUtil.sleep(2000);
		clickIt(TLPeriodDropDownArrow);
		clickIt(TLPeriodDropDown.get(2));
		TestUtil.sleep(2000);
		super.addLog("Verify Number of Columns displayed is 5");
		log.info("Verify Number of Columns displayed is 5");
		Assert.assertEquals(AllHeaders.size(), 5);
		if (TotalNumOfServices.getText().trim().equals("0 of 0")) {
			super.addLog("No Trace logs present in table for today");
			log.info("No Trace logs present in table for today");
			Assert.assertEquals(FirstRow.getText(), "No Record Found!");
			b = false;
			return b;
		} else {
			if (j == 0) {
				s = AllTLMacAddresses.get(0).getText();
				super.addLog("Click on search icon and type " + s);
				log.info("Click on search icon and type " + s);
			} else if (j == 1) {
				s = AllTLFilenames.get(0).getText();
				super.addLog("Click on search icon and type " + s);
				log.info("Click on search icon and type " + s);
			}
			waitForVisibilityOf(SearchIcon, 10);
			clickIt(SearchIcon);
			clickIt(SearchInputBox);
			SearchInputBox.sendKeys(s);
			TestUtil.sleep(2000);
			super.addLog("Verify that table displays only rows with " + s);
			log.info("Verify that table displays only rows with " + s);
			if (j == 0) {
				for (int i = 0; i < AllTLMacAddresses.size(); i++) {
					if (!(AllTLMacAddresses.get(i).getText().contains(s)))
						b = false;
				}
			} else if (j == 1) {
				for (int i = 0; i < AllTLFilenames.size(); i++) {
					if (!(AllTLFilenames.get(i).getText().contains(s)))
						b = false;
				}
			}
			SearchInputBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			SearchInputBox.sendKeys(Keys.DELETE);
			TestUtil.sleep(2000);
			return b;
		}
	}

	/**
	 * This function view the trace log download for the first row
	 * @return true on success
	 */
	public boolean TraceLogsDownload() {
		boolean b = false;
		clickIt(TopLinks.get(6));
		Assert.assertEquals(AllHeaders.size(), 5);
		clickIt(TLPeriodDropDownArrow);
		clickIt(TLPeriodDropDown.get(2));
		TestUtil.sleep(2000);
		if (TotalNumOfServices.getText().trim().equals("0 of 0")) {
			super.addLog("No Trace logs present in table for today");
			log.info("No Trace logs present in table for today");
			Assert.assertEquals(FirstRow.getText(), "No Record Found!");
			return false;
		} else {
			String filename = AllTLFilenames.get(0).getText();
			super.addLog("Click on download for the first row");
			log.info("Click on download for the first row");
			clickIt(FirstRowTLMatIcons.get(0));
			IsSpinningComplete();
			File file = new File(System.getProperty("user.dir"));
			File ff[] = file.listFiles();
			super.addLog("Verify that file is downloaded: " + filename);
			log.info("Verify that file is downloaded: " + filename);
			for (File f : ff) {
				if (f.getName().contains(filename)) {
					System.out.println(f.getName());
					String filePath = System.getProperty("user.dir") + "\\" + f.getName();
					File delfile = new File(filePath);
					delfile.delete();
					b = true;
				}
			}
			return b;
		}
	}

	/**
	 * This function view the trace log file for the first row
	 * @return true on success
	 */
	public boolean TraceLogsViewFile() {
		clickIt(TopLinks.get(6));
		Assert.assertEquals(AllHeaders.size(), 5);
		clickIt(TLPeriodDropDownArrow);
		clickIt(TLPeriodDropDown.get(2));
		TestUtil.sleep(2000);
		if (TotalNumOfServices.getText().trim().equals("0 of 0")) {
			super.addLog("No Trace logs present in table for today");
			log.info("No Trace logs present in table for today");
			Assert.assertEquals(FirstRow.getText(), "No Record Found!");
			return false;
		} else {
			super.addLog("Click on view for the first row");
			log.info("Click on view for the first row");
			clickIt(FirstRowTLMatIcons.get(1));
			IsSpinningComplete();
			super.addLog("Verify that View File Window is opened");
			log.info("Verify that View File Window is opened");
			if (TLViewFile.getText().contains("View File")) {
				clickIt(TLViewFileClose);
				return true;
			} else
				return false;
		}
	}

	/**
	 * This function displays trace logs for today
	 * @return true on success
	 */
	public boolean TraceLogsToday() {
		boolean b = true;
		clickIt(TopLinks.get(6));
		clickIt(TLPeriodDropDownArrow);
		clickIt(TLPeriodDropDown.get(0));
		TestUtil.sleep(2000);
		Assert.assertEquals(AllHeaders.size(), 5);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		String s = sdf.format(Calendar.getInstance().getTime());
		super.addLog("Verify all logs have upload date as today's date");
		log.info("Verify all logs have upload date as today's date");
		if (TotalNumOfServices.getText().trim().equals("0 of 0")) {
			super.addLog("No Trace logs present in table for today");
			log.info("No Trace logs present in table for today");
			Assert.assertEquals(FirstRow.getText(), "No Record Found!");
			return b;
		} else {
			setNoOfItemsTo100();
			while (NextPageBtn.isEnabled()) {
				
				for (int i = 0; i < AllTLUploadDates.size(); i++) {
					if (!(AllTLUploadDates.get(i).getText().split(" ")[0].trim().equals(s)))
						b = false;
				}
				super.addLog("Click on next button of pagination");
				log.info("Click on next button of pagination");
				clickIt(NextPageBtn);
				TestUtil.sleep(3000);
			}
			super.addLog("Click on first page button of pagination");
			log.info("Click on first page button of pagination");
			clickIt(FirstPageBtn);
			return b;
		}
	}

	/**
	 * This function displays trace logs for given number of days
	 * @param x=3 or 7
	 * @return true on success
	 */
	public boolean TraceLogsLastXDays(int x) {

		boolean b = true;
		clickIt(TopLinks.get(6));
		Assert.assertEquals(AllHeaders.size(), 5);
		
		TestUtil.sleep(2000);
		setNoOfItemsTo100();
		TestUtil.sleep(2000);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -x);
		String s = sdf.format(cal.getTime());
		clickIt(TLPeriodDropDownArrow);
		if (x == 3) {
			super.addLog("Select last 3 days from dropdown");
			log.info("Select last 3 days from dropdown");
			clickIt(TLPeriodDropDown.get(1));
		} else if (x == 7) {
			super.addLog("Select last 7 days from dropdown");
			log.info("Select last 7 days from dropdown");
			clickIt(TLPeriodDropDown.get(2));
		}
		TestUtil.sleep(2000);
		if (TotalNumOfServices.getText().trim().equals("0 of 0")) {
			super.addLog("No Trace logs present in table for today");
			log.info("No Trace logs present in table for today");
			Assert.assertEquals(FirstRow.getText(), "No Record Found!");
			b = false;
			return b;
		} else {
			super.addLog("Verify all logs have upload date as any date in the last " + x + " days");
			log.info("Verify all logs have upload date as any date in the last " + x + " days");
			while (NextPageBtn.isEnabled()) {
				
				for (int i = 0; i < AllTLUploadDates.size(); i++) {
					try {
						Date adate = sdf.parse(s);
						Date cdate = sdf.parse(AllTLUploadDates.get(i).getText().split(" ")[0].trim());
						if (!(adate.compareTo(cdate) <= 0))
							b = false;
	
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				super.addLog("Click on next button of pagination");
				log.info("Click on next button of pagination");
				clickIt(NextPageBtn);
				TestUtil.sleep(3000);
			}
			return b;
		}

	}

	/**
	 * This function verifies that number of groups for Mapped Content page
	 * @return true on success
	 */
	public boolean MappedContent() {
		clickIt(TopLinks.get(0));
		int n = GetNoOfGroups();
		IsSpinningComplete();
		clickIt(TopLinks.get(7));
		super.addLog("Verify Number of Columns displayed is 7");
		log.info("Verify Number of Columns displayed is 7");
		Assert.assertEquals(AllHeaders.size(), 7);
		if (SearchBubbleGroupsNames.size() == n + 1)
			return true;
		else
			return false;
	}

	/**
	 * This function verifies that refresh works for Mapped Content page
	 * @return true on success
	 */
	public boolean MappedContentRefresh() {
		clickIt(TopLinks.get(7));
		super.addLog("Verify Number of Columns displayed is 7");
		log.info("Verify Number of Columns displayed is 7");
		Assert.assertEquals(AllHeaders.size(), 7);
		TestUtil.sleep(2000);
		int n = AllRows.size();
		clickIt(AllMCLinks.get(0));
		IsSpinningComplete();
		super.addLog("Verify Refresh functionality");
		log.info("Verify Refresh functionality");
		if (AllRows.size() == n)
			return true;
		else
			return false;
	}

	/**
	 * This function verfies that search work on Mapped content page
	 * @param j=0 for MAC address, j=1 for IP address
	 * @return true on success
	 */
	public boolean MappedContentSearch(int j) {
		boolean b = true;
		String s = null;
		clickIt(TopLinks.get(7));
		TestUtil.sleep(2000);
		super.addLog("Verify Number of Columns displayed is 7");
		log.info("Verify Number of Columns displayed is 7");
		Assert.assertEquals(AllHeaders.size(), 7);
		if (j == 0) {
			s = AllMCMacAddresses.get(0).getText();
			super.addLog("Click on search icon and type " + s);
			log.info("Click on search icon and type " + s);
		} else if (j == 1) {
			s = AllMCIPAddresses.get(0).getText();
			super.addLog("Click on search icon and type " + s);
			log.info("Click on search icon and type " + s);
		}
		waitForVisibilityOf(SearchIcon, 10);
		clickIt(SearchIcon);
		clickIt(SearchInputBox);
		SearchInputBox.sendKeys(s);
		IsSpinningComplete();
		super.addLog("Verify that table displays only rows with " + s);
		log.info("Verify that table displays only rows with " + s);
		if (j == 0) {
			for (int i = 0; i < AllMCMacAddresses.size(); i++) {
				if (!(AllMCMacAddresses.get(i).getText().contains(s)))
					b = false;
			}
		} else if (j == 1) {
			for (int i = 0; i < AllMCIPAddresses.size(); i++) {
				if (!(AllMCIPAddresses.get(i).getText().contains(s)))
					b = false;
			}
		}

		SearchInputBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		SearchInputBox.sendKeys(Keys.DELETE);
		IsSpinningComplete();
		return b;
	}

	/**
	 * This function verifies that View file works in Mapped Content page for the first row
	 * @return true on success
	 */
	public boolean MappedContentViewFile() {
		clickIt(TopLinks.get(7));
		TestUtil.sleep(2000);
		super.addLog("Verify Number of Columns displayed is 7");
		log.info("Verify Number of Columns displayed is 7");
		Assert.assertEquals(AllHeaders.size(), 7);
		clickIt(AllMCActions.get(0));
		IsSpinningComplete();
		super.addLog("Verify that View File Window is opened");
		log.info("Verify that View File Window is opened");
		TestUtil.sleep(3000);
		if (TLViewFile.getText().contains("View Package Manifest")){
			TestUtil.sleep(2000);
			clickIt(CombinedScroll);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.querySelector(\"div[class='row mt-1 ng-star-inserted'] div:nth-child(1) div:nth-child(2)\").scrollTop=1000");
			
			if (AllMCViewWinNames.get(0).getText().equals("Device Manifest")
					&& AllMCViewWinNames.get(1).getText().equals("CMS Manifest") && CombinedScroll.isDisplayed()) {
				clickIt(TLViewFileClose);
				return true;
			}else
				return false;
		}else {
			log.info(SiteSelectionMsg.getText());
			super.addLog(SiteSelectionMsg.getText());
			return false;
		}
	}

	/**
	 * This function verifies that search by Group name works in Mapped Content page for the groupname of first row
	 * @return true on success
	 */
	public boolean MappedContentSearchbyGroup() {
		boolean b = true;
		clickIt(TopLinks.get(7));
		TestUtil.sleep(2000);
		super.addLog("Verify Number of Columns displayed is 7");
		log.info("Verify Number of Columns displayed is 7");
		Assert.assertEquals(AllHeaders.size(), 7);
		String groupName = AllMCGroups.get(0).getText();
		super.addLog("Search for the category with row 1 group name");
		log.info("Search for the category with row 1 group name");
		for (int i = 1; i < SearchBubbleGroupsNames.size(); i++) {
			if (groupName.equals(SearchBubbleGroupsNames.get(i).getText())) {
				clickIt(SearchBubbleGroupsNames.get(i));
				IsSpinningComplete();
				break;
			}
		}
		super.addLog("Verify all group names are the same as category selected");
		log.info("Verify all group names are the same as category selected");
		for (int j = 0; j < AllMCGroups.size(); j++) {
			if (!AllMCGroups.get(j).getText().equals(groupName)) {
				b = false;
				break;
			}

		}
		return b;
	}

	/**
	 * This function verifies that create new script for scheduled script
	 * @return true on success
	 */
	public void SMCreateNewScript() {
		
		String newscript = null;
		newscript = prop.getProperty("scheduledscriptname");
		TestUtil.sleep(2000);
		clickIt(TopLinks.get(5));

		super.addLog("Enter all details for new script");
		log.info("Enter all details for new script");

		clickIt(NewScriptLink);
		TestUtil.sleep(2000);
		ScriptName.sendKeys(newscript);
		clickIt(AllDropDownArrows.get(7));

		clickIt(RepeatOptions.get(1));
		ScriptDetails.sendKeys("echo");

		super.addLog("Click Add & Schedule Button");
		log.info("Click Add & Schedule Button");

		clickIt(AddScheduleButton);
		TestUtil.sleep(2000);

		super.addLog("Verify that alert message about Script has been added & triggered successfully is displayed");
		log.info("Verify that alert message about Script has been added & triggered successfully is displayed");

		softAssert.assertTrue(ScriptInfoMsg.getText().equals("Script has been added & triggered successfully."), "Alert message not displayed");
		
		clickIt(MatExpanders.get(0));
		TestUtil.sleep(2000);
		String tablexpath = "//table[contains(@class,'scheduled-list')]//tbody//tr[";
		String t = TotalNumOfRows.get(0).getText();
		int n = Integer.parseInt(t.split("of")[1].trim());

		super.addLog("Verify that script name is present in scheduled script table");
		log.info("Verify that script name is present in scheduled script table");
		String newscriptname = tablexpath + n + "]/td[3]";
		softAssert.assertTrue(driver.findElement(By.xpath(newscriptname)).getText().equals(newscript), "script name not displayed");
		
		super.addLog("Verify that brand name is present in scheduled script table");
		log.info("Verify that brand name is present in scheduled script table");
		String expectedBrand = prop.getProperty("brand");
		String brand = tablexpath + n + "]/td[5]//mat-chip";
		softAssert.assertTrue(driver.findElement(By.xpath(brand)).getText().equals(expectedBrand), "brand name not displayed");
			

		super.addLog("Verify that franchise name is present in scheduled script table");
		log.info("Verify that franchise name is present in scheduled script table");
		String expectedFranchise = prop.getProperty("franchise") + " (" + prop.getProperty("brand") + ")";
		String franchise = tablexpath + n + "]/td[6]//mat-chip";
		softAssert.assertTrue(driver.findElement(By.xpath(franchise)).getText().equals(expectedFranchise), "franchise name not displayed");
			

		super.addLog("Verify that site name is present in scheduled script table");
		log.info("Verify that site name is present in scheduled script table");
		String expectedSite = prop.getProperty("store") + " (" + prop.getProperty("franchise") + ")";
		String site = tablexpath + n + "]/td[7]//mat-chip";
		softAssert.assertTrue(driver.findElement(By.xpath(site)).getText().equals(expectedSite), "site name not displayed");
			
		clickIt(MatExpanders.get(0));
		softAssert.assertAll();
	}

	/**
	 * This function verifies that view works for scheduled script
	 * @return true on success
	 */
	public boolean SMViewScheduledScript() {
		int h = 0;
		String newscript = prop.getProperty("scheduledscriptname");
		clickIt(TopLinks.get(5));
		TestUtil.sleep(2000);
		clickIt(MatExpanders.get(0));
		TestUtil.sleep(2000);
		for (int i = 0; i < AllScriptNames.size(); i++) {
			if (AllScriptNames.get(i).getText().equals(newscript)) {
				h = i + 1;
			}
		}
		String initXpath = "//tbody/tr[";
		String lastXpath = "]/td[10]/mat-icon";
		String finalXpath = initXpath + h + lastXpath;
		clickIt(driver.findElement(By.xpath(finalXpath)));
		super.addLog("Click on View for created script");
		log.info("Click on View for created script");
		clickIt(ScriptActions.get(0));
		super.addLog("Verify that the script name is in the heading");
		log.info("Verify that the script name is in the heading");
		softAssert.assertTrue(ViewScriptHeading.getText().equals(newscript));
		super.addLog("Verify Delete button is displayed on Script view window");
		log.info("Verify Delete button is displayed on Script view window");
		softAssert.assertTrue(ViewScriptDelete.isDisplayed());
		super.addLog("Verify Bookmark button is displayed on Script view window");
		log.info("Verify Bookmark button is displayed on Script view window");
		softAssert.assertTrue(ViewScriptBookmark.isDisplayed());
		super.addLog("Verify Stop Occurence button is displayed on Script view window");
		log.info("Verify Stop Occurence button is displayed on Script view window");
		softAssert.assertTrue(ViewScriptOccurenceBtn.isDisplayed());
		softAssert.assertAll();
		if (ViewScriptHeading.getText().equals(newscript) && ViewScriptDelete.isDisplayed()
				&& ViewScriptBookmark.isDisplayed() && ViewScriptOccurenceBtn.isDisplayed()) {
			
			clickIt(ViewScriptClose);
			return true;
		} else {
			clickIt(ViewScriptClose);
			return false;
		}
	}

	/**
	 * This function verifies that stop and start occurence works for scheduled script
	 * @return true on success
	 */
	public boolean SMStopStartOccurence() {
		int h = 0;
		String newscript = prop.getProperty("scheduledscriptname");
		clickIt(TopLinks.get(5));
		TestUtil.sleep(2000);
		for (int i = 0; i < AllScriptNames.size(); i++) {
			if (AllScriptNames.get(i).getText().equals(newscript)) {
				h = i + 1;
			}
		}
		String initXpath = "//tbody/tr[";
		String lastXpath = "]/td[9]/mat-icon";
		String finalXpath = initXpath + h + lastXpath;
		super.addLog("Click on Stop Occurence for created script");
		log.info("Click on Stop Occurence for created script");
		TestUtil.sleep(4000);
		clickIt(driver.findElement(By.xpath(finalXpath)));
		clickIt(ViewScriptOccurenceBtn);
		String ForStop = ScriptInfoMsg.getText();
		String ForStopExpected = newscript + " has been stopped";
		TestUtil.sleep(8000);
		super.addLog("Click on Start Occurence for created script");
		log.info("Click on Start Occurence for created script");
		clickIt(driver.findElement(By.xpath(finalXpath)));
		clickIt(ViewScriptOccurenceBtn);
		String ForStart = ScriptInfoMsg.getText();
		String ForStartExpected = newscript + " has been started";
		super.addLog("Verify alert messages about start and stop");
		log.info("Verify alert messages about start and stop");
		System.out.println(ForStop);
		System.out.println(ForStart);
		if (ForStop.equals(ForStopExpected) && ForStart.equals(ForStartExpected))
			return true;
		else
			return false;
	}

	/**
	 * This function verifies that download works for scheduled script
	 * @return true on success
	 */
	public boolean SMDownloadScheduledScript() {
		int h = 0;
		boolean b = false;
		String newscript = prop.getProperty("scheduledscriptname");
		clickIt(TopLinks.get(5));
		TestUtil.sleep(2000);
		for (int i = 0; i < AllScriptNames.size(); i++) {
			if (AllScriptNames.get(i).getText().equals(newscript)) {
				h = i + 1;
			}

		}
		String initXpath = "//tbody/tr[";
		String lastXpath = "]/td[10]/mat-icon";
		String finalXpath = initXpath + h + lastXpath;
		super.addLog("Click on Download for created script");
		log.info("Click on Download for created script");
		clickIt(driver.findElement(By.xpath(finalXpath)));

		clickIt(ScriptActions.get(1));
		TestUtil.sleep(4000);
		File file = new File(System.getProperty("user.dir"));
		File ff[] = file.listFiles();
		super.addLog("Verify that file is downloaded");
		log.info("Verify that file is downloaded");
		for (File f : ff) {
			if (f.getName().contains(newscript)) {
				String filePath = System.getProperty("user.dir") + "\\" + f.getName();
				File delfile = new File(filePath);
				delfile.delete();
				b = true;
			}
		}
		return b;
	}

	/**
	 * This function verifies that delete works for scheduled script
	 * @return true on success
	 */
	public boolean SMDeleteScheduledScript() {
		int h = 0;
		String newscript = prop.getProperty("scheduledscriptname");
		clickIt(TopLinks.get(5));
		TestUtil.sleep(2000);
		for (int i = 0; i < AllScriptNames.size(); i++) {
			if (AllScriptNames.get(i).getText().equals(newscript)) {
				h = i + 1;
			}

		}
		String initXpath = "//tbody/tr[";
		String lastXpath = "]/td[10]/mat-icon";
		String finalXpath = initXpath + h + lastXpath;
		super.addLog("Click on Delete for created script");
		log.info("Click on Delete for created script");
		String ForDeleteExpected = newscript + " has been deleted";
		clickIt(driver.findElement(By.xpath(finalXpath)));

		clickIt(ScriptActions.get(2));
		clickIt(ViewScriptOccurenceBtn);
		super.addLog("Verify that alert message about file deletion is shown");
		log.info("Verify that alert message about file deletion is shown");
		if (ScriptInfoMsg.getText().equals(ForDeleteExpected))
			return true;
		else
			return false;
	}

	/**
	 * This function verifies that create new non-scheduled script works
	 * @return true on success
	 */
	public void SMCreateNewNonScheduledScript() {
		
		String newscript = prop.getProperty("scriptname");
		waitForelementToBeClickable(TopLinks.get(0), 10);
		clickIt(TopLinks.get(0));
		TestUtil.sleep(2000);
		clickIt(TopLinks.get(5));
		clickIt(MatExpanders.get(1));

		super.addLog("Enter all details for new script");
		log.info("Enter all details for new script");

		clickIt(NewScriptLink);
		TestUtil.sleep(2000);
		ScriptName.sendKeys(newscript);
		ScriptDetails.sendKeys("echo");

		super.addLog("Click Add Button");
		log.info("Click Add Button");
		TestUtil.sleep(2000);
		clickIt(AddScheduleButton);
		TestUtil.sleep(2000);

		super.addLog("Verify that alert message about Script has been added is displayed");
		log.info("Verify that alert message about Script has been added is displayed");
		softAssert.assertTrue(ScriptInfoMsg.getText().equals("Script added"),"Alert messsage not displayed");
		
		super.addLog("Verify that script name is present in schduled script table");
		log.info("Verify that script name is present in schduled script table");
		String newscriptname = "//table[contains(@class,'script-list')]//tbody//tr[1]/td[3]";
		softAssert.assertTrue(driver.findElement(By.xpath(newscriptname)).getText().equals(newscript),"script name not present");
		softAssert.assertAll();

	}

	/**
	 * This function verifies that search works for non-scheduled script
	 * @return true on success
	 */
	public boolean SMSearchScript() {
		boolean b = true;
		TestUtil.sleep(2000);
		String s = prop.getProperty("scriptname");
		waitForVisibilityOf(SearchIcon, 10);
		clickIt(SearchIcon);
		clickIt(SearchInputBox);
		SearchInputBox.sendKeys(s);
		TestUtil.sleep(4000);
		super.addLog("Verify that table displays only rows with " + s);
		log.info("Verify that table displays only rows with " + s);
		for (int i = 0; i < AllNonScheduledScriptNames.size(); i++) {
			if (!(AllNonScheduledScriptNames.get(i).getText().contains(s)))
				b = false;
		}
		return b;
	}

	/**
	 * This function verifies that delete works for non-scheduled script
	 * @return true on success
	 */
	public boolean SMDeleteScript() {

		TestUtil.sleep(4000);
		clickIt(TopLinks.get(5));
		TestUtil.sleep(2000);
		clickIt(MatExpanders.get(1));
		TestUtil.sleep(2000);
		clickIt(DeleteScriptBtn);
		clickIt(DeleteScriptAlertBtn);
		String ForDeleteExpected = "Deletion completed successfully";
		super.addLog("Verify that alert message about file deletion is shown");
		log.info("Verify that alert message about file deletion is shown");
		if (ScriptInfoMsg.getText().equals(ForDeleteExpected)) {
			return true;
		} else
			return false;
	}

	/**
	 * This function verifies that download works for non-scheduled script
	 * @return true on success
	 */
	public boolean SMDownloadScript() {
		boolean b = false;
		String newscript = prop.getProperty("scriptname");
		clickIt(DownloadScriptBtn);
		TestUtil.sleep(4000);
		File file = new File(System.getProperty("user.dir"));
		File ff[] = file.listFiles();
		super.addLog("Verify that file is downloaded");
		log.info("Verify that file is downloaded");
		for (File f : ff) {
			if (f.getName().contains(newscript)) {
				String filePath = System.getProperty("user.dir") + "\\" + f.getName();
				File delfile = new File(filePath);
				delfile.delete();
				b = true;
			}
		}
		return b;
	}

	/**
	 * This function cleans up the script from scheduled scripts list after all functions are run on it
	 */
	public void SMCleanup(String s) {

		TestUtil.sleep(2000);
		clickIt(MatExpanders.get(0));
		TestUtil.sleep(2000);
		waitForVisibilityOf(SearchIcon, 10);
		clickIt(SearchIcon);
		SearchInputBox.sendKeys(s);
		TestUtil.sleep(3000);
		for (int i = 0; i < AllScriptNames.size(); i++) {
			if ((AllScriptNames.get(i).getText().contains(s))) {
				clickIt(driver.findElement(By.xpath("//tbody/tr[1]/td[10]/mat-icon")));
				clickIt(ScriptActions.get(2));
				clickIt(ViewScriptOccurenceBtn);
				TestUtil.sleep(2000);
				clickIt(SearchInputBox);
				SearchInputBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				SearchInputBox.sendKeys(Keys.DELETE);
				TestUtil.sleep(2000);
				break;
			}
		}
	}

	/**
	 * This function cleans up the script from non-scheduled scripts list after all functions are run on it
	 */
	public void SMCleanup2(String s) {
		TestUtil.sleep(4000);
		clickIt(MatExpanders.get(1));
		TestUtil.sleep(2000);
		waitForVisibilityOf(SearchIcon, 10);
		clickIt(SearchIcon);
		SearchInputBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		SearchInputBox.sendKeys(Keys.DELETE);
		TestUtil.sleep(2000);
		SearchInputBox.sendKeys(s);
		TestUtil.sleep(4000);
		for (int i = 0; i < AllNonScheduledScriptNames.size(); i++) {
			if ((AllNonScheduledScriptNames.get(i).getText().contains(s))) {
				clickIt(DeleteScriptBtn);
				clickIt(DeleteScriptAlertBtn);
				IsSpinningComplete();
				clickIt(SearchInputBox);
				SearchInputBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
				SearchInputBox.sendKeys(Keys.DELETE);
				TestUtil.sleep(2000);
				break;
			}
		}
	}

	/**
	 * This function gives 'Test' as script name in new script window and confirms that error message appears
	 * @return true on success
	 */
	public boolean DuplicateSScriptName() {
		clickIt(TopLinks.get(5));
		TestUtil.sleep(2000);
		String newscript = "Test";
		super.addLog("Enter Test as script name");
		log.info("Enter Test as script name");
		clickIt(NewScriptLink);
		TestUtil.sleep(2000);
		ScriptName.sendKeys(newscript);
		clickIt(driver.findElement(By.xpath("//app-script-info")));
		if (DuplicateScriptError.getText().equals("Script Name is already taken. Please choose another"))
			return true;
		else
			return false;
	}

	/**
	 * This function clicks on Upload File checkbox on new script window and confirms that upload logo shows up
	 * @return true on success
	 */
	public boolean UploadLogo() {
		super.addLog("Click upload file checkbox");
		log.info("Click upload file checkbox");
		clickIt(UploadFileChkBox);
		TestUtil.sleep(2000);
		if (UploadImage.isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * This function creates a scheduled script with name deletescript from config.properties file.
	 * then it tries to delete script from non-schdeuled scripts and verifies that error shows up
	 * 'Please delete the schedules before deleting this script.'
	 * @return true on success
	 */
	public boolean ScriptDeletionSequence() {
		clickIt(TopLinks.get(0));
		String s = prop.getProperty("deletescript");
		TestUtil.sleep(2000);
		clickIt(TopLinks.get(5));
		super.addLog("Enter all details for new script");
		log.info("Enter all details for new script");
		TestUtil.sleep(2000);
		clickIt(NewScriptLink);
		TestUtil.sleep(2000);
		ScriptName.sendKeys(s);
		clickIt(AllDropDownArrows.get(7));
		clickIt(RepeatOptions.get(1));
		ScriptDetails.sendKeys("echo");
		super.addLog("Click Add & Schedule Button");
		log.info("Click Add & Schedule Button");
		clickIt(AddScheduleButton);
		TestUtil.sleep(4000);
		clickIt(MatExpanders.get(1));
		TestUtil.sleep(2000);
		waitForVisibilityOf(SearchIcon, 10);
		super.addLog("Search for just added script in the second table of non schduled scripts");
		log.info("Search for just added script in the second table of non schduled scripts");
		clickIt(SearchIcon);
		clickIt(SearchInputBox);
		SearchInputBox.sendKeys(s);
		TestUtil.sleep(4000);
		for (int i = 0; i < AllNonScheduledScriptNames.size(); i++) {
			if ((AllNonScheduledScriptNames.get(i).getText().contains(s))) {
				break;
			}
		}
		super.addLog("Click on Delete button");
		log.info("Click on Delete button");
		clickIt(DeleteScriptBtn);
		clickIt(DeleteScriptAlertBtn);
		super.addLog("Verify that the message 'Please delete the schedules before deleting this script.' appears");
		log.info("Verify that the message 'Please delete the schedules before deleting this script.' appears");
		if (ScriptInfoMsg.getText().equals("Please delete the schedules before deleting this script."))
			return true;
		else
			return false;
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
	 * This function does CaptureScreenshot for an online device and polls the activity page until the CaptureScreenshot shows complete
	 *  and also verifies entry on logs page
	 * @return true on success
	 */
	public boolean CaptureScreenshot_LogsAndActivities() {
		int j = 0;
		boolean b1 = false;
		boolean b2 = false;
		boolean b3 = false;
		boolean b4 = false;
		String GroupName, MACAddress, IPAddress;
		TestUtil.sleep(2000);
		clickIt(TopLinks.get(1));
		Assert.assertEquals(AllHeaders.size(), 15);
		setNoOfItemsTo100();
		TestUtil.sleep(2000);
		clickIt(GroupsOnlineOfflineLinks.get(0));
		TestUtil.sleep(2000);
		super.addLog("Hover over the last column of the first row with checkbox enabled in the table");
		log.info("Hover over the last column of the first row with checkbox enabled in the table");
		for (int i = 0; i < AllCheckboxesSpan.size(); i++) {
			if (AllCheckboxesInput.get(i).getAttribute("tabindex").toString().equals("0")) {
				clickIt(AllCheckboxesSpan.get(i));
				j = i;
				break;
			}
		}
		Actions act = new Actions(driver);
		super.addLog("Click on Capture screenshot");
		log.info("Click on Capture screenshot");
		GroupName = AllGroupNames.get(j).getText();
		MACAddress = AllMCActions.get(j).getText();
		IPAddress = AllIPaddresses.get(j).getText();
		act.moveToElement(AllGoLiveDates.get(j)).perform();
		clickIt(FourHoverOptionsList.get(0));
		TestUtil.sleep(2000);
		if (BoldActionBtn.isDisplayed()
				&& HoverAlertMsg.getText().contains("Are you sure you want to capture the screenshot?")) {
			waitForElementToDisplay(HoverScreenShotBtn, 10);
			clickIt(HoverScreenShotBtn);
		}
		TestUtil.sleep(2000);
		super.addLog("Verify that 'Screenshot command has been triggered successfully.' message appears ");
		log.info("Verify that 'Screenshot command has been triggered successfully.' message appears ");

		if (ScriptInfoMsg.getText().equals("Screenshot command has been triggered successfully.")) {
			super.addLog(
					"Click on Logs tab and verify that first row contains details about screenshot taken in groups tab with status pending");
			log.info(
					"Click on Logs tab and verify that first row contains details about screenshot taken in groups tab with status pending");
			clickIt(TopLinks.get(4));
			Assert.assertEquals(AllHeaders.size(), 7);
			if (AllCategories.get(0).getText().equals("Capture Screenshot")
					&& (AllMacAddresses.get(0).getText().equals(MACAddress))
					&& (AllStatuses.get(0).getText().equals("Pending")))
				b1 = true;
			TestUtil.sleep(2000);
			super.addLog(
					"Click on Activity link and verify that first row contains details about screenshot taken in groups tab");
			log.info(
					"Click on Activity link and verify that first row contains details about screenshot taken in groups tab");
			clickIt(ActivityLink);
			TestUtil.sleep(2000);
			if (AllGroupNames.get(0).getText().equals(GroupName)
					&& (AllMacAddresses.get(0).getText().equals(MACAddress))
					&& (AllActivityStatuses.get(0).getText().equals("Pending"))
					&& (AllCategories.get(0).getText().equals(IPAddress)))
				b2 = true;
		
			super.addLog("Keep polling until the current capture screenshot shows complete status in Activity tab");
			log.info("Keep polling until the current capture screenshot shows complete status in Activity tab");
	
			if (b1 && b2) {
	
				for (int i = 0; i < 20; i++) {
					for (int k = 0; k < ActivityColumn6.size(); k++) {
						if (ActivityColumn8.get(k).getText().equals("Capture Screenshot")) {
							j = k;
							break;
						}
					}
					if (AllActivityStatuses.get(j).getText().equals("Completed")) {
						b3 = true;
						clickIt(BackArrow);
						break;
					} else {
						super.addLog("Wait for 30 seconds");
						log.info("Wait for 30 seconds");
						TestUtil.sleep(30000);
						clickIt(BackArrow);
						TestUtil.sleep(2000);
						clickIt(ActivityLink);
						TestUtil.sleep(2000);
					}
				}
			}
			super.addLog("Validate that the current capture screenshot shows complete status in Logs tab");
			log.info("Validate that the current capture screenshot shows complete status in Logs tab");
	
			if (b3) {
				TestUtil.sleep(2000);
				clickIt(TopLinks.get(4));
				Assert.assertEquals(AllHeaders.size(), 7);
				for (int k = 0; k < ActivityColumn3.size(); k++) {
					if (ActivityColumn3.get(k).getText().equals("Capture Screenshot")) {
						j = k;
						break;
					}
				}
				if (AllStatuses.get(j).getText().equals("Completed"))
					b4 = true;
			}
		}else {
			log.info(ScriptInfoMsg.getText());
			super.addLog(ScriptInfoMsg.getText());
		}
		return b4;

	}

	/**
	 * This function does PullManifest for an online device and polls the activity page until the PullManifest shows complete
	 *  and also verifies entry on logs page
	 * @return true on success
	 */
	public boolean PullManifest_LogsAndActivities() {
		int j = 0;
		boolean b1 = false;
		boolean b2 = false;
		boolean b3 = false;
		boolean b4 = false;
		String GroupName, MACAddress, IPAddress;
		TestUtil.sleep(2000);
		clickIt(TopLinks.get(1));
		Assert.assertEquals(AllHeaders.size(), 15);
		setNoOfItemsTo100();
		TestUtil.sleep(2000);
		clickIt(GroupsOnlineOfflineLinks.get(0));
		TestUtil.sleep(2000);
		super.addLog("Hover over the last column of the first row with checkbox enabled in the table");
		log.info("Hover over the last column of the first row with checkbox enabled in the table");
		for (int i = 0; i < AllCheckboxesSpan.size(); i++) {
			if (AllCheckboxesInput.get(i).getAttribute("tabindex").toString().equals("0")) {
				clickIt(AllCheckboxesSpan.get(i));
				j = i;
				break;
			}
		}
		Actions act = new Actions(driver);
		super.addLog("Click on Pull Manifest");
		log.info("Click on Pull Manifest");
		GroupName = AllGroupNames.get(j).getText();
		MACAddress = AllMCActions.get(j).getText();
		IPAddress = AllIPaddresses.get(j).getText();
		act.moveToElement(AllGoLiveDates.get(j)).perform();
		clickIt(FourHoverOptionsList.get(1));
		TestUtil.sleep(2000);
		if (BoldActionBtn.isDisplayed() && HoverAlertMsg.getText()
				.contains("Are you sure you want to pull the package manifest from the device(s)?")) {
			waitForElementToDisplay(HoverPullManifestBtn, 10);
			clickIt(HoverPullManifestBtn);
		}
		TestUtil.sleep(2000);
		super.addLog("Verify that 'Pull Manifest command has been triggered successfully.' message appears");
		log.info("Verify that 'Pull Manifest command has been triggered successfully.' message appears ");

		if (ScriptInfoMsg.getText().equals("Pull Manifest command has been triggered successfully.")) {
			super.addLog(
					"Click on Logs tab and verify that first row contains details about Pull Manifest taken in groups tab with status pending");
			log.info(
					"Click on Logs tab and verify that first row contains details about Pull Manifest taken in groups tab with status pending");
			clickIt(TopLinks.get(4));
			Assert.assertEquals(AllHeaders.size(), 7);
			if (AllCategories.get(0).getText().equals("Upload Device Package Manifest")
					&& (AllMacAddresses.get(0).getText().equals(MACAddress))
					&& (AllStatuses.get(0).getText().equals("Pending")))
				b1 = true;
			TestUtil.sleep(2000);
			super.addLog(
					"Click on Activity link and verify that first row contains details about Pull Manifest taken in groups tab");
			log.info(
					"Click on Activity link and verify that first row contains details about Pull Manifest taken in groups tab");
			clickIt(ActivityLink);
			TestUtil.sleep(2000);
			if (AllGroupNames.get(0).getText().equals(GroupName)
					&& (AllMacAddresses.get(0).getText().equals(MACAddress))
					&& (AllActivityStatuses.get(0).getText().equals("Pending"))
					&& (AllCategories.get(0).getText().equals(IPAddress)))
				b2 = true;
		
			super.addLog("Keep polling until Upload Device Package Manifest shows complete status in Activity tab");
			log.info("Keep polling until Upload Device Package Manifest shows complete status in Activity tab");
	
			if (b1 && b2) {
				for (int i = 0; i < 20; i++) {
					for (int k = 0; k < ActivityColumn6.size(); k++) {
						if (ActivityColumn8.get(k).getText().equals("Upload Device Package Manifest")) {
							j = k;
							break;
						}
					}
					if (AllActivityStatuses.get(j).getText().equals("Completed")) {
						b3 = true;
						clickIt(BackArrow);
						break;
					} else {
						super.addLog("Wait for 30 seconds");
						log.info("Wait for 30 seconds");
						TestUtil.sleep(30000);
						clickIt(BackArrow);
						TestUtil.sleep(2000);
						clickIt(ActivityLink);
						TestUtil.sleep(2000);
					}
				}
			}
			super.addLog("Validate that Upload Device Package Manifest shows complete status in Logs tab");
			log.info("Validate that Upload Device Package Manifest shows complete status in Logs tab");
	
			if (b3) {
				TestUtil.sleep(2000);
				clickIt(TopLinks.get(4));
				Assert.assertEquals(AllHeaders.size(), 7);
				for (int k = 0; k < ActivityColumn3.size(); k++) {
					if (ActivityColumn3.get(k).getText().equals("Upload Device Package Manifest")) {
						j = k;
						break;
					}
				}
				if (AllStatuses.get(j).getText().equals("Completed"))
					b4 = true;
				}
		}else {
			log.info(ScriptInfoMsg.getText());
			super.addLog(ScriptInfoMsg.getText());
		}
		return b4;
	}

	/**
	 * This function does Reboot for an online device and polls the activity page until the Reboot shows complete
	 *  and also verifies entry on logs page
	 * @return true on success
	 */
	public boolean Reboot_LogsAndActivities() {
		int j = 0;
		boolean b1 = false;
		boolean b2 = false;
		boolean b3 = false;
		boolean b4 = false;
		String GroupName, MACAddress, IPAddress;
		TestUtil.sleep(2000);
		clickIt(TopLinks.get(1));
		Assert.assertEquals(AllHeaders.size(), 15);
		setNoOfItemsTo100();
		TestUtil.sleep(2000);
		clickIt(GroupsOnlineOfflineLinks.get(0));
		TestUtil.sleep(2000);
		super.addLog("Hover over the last column of the first row with checkbox enabled in the table");
		log.info("Hover over the last column of the first row with checkbox enabled in the table");
		for (int i = 0; i < AllCheckboxesSpan.size(); i++) {
			if (AllCheckboxesInput.get(i).getAttribute("tabindex").toString().equals("0")) {
				clickIt(AllCheckboxesSpan.get(i));
				j = i;
				break;
			}
		}
		Actions act = new Actions(driver);
		super.addLog("Click on Reboot");
		log.info("Click on Reboot");
		GroupName = AllGroupNames.get(j).getText();
		MACAddress = AllMCActions.get(j).getText();
		IPAddress = AllIPaddresses.get(j).getText();
		act.moveToElement(AllGoLiveDates.get(j)).perform();
		clickIt(FourHoverOptionsList.get(2));
		TestUtil.sleep(2000);
		if (BoldActionBtn.isDisplayed()
				&& HoverAlertMsg.getText().contains("Are you sure you want to reboot the device(s) ?")) {
			waitForElementToDisplay(HoverRebootBtn, 10);
			clickIt(HoverRebootBtn);
		}
		TestUtil.sleep(2000);
		super.addLog("Verify that 'Reboot command has been triggered successfully.' message appears ");
		log.info("Verify that 'Reboot command has been triggered successfully.' message appears ");

		if (ScriptInfoMsg.getText().equals("Reboot command has been triggered successfully.")) {
			super.addLog(
					"Click on Logs tab and verify that first row contains details about Reboot taken in groups tab with status pending");
			log.info("Click on Logs tab and verify that first row contains details about Reboot taken in groups tab with status pending");
			clickIt(TopLinks.get(4));
			Assert.assertEquals(AllHeaders.size(), 7);
			if (AllCategories.get(0).getText().equals("Reboot") && (AllMacAddresses.get(0).getText().equals(MACAddress))
					&& (AllStatuses.get(0).getText().equals("Pending")))
				b1 = true;
			TestUtil.sleep(2000);
			super.addLog(
					"Click on Activity link and verify that first row contains details about Reboot taken in groups tab");
			log.info(
					"Click on Activity link and verify that first row contains details about Reboot taken in groups tab");
			clickIt(ActivityLink);
			TestUtil.sleep(2000);
			if (AllGroupNames.get(0).getText().equals(GroupName)
					&& (AllMacAddresses.get(0).getText().equals(MACAddress))
					&& (AllActivityStatuses.get(0).getText().equals("Pending"))
					&& (AllCategories.get(0).getText().equals(IPAddress)))
				b2 = true;
		
			super.addLog("Keep polling until Reboot shows complete status in Activity tab");
			log.info("Keep polling until Reboot shows complete status in Activity tab");
	
			if (b1 && b2) {
				for (int i = 0; i < 20; i++) {
					for (int k = 0; k < ActivityColumn6.size(); k++) {
						if (ActivityColumn8.get(k).getText().equals("Reboot")) {
							j = k;
							break;
						}
					}
					if (AllActivityStatuses.get(j).getText().equals("Completed")) {
						b3 = true;
						clickIt(BackArrow);
						break;
					} else {
						super.addLog("Wait for 30 seconds");
						log.info("Wait for 30 seconds");
						TestUtil.sleep(30000);
						clickIt(BackArrow);
						TestUtil.sleep(2000);
						clickIt(ActivityLink);
						TestUtil.sleep(2000);
					}
				}
			}
			super.addLog("Validate that the Reboot shows complete status in Logs tab");
			log.info("Validate that the Reboot shows complete status in Logs tab");
	
			if (b3) {
				TestUtil.sleep(2000);
				clickIt(TopLinks.get(4));
				Assert.assertEquals(AllHeaders.size(), 7);
				for (int k = 0; k < ActivityColumn3.size(); k++) {
					if (ActivityColumn3.get(k).getText().equals("Reboot")) {
						j = k;
						break;
					}
				}
				if (AllStatuses.get(j).getText().equals("Completed"))
					b4 = true;
				}
		}else {
			log.info(ScriptInfoMsg.getText());
			super.addLog(ScriptInfoMsg.getText());
		}
		return b4;
	}

	/**
	 * This function adds a script for an online device and polls the activity page until the script shows complete
	 *  and also verifies entry on logs page
	 * @return true on success
	 */
	public boolean Script_LogsAndActivities() {
		int j = 0;
		boolean b1 = false;
		boolean b2 = false;
		boolean b3 = false;
		boolean b4 = false;
		boolean b5 = false;
		String GroupName, MACAddress, IPAddress;
		TestUtil.sleep(2000);
		clickIt(TopLinks.get(1));
		Assert.assertEquals(AllHeaders.size(), 15);
		setNoOfItemsTo100();
		TestUtil.sleep(2000);
		clickIt(GroupsOnlineOfflineLinks.get(0));
		TestUtil.sleep(2000);
		super.addLog("Hover over the last column of the first row with checkbox enabled in the table");
		log.info("Hover over the last column of the first row with checkbox enabled in the table");
		for (int i = 0; i < AllCheckboxesSpan.size(); i++) {
			if (AllCheckboxesInput.get(i).getAttribute("tabindex").toString().equals("0")) {
				clickIt(AllCheckboxesSpan.get(i));
				j = i;
				break;
			}
		}
		Actions act = new Actions(driver);
		super.addLog("Click on Script icon");
		log.info("Click on Script icon");
		GroupName = AllGroupNames.get(j).getText();
		MACAddress = AllMCActions.get(j).getText();
		IPAddress = AllIPaddresses.get(j).getText();
		act.moveToElement(AllGoLiveDates.get(j)).perform();
		clickIt(FourHoverOptionsList.get(3));
		TestUtil.sleep(2000);
		String newscript = prop.getProperty("Groupscriptname");

		super.addLog("Enter all details for new script");
		log.info("Enter all details for new script");

		ScriptName.sendKeys(newscript);
		ScriptDetails.sendKeys("echo");

		super.addLog("Click Send Button");
		log.info("Click Send Button");
		TestUtil.sleep(2000);
		clickIt(SendButton);

		TestUtil.sleep(2000);
		super.addLog("Verify that 'Script has been triggered successfully.' message appears ");
		log.info("Verify that 'Script has been triggered successfully.' message appears ");

		if (ScriptInfoMsg.getText().equals("Script has been triggered successfully.")) {
			super.addLog(
					"Click on Logs tab and verify that first row contains details about Script sent in groups tab");
			log.info("Click on Logs tab and verify that first row contains details about Script sent  in groups tab");
			clickIt(TopLinks.get(4));
			Assert.assertEquals(AllHeaders.size(), 7);
			if (AllCategories.get(0).getText().equals(newscript)
					&& (AllMacAddresses.get(0).getText().equals(MACAddress))
					&& (AllStatuses.get(0).getText().equals("Pending")))
				b1 = true;
			TestUtil.sleep(2000);
			super.addLog(
					"Click on Activity link and verify that first row contains details about Script sent  in groups tab");
			log.info(
					"Click on Activity link and verify that first row contains details about Script sent  in groups tab");
			clickIt(ActivityLink);
			TestUtil.sleep(2000);
			if (AllGroupNames.get(0).getText().equals(GroupName)
					&& (AllMacAddresses.get(0).getText().equals(MACAddress))
					&& (AllActivityStatuses.get(0).getText().equals("Pending"))
					&& (AllCategories.get(0).getText().equals(IPAddress))) {
				b2 = true;
				String grLink = "//a[text()='" + newscript + "']";
				clickIt(driver.findElement(By.xpath(grLink)));
				TestUtil.sleep(2000);
				super.addLog("Verify that Pending Button is displayed and window has only one tab: Script");
				log.info("Verify that Pending Button is displayed and window has only one tab: Script");
				if (ButtonOnWindow.getText().equals("Pending") && ActivityWindowTabs.size() == 1)
					b3 = true;
				else
					b3 = false;
				clickIt(ScreenShotClose);
			}
		
			super.addLog("Keep polling until the current script shows complete status in Activity tab");
			log.info("Keep polling until the current script shows complete status in Activity tab");
	
			if (b1 && b2 && b3) {
				for (int i = 0; i < 20; i++) {
					for (int k = 0; k < ActivityColumn6.size(); k++) {
						if (ActivityColumn8.get(k).getText().equals(newscript)) {
							j = k;
							break;
						}
					}
					if (AllActivityStatuses.get(j).getText().equals("Completed")) {
						b4 = true;
						clickIt(BackArrow);
						break;
					} else {
						super.addLog("Wait for 30 seconds");
						log.info("Wait for 30 seconds");
						TestUtil.sleep(30000);
						clickIt(BackArrow);
						TestUtil.sleep(2000);
						clickIt(ActivityLink);
						TestUtil.sleep(2000);
					}
				}
			}
			super.addLog("Validate that the current script shows complete status in Logs tab");
			log.info("Validate that the current script shows complete status in Logs tab");
			if (b4) {
				TestUtil.sleep(2000);
				clickIt(TopLinks.get(4));
				Assert.assertEquals(AllHeaders.size(), 7);
				for (int k = 0; k < ActivityColumn3.size(); k++) {
					if (ActivityColumn3.get(k).getText().equals(newscript)) {
						j = k;
						break;
					}
				}
				if (AllStatuses.get(j).getText().equals("Completed"))
					b5 = true;
				}
		}else {
			log.info(ScriptInfoMsg.getText());
			super.addLog(ScriptInfoMsg.getText());
		}
		clickIt(TopLinks.get(5));
		TestUtil.sleep(2000);
		return b5;
	}

	/**
	 * This function sorts trace logs by mac address, file size, filename
	 * @param c=1 for mac address,c=3 for file size, c=4 for filename
	 * @return true on success
	 */
	public boolean ValidateTraceLogsSortByGivenColumn(int c) {
		
		TestUtil.sleep(4000);
		super.addLog("Click on first page button of pagination");
		log.info("Click on first page button of pagination");
		clickIt(FirstPageBtn);
		TestUtil.sleep(4000);
		if (AllRows.size() != 0) {
			List<String> BeforeSortList = GetListOfAllCurrentRowsForCol(c);
			List<String> AfterSortList = new ArrayList<String>();
			
			if (c == 3) {
				List<Float> bytelist = new ArrayList<Float>();
				List<Float> kblist = new ArrayList<Float>();
				List<String> SortedByteList = new ArrayList<String>();
				List<String> SortedKBList = new ArrayList<String>();
				for (int i = 0; i < BeforeSortList.size(); i++) {
					if (BeforeSortList.get(i).contains("bytes")) {
						Float t = Float.parseFloat(BeforeSortList.get(i).split(" ")[0]);
						bytelist.add(t);
						Collections.sort(bytelist);
					}
				}

				for (int i = 0; i < BeforeSortList.size(); i++) {
					if (BeforeSortList.get(i).contains("kb")) {
						Float t = Float.parseFloat(BeforeSortList.get(i).split(" ")[0]);
						kblist.add(t);
						Collections.sort(kblist);
					}
				}

				for (int i = 0; i < bytelist.size(); i++) {
					SortedByteList.add(new DecimalFormat("0").format(bytelist.get(i)) + " bytes");
				}

				for (int i = 0; i < kblist.size(); i++) {
					SortedKBList.add(new DecimalFormat("0.00").format(kblist.get(i)) + " kb");
				}

				SortedByteList.addAll(SortedByteList.size(), SortedKBList);
				AfterSortList = SortedByteList;
			} else {
				AfterSortList = BeforeSortList.stream().sorted().collect(Collectors.toList());
			}
			super.addLog("Click on first page button of pagination");
			log.info("Click on first page button of pagination");
			clickIt(FirstPageBtn);
			TestUtil.sleep(2000);		
			super.addLog("Click on header link to sort");
			log.info("Click on header link to sort");
			clickIt(AllHeadersSortingLink.get(c - 1));
			TestUtil.sleep(2000);
			List<String> AfterSortListFromWebsite = GetListOfAllCurrentRowsForCol(c);
			super.addLog("Verify that list displayed on screen matches sorted list in program");
			log.info("Verify that list displayed on screen matches sorted list in program");
			System.out.println(AfterSortList);
			System.out.println(AfterSortListFromWebsite);
			
			if (AfterSortList.equals(AfterSortListFromWebsite))
				return true;
			else
				return false;
		} else
			return true;

	}

	/**
	 * This function sorts trace logs by upload date
	 * @param c=2
	 * @return true on success
	 */
	public boolean SortByDateGivenCol(int c) {
		
		TestUtil.sleep(2000);
		super.addLog("Click on first page button of pagination");
		log.info("Click on first page button of pagination");
		clickIt(FirstPageBtn);
		TestUtil.sleep(2000);
		if (AllRows.size() != 0) {
			List<String> BeforeSortList = GetListOfAllCurrentRowsForCol(c);
			Collections.sort(BeforeSortList, new Comparator<String>() {
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");

				@Override
				public int compare(String o1, String o2) {
					try {
						return dateFormat.parse(o1).compareTo(dateFormat.parse(o2));
					} catch (ParseException e) {
						throw new IllegalArgumentException(e);
					}

				}
			});
			super.addLog("Click on first page button of pagination");
			log.info("Click on first page button of pagination");
			clickIt(FirstPageBtn);
			super.addLog("Click on header link to sort");
			log.info("Click on header link to sort");
			clickIt(AllHeadersSortingLink.get(c - 1));
			TestUtil.sleep(4000);
			List<String> AfterSortListFromWebsite = GetListOfAllCurrentRowsForCol(c);
			super.addLog("Verify that list displayed on screen matches sorted list in program");
			log.info("Verify that list displayed on screen matches sorted list in program");
			System.out.println(BeforeSortList);
			System.out.println(AfterSortListFromWebsite);
			if (BeforeSortList.equals(AfterSortListFromWebsite))
				return true;
			else
				return false;
		} else
			return true;
	}

	/**
	 * This function removes the bookmark for scriptname from config.properties on Script page
	 * and confirms that the bookmark does not exist when adding new script from Groups tab
	 * @return true on success
	 */
	public boolean BookMarkScript() {

		int j = 0;
		String newscript = prop.getProperty("scriptname");
		super.addLog("Remove bookmark for script: " + newscript);
		log.info("Remove bookmark for script: " + newscript);
		clickIt(BookMarkScriptBtn);
		TestUtil.sleep(2000);
		if (ScriptInfoMsg.getText().contains("removed from bookmarked")) {
			TestUtil.sleep(2000);
			clickIt(TopLinks.get(1));
			softAssert.assertEquals(AllHeaders.size(), 15);
			setNoOfItemsTo100();
			TestUtil.sleep(2000);
			super.addLog("Hover over the last column of the first row with checkbox enabled in the table");
			log.info("Hover over the last column of the first row with checkbox enabled in the table");
			for (int i = 0; i < AllCheckboxesSpan.size(); i++) {
				if (AllCheckboxesInput.get(i).getAttribute("tabindex").toString().equals("0")) {
					clickIt(AllCheckboxesSpan.get(i));
					j = i;
					break;
				}
			}
			Actions act = new Actions(driver);
			super.addLog("Click on Script");
			log.info("Click on Script");
			act.moveToElement(AllGoLiveDates.get(j)).perform();
			clickIt(FourHoverOptionsList.get(3));
			TestUtil.sleep(2000);
			clickIt(ScriptsDropDown.get(0));
			int i = 0;
			super.addLog("Confirm that script name does not exist in bookmarks list: " + newscript);
			log.info("Confirm that script name does not exist in bookmarks list: " + newscript);
			while (i < AllBookMarks.size()) {
				if (!AllBookMarks.get(i).getText().equals(newscript))
					i++;
				else
					break;
			}
			if (i == AllBookMarks.size()) {
				clickIt(GroupsDropDownClose);
				clickIt(GroupsScriptClose);	
				return true;
			} else {
				clickIt(GroupsDropDownClose);
				clickIt(GroupsScriptClose);
				return false;
			}
		}
		return false;
	}

	/**
	 * This function confirms that all checkboxes are selected when top checkbox is selected for scheduled and non-scheduled scripts
	 * @param i=0 for scheduled and i=1 for non-scheduled scripts
	 * @return true on success
	 */
	public boolean SMMultipleScriptsSelect(int i) {
		TestUtil.sleep(2000);
		waitForelementToBeClickable(TopLinks.get(0), 10);
		clickIt(TopLinks.get(0));
		TestUtil.sleep(2000);
		clickIt(TopLinks.get(5));
		clickIt(MatExpanders.get(i));
		TestUtil.sleep(2000);
		super.addLog("Click on checkbox to select all rows");
		log.info("Click on checkbox to select all rows");
		clickIt(ScriptsMainCheckboxes.get(i));
		if (i == 0) {
			super.addLog("Verify that Download, Delete and Stop scripts options display at the top");
			log.info("Verify that Download, Delete and Stop scripts options display at the top");
			if (ScriptsHDFourHoverOptionsList.size() == 4)
				return true;
			else
				return false;
		} else {
			super.addLog("Verify that Download option display at the top");
			log.info("Verify that Download option display at the top");
			if (ScriptsHDFourHoverOptionsList.size() == 2)
				return true;
			else
				return false;
		}
	}

	/**
	 * This function verifies that error message is displayed when script description exceeds 1000 characters
	 * @return true on success
	 */
	public boolean ScriptDescriptionSize() {
		TestUtil.sleep(2000);
		super.addLog("Enter text more than 1000 characters inside script description textbox");
		log.info("Enter text more than 1000 characters inside script description textbox");
		ScriptDescription.sendKeys(
				"ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
		TestUtil.sleep(2000);
		super.addLog("Verify error message appears");
		log.info("Verify error message appears");
		if (ScriptDescriptionError.getText().equals("Max 1000 characters are allowed")) {
			clickIt(ViewScriptClose);
			return true;
		} else {
			clickIt(ViewScriptClose);
			return false;
		}
	}

	/**
	 * This function connects to the database and confirms that the data on activity page for today matches with the DB data
	 */
	public void ValidateActivityDatawithDB() {

		TestUtil.sleep(4000);
		clickIt(TopLinks.get(1));
		Assert.assertEquals(AllHeaders.size(), 15);
		TestUtil.sleep(2000);
		setNoOfItemsTo100();
		TestUtil.sleep(2000);
		super.addLog("Click on Activity Link");
		log.info("Click on Activity Link");
		clickIt(ActivityLink);
		TestUtil.sleep(2000);
		super.addLog("Select Today from dropdown");
		log.info("Select Today from dropdown");
		clickIt(ActivityDropDown);
		clickIt(ActivityToday);
		TestUtil.sleep(2000);
		byte[] un = Base64.getDecoder().decode(prop.getProperty("DBuser"));
		byte[] pwd = Base64.getDecoder().decode(prop.getProperty("DBpass"));

		Statement stmt;
		ResultSet rs;
		String s;
		try {
			super.addLog("Connect to Database and get all rows for today");
			log.info("Connect to Database and get all rows for today");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(prop.getProperty("DBConnectionString"), new String(un),
					new String(pwd));

			stmt = conn.createStatement();
			s = "select g.groupname, dm.IoTHubDeviceId as MACAddress, a.IPAddress, dm.GroupId as LocationCode,  a.CompletedBy, a.Status, a.CreatedDate , a.CommandName \r\n"
					+ "from activity a, devicemapping dm full join [Group] g on dm.groupid=g.groupid  where a.CreatedDate between cast(getutcdate() as date) and getutcdate() and a.isactive=1 \r\n"
					+ "and dm.siteid='9807ED24-E684-4429-A808-F391BE68C8A2' and a.deviceid=dm.deviceid order by a.createddate desc";

			rs = stmt.executeQuery(s);

			rs = stmt.executeQuery(s);
			int i = 0;
			String format = "yyyy-MM-dd HH:mm:ss";
			String targetformat = "MM/dd/yy hh:mm a";
			SimpleDateFormat utcFormatter = new SimpleDateFormat(format);
			utcFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
			super.addLog("Traverse through all rows and verify whether data matches rows on Activity table");
			log.info("Traverse through all rows and verify whether data matches rows on Activity table");
			super.addLog(
					"Verify Group name, MAC address, IP address, Location code, Status, Date, Activity for each row");
			log.info("Verify Group name, MAC address, IP address, Location code, Status, Date, Activity for each row");
			while (rs.next()) {

				Date date = utcFormatter.parse(rs.getString(7).toString());
				SimpleDateFormat estFormatter = new SimpleDateFormat(targetformat);
				estFormatter.setTimeZone(TimeZone.getTimeZone("EST"));

				int j = i + 1;
				// System.out.println(rs.getString(1) + " " + rs.getString(2) + " "
				// +rs.getString(3) + " " +rs.getString(4) + "****" +
				// rs.getString(5) + "****" +rs.getString(6).toString().trim() + " "
				// +estFormatter.format(date)+ " " +rs.getString(8));
				softAssert.assertEquals(rs.getString(1), ActivityColumn1.get(i).getText(),
						"Group name does not match value in DB for row " + j);
				softAssert.assertEquals(rs.getString(2), ActivityColumn2.get(i).getText().toLowerCase(),
						"MAC address does not match value in DB for row " + j);
				softAssert.assertEquals(rs.getString(3), ActivityColumn3.get(i).getText(),
						"IP address does not match value in DB for row " + j);
				softAssert.assertEquals(rs.getString(4), ActivityColumn4.get(i).getText(),
						"Location code does not match value in DB for row " + j);
				softAssert.assertEquals(rs.getString(5).toString().trim(), ActivityColumn5.get(i).getText().toString(),
						"Completed by does not match value in DB for row " + j);
				softAssert.assertTrue(rs.getString(6).contains(ActivityColumn6.get(i).getText()),
						"Status does not match value in DB for row " + j);

				softAssert.assertEquals(estFormatter.format(date), ActivityColumn7.get(i).getText(),
						"Date does not match value in DB for row " + j);

				softAssert.assertEquals(rs.getString(8), ActivityColumn8.get(i).getText(),
						"Activity does not match value in DB for row " + j);

				// System.out.println(ActivityColumn1.get(i).getText() + " " +
				// ActivityColumn2.get(i).getText().toLowerCase() + " " +
				// ActivityColumn3.get(i).getText() + " " +
				// ActivityColumn4.get(i).getText() + "***" + ActivityColumn5.get(i).getText() +
				// "***" + ActivityColumn6.get(i).getText() + " " +
				// estFormatter.format(date) + " " + ActivityColumn8.get(i).getText());
				i++;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		softAssert.assertAll();
		clickIt(BackArrow);
	}

	/**
	 * This function connects to the database and confirms that the data on activity page for last 7 days matches with the DB data
	 */
	public void ValidateActivityDatawithDB1() {

		TestUtil.sleep(4000);
		clickIt(TopLinks.get(1));
		Assert.assertEquals(AllHeaders.size(), 15);
		TestUtil.sleep(2000);
		setNoOfItemsTo100();
		TestUtil.sleep(2000);
		super.addLog("Click on Activity Link");
		log.info("Click on Activity Link");
		clickIt(ActivityLink);
		TestUtil.sleep(2000);

		byte[] un = Base64.getDecoder().decode(prop.getProperty("DBuser"));
		byte[] pwd = Base64.getDecoder().decode(prop.getProperty("DBpass"));

		Statement stmt;
		ResultSet rs;
		String s;
		try {
			super.addLog("Connect to Database and get all rows for last 7 days");
			log.info("Connect to Database and get all rows for last 7 days");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(prop.getProperty("DBConnectionString"), new String(un),
					new String(pwd));

			stmt = conn.createStatement();
			s = "select g.groupname, dm.IoTHubDeviceId as MACAddress, a.IPAddress, dm.GroupId as LocationCode,  a.CompletedBy, a.Status, a.CreatedDate , \r\n"
					+ "a.CommandName from activity a, devicemapping dm full join [Group] g on dm.groupid=g.groupid  where a.CreatedDate between \r\n"
					+ "dateadd(day,-7,cast(getutcdate() as date)) and GETUTCDATE() and a.isactive=1 and dm.siteid='9807ED24-E684-4429-A808-F391BE68C8A2' \r\n"
					+ "and a.deviceid=dm.deviceid order by a.createddate desc";

			rs = stmt.executeQuery(s);

			rs = stmt.executeQuery(s);
			int i = 0;
			int t = 0;
			String format = "yyyy-MM-dd HH:mm:ss";
			String targetformat = "MM/dd/yy hh:mm a";
			SimpleDateFormat utcFormatter = new SimpleDateFormat(format);
			utcFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
			super.addLog("Traverse through all rows and verify whether data matches rows on Activity table");
			log.info("Traverse through all rows and verify whether data matches rows on Activity table");
			super.addLog(
					"Verify Group name, MAC address, IP address, Location code, Status, Date, Activity for each row");
			log.info("Verify Group name, MAC address, IP address, Location code, Status, Date, Activity for each row");

			while (rs.next()) {

				Date date = utcFormatter.parse(rs.getString(7).toString());
				SimpleDateFormat estFormatter = new SimpleDateFormat(targetformat);
				estFormatter.setTimeZone(TimeZone.getTimeZone("EST"));

				int j = t + 1;
				if (rs.getString(1) != null)
					softAssert.assertEquals(rs.getString(1), ActivityColumn1.get(i).getText(),
							"Group name does not match value in DB for row " + j);
				softAssert.assertEquals(rs.getString(2), ActivityColumn2.get(i).getText().toLowerCase(),
						"MAC address does not match value in DB for row " + j);
				softAssert.assertEquals(rs.getString(3), ActivityColumn3.get(i).getText(),
						"IP address does not match value in DB for row " + j);
				softAssert.assertEquals(rs.getString(4), ActivityColumn4.get(i).getText(),
						"Location code does not match value in DB for row " + j);
				softAssert.assertEquals(rs.getString(5).toString().trim(), ActivityColumn5.get(i).getText().toString(),
						"Completed by does not match value in DB for row " + j);
				softAssert.assertTrue(rs.getString(6).contains(ActivityColumn6.get(i).getText()),
						"Status does not match value in DB for row " + j);

				softAssert.assertEquals(estFormatter.format(date), ActivityColumn7.get(i).getText(),
						"Date does not match value in DB for row " + j);

				softAssert.assertEquals(rs.getString(8), ActivityColumn8.get(i).getText(),
						"Activity does not match value in DB for row " + j);

				/*
				 * System.out.println(t);
				 * 
				 * System.out.println(rs.getString(1) + " " + rs.getString(2) + " "
				 * +rs.getString(3) + " " +rs.getString(4) + "***" + rs.getString(5) + "***"
				 * +rs.getString(6).toString().trim() + " " +estFormatter.format(date)+ " "
				 * +rs.getString(8)); System.out.println(ActivityColumn1.get(i).getText() + " "
				 * + ActivityColumn2.get(i).getText().toLowerCase() + " " +
				 * ActivityColumn3.get(i).getText() + " " + ActivityColumn4.get(i).getText() +
				 * "***" + ActivityColumn5.get(i).getText() + "***" +
				 * ActivityColumn6.get(i).getText() + " " + estFormatter.format(date) + " " +
				 * ActivityColumn8.get(i).getText());
				 */

				i++;
				t++;
				if (i == 100) {
					if (NextPageBtn.isEnabled()) {
						super.addLog("Click on next button of pagination");
						log.info("Click on next button of pagination");
						clickIt(NextPageBtn);
						TestUtil.sleep(4000);
						i = 0;
					}
				}

			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		softAssert.assertAll();
		clickIt(BackArrow);
	}

	/**
	 * This function searches by MAC address displayed on the first row of the table in the Activity page
	 * @return true on success
	 */
	public boolean ActivitySearchByMac() {
		boolean b = true;
		String s = null;
		TestUtil.sleep(4000);
		clickIt(TopLinks.get(1));
		Assert.assertEquals(AllHeaders.size(), 15);
		TestUtil.sleep(2000);
		setNoOfItemsTo100();
		TestUtil.sleep(2000);
		super.addLog("Click on Activity Link");
		log.info("Click on Activity Link");
		clickIt(ActivityLink);
		TestUtil.sleep(2000);
		super.addLog("Verify Number of Columns displayed is 8");
		log.info("Verify Number of Columns displayed is 8");
		Assert.assertEquals(AllHeaders.size(), 8);
		s = AllMCMacAddresses.get(0).getText();
		super.addLog("Click on search icon and type " + s);
		log.info("Click on search icon and type " + s);

		waitForVisibilityOf(SearchIcon, 10);
		clickIt(SearchIcon);
		clickIt(SearchInputBox);
		SearchInputBox.sendKeys(s);
		IsSpinningComplete();
		super.addLog("Verify that table displays only rows with " + s);
		log.info("Verify that table displays only rows with " + s);

		for (int i = 0; i < AllMCMacAddresses.size(); i++) {
			if (!(AllMCMacAddresses.get(i).getText().contains(s)))
				b = false;
		}
		SearchInputBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		SearchInputBox.sendKeys(Keys.DELETE);
		IsSpinningComplete();
		return b;
	}

	/**
	 * This function searches by Group name displayed on the first row of the table in the Activity page
	 * @return true on success
	 */
	public boolean ActivitySearchByGroup() {
		boolean b = true;
		String GroupName = ActivityColumn1.get(0).getText();
		super.addLog("Click on the Groups button for group name: " + GroupName);
		log.info("Click on the Groups button for group name: " + GroupName);
		for (int i = 0; i < SearchBubbleGroupsNames.size(); i++) {
			if (SearchBubbleGroupsNames.get(i).getText().equals(GroupName)) {
				clickIt(SearchBubbleGroupsNames.get(i));
				break;
			}
		}
		TestUtil.sleep(2000);
		super.addLog("Verify that all dislayed rows have group name: " + GroupName);
		log.info("Verify that all dislayed rows have group name: " + GroupName);
		while (NextPageBtn.isEnabled()) {
			for (int i = 0; i < ActivityColumn1.size(); i++) {
				if (!ActivityColumn1.get(i).getText().equals(GroupName)) {
					b = false;
					break;
				}
			}
			super.addLog("Click on next button of pagination");
			log.info("Click on next button of pagination");
			clickIt(NextPageBtn);
			TestUtil.sleep(2000);
		}
		super.addLog("Click on first page button of pagination");
		log.info("Click on first page button of pagination");
		clickIt(FirstPageBtn);
		TestUtil.sleep(2000);
		clickIt(SearchBubbleGroupsNames.get(0));
		return b;
	}

	/**
	 * This function click on the completed Capture screenshot
	 * and confirms that the page display two tabs and download functionality works
	 * @return on success
	 */
	public boolean ActivityClickCompScreenShot() {

		int j = 0;
		boolean b = false;
		clickIt(StatusLink);
		TestUtil.sleep(4000);
		for (int i = 0; i < ActivityColumn6.size(); i++) {
			if (ActivityColumn6.get(i).getText().equals("Completed")
					&& ActivityColumn8.get(i).getText().equals("Capture Screenshot")) {
				j = i;
				break;
			}
		}
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", ActivityColumn8Links.get(j));
		//clickIt(ActivityColumn8Links.get(j));
		TestUtil.sleep(2000);
		clickIt(ScreenShotDownload);

		TestUtil.sleep(4000);
		File file = new File(System.getProperty("user.dir"));
		File ff[] = file.listFiles();
		super.addLog("Verify that file is downloaded");
		log.info("Verify that file is downloaded");
		for (File f : ff) {
			if (f.getName().contains("screenshot")) {
				String filePath = System.getProperty("user.dir") + "\\" + f.getName();
				File delfile = new File(filePath);
				delfile.delete();
				b = true;
			}
		}
		clickIt(ScreenShotClose);
		return b;
	}

	/**
	 * This function click on the completed Upload Device Package Manifest or Script based on parameter c passed to it
	 * and confirms that the page display two tabs and download functionality works
	 * @param c=0 for Pull Manifest, c=1 for Script
	 * @return on success
	 */
	public boolean ActivityClickCompPkgManifestAndScript(int c) {

		TestUtil.sleep(4000);
		int j = 0;
		boolean b1 = false;
		boolean b2 = false;
		
		if (c == 0) {
			for (int i = 0; i < ActivityColumn6.size(); i++) {
				if (ActivityColumn6.get(i).getText().equals("Completed")
						&& ActivityColumn8.get(i).getText().contains("Upload Device Package Manifest")) {
					j = i;
					break;
				}
			}
		} else if (c == 1) {
			for (int i = 0; i < ActivityColumn6.size(); i++) {
				if (ActivityColumn6.get(i).getText().equals("Completed")
						&& !ActivityColumn8.get(i).getText().contains("Upload Device Package Manifest")
						&& !ActivityColumn8.get(i).getText().contains("Capture Screenshot")
						&& !ActivityColumn8.get(i).getText().contains("Reboot")) {
					j = i;
					break;
				}
			}
		}
		TestUtil.sleep(4000);
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", ActivityColumn8Links.get(j));
		TestUtil.sleep(4000);
		clickIt(ScreenShotDownload);

		TestUtil.sleep(4000);
		File file = new File(System.getProperty("user.dir"));
		File ff[] = file.listFiles();
		super.addLog("Verify that file is downloaded");
		log.info("Verify that file is downloaded");
		for (File f : ff) {
			if (f.getName().contains("Script_")) {
				String filePath = System.getProperty("user.dir") + "\\" + f.getName();
				File delfile = new File(filePath);
				delfile.delete();
				b1 = true;
			}
		}
		super.addLog("Verify that Green Complete Button is displayed and window has two tabs: Script and Output");
		log.info("Verify that Green Complete Button is displayed and window has two tabs: Script and Output");
		if (ButtonOnWindow.getText().equals("Completed") && ActivityWindowTabs.size() == 2)
			b2 = true;
		else
			b2 = false;
		clickIt(ScreenShotClose);

		if (c == 1) {
			clickIt(StatusLink);
			TestUtil.sleep(2000);
			clickIt(StatusLink);
			TestUtil.sleep(2000);
		}
		if (b1 && b2)
			return true;
		else
			return false;
	}
	
	/**
	 * This function displays the rows on on the Activity page based on number of days selected from dropdown at the top
	 * @param x 0,7,14,30,90
	 * @return true on success
	 */
	public boolean ActivityLastXDays(int x) {

		boolean b = true;

		TestUtil.sleep(2000);
		super.addLog("Select Today from dropdown");
		log.info("Select Today from dropdown");
		clickIt(ActivityDropDown);

		TestUtil.sleep(2000);
	
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -(x));
		String s = sdf.format(cal.getTime());
		
		if (x == 0) {
			super.addLog("Select today from dropdown");
			log.info("Select today from dropdown");
			clickIt(ActivityToday);
		} else if (x == 7) {
			super.addLog("Select last 7 days from dropdown");
			log.info("Select last 7 days from dropdown");
			clickIt(ActivityLast7Days);
		} else if (x == 14) {
			super.addLog("Select last 14 days from dropdown");
			log.info("Select last 14 days from dropdown");
			clickIt(ActivityLast14Days);
		} else if (x == 30) {
			super.addLog("Select last 30 days from dropdown");
			log.info("Select last 30 days from dropdown");
			clickIt(ActivityLast30Days);
		} else if (x == 90) {
			super.addLog("Select last 90 days from dropdown");
			log.info("Select last 90 days from dropdown");
			clickIt(ActivityLast90Days);
		}

		TestUtil.sleep(2000);
		if (TotalNumOfServices.getText().trim().equals("0 of 0")) {
			super.addLog("No Activities present in table for today");
			log.info("No Activities present in table for today");
			Assert.assertEquals(FirstRow.getText(), "No Record Found!");
			b = false;
			clickIt(BackArrow);
			return b;
		} else {
			super.addLog("Verify all Activities have date as any date in the last " + x + " days");
			log.info("Verify all Activities have date as any date in the last " + x + " days");
			for (int i = 0; i < ActivityColumn7.size(); i++) {

				try {
					Date adate = sdf.parse(s);
					Date cdate = sdf.parse(ActivityColumn7.get(i).getText().split(" ")[0].trim());
					if ((cdate.compareTo(adate) < 0)) {
						System.out.println("Failed since: " + cdate.toString().split(" ")[2] + " is not within the date range selected");
						super.addLog("Failed since: " + cdate.toString().split(" ")[2] + " is not within the date range selected");
						log.info("Failed since: " + cdate.toString().split(" ")[2] + " is not within the date range selected");
						b = false;
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			while (NextPageBtn.isEnabled()) {
				super.addLog("Click on next button of pagination");
				log.info("Click on next button of pagination");
				clickIt(NextPageBtn);
				TestUtil.sleep(3000);
				for (int i = 0; i < ActivityColumn7.size(); i++) {
					try {
						Date adate = sdf.parse(s);
						Date cdate = sdf.parse(ActivityColumn7.get(i).getText().split(" ")[0].trim());
						
						if ((cdate.compareTo(adate) < 0)) {
							System.out.println("Failed since: " + cdate.toString().split(" ")[2] + " is not within the date range selected");
							super.addLog("Failed since: " + cdate.toString().split(" ")[2] + " is not within the date range selected");
							log.info("Failed since: " + cdate.toString().split(" ")[2] + " is not within the date range selected");
							b = false;
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
			return b;
		}

	}

	/**
	 * This function sorts by Status column on the Activity page
	 * @return true on success
	 */
	public boolean ValidateActivitySortByStatus() {
		TestUtil.sleep(2000);
		clickIt(BackArrow);
		TestUtil.sleep(4000);
		clickIt(TopLinks.get(1));
		Assert.assertEquals(AllHeaders.size(), 15);
		TestUtil.sleep(2000);
		setNoOfItemsTo100();
		TestUtil.sleep(2000);
		super.addLog("Click on Activity Link");
		log.info("Click on Activity Link");
		clickIt(ActivityLink);
		TestUtil.sleep(2000);
		super.addLog("Verify Number of Columns displayed is 8");
		log.info("Verify Number of Columns displayed is 8");
		Assert.assertEquals(AllHeaders.size(), 8);
		clickIt(ActivityDropDown);
		clickIt(ActivityLast7Days);
		TestUtil.sleep(4000);
		if (AllRows.size() != 0) {
			List<String> BeforeSortList = GetListOfAllCurrentRowsForCol(6);
			super.addLog("Click on first page button of pagination");
			log.info("Click on first page button of pagination");
			clickIt(FirstPageBtn);
			TestUtil.sleep(4000);
			List<String> AfterSortList = BeforeSortList.stream().sorted().collect(Collectors.toList());
			TestUtil.sleep(4000);
			clickIt(StatusLink);
			TestUtil.sleep(4000);
			List<String> AfterSortListFromWebsite = GetListOfAllCurrentRowsForCol(6);
			super.addLog("Verify that list displayed on screen matches sorted list in program");
			log.info("Verify that list displayed on screen matches sorted list in program");
			System.out.println(AfterSortList);
			System.out.println(AfterSortListFromWebsite);
			super.addLog("Click on first page button of pagination");
			log.info("Click on first page button of pagination");
			clickIt(FirstPageBtn);
			if (AfterSortList.equals(AfterSortListFromWebsite))
				return true;
			else
				return false;
		} else
			return true;
	}

	/**
	 * This function sorts by Date column on the Activity page
	 * @return true on success
	 */
	public boolean ActivitySortByDateGivenCol() {

	
		TestUtil.sleep(4000);
		if (AllRows.size() != 0) {
			List<String> BeforeSortList = GetListOfAllCurrentRowsForCol(7);

			Collections.sort(BeforeSortList, new Comparator<String>() {
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");

				@Override
				public int compare(String o1, String o2) {
					try {
						return dateFormat.parse(o1).compareTo(dateFormat.parse(o2));
					} catch (ParseException e) {
						throw new IllegalArgumentException(e);
					}

				}
			});
			super.addLog("Click on first page button of pagination");
			log.info("Click on first page button of pagination");
			clickIt(FirstPageBtn);
			TestUtil.sleep(4000);
			clickIt(DateLink);
			TestUtil.sleep(4000);

			List<String> AfterSortListFromWebsite = GetListOfAllCurrentRowsForCol(7);
			super.addLog("Verify that list displayed on screen matches sorted list in program");
			log.info("Verify that list displayed on screen matches sorted list in program");
			System.out.println(BeforeSortList);
			System.out.println(AfterSortListFromWebsite);

			if (BeforeSortList.equals(AfterSortListFromWebsite))
				return true;
			else
				return false;
		} else
			return true;
	}

	/**
	 * This function verifies that after clicking on site sync, the url at sync-status shows pass status
	 * @return true on success
	 */
	public boolean SiteSyncURL() {
		boolean b = false;
		TestUtil.sleep(2000);
		waitForelementToBeClickable(SyncBtn, 10);
		clickIt(SyncBtn);
		super.addLog("Check whether confirmation alert is present");
		log.info("Check whether confirmation alert is present");
		TestUtil.sleep(2000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		try {
			if (BoldActionBtn.isDisplayed())
				clickIt(BoldActionBtn);
		} catch (Exception e) {
			System.out.println("Confirmation alert not displayed");
		}
		TestUtil.sleep(2000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		if (AlertMessage.getText().contains("Sync Has Been Initiated Successfully for Site")) {
			clickIt(AlertMessageClose);
			TestUtil.sleep(2000);
			b = true;
		} else {
			TestUtil.sleep(2000);
			b = false;
		}
		if (b) {
			super.addLog("Open New Window and go to site sync URL");
			log.info("Open New Window and go to site sync URL");

			driver.switchTo().newWindow(WindowType.TAB);
			String siteID = prop.getProperty("siteID");
			driver.navigate().to(siteID + "sync-status");

			super.addLog("Enter SiteName");
			log.info("Enter SiteName");

			SiteSync_txtbox.sendKeys("Starlink0012");
			super.addLog("Click Search button");
			log.info("Click Search button");

			clickIt(SiteSync_Searchbtn);
			int j = 0;
			super.addLog("Check whether sitename exists in the search results table");
			log.info("Check whether sitename exists in the search results table");

			for (int i = 0; i < ActivityColumn2.size(); i++) {
				if (ActivityColumn2.get(i).getText().equals("Starlink0012")) {
					j = i;
					break;
				}
			}
			if (ActivityColumn2.get(j).getText().equals("Pass")) {
				super.addLog("Sitename has status : Pass");
				log.info("Sitename has status : Pass");

				return true;
			} else {
				super.addLog("Sitename does not have status : Pass");
				log.info("Sitename does not have status : Pass");
				return false;
			}
		} else
			return false;
	}

}
