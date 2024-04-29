//This is QR code test page
//@author : Praggati Oswal
package ztp.qa.testcases;
import java.util.Base64;
import org.testng.Assert;
import org.testng.annotations.*;
import ztp.qa.base.TestBase;
import ztp.qa.pages.*;


public class RMTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	SupportToolsPage supportToolsPage;
	WatcherPage watcherPage;
	QRCodePage qrCodePage;
	RMPage rmPage;
	
	public RMTest() {
		super();
	}


	@BeforeClass
	public void starttest() {
		
		initialization();	
		loginPage = new LoginPage();
		String pwd = prop.getProperty("password");
		byte[] decrypt = Base64.getDecoder().decode(pwd);
		homePage = loginPage.login(prop.getProperty("username"),new String(decrypt) );
		Assert.assertTrue(homePage.validateSPLabel(), "Unable to load home page");
		supportToolsPage = homePage.RMSearch();
		Assert.assertTrue(supportToolsPage.ValidateWatcherClientImg(),
				"Unable to load support tools page");
		log.info("On Support Tools page");
		rmPage = supportToolsPage.GotoRMPage();
		Assert.assertTrue(rmPage.VerifyRMPage(),"Unable to RM page");
		log.info("On RM page");
		rmPage.NoOfGroups=rmPage.GetNoOfGroups();
	}

	
	@Test(priority = 1, description ="Site Details Verification")
	public void RM_ValidateSiteDetails() {
	
		log.info("RM_ValidateSiteDetails Test started");
		super.addLog("RM_ValidateSiteDetails Test started");
		super.addLog("Verify Site Name");
		Assert.assertTrue(rmPage.SiteDetails(),
				"Site Details not displayed ");
		log.info("Site Details displayed correctly");
		super.addLog("Site Details displayed correctly");
		log.info("RM_ValidateSiteDetails Test completed");
		super.addLog("RM_ValidateSiteDetails Test completed");
	}
	
	@Test(priority = 2, description ="Site Details Groups link Verification")
		public void RM_ValidateSiteDetailsGroupsLink() {
		
			super.addLog("RM_ValidateSiteDetailsGroupsLink Test started");
			log.info("RM_ValidateSiteDetailsGroupsLink Test started");
			super.addLog("Click Groups Link and confirm number matches what shows on Groups page");
			Assert.assertTrue(rmPage.SiteDetailsGroupsLink(),
					"Matching number of groups not displayed ");
			log.info("Matching number of groups displayed");
			super.addLog("Matching number of groups displayed");
			log.info("RM_ValidateSiteDetailsGroupsLink Test completed");
			super.addLog("RM_ValidateSiteDetailsGroupsLink Test completed");
		}
	
	@Test(priority = 3, description ="Site Election off Verification")
	public void RM_ValidateSDSiteElectionOff() {
	
		super.addLog("RM_ValidateSDSiteElectionOff Test started");
		log.info("RM_ValidateSDSiteElectionOff Test started");
		super.addLog("Turn off Site Election and confirm message is displayed");
		Assert.assertTrue(rmPage.SDSiteElectionOnOff(1),
				"Site election for site has been disabled message did not appear");
		log.info("Site election for site has been disabled message appeared");
		super.addLog("Site election for site has been disabled message appeared");
		log.info("RM_ValidateSDSiteElectionOff Test completed");
		super.addLog("RM_ValidateSDSiteElectionOff Test completed");
	}
	
	@Test(priority = 4, description ="Site Election on Verification")
	public void RM_ValidateSDSiteElectionOn() {
	
		super.addLog("RM_ValidateSDSiteElectionOn Test started");
		log.info("RM_ValidateSDSiteElectionOn Test started");
		super.addLog("Turn on Site Election and confirm message is displayed");
		Assert.assertTrue(rmPage.SDSiteElectionOnOff(2),
				"Site election for site has been enabled message did not appear");
		log.info("Site election for site has been enabled message appeared");
		super.addLog("Site election for site has been enabled message appeared");
		log.info("RM_ValidateSDSiteElectionOn Test completed");
		super.addLog("RM_ValidateSDSiteElectionOn Test completed");
	}
	
	@Test(priority = 5, description ="Site Sync Verification")
	public void RM_ValidateSDSiteSync() {
	
		super.addLog("RM_ValidateSDSiteSync Test started");
		log.info("RM_ValidateSDSiteSync Test started");
		super.addLog("Click Site Sync and confirm message is displayed");
		Assert.assertTrue(rmPage.SDSiteSync(),
				"Sync Has Been Initiated Successfully for Site message did not appear");
		super.addLog("Sync Has Been Initiated Successfully for Site message appeared");
		log.info("Sync Has Been Initiated Successfully for Site message appeared");
		log.info("RM_ValidateSDSiteSync Test completed");
		super.addLog("RM_ValidateSDSiteSync Test completed");
	}
	
	
	@Test(priority = 6, description ="Groups Search by All Verification")
	public void RM_ValidateSearchAll() {
		super.addLog("RM_ValidateSearchAll Test started");
		log.info("RM_ValidateSearchAll Test started");
		super.addLog("Verify No Of Groups Displayed by All Search");
		Assert.assertTrue(rmPage.SearchBySelectedCriteria(0),
				"No Of Groups Displayed by All Search does not match total number of items");		
		log.info("Number of Groups displayed on All button matches total number of rows of table");
		super.addLog("Number of Groups displayed on All button matches total number of rows of table");
		log.info("RM_ValidateSearchAll Test completed");
		super.addLog("RM_ValidateSearchAll Test completed");
	}
	
	@Test(priority = 7, description ="Groups Search by Ungrouped Verification")
	public void RM_ValidateSearchUngrouped() {
		super.addLog("RM_ValidateSearchUngrouped Test started");
		log.info("RM_ValidateSearchUngrouped Test started");
		super.addLog("Verify No Of Groups Displayed by Ungrouped Search");
		int i=rmPage.FindUnGroupedButton();
		Assert.assertTrue(rmPage.SearchBySelectedCriteria(i),
				"No Of Groups Displayed by Ungrouped does not match total number of items");		
		log.info("Number of Groups displayed on Ungrouped button matches total number of rows of table");
		super.addLog("Number of Groups displayed on Ungrouped button matches total number of rows of table");
		log.info("RM_ValidateSearchUngrouped Test completed");
		super.addLog("RM_ValidateSearchUngrouped Test completed");
	}
	
	@Test(priority = 8, description ="Groups Search by Empty search Criteria")
	public void RM_ValidateSearchEmptyGroups() {
		super.addLog("RM_ValidateSearchEmptyGroups Test started");
		log.info("RM_ValidateSearchEmptyGroups Test started");
		super.addLog("Verify Groups Search by Empty search Criteria");
		int i=rmPage.FindEmptyGroup();
		Assert.assertTrue(rmPage.SearchBySelectedCriteria(i),
				"No groups displayed for Empty search Criteria did not work");			
		log.info("No groups displayed for Empty search Criteria");
		super.addLog("No groups displayed for Empty search Criteria");
		log.info("RM_ValidateSearchEmptyGroups Test completed");
		super.addLog("RM_ValidateSearchEmptyGroups Test completed");
	}
	
	@Test(priority = 9, description ="Groups Search by Non Empty search Criteria")
	public void RM_ValidateSearchNonEmptyGroups() {
		super.addLog("RM_ValidateSearchNonEmptyGroups Test started");
		log.info("RM_ValidateSearchNonEmptyGroups Test started");
		super.addLog("Verify Groups Search by Non Empty search Criteria");
		int i=rmPage.FindNonEmptyGroup();
		Assert.assertTrue(rmPage.SearchBySelectedCriteria(i),
				"Number of Groups displayed on Non Empty button does not match total number of rows of table");			
		log.info("Number of Groups displayed on Non Empty button matches total number of rows of table");
		super.addLog("Number of Groups displayed on Non Empty button matches total number of rows of table");
		log.info("RM_ValidateSearchNonEmptyGroups Test completed");
		super.addLog("RM_ValidateSearchNonEmptyGroups Test completed");
	}

	
	@Test(priority = 10, description ="Groups Search by Multiple buttons Verification")
	public void RM_ValidateSearchCombinedGroups() {
		super.addLog("RM_ValidateSearchCombinedGroups Test started");
		log.info("RM_ValidateSearchCombinedGroups Test started");
		super.addLog("Verify Groups Search by multiple buttons search Criteria");
		Assert.assertTrue(rmPage.SearchCombinedGroups(),
				"Number of Groups displayed on all selected button does not match total number of rows of table");			
		super.addLog("Verify number of Groups displayed on all selected button matches total number of rows of table");
		log.info("Verify number of Groups displayed on all selected button matches total number of rows of table");
		log.info("RM_ValidateSearchCombinedGroups Test completed");
		super.addLog("RM_ValidateSearchCombinedGroups Test completed");
	}
	
	@Test(priority = 11, description ="Groups names match search criteria")
	public void RM_ValidateSearchGroupNamesWithCriteria() {
		super.addLog("RM_ValidateSearchGroupNamesWithCriteria Test started");
		log.info("RM_ValidateSearchGroupNamesWithCriteria Test started");
		super.addLog("Verify Groups names match search criteria");
		Assert.assertTrue(rmPage.SearchGroupNamesWithCriteria(),
				"Names of Groups displayed does not match selected search criteria");			
		super.addLog("Verify names of Groups displayed matches selected search criteria");
		log.info("Verify names of Groups displayed matches selected search criteria");
		log.info("RM_ValidateSearchGroupNamesWithCriteria Test completed");
		super.addLog("RM_ValidateSearchGroupNamesWithCriteria Test completed");
	}
	
	@Test(priority = 12, description ="Search By Serial Number")
	public void RM_ValidateSearchBySerialNo() {
		super.addLog("RM_ValidateSearchBySerialNo Test started");
		log.info("RM_ValidateSearchBySerialNo Test started");
		super.addLog("Verify Search By Serial Number");
		Assert.assertTrue(rmPage.SearchBySerialNo(),
				"List of Serial Numbers displayed does not match selected search criteria");			
		super.addLog("Verify list of serial numbers displayed matches selected search criteria");
		log.info("Verify list of serial numbers displayed matches selected search criteria");
		log.info("RM_ValidateSearchBySerialNo Test completed");
		super.addLog("RM_ValidateSearchBySerialNo Test completed");
	}
	
	@Test(priority = 13, description ="Search By IP address")
	public void RM_ValidateSearchByIp() {
		super.addLog("RM_ValidateSearchGroupNamesWithCriteria Test started");
		log.info("RM_ValidateSearchGroupNamesWithCriteria Test started");
		super.addLog("Verify Groups names match search criteria");
		Assert.assertTrue(rmPage.SearchByIp(),
				"List of IP addresses displayed does not match selected search criteria");			
		super.addLog("Verify list of IP addresses displayed matches selected search criteria");
		log.info("Verify list of IP addresses displayed matches selected search criteria");
		log.info("RM_ValidateSearchGroupNamesWithCriteria Test completed");
		super.addLog("RM_ValidateSearchGroupNamesWithCriteria Test completed");
	}
	
	@Test(priority = 14, description ="Reset Search Criteria after clicking All button")
	public void RM_ValidateResetSearchwithAllBtn() {
		super.addLog("RM_ValidateResetSearchwithAllBtn Test started");
		log.info("RM_ValidateResetSearchwithAllBtn Test started");
		super.addLog("Verify Search is reset when All button is clicked");
		Assert.assertTrue(rmPage.ResetSearchwithAllBtn(),
				"Reset Search does not work");			
		super.addLog("Verify all search buttons are not highlighted when All button is clicked");
		log.info("Verify all search buttons are not highlighted when All button is clicked");
		log.info("RM_ValidateResetSearchwithAllBtn Test completed");
		super.addLog("RM_ValidateResetSearchwithAllBtn Test completed");
	}

	@Test(priority = 15, description ="Display of Online Groups")
	public void RM_ValidateOnlineGroups() {
		super.addLog("RM_ValidateOnlineGroups Test started");
		log.info("RM_ValidateOnlineGroups Test started");
		super.addLog("Verify groups shows are online only when Online button is clicked");
		Assert.assertTrue(rmPage.OnlineOfflineGroups(0),
				"Display of Online Groups does not work");			
		super.addLog("After Online button is clicked, only online groups are shown in green");
		log.info("After Online button is clicked, only online groups are shown in green");
		log.info("RM_ValidateOnlineGroups Test completed");
		super.addLog("RM_ValidateOnlineGroups Test completed");
	}
	
	@Test(priority = 16, description ="Display of Offline Groups")
	public void RM_ValidateOfflineGroups() {
		super.addLog("RM_ValidateOfflineGroups Test started");
		log.info("RM_ValidateOfflineGroups Test started");
		super.addLog("Verify groups shows are Offline only when Offline button is clicked");
		Assert.assertTrue(rmPage.OnlineOfflineGroups(1),
				"Display of Offline Groups does not work");			
		super.addLog("After Offline button is clicked, only Offline groups are shown in red");
		log.info("After Online button is clicked, only online groups are shown in green");
		log.info("RM_ValidateOfflineGroups Test completed");
		super.addLog("RM_ValidateOfflineGroups Test completed");
	}
	
	@Test(priority = 17, description ="Display of options on hovering on last column")
	public void RM_ValidateHoverOptions() {
		super.addLog("RM_ValidateHoverOptions Test started");
		log.info("RM_ValidateHoverOptions Test started");
		super.addLog("Verify display of options on hovering on last column");
		rmPage.HoverOptions();			
		super.addLog("On hovering on last column for online groups, 4 options are displayed");
		log.info("On hovering on last column for online groups, 4 options are displayed");
		log.info("RM_ValidateHoverOptions Test completed");
		super.addLog("RM_ValidateHoverOptions Test completed");
	}
	
	@Test(priority = 18, description ="Display of hovering options when all checkbox is selected")
	public void RM_ValidateHeaderHoverDisplay() {
		super.addLog("RM_ValidateHeaderHoverDisplay Test started");
		log.info("RM_ValidateHeaderHoverDisplay Test started");
		super.addLog("Verify display of options on hovering on header");
		Assert.assertTrue(rmPage.HeaderHoverDisplay(),
				"Display of options on hovering on header does not work");			
		super.addLog("On checking groups checkbox, 4 options are displayed in header");
		log.info("On checking groups checkbox, 4 options are displayed in header");
		log.info("RM_ValidateHeaderHoverDisplay Test completed");
		super.addLog("RM_ValidateHeaderHoverDisplay Test completed");
	}
	
	@Test(priority = 19, description ="Hovering on disabled checkbox")
	public void RM_ValidateNotOnboardedDevices() {
		super.addLog("RM_ValidateNotOnboardedDevices Test started");
		log.info("RM_ValidateNotOnboardedDevices Test started");
		super.addLog("Verify that hovering on disabled checkbox displays correct message");
		Assert.assertTrue(rmPage.NotOnboardedDevices(),
				"Hovering on disabled checkbox does not display message");			
		super.addLog("Device is not onboarded message displayed");
		log.info("Device is not onboarded message displayed");
		log.info("RM_ValidateNotOnboardedDevices Test completed");
		super.addLog("RM_ValidateNotOnboardedDevices Test completed");
	}
	
	@Test(priority = 20, description ="Verify scrolling in table")
	public void RM_ValidateScrollTable() {
		super.addLog("RM_ValidateScrollTable Test started");
		log.info("RM_ValidateScrollTable Test started");
		super.addLog("Verify that scrolling works in table");
		Assert.assertTrue(rmPage.ScrollTable(),
				"Scrolling does not work");			
		super.addLog("Scrolling works in table");
		log.info("Scrolling works in table");
		log.info("RM_ValidateScrollTable Test completed");
		super.addLog("RM_ValidateScrollTable Test completed");
	}
	
	@Test(priority = 21, description ="Group Sync")
	public void RM_GroupSync() {
		super.addLog("RM_GroupSync Test started");
		log.info("RM_GroupSync Test started");
		super.addLog("Verify that Group Sync works");
		Assert.assertTrue(rmPage.GroupSync(),
				"Alert confirmation is not displayed");			
		super.addLog("Sync Has Been Initiated Successfully for Group message appeared");
		log.info("Sync Has Been Initiated Successfully for Group message appeared");
		log.info("RM_GroupSync Test completed");
		super.addLog("RM_GroupSync Test completed");
	}
		
	@Test(priority = 22, description ="Sort By SW")
	public void RM_ValidateSortBySW() {
		super.addLog("RM_ValidateSortBySW Test started");
		log.info("RM_ValidateSortBySW Test started");
		rmPage.resetRMPage();
		Assert.assertTrue(rmPage.SpSortByGivenColumn(2),
				"Sorting by SW does not work");			
		super.addLog("Sorting by SW works");
		log.info("Sorting by SW works");
		log.info("RM_ValidateSortBySW Test completed");
		super.addLog("RM_ValidateSortBySW Test completed");
	}
	
	@Test(priority = 23, description ="Sort By ZTP")
	public void RM_ValidateSortByZTP() {
		super.addLog("RM_ValidateSortByZTP Test started");
		log.info("RM_ValidateSortByZTP Test started");
		Assert.assertTrue(rmPage.SortByGivenColumn(3),
				"Sorting by ZTP does not work");			
		super.addLog("Sorting by ZTP works");
		log.info("Sorting by ZTP works");
		log.info("RM_ValidateSortByZTP Test completed");
		super.addLog("RM_ValidateSortByZTP Test completed");
	}
	
	@Test(priority = 24, description ="Sort By Starlink")
	public void RM_ValidateSortByStarlink() {
		super.addLog("RM_ValidateSortByStarlink Test started");
		log.info("RM_ValidateSortByStarlink Test started");
		Assert.assertTrue(rmPage.SortByGivenColumn(4),
				"Sorting by Starlink does not work");			
		super.addLog("Sorting by Starlink works");
		log.info("Sorting by Starlink works");
		log.info("RM_ValidateSortByStarlink Test completed");
		super.addLog("RM_ValidateSortByStarlink Test completed");
	}
	
	@Test(priority = 25, description ="Sort By MSR")
	public void RM_ValidateSortByMSR() {
		super.addLog("RM_ValidateSortByMSR Test started");
		log.info("RM_ValidateSortByMSR Test started");
		Assert.assertTrue(rmPage.SortByGivenColumn(6),
				"Sorting by MSR does not work");			
		super.addLog("Sorting by MSR works");
		log.info("Sorting by MSR works");
		log.info("RM_ValidateSortByMSR Test completed");
		super.addLog("RM_ValidateSortByMSR Test completed");
	}
	
	@Test(priority = 26, description ="Sort By MacAdd")
	public void RM_ValidateSortByMacAdd() {
		super.addLog("RM_ValidateSortByMacAdd Test started");
		log.info("RM_ValidateSortByMacAdd Test started");
		Assert.assertTrue(rmPage.SortByGivenColumn(7),
				"Sorting by MacAdd does not work");			
		super.addLog("Sorting by MacAdd works");
		log.info("Sorting by MacAdd works");
		log.info("RM_ValidateSortByMacAdd Test completed");
		super.addLog("RM_ValidateSortByMacAdd Test completed");
	}
	
	@Test(priority = 27, description ="Sort By IP")
	public void RM_ValidateSortByIP() {
		super.addLog("RM_ValidateSortByIP Test started");
		log.info("RM_ValidateSortByIP Test started");
		Assert.assertTrue(rmPage.SpSortByGivenColumn(8),
				"Sorting by IP does not work");			
		super.addLog("Sorting by IP works");
		log.info("Sorting by IP works");
		log.info("RM_ValidateSortByIP Test completed");
		super.addLog("RM_ValidateSortByIP Test completed");
	}
	
	@Test(priority = 28, description ="Sort By Lockdown")
	public void RM_ValidateSortByLockdown() {
		super.addLog("RM_ValidateSortByLockdown Test started");
		log.info("RM_ValidateSortByLockdown Test started");
		Assert.assertTrue(rmPage.SortByGivenColumn(12),
				"Sorting by Lockdown does not work");			
		super.addLog("Sorting by Lockdown works");
		log.info("Sorting by Lockdown works");
		log.info("RM_ValidateSortByLockdown Test completed");
		super.addLog("RM_ValidateSortByLockdown Test completed");
	}
	
	@Test(priority = 29, description ="Sort By ModifiedDt")
	public void RM_ValidateSortByModifiedDt() {
		super.addLog("RM_ValidateSortByModifiedDt Test started");
		log.info("RM_ValidateSortByModifiedDt Test started");
		rmPage.resetRMPage();
		Assert.assertTrue(rmPage.SortByModifiedDateGivenCol(14),
				"Sorting by ModifiedDt does not work");			
		super.addLog("Sorting by ModifiedDt works");
		log.info("Sorting by ModifiedDt works");
		log.info("RM_ValidateSortByModifiedDt Test completed");
		super.addLog("RM_ValidateSortByModifiedDt Test completed");
	}
	
	@Test(priority = 30, description ="Sort By GoLiveDt")
	public void RM_ValidateSortByGoLiveDt() {
		super.addLog("RM_ValidateSortByGoLiveDt Test started");
		log.info("RM_ValidateSortByGoLiveDt Test started");
		Assert.assertTrue(rmPage.SortByGivenColumn(15),
				"Sorting by GoLiveDt does not work");			
		super.addLog("Sorting by GoLiveDt works");
		log.info("Sorting by GoLiveDt works");
		log.info("RM_ValidateSortByGoLiveDt Test completed");
		super.addLog("RM_ValidateSortByGoLiveDt Test completed");
	}

	
	@Test(priority = 31, description ="Capture Screenshot on Groups tab and confirm entries in Logs and Activity tabs")
	public void RM_CaptureScreenshot_LogsAndActivities() {
		super.addLog("RM_CaptureScreenshot_LogsAndActivities Test started");
		log.info("RM_CaptureScreenshot_LogsAndActivities Test started");
		super.addLog("Capture Screenshot on Groups tab and confirm entries in Logs and Activity tabs");
		Assert.assertTrue(rmPage.CaptureScreenshot_LogsAndActivities(),
				"Capture Screenshot on Groups tab and entries not present in Logs and Activity tabs");			
		super.addLog("Capture Screenshot on Groups tab and entries present in Logs and Activity tabs");
		log.info("Capture Screenshot on Groups tab and entries present in Logs and Activity tabs");
		log.info("RM_CaptureScreenshot_LogsAndActivities Test completed");
		super.addLog("RM_CaptureScreenshot_LogsAndActivities Test completed");
	}
	
	@Test(priority = 32, description ="PullManifest on Groups tab and confirm entries in Logs and Activity tabs")
	public void RM_PullManifest_LogsAndActivities() {
		super.addLog("RM_PullManifest_LogsAndActivities Test started");
		log.info("RM_PullManifest_LogsAndActivities Test started");
		super.addLog("PullManifest on Groups tab and confirm entries in Logs and Activity tabs");
		Assert.assertTrue(rmPage.PullManifest_LogsAndActivities(),
				"PullManifest on Groups tab and entries not present in Logs and Activity tabs");			
		super.addLog("PullManifest on Groups tab and entries present in Logs and Activity tabs");
		log.info("PullManifest on Groups tab and entries present in Logs and Activity tabs");
		log.info("RM_CaptureScreenshot_LogsAndActivities Test completed");
		super.addLog("RM_PullManifest_LogsAndActivities Test completed");
	}
	
	@Test(priority = 33, description ="Reboot on Groups tab and confirm entries in Logs and Activity tabs")
	public void RM_Reboot_LogsAndActivities() {
		super.addLog("RM_Reboot_LogsAndActivities Test started");
		log.info("RM_Reboot_LogsAndActivities Test started");
		super.addLog("Reboot on Groups tab and confirm entries in Logs and Activity tabs");
		Assert.assertTrue(rmPage.Reboot_LogsAndActivities(),
				"Reboot on Groups tab and entries not present in Logs and Activity tabs");			
		super.addLog("Reboot on Groups tab and entries present in Logs and Activity tabs");
		log.info("Reboot on Groups tab and entries present in Logs and Activity tabs");
		log.info("RM_Reboot_LogsAndActivities Test completed");
		super.addLog("RM_Reboot_LogsAndActivities Test completed");
	}
	
	@Test(priority = 34, description ="Script on Groups tab and confirm entries in Logs and Activity tabs")
	public void RM_Script_LogsAndActivities() {
		super.addLog("RM_Script_LogsAndActivities Test started");
		log.info("RM_Script_LogsAndActivities Test started");
		super.addLog("Script on Groups tab and confirm entries in Logs and Activity tabs");
		Assert.assertTrue(rmPage.Script_LogsAndActivities(),
				"Script on Groups tab and entries not present in Logs and Activity tabs");
		String s=prop.getProperty("Groupscriptname");
		rmPage.SMCleanup2(s);
		super.addLog("Script on Groups tab and entries present in Logs and Activity tabs");
		log.info("Script on Groups tab and entries present in Logs and Activity tabs");
		log.info("RM_Script_LogsAndActivities Test completed");
		super.addLog("RM_Script_LogsAndActivities Test completed");
	}

	//@Test(priority = 35, description ="Verify Site Sync with backend URL")
	public void RM_SiteSyncURL() {
		super.addLog("RM_SiteSyncURL Test started");
		log.info("RM_SiteSyncURL Test started");
		super.addLog("Verify Site Sync with backend URL");
		Assert.assertTrue(rmPage.SiteSyncURL(),
				"Site Sync does not tally with backend URL");
		super.addLog("Verify Site Sync with backend URL");
		log.info("Complete status for Screenshot,Pull Manifest,Reboot and Script in Logs and Activity tabs");
		log.info("RM_SiteSyncURL Test completed");
		super.addLog("RM_SiteSyncURL Test completed");
	}
	
	@Test(priority = 36, description ="Site Health Verification")
	public void RM_ValidateSiteHealth() {
	
		super.addLog("RM_ValidateSiteHealth Test started");
		log.info("RM_ValidateSiteHealth Test started");
		super.addLog("Verify SiteHealth");
		rmPage.SiteHealth();
		log.info("SiteHealth displayed correctly");
		log.info("RM_ValidateSiteHealth Test completed");
		super.addLog("RM_ValidateSiteHealth Test completed");
	}

	@Test(priority = 37, description ="Events Verification")
	public void RM_ValidateEvents() {
	
		super.addLog("RM_ValidateEvents Test started");
		log.info("RM_ValidateEvents Test started");
		super.addLog("Verify Events Data");
		Assert.assertTrue(rmPage.EventsDisplay(),
				"Events not displayed correctly");		
		log.info("Events displayed correctly");
		log.info("RM_ValidateEvents Test completed");
		super.addLog("RM_ValidateEvents Test completed");
	}
		
	@Test(priority = 38, description ="Logs Checkbox Verification")
	public void RM_ValidateLogsCheckbox() {
	
		super.addLog("RM_ValidateLogsCheckbox Test started");
		log.info("RM_ValidateLogsCheckbox Test started");
		super.addLog("Verify that selecting top checkbox selects all completed logs");
		Assert.assertTrue(rmPage.LogsCheckbox(),
				"Selecting top checkbox does not select all completed logs");
		log.info("Selecting top checkbox does selects all completed logs");
		log.info("RM_ValidateLogs Test completed");
		super.addLog("RM_ValidateLogs Test completed");
	}
	
	@Test(priority = 39, description ="Logs SearchByCategory Verification")
	public void RM_ValidateLogsSearchByCategory() {
	
		super.addLog("RM_ValidateLogsSearchByCategory Test started");
		log.info("RM_ValidateLogsSearchByCategory Test started");
		super.addLog("Verify Search by category works on logs page");
		Assert.assertTrue(rmPage.LogsSearch(0),
				"Search by category does not work on logs page");
		log.info("Search by category works on logs page");
		log.info("RM_ValidateLogsSearchByCategory Test completed");
		super.addLog("RM_ValidateLogsSearchByCategory Test completed");
	}
	
	@Test(priority = 40, description ="Logs SearchByMac Verification")
	public void RM_ValidateLogsSearchByMac() {
	
		super.addLog("RM_ValidateLogsSearchByMac Test started");
		log.info("RM_ValidateLogsSearchByMac Test started");
		super.addLog("Verify Search by MAC Address works on logs page");
		Assert.assertTrue(rmPage.LogsSearch(1),
				"Search by MAC Address does not work on logs page");
		log.info("Search by MAC Address works on logs page");
		log.info("RM_ValidateLogsSearchByMac Test completed");
		super.addLog("RM_ValidateLogsSearchByMac Test completed");
	}
	
	@Test(priority = 41, description ="Only completed logs show download icon")
	public void RM_ValidateCompletedLogsShowDownload() {
	
		super.addLog("RM_ValidateCompletedLogsShowDownload Test started");
		log.info("RM_ValidateCompletedLogsShowDownload Test started");
		super.addLog("Verify that only completed logs show download icon");
		Assert.assertTrue(rmPage.CompletedLogsShowDownload(),
				"Completed logs do not show download icon");
		log.info("Only completed logs show download icon");
		log.info("RM_ValidateCompletedLogsShowDownload Test completed");
		super.addLog("RM_ValidateCompletedLogsShowDownload Test completed");
	}
	
	@Test(priority = 42, description ="Download Log file")
	public void RM_ValidateDownloadLogfile() {
	
		super.addLog("RM_ValidateDownloadLogfile Test started");
		log.info("RM_ValidateDownloadLogfile Test started");
		super.addLog("Verify that log file is downloaded");
		Assert.assertTrue(rmPage.DownloadLogfile(),
				"Log file is not downloaded");
		log.info("Log file is downloaded");
		log.info("RM_ValidateDownloadLogfile Test completed");
		super.addLog("RM_ValidateDownloadLogfile Test completed");
	}
	
	@Test(priority = 43, description ="Script Manager Verification")
	public void RM_ValidateScriptManager() {
	
		super.addLog("RM_ValidateScriptManager Test started");
		log.info("RM_ValidateScriptManager Test started");
		super.addLog("Verify ScriptManager");
		Assert.assertTrue(rmPage.ScriptManager(),
				"ScriptManager not displayed ");
		log.info("ScriptManager displayed correctly");
		log.info("RM_ValidateScriptManager Test completed");
		super.addLog("RM_ValidateScriptManager Test completed");
	}
	
	@Test(priority = 44, description ="Trace logs Search by filename")
	public void RM_ValidateTraceLogsSearchByFileName() {
	
		super.addLog("RM_ValidateTraceLogsSearchByFileName Test started");
		log.info("RM_ValidateTraceLogsSearchByFileName Test started");
		super.addLog("Verify Trace logs Search by filename");
		Assert.assertTrue(rmPage.TraceLogsSearch(1),
				"Trace logs Search by filename does not work");
		log.info("Trace logs Search by filename works");
		log.info("RM_ValidateTraceLogsSearchByFileName Test completed");
		super.addLog("RM_ValidateTraceLogsSearchByFileName Test completed");
	}
	
	@Test(priority = 45, description ="Trace logs Search by MAC")
	public void RM_ValidateTraceLogsSearchByMAC() {
	
		super.addLog("RM_ValidateTraceLogsSearchByMAC Test started");
		log.info("RM_ValidateTraceLogsSearchByMAC Test started");
		super.addLog("Verify Trace logs Search by MAC");
		Assert.assertTrue(rmPage.TraceLogsSearch(0),
				"Trace logs Search by MAC does not work");
		log.info("Trace logs Search by MAC works");
		log.info("RM_ValidateTraceLogsSearchByMAC Test completed");
		super.addLog("RM_ValidateTraceLogsSearchByMAC Test completed");
	}
	
	
	@Test(priority = 46, description ="Trace logs download file")
	public void RM_ValidateTraceLogsDownload() {
	
		super.addLog("RM_ValidateTraceLogsDownload Test started");
		log.info("RM_ValidateTraceLogsDownload Test started");
		super.addLog("Verify TraceLogs");
		Assert.assertTrue(rmPage.TraceLogsDownload(),
				"Trace logs download file does not work");
		log.info("Trace logs  download file works");
		log.info("RM_ValidateTraceLogsDownload Test completed");
		super.addLog("RM_ValidateTraceLogsDownload Test completed");
	}
	
	@Test(priority = 47, description ="Trace logs view file")
	public void RM_ValidateTraceLogsViewFile() {
	
		super.addLog("RM_ValidateTraceLogsViewFile Test started");
		log.info("RM_ValidateTraceLogsViewFile Test started");
		super.addLog("Verify TraceLogs View File");
		Assert.assertTrue(rmPage.TraceLogsViewFile(),
				"Trace logs view file does not work");
		log.info("Trace logs  view file works");
		log.info("RM_ValidateTraceLogsViewFile Test completed");
		super.addLog("RM_ValidateTraceLogsViewFile Test completed");
	}
	
	@Test(priority = 48, description ="Trace logs display for Today")
	public void RM_ValidateTraceLogsToday() {
	
		super.addLog("RM_ValidateTraceLogsToday Test started");
		log.info("RM_ValidateTraceLogsToday Test started");
		super.addLog("Verify TraceLogs display for Today");
		Assert.assertTrue(rmPage.TraceLogsToday(),
				"Trace logs display for Today does not work");
		log.info("Trace logs display for Today works");
		log.info("RM_ValidateTraceLogsToday Test completed");
		super.addLog("RM_ValidateTraceLogsToday Test completed");
	}
	
	@Test(priority = 49, description ="Trace logs display for Last3Days")
	public void RM_ValidateTraceLogsLast3Days() {
	
		super.addLog("RM_ValidateTraceLogsLast3Days Test started");
		log.info("RM_ValidateTraceLogsLast3Days Test started");
		super.addLog("Verify TraceLogs display for Last3Days");
		Assert.assertTrue(rmPage.TraceLogsLastXDays(3),
				"Trace logs display for display for Last3Days does not work");
		log.info("Trace logs display for display for Last3Days works");
		log.info("RM_ValidateTraceLogsLast3Days Test completed");
		super.addLog("RM_ValidateTraceLogsLast3Days Test completed");
	}
	
	@Test(priority = 50, description ="Trace logs display for Last7Days")
	public void RM_ValidateTraceLogsLast7Days() {
	
		super.addLog("RM_ValidateTraceLogsLast7Days Test started");
		log.info("RM_ValidateTraceLogsLast7Days Test started");
		super.addLog("Verify TraceLogs display for Last7Days");
		Assert.assertTrue(rmPage.TraceLogsLastXDays(7),
				"Trace logs display for display for Last7Days does not work");
		log.info("Trace logs display for display for Last7Days works");
		log.info("RM_ValidateTraceLogsLast7Days Test completed");
		super.addLog("RM_ValidateTraceLogsLast7Days Test completed");
	}
	
	@Test(priority = 51, description ="Trace logs SortByMac")
	public void RM_ValidateTraceLogsSortByMac() {
	
		super.addLog("RM_ValidateTraceLogsSortByMac Test started");
		log.info("RM_ValidateTraceLogsSortByMac Test started");
		super.addLog("Verify TraceLogs SortByMac");
		Assert.assertTrue(rmPage.ValidateTraceLogsSortByGivenColumn(1),
				"Trace logs SortByMac does not work");
		log.info("Trace logs SortByMac works");
		log.info("RM_ValidateTraceLogsSortByMac Test completed");
		super.addLog("RM_ValidateTraceLogsSortByMac Test completed");
	}
	
	@Test(priority = 52, description ="Trace logs Sort By UploadDate")
	public void RM_ValidateTraceLogsSortByDate() {
	
		super.addLog("RM_ValidateTraceLogsSortByDate Test started");
		log.info("RM_ValidateTraceLogsSortByDate Test started");
		super.addLog("Verify TraceLogs  SortBy UploadDate");
		Assert.assertTrue(rmPage.SortByDateGivenCol(2),
				"Trace logs  SortBy UploadDate does not work");
		log.info("Trace logs  SortBy UploadDate works");
		log.info("RM_ValidateTraceLogsSortByDate Test completed");
		super.addLog("RM_ValidateTraceLogsSortByDate Test completed");
	}
	
	@Test(priority = 53, description ="Trace logs SortBy File Size")
	public void RM_ValidateTraceLogsSortBySize() {
	
		super.addLog("RM_ValidateTraceLogsSortBySize Test started");
		log.info("RM_ValidateTraceLogsSortBySize Test started");
		super.addLog("Verify TraceLogs SortBy File Size");
		Assert.assertTrue(rmPage.ValidateTraceLogsSortByGivenColumn(3),
				"Trace logs SortBy File Size does not work");
		log.info("Trace logs SortBy File Size works");
		log.info("RM_ValidateTraceLogsSortBySize Test completed");
		super.addLog("RM_ValidateTraceLogsSortBySize Test completed");
	}
	
	@Test(priority = 54, description ="Trace logs SortBy FileName")
	public void RM_ValidateTraceLogsSortByFileName() {
	
		super.addLog("RM_ValidateTraceLogsSortByFileName Test started");
		log.info("RM_ValidateTraceLogsSortByFileName Test started");
		super.addLog("Verify TraceLogs SortBy FileName");
		Assert.assertTrue(rmPage.ValidateTraceLogsSortByGivenColumn(4),
				"Trace logs SortBy FileName does not work");
		log.info("Trace logs SortBy FileName works");
		log.info("RM_ValidateTraceLogsSortByFileName Test completed");
		super.addLog("RM_ValidateTraceLogsSortByFileName Test completed");
	}
	
	@Test(priority = 55, description ="Mapped Content Verification")
	public void RM_ValidateMappedContent() {
	
		super.addLog("RM_ValidateMappedContent Test started");
		log.info("RM_ValidateMappedContent Test started");
		super.addLog("Verify MappedContent");
		Assert.assertTrue(rmPage.MappedContent(),
				"MappedContent not displayed ");
		log.info("MappedContent displayed correctly");
		log.info("RM_ValidateMappedContent Test completed");
		super.addLog("RM_ValidateMappedContent Test completed");
	}
	
	@Test(priority = 56, description ="Mapped Content Refresh")
	public void RM_ValidateMappedContentRefresh() {
	
		super.addLog("RM_ValidateMappedContentRefresh Test started");
		log.info("RM_ValidateMappedContentRefresh Test started");
		super.addLog("Verify MappedContent Refresh");
		Assert.assertTrue(rmPage.MappedContentRefresh(),
				"MappedContent Refresh is not working");
		log.info("MappedContent Refresh is working");
		log.info("RM_ValidateMappedContentRefresh Test completed");
		super.addLog("RM_ValidateMappedContentRefresh Test completed");
	}
	
	@Test(priority = 57, description ="Mapped Content Search by MAC")
	public void RM_ValidateMappedContentSearchbyMac() {
	
		super.addLog("RM_ValidateMappedContentSearchbyMac Test started");
		log.info("RM_ValidateMappedContentSearchbyMac Test started");
		super.addLog("Verify MappedContent Search by MAC");
		Assert.assertTrue(rmPage.MappedContentSearch(0),
				"MappedContent Search by MAC is not working");
		log.info("MappedContent Search by MAC is working");
		log.info("RM_ValidateMappedContentSearchbyMac Test completed");
		super.addLog("RM_ValidateMappedContentSearchbyMac Test completed");
	}
	
	@Test(priority = 58, description ="Mapped Content Search by IP")
	public void RM_ValidateMappedContentSearchbyIP() {
	
		super.addLog("RM_ValidateMappedContentSearchbyIP Test started");
		log.info("RM_ValidateMappedContentSearchbyIP Test started");
		super.addLog("Verify MappedContent Search by IP");
		Assert.assertTrue(rmPage.MappedContentSearch(1),
				"MappedContent Search by IP is not working");
		log.info("MappedContent Search by IP is working");
		log.info("RM_ValidateMappedContentSearchbyIP Test completed");
		super.addLog("RM_ValidateMappedContentSearchbyIP Test completed");
	}
	
	@Test(priority = 59, description ="Mapped Content View File")
	public void RM_ValidateMappedContentViewFile() {
	
		super.addLog("RM_ValidateMappedContentViewFile Test started");
		log.info("RM_ValidateMappedContentViewFile Test started");
		super.addLog("Verify MappedContent View File");
		Assert.assertTrue(rmPage.MappedContentViewFile(),
				"MappedContent View File is not working");
		log.info("MappedContent View File is working");
		log.info("RM_ValidateMappedContentViewFile Test completed");
		super.addLog("RM_ValidateMappedContentViewFile Test completed");
	}

	@Test(priority = 60, description ="Mapped Content Search by Group")
	public void RM_ValidateMappedContentSearchbyGroup() {
	
		super.addLog("RM_ValidateMappedContentSearchbyGroup Test started");
		log.info("RM_ValidateMappedContentSearchbyGroup Test started");
		super.addLog("Verify MappedContent Search by Group");
		Assert.assertTrue(rmPage.MappedContentSearchbyGroup(),
				"MappedContent Search by Group is not working");
		log.info("MappedContent Search by Group is working");
		log.info("RM_ValidateMappedContentSearchbyGroup Test completed");
		super.addLog("RM_ValidateMappedContentSearchbyGroup Test completed");
	}
	
	@Test(priority = 61, description ="Script Manager create new scheduled script")
	public void RM_ValidateSMCreateNewScript() {
	
		super.addLog("RM_ValidateSMCreateNewScript Test started");
		log.info("RM_ValidateSMCreateNewSCript Test started");
		super.addLog("Verify all steps of creating new script");
		
		rmPage.SMCreateNewScript();
		log.info("Script Manager create new scheduled script is working");
		log.info("RM_ValidateSMCreateNewSCript Test completed");
		super.addLog("RM_ValidateSMCreateNewScript Test completed");
	}
	
	@Test(priority = 62, description ="Script Manager View scheduled script")
	public void RM_ValidateSMViewScheduledScript() {
	
		super.addLog("RM_ValidateSMViewScheduledScript Test started");
		log.info("RM_ValidateSMViewScheduledScript Test started");
		super.addLog("Verify all steps to view script");
		Assert.assertTrue(rmPage.SMViewScheduledScript() ,
				"Script Manager View scheduled script is not working");
		log.info("Script Manager View scheduled script is working");
		log.info("RM_ValidateSMViewScheduledScript Test completed");
		super.addLog("RM_ValidateSMViewScheduledScript Test completed");
	}
	
	@Test(priority = 63, description ="Script Manager stop scheduled occurence")
	public void RM_ValidateSMStopStartOccurence() {
	
		super.addLog("RM_ValidateSMStopStartOccurence Test started");
		log.info("RM_ValidateSMStopStartOccurence Test started");
		super.addLog("Verify all steps for stopping and starting scheduled occurence");
		Assert.assertTrue(rmPage.SMStopStartOccurence(),
				"Script Manager stop & start scheduled occurence is not working");
		log.info("RM_ValidateSMStopStartOccurence Test completed");
		super.addLog("RM_ValidateSMStopStartOccurence Test completed");
	}
	
	
	@Test(priority = 64, description ="Script Manager download scheduled script")
	public void RM_ValidateSMDownloadScheduledScript() {
	
		super.addLog("RM_ValidateSMDownloadScheduledScript Test started");
		log.info("RM_ValidateSMDownloadScheduledScript Test started");
		super.addLog("Verify all steps for downloading scheduled script");
		Assert.assertTrue(rmPage.SMDownloadScheduledScript(),
				"Script Manager download scheduled script is not working");
		log.info("Script Manager download scheduled script is working");
		log.info("RM_ValidateSMDownloadScheduledScript Test completed");
		super.addLog("RM_ValidateSMDownloadScheduledScript Test completed");
	}
	
	@Test(priority = 65, description ="Script Manager delete scheduled script")
	public void RM_ValidateSMDeleteScheduledScript() {
	
		super.addLog("RM_ValidateSMDeleteScheduledScript Test started");
		log.info("RM_ValidateSMDeleteScheduledScript Test started");
		super.addLog("Verify all steps for deleting scheduled script");
		Assert.assertTrue(rmPage.SMDeleteScheduledScript(),
				"Script Manager delete scheduled script is not working");
		String s=prop.getProperty("scheduledscriptname");
		rmPage.SMCleanup2(s);
		log.info("Script Manager delete scheduled script is working");
		log.info("RM_ValidateSMDeleteScheduledScript Test completed");
		super.addLog("RM_ValidateSMDeleteScheduledScript Test completed");
	}
	
	@Test(priority = 66, description ="Script Manager Multiple ScheduledScripts Select")
	public void RM_ValidateSMMultipleScheduledScriptsSelect() {
	
		super.addLog("RM_ValidateSMDeleteScheduledScript Test started");
		log.info("RM_ValidateSMDeleteScheduledScript Test started");
		super.addLog("Verify all steps for  Multiple ScheduledScripts Select");
		Assert.assertTrue(rmPage.SMMultipleScriptsSelect(0),
				"Script Manager  Multiple ScheduledScripts Select is not working");
		log.info("Script ManagerMultiple ScheduledScripts Select is working");
		log.info("RM_ValidateSMDeleteScheduledScript Test completed");
		super.addLog("RM_ValidateSMDeleteScheduledScript Test completed");
	}
	
	@Test(priority = 67, description ="Script Manager create new non-scheduled script")
	public void RM_ValidateSMCreateNewNonScheduledScript() {
	
		super.addLog("RM_ValidateSMCreateNewNonScheduledScript Test started");
		log.info("RM_ValidateSMCreateNewNonScheduledScript Test started");
		super.addLog("Verify all steps of creating new script");
		rmPage.SMCreateNewNonScheduledScript();
		log.info("Script Manager create new non scheduled script is working");
		log.info("RM_ValidateSMCreateNewNonScheduledScript Test completed");
		super.addLog("RM_ValidateSMCreateNewNonScheduledScript Test completed");
	}
	
	@Test(priority = 68, description ="Script Manager Search script")
	public void RM_ValidateSMSearchScript() {
	
		super.addLog("RM_ValidateSMSearchScript Test started");
		log.info("RM_ValidateSMSearchScript Test started");
		super.addLog("Verify all steps for searching script");
		Assert.assertTrue(rmPage.SMSearchScript(),
				"Script Manager Search script is not working");
		log.info("Script Manager Search script is working");
		log.info("RM_ValidateSMSearchScript Test completed");
		super.addLog("RM_ValidateSMSearchScript Test completed");
	}
	
	@Test(priority = 69, description ="Script Manager download script")
	public void RM_ValidateSMDownloadScript() {
	
		super.addLog("RM_ValidateSMDownloadScript Test started");
		log.info("RM_ValidateSMDownloadScript Test started");
		super.addLog("Verify all steps for downloading script");
		Assert.assertTrue(rmPage.SMDownloadScript(),
				"Script Manager download script is not working");
		log.info("Script Manager download script is working");
		log.info("RM_ValidateSMDownloadScript Test completed");
		super.addLog("RM_ValidateSMDownloadScript Test completed");
	}
	
	@Test(priority = 70, description ="Script Manager BookMark Script")
	public void RM_BookMarkScript() {
	
		super.addLog("RM_BookMarkScript Test started");
		log.info("RM_BookMarkScript Test started");
		super.addLog("Verify all steps for  BookMark Script");
		Assert.assertTrue(rmPage.BookMarkScript(),
				"Script Manager  BookMark Script is not working");
		log.info("Script Manager  BookMark Script is working");
		log.info("RM_BookMarkScript Test completed");
		super.addLog("RM_BookMarkScript Test completed");
	}
	
	@Test(priority = 71, description ="Script Manager delete script")
	public void RM_ValidateSMDeleteScript() {
	
		super.addLog("RM_ValidateSMDeleteScript Test started");
		log.info("RM_ValidateSMDeleteScript Test started");
		super.addLog("Verify all steps of deleting script");
		Assert.assertTrue(rmPage.SMDeleteScript(),
				"Script Manager delete script is not working");
		
		log.info("Script Manager delete script is working");
		log.info("RM_ValidateSMDeleteScript Test completed");
		super.addLog("RM_ValidateSMDeleteScript Test completed");
	}
	
	@Test(priority = 72, description ="Script Manager MultipleScriptsSelect")
	public void RM_ValidateSMMultipleScriptsSelect() {
	
		super.addLog("RM_ValidateSMMultipleScriptsSelect Test started");
		log.info("RM_ValidateSMMultipleScriptsSelect Test started");
		super.addLog("Verify all steps of MultipleScriptsSelect");
		Assert.assertTrue(rmPage.SMMultipleScriptsSelect(1),
				"Script Manager MultipleScriptsSelect is not working");
		
		log.info("Script Manager MultipleScriptsSelect is working");
		log.info("RM_ValidateSMMultipleScriptsSelect Test completed");
		super.addLog("RM_ValidateSMMultipleScriptsSelect Test completed");
	}
	
	@Test(priority = 73, description ="Script Manager Duplicate ScriptName")
	public void RM_ValidateDuplicateSScriptName() {
	
		super.addLog("RM_ValidateDuplicateSScriptName Test started");
		log.info("RM_ValidateDuplicateSScriptName Test started");
		super.addLog("Verify all steps for Duplicate ScriptName");
		Assert.assertTrue(rmPage.DuplicateSScriptName(),
				"Script Manager Duplicate ScriptName is not working");
		log.info("Script Manager Duplicate ScriptName is working");
		log.info("RM_ValidateDuplicateSScriptName Test completed");
		super.addLog("RM_ValidateDuplicateSScriptName Test completed");
	}
	
	@Test(priority = 74, description ="Script Manager UploadLogo")
	public void RM_ValidateUploadLogo() {
	
		super.addLog("RM_ValidateUploadLogo Test started");
		log.info("RM_ValidateUploadLogo Test started");
		super.addLog("Verify all steps of Script Manager UploadLogo");
		Assert.assertTrue(rmPage.UploadLogo(),
				"Script Manager UploadLogo is not working");
		log.info("Script Manager UploadLogo is working");
		log.info("RM_ValidateUploadLogo Test completed");
		super.addLog("RM_ValidateUploadLogo Test completed");
	}
	
	@Test(priority = 75, description ="Script Manager ScriptDescription Size")
	public void RM_ValidateScriptDescriptionSize() {
	
		super.addLog("RM_ValidateScriptDescriptionSize Test started");
		log.info("RM_ValidateScriptDescriptionSize Test started");
		super.addLog("Verify ScriptDescription Size error when entering more than 1000 characters");
		Assert.assertTrue(rmPage.ScriptDescriptionSize(),
				"Script Manager ScriptDescription Size is not working");
		log.info("RM_ValidateScriptDescriptionSize Test completed");
		super.addLog("RM_ValidateScriptDescriptionSize Test completed");
	}
	
	@Test(priority = 76, description ="Script Manager ScriptDeletion Sequence")
	public void RM_ValidateScriptDeletionSequence() {
	
		super.addLog("RM_ValidateSMDeleteScript Test started");
		log.info("RM_ValidateSMDeleteScript Test started");
		super.addLog("Verify all steps of deleting script");
		Assert.assertTrue(rmPage.ScriptDeletionSequence(),
				"Script Manager delete script is not working");
		String s=prop.getProperty("deletescript");
		rmPage.SMCleanup(s);
		rmPage.SMCleanup2(s);
		log.info("Script Manager delete script is working");
		log.info("RM_ValidateSMDeleteScript Test completed");
		super.addLog("RM_ValidateSMDeleteScript Test completed");
	}
	
	@Test(priority = 77, description ="Activity page: Verify data with database")
	public void RM_ValidateActivityDatawithDB() {
	
		super.addLog("RM_ValidateActivityDatawithDB Test started");
		log.info("RM_ValidateActivityDatawithDB Test started");
		super.addLog("Verify all rows on activity page as per database");
		rmPage.ValidateActivityDatawithDB();
		log.info("Activity page: Verify data with database is working");
		log.info("RM_ValidateActivityDatawithDB Test completed");
		super.addLog("RM_ValidateActivityDatawithDB Test completed");
	}
	
	@Test(priority = 78, description ="Activity page: Verify data with database")
	public void RM_ValidateActivityDatawithDB7Days() {
	
		super.addLog("RM_ValidateActivityDatawithDB7Days Test started");
		log.info("RM_ValidateActivityDatawithDB7Days Test started");
		super.addLog("Verify all rows on activity page as per databse");
		rmPage.ValidateActivityDatawithDB1();
		log.info("Activity page: Verify data with database is working");
		log.info("RM_ValidateActivityDatawithDB7Days Test completed");
		super.addLog("RM_ValidateActivityDatawithDB7Days Test completed");
	}
	
	@Test(priority = 79, description ="Activity page: Search By Mac Address")
	public void RM_ValidateActivitySearchByMac() {
	
		super.addLog("RM_ValidateActivitySearchByMac Test started");
		log.info("RM_ValidateActivitySearchByMac Test started");
		super.addLog("Verify Search By Mac Address");
		Assert.assertTrue(rmPage.ActivitySearchByMac(),
				"Activity page: Search By Mac Address is not working");
		log.info("Activity page: Search By Mac Address is working");
		log.info("RM_ValidateActivitySearchByMac Test completed");
		super.addLog("RM_ValidateActivitySearchByMac Test completed");
	}
	
	@Test(priority = 80, description ="Activity page: SearchByGroup()")
	public void RM_ValidateActivitySearchByGroup() {
	
		super.addLog("RM_ValidateActivitySearchByGroup Test started");
		log.info("RM_ValidateActivitySearchByGroup Test started");
		super.addLog("Verify SearchByGroup()");
		Assert.assertTrue(rmPage.ActivitySearchByGroup(),
				"Activity page: SearchByGroup is not working");
		log.info("Activity page: SearchByGroup is working");
		log.info("RM_ValidateActivitySearchByGroup Test completed");
		super.addLog("RM_ValidateActivitySearchByGroup Test completed");
	}
	
	@Test(priority = 81, description ="Activity page: Screenshot download")
	public void RM_ValidateActivityClickCompScreenShot() {
	
		super.addLog("RM_ValidateActivityClickCompScreenShot Test started");
		log.info("RM_ValidateActivityClickCompScreenShot Test started");
		super.addLog("Verify that Screenshot can be downloaded for completed Capture ScreenShot activity");
		Assert.assertTrue(rmPage.ActivityClickCompScreenShot(),
				"Activity page: Screenshot download is not working");
		log.info("Activity page: Screenshot download is working");
		log.info("RM_ValidateActivityClickCompScreenShot Test completed");
		super.addLog("RM_ValidateActivityClickCompScreenShot Test completed");
	}
	
	@Test(priority = 82, description ="Activity page: Upload Device Package Manifest download")
	public void RM_ValidateActivityClickCompPkgManifest() {
	
		super.addLog("RM_ValidateActivityClickCompPkgManifest Test started");
		log.info("RM_ValidateActivityClickCompPkgManifest Test started");
		super.addLog("Verify that Upload Device Package Manifest can be downloaded for completed Pull Manifest activity");
		Assert.assertTrue(rmPage.ActivityClickCompPkgManifestAndScript(0),
				"Activity page: Upload Device Package Manifest download is not working");
		log.info("Activity page:Upload Device Package Manifest download is working");
		log.info("RM_ValidateActivityClickCompPkgManifest Test completed");
		super.addLog("RM_ValidateActivityClickCompPkgManifest Test completed");
	}
	
	@Test(priority = 83, description ="Activity page: Complete Script")
	public void RM_ValidateActivityClickCompletedScript() {
	
		super.addLog("RM_ValidateActivityClickCompletedScript Test started");
		log.info("RM_ValidateActivityClickCompletedScript Test started");
		super.addLog("Verify that Complete Script can be downloaded for completed Script");
		Assert.assertTrue(rmPage.ActivityClickCompPkgManifestAndScript(1),
				"Activity page:Complete Script download is not working");
		log.info("Activity page:Complete Script download is working");
		log.info("RM_ValidateActivityClickCompletedScript Test completed");
		super.addLog("RM_ValidateActivityClickCompletedScript Test completed");
	}
	
	@Test(priority = 84, description ="Activity page: Sort By Today")
	public void RM_ValidateActivitySortByToday() {
	
		super.addLog("RM_ValidateActivitySortByToday Test started");
		log.info("RM_ValidateActivitySortByToday Test started");
		super.addLog("Verify Sort By Today data in table");
		Assert.assertTrue(rmPage.ActivityLastXDays(0),
				"Activity page:Sort By Today is not working");
		log.info("Activity page:Sort By Today works");
		log.info("RM_ValidateActivitySortByToday Test completed");
		super.addLog("RM_ValidateActivitySortByToday Test completed");
	}
	
	@Test(priority = 85, description ="Activity page: Sort By Last 7 days")
	public void RM_ValidateActivitySortByL7Days() {
	
		super.addLog("RM_ValidateActivitySortByL7Days Test started");
		log.info("RM_ValidateActivitySortByL7Days Test started");
		super.addLog("Verify Sort By Last 7 days data in table");
		Assert.assertTrue(rmPage.ActivityLastXDays(7),
				"Activity page:Sort By Last 7 days is not working");
		log.info("Activity page:Sort By Last 7 days works");
		log.info("RM_ValidateActivitySortByL7Days Test completed");
		super.addLog("RM_ValidateActivitySortByL7Days Test completed");
	}
	
	@Test(priority = 86, description ="Activity page: Sort By Last 14 days")
	public void RM_ValidateActivitySortByL14Days() {
	
		super.addLog("RM_ValidateActivitySortByL14Days Test started");
		log.info("RM_ValidateActivitySortByL14Days Test started");
		super.addLog("Verify Sort By Last 30 days data in table");
		Assert.assertTrue(rmPage.ActivityLastXDays(14),
				"Activity page:Sort By Last 14 days is not working");
		log.info("Activity page:Sort By Last 14 days works");
		log.info("RM_ValidateActivitySortByL14Days Test completed");
		super.addLog("RM_ValidateActivitySortByL14Days Test completed");
	}
	
	@Test(priority = 87, description ="Activity page: Sort By Last 30 days")
	public void RM_ValidateActivitySortByL30Days() {
	
		super.addLog("RM_ValidateActivitySortByL30Days Test started");
		log.info("RM_ValidateActivitySortByL30Days Test started");
		super.addLog("Verify Sort By Last 30 days data in table");
		Assert.assertTrue(rmPage.ActivityLastXDays(30),
				"Activity page:Sort By Last 30 days is not working");
		log.info("Activity page:Sort By Last 30 days works");
		log.info("RM_ValidateActivitySortByL30Days Test completed");
		super.addLog("RM_ValidateActivitySortByL30Days Test completed");
	}
	
	@Test(priority = 88, description ="Activity page: Sort By Last 90 days")
	public void RM_ValidateActivitySortByL90Days() {
	
		super.addLog("RM_ValidateActivitySortByL90Days Test started");
		log.info("RM_ValidateActivitySortByL90Days Test started");
		super.addLog("Verify Sort By Last 90 days data in table");
		Assert.assertTrue(rmPage.ActivityLastXDays(90),
				"Activity page:Sort By Last 90 days is not working");
		log.info("Activity page:Sort By Last 90 days works");
		log.info("RM_ValidateActivitySortByL90Days Test completed");
		super.addLog("RM_ValidateActivitySortByL90Days Test completed");
	}
	
	@Test(priority = 89, description ="Activity page: Sort By Status")
	public void RM_ValidateActivitySortByStatus() {
	
		super.addLog("RM_ValidateActivitySortByStatus Test started");
		log.info("RM_ValidateActivitySortByStatus Test started");
		super.addLog("Verify Sort By Status data in table");
		Assert.assertTrue(rmPage.ValidateActivitySortByStatus(),
				"Activity page:Sort By Status is not working");
		log.info("Activity page:Sort By Status works");
		log.info("RM_ValidateActivitySortByStatus Test completed");
		super.addLog("RM_ValidateActivitySortByStatus Test completed");
	}
	
	@Test(priority = 90, description ="Activity page: Sort By Date")
	public void RM_ValidateActivitySortByDate() {
	
		super.addLog("RM_ValidateActivitySortByDate Test started");
		log.info("RM_ValidateActivitySortByDate Test started");
		super.addLog("Verify Sort By Date data in table");
		Assert.assertTrue(rmPage.ActivitySortByDateGivenCol(),
				"Activity page:Sort By Date is not working");
		log.info("Activity page:Sort By Date works");
		log.info("RM_ValidateActivitySortByDate Test completed");
		super.addLog("RM_ValidateActivitySortByDate Test completed");
	}
	@AfterClass
	public void logout() {
		
		loginPage = homePage.Logout();
		Assert.assertTrue(loginPage.validateMainLogoImage(),
				"Unable to log out successfully");
		log.info("Logged out successfully");
		driver.quit();
	}

}