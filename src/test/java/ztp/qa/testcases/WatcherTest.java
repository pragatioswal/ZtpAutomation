//This is watcher clients test page
//@author : Praggati Oswal
package ztp.qa.testcases;
import java.util.Base64;
import java.util.Optional;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v122.network.Network;
import org.testng.Assert;
import org.testng.annotations.*;
import ztp.qa.base.TestBase;
import ztp.qa.pages.*;
import ztp.qa.util.*;

public class WatcherTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	SupportToolsPage supportToolsPage;
	WatcherPage watcherPage;
	public static String Authorization;
	public WatcherTest() {
		super();
	}

	@BeforeClass
	public void starttest() {
		
		initialization();
		loginPage = new LoginPage();
		String pwd = prop.getProperty("password");
		byte[] decrypt = Base64.getDecoder().decode(pwd);
		homePage = loginPage.login(prop.getProperty("username"),new String(decrypt) );
		Assert.assertTrue(homePage.validateSPLabel(), "Unable to load homepage");
		supportToolsPage = homePage.RMSearch();
		Assert.assertTrue(supportToolsPage.ValidateWatcherClientImg());
		log.info("On Support Tools page");
		//Add a devtool object to get the request header to capture the authorization code dynamically
		DevTools devTool =  driver.getDevTools();		
		devTool.createSession();
		devTool.send(Network.enable(Optional.empty(), Optional.empty(),Optional.empty()));
		devTool.addListener(Network.requestWillBeSent(), requestSent -> {
			if(requestSent.getRequest().getUrl().equals("https://restwatcherclient-test.azurewebsites.net/api/v1/"
					+ "getservices/8643470052?CurrentPage=1&PageSize=10") 
					&& requestSent.getRequest().getHeaders().toString().contains("Authorization=")) {
					String reqHeader= requestSent.getRequest().getHeaders().toString();
					Authorization = reqHeader.split("Authorization=")[1].trim().split(",")[0].trim();
			}
		});
		watcherPage = supportToolsPage.GotoWatcherClient();
		Assert.assertTrue(watcherPage.ValidateServicesTablePopulated(), "Services not found");
	}

	
	@Test(priority = 1, description ="Checks all services displayed match the services from API call")
	public void Wat_ValidateAllService() {

		super.addLog("Wat_ValidateAllService Test started");
		log.info("Wat_ValidateAllService Test started");
		Assert.assertTrue(watcherPage.AllService(Authorization),
				"All table value for services do not match the api calls data");
		log.info("All table value for services match the api calls data");
		log.info("Wat_ValidateAllService Test completed");
		super.addLog("Wat_ValidateAllService Test completed");
	}
	
	@Test(priority = 2, description ="Checks Start to Stop functionality works for service")
	public void Wat_ValidateStartToStopService() {

		super.addLog("Wat_ValidateStartToStopService Test started");
		log.info("Wat_ValidateStartToStopService Test started");
		int i = watcherPage.FindFirstStoppedService();	
		Assert.assertTrue(watcherPage.StartToStopServiceFuncationality(i),
				"Start to Stop does not work for service");
		log.info("Start to Stop works for service");
		log.info("Wat_ValidateStartToStopService Test completed");
		super.addLog("Wat_ValidateStartToStopService Test completed");
	}

	@Test(priority = 3, description ="Checks Restart functionality works for service")
	public void Wat_ValidateRestartService() {

		super.addLog("Wat_ValidateRestartService Test started");
		log.info("Wat_ValidateRestartService Test started");
		int i = watcherPage.FindFirstRunningService();
		Assert.assertTrue(watcherPage.RestartServiceFuncationality(i),
				"Restart functionality does not work for service");
		log.info("Restart functionality works for service");
		log.info("Wat_ValidateRestartService Test completed");
		super.addLog("Wat_ValidateRestartService Test completed");
	}

	@Test(priority = 4, description ="Checks Stop to start functionality works for service")
	public void Wat_ValidateStopToStartService() {

		super.addLog("Wat_ValidateStopToStartService Test started");
		log.info("Wat_ValidateStopToStartService Test started");
		int i = watcherPage.FindFirstRunningService();
		Assert.assertTrue(watcherPage.StopToStartServiceFuncationality(i),
				"Stop to start does not work for service");
		log.info("Stop to start works for service");
		log.info("Wat_ValidateStopToStartService Test completed");
		super.addLog("Wat_ValidateStopToStartService Test completed");
	}

	@Test(priority = 5, description ="Sorts by Display Name on Service Tab")
	public void Wat_ValidateSortByDisplayName() {
		super.addLog("Wat_ValidateSortByDisplayName Test started");
		log.info("Wat_ValidateSortByDisplayName Test started");
		Assert.assertTrue(watcherPage.SortByCategory(1),
				"Sort by Display Name does not work");
		log.info("Sort by Display Name works");
		log.info("Wat_ValidateSortByDisplayName Test completed");
		super.addLog("Wat_ValidateSortByDisplayName Test completed");
	}

	@Test(priority = 6, description ="Checks Total number of dislayed services")
	public void Wat_ValidateTotalNoOfServices() {
		super.addLog("Wat_ValidateTotalNoOfServices Test started");
		log.info("Wat_ValidateTotalNoOfServices Test started");
		Assert.assertTrue(watcherPage.ConfirmTotalNoOfServices(),
				"Total number of dislayed services does not matchcount");
		log.info("Total number of dislayed services matches count");
		log.info("Wat_ValidateTotalNoOfServices Test completed");
		super.addLog("Wat_ValidateTotalNoOfServices Test completed");
	}

	@Test(priority = 7, description ="Next Page Functionality")
	public void Wat_ValidateNextPage() {
		super.addLog("Wat_ValidateNextPage Test started");
		log.info("Wat_ValidateNextPage Test started");
		Assert.assertTrue(watcherPage.ClickNextBtn(),
				"Next Page Functionality does not work");
		log.info("Next Page Functionality works");
		log.info("Wat_ValidateNextPage Test completed");
		super.addLog("Wat_ValidateNextPage Test completed");
	}

	@Test(priority = 8, description ="Previous Page Functionality")
	public void Wat_ValidatePreviousPage() {
		super.addLog("Wat_ValidatePreviousPage Test started");
		log.info("Wat_ValidatePreviousPage Test started");
		Assert.assertTrue(watcherPage.ClickPreviousBtn(),
				"Previous Page Functionality does not work");
		log.info("Previous Page Functionality works");
		log.info("Wat_ValidatePreviousPage Test completed");
		super.addLog("Wat_ValidatePreviousPage Test completed");
	}

	@Test(priority = 9, description ="Refresh Services Functionality")
	public void Wat_ValidateRefreshServices() {
		super.addLog("Wat_ValidateRefreshServices Test started");
		log.info("Wat_ValidateRefreshServices Test started");
		Assert.assertTrue(watcherPage.ClickRefreshLink("Services"),
				"Refresh Services Functionality does not work");
		log.info("Refresh Services Functionality works");
		log.info("Wat_ValidateRefreshServices Test completed");
		super.addLog("Wat_ValidateRefreshServices Test completed");
	}

	@Test(priority = 10, description ="4 Ziosk Service loaded on Watcher Client page")
	public void Wat_ValidateSearchZioskServices() {

		super.addLog("Wat_ValidateSearchZioskServices Test started");
		log.info("Wat_ValidateSearchZioskServices Test started");
		TestUtil.sleep(5000);
		log.info("Services loaded on Watcher Client page");
		Assert.assertTrue(watcherPage.SearchZioskServices(),
				"4 Ziosk Service not loaded on Watcher Client page");
		log.info("4 Ziosk Service loaded on Watcher Client page");
		log.info("Wat_ValidateSearchZioskServices Test completed");
		super.addLog("Wat_ValidateSearchZioskServices Test completed");
	}

	@Test(priority = 11, description ="Stop and start button is disabled for Ziosk Online Ordering Bridge Service")
	public void Wat_ValidateZOOBServiceStopStartDisabled() {

		super.addLog("Wat_ValidateZOOBServiceStopStartDisabled Test started");
		log.info("Wat_ValidateZOOBServiceStopStartDisabled Test started");
		Assert.assertTrue(watcherPage.ZOOBServiceStopDisabled(),
				"Stop and start button is disabled for Ziosk Online Ordering Bridge Service");
		log.info("Stop and start button is disabled for Ziosk Online Ordering Bridge Service");
		log.info("Wat_ValidateZOOBServiceStopStartDisabled Test completed");
		super.addLog("Wat_ValidateZOOBServiceStopStartDisabled Test completed");
	}

	@Test(priority = 12, description ="Items per Page displayed: 5,10,25 and 100")
	public void Wat_ValidateItemsPerPageFunctionality() {

		super.addLog("Wat_ValidateItemsPerPageFunctionality Test started");
		log.info("Wat_ValidateItemsPerPageFunctionality Test started");
		Assert.assertTrue(watcherPage.ItemsPerPageFunctionality(),
				"Items per Page displayed incorrectly for 5,10,25 or 100");
		log.info("Items per Page displayed correctly for 5,10,25 and 100");
		log.info("Wat_ValidateItemsPerPageFunctionality Test completed");
		super.addLog("Wat_ValidateItemsPerPageFunctionality Test completed");

	}

	@Test(priority = 13, description ="Sorts by Service Name on Services Tab")
	public void Wat_ValidateSortByServiceName() {
		
		super.addLog("Wat_ValidateSortByServiceName Test started");
		log.info("Wat_ValidateSortByServiceName Test started");
		Assert.assertTrue(watcherPage.SortByCategory(3),
				"Sort by Service Name does not work");
		log.info("Sort by Service Name works");
		log.info("Wat_ValidateSortByServiceName Test completed");
		super.addLog("Wat_ValidateSortByServiceName Test completed");
	}

	@Test(priority = 14, description ="Sorts by Status on services tab")
	public void Wat_ValidateSortByStatus() {
		
		super.addLog("Wat_ValidateSortByStatus Test started");
		log.info("Wat_ValidateSortByStatus Test started");
		Assert.assertTrue(watcherPage.SortByCategory(2),"Sort by Status does not work");
		log.info("Sort by Status works");
		log.info("Wat_ValidateSortByStatus Test completed");
		super.addLog("Wat_ValidateSortByStatus Test completed");
	}

	@Test(priority = 15, description ="Verify all data displayed on Process tab matches API calls")
	public void Wat_ValidateAllProcess() {
		
		super.addLog("Wat_ValidateAllProcess Test started");
		log.info("Wat_ValidateAllProcess Test started");
		Assert.assertTrue(watcherPage.ValidateAllProcess(Authorization),
				"All data displayed on Process tab does not match API calls");
		log.info("All data displayed on Process tab matches API calls");
		log.info("Wat_ValidateAllProcess Test completed");
		super.addLog("Wat_ValidateAllProcess Test completed");
	}
	
	@Test(priority = 16, description ="Sorts by Process name on Process tab")
	public void Wat_ValidateSortByProcessName() {
		
		super.addLog("Wat_ValidateSortByProcessName Test started");
		log.info("Wat_ValidateSortByProcessName Test started");
		Assert.assertTrue(watcherPage.SortByProcessName(),
				"Sort by Process name does not work on Process Page");
		log.info("Sort by Process name works on Process Page");
		log.info("Wat_ValidateSortByProcessName Test completed");
		super.addLog("Wat_ValidateSortByProcessName Test completed");
	}

	@Test(priority = 17, description ="Refresh Processes Functionality")
	public void Wat_ValidateRefreshProcesses() {
	
		super.addLog("Wat_ValidateRefreshProcesses Test started");
		log.info("Wat_ValidateRefreshProcesses Test started");
		Assert.assertTrue(watcherPage.ClickRefreshLink("Processes"),
				"Refresh Processes Functionality doe not work");
		log.info("Refresh Processes Functionality works");
		log.info("Wat_ValidateRefreshProcesses Test completed");
		super.addLog("Wat_ValidateRefreshProcesses Test completed");
	}

	@Test(priority = 18, description ="4 Ziosk Processes on Watcher Client page")
	public void Wat_ValidateSearchZioskProcesses() {

		super.addLog("Wat_ValidateSearchZioskProcesses Test started");
		log.info("Wat_ValidateSearchZioskProcesses Test started");
		log.info("Services loaded on Watcher Client page");
		Assert.assertTrue(watcherPage.SearchZioskProcesses(),
				"4 Ziosk Processes not loaded on Watcher Client page");
		log.info("4 Ziosk Processes loaded on Watcher Client page");
		log.info("Wat_ValidateSearchZioskProcesses Test completed");
		super.addLog("Wat_ValidateSearchZioskProcesses Test completed");
	}

	@Test(priority = 19, description ="Switch between Services, Processes and Files tabs")
	public void Wat_ValidateSwitchingBetTabs() {
		
		super.addLog("Wat_ValidateSwitchingBetTabs Test started");
		log.info("Wat_ValidateSwitchingBetTabs Test started");
		Assert.assertTrue(watcherPage.SwitchingBetTabs(),
				"Switching between Services, Processes and Files tabs does not work");
		log.info("Switching between Services, Processes and Files tabs works");
		log.info("Wat_ValidateSwitchingBetTabs Test completed");
		super.addLog("Wat_ValidateSwitchingBetTabs Test completed");
	}

	@Test(priority = 20, description ="Verify all data displayed on files tab matches API calls")
	public void Wat_ValidateAllFiles() {
		
		super.addLog("Wat_ValidateAllProcess Test started");
		log.info("Wat_ValidateAllProcess Test started");
		Assert.assertTrue(watcherPage.ValidateAllFiles(Authorization),
				"All data displayed on files tab does not match API calls");
		log.info("All data displayed on files tab matches API calls");
		log.info("Wat_ValidateAllProcess Test completed");
		super.addLog("Wat_ValidateAllProcess Test completed");
	}

	@Test(priority = 21, description ="Color Coding of files a per size in Files tab")
	public void Wat_ValidateFileSize() {
		
		super.addLog("Wat_ValidateFileSize Test started");
		log.info("Wat_ValidateFileSize Test started");
		Assert.assertTrue(watcherPage.TraverseFiles(),
				"Files are not color coded correctly as per size");
		log.info("Files are color coded correctly in Files tabs");
		log.info("Wat_ValidateFileSize Test completed");
		super.addLog("Wat_ValidateFileSize Test completed");
	}

	@Test(priority = 22, description ="Download feature for Files tab")
	public void Wat_ValidateDownloadFile() {
	
		super.addLog("Wat_ValidateDownloadFile Test started");
		log.info("Wat_ValidateDownloadFile Test started");
		Assert.assertTrue(watcherPage.DownloadFile(),
				"Download feature does not work for Files tab");
		log.info("Download feature works for Files tab");
		log.info("Wat_ValidateDownloadFile Test completed");
		super.addLog("Wat_ValidateDownloadFile Test completed");
	}
	
	@Test(priority = 23, description ="Expand All feature for Files tab")
	public void Wat_ValidateExpandAll() {
		
		super.addLog("Wat_ValidateExpandAll Test started");
		log.info("Wat_ValidateExpandAll Test started");
		Assert.assertTrue(watcherPage.ExpandAllFiles(),
				"Expand All feature does not work for Files tab");
		log.info("Expand All feature works for Files tab");
		log.info("Wat_ValidateExpandAll Test completed");
		super.addLog("Wat_ValidateExpandAll Test completed");
	}

	
	@Test(priority = 24, description ="Switch between pages using Tool dropdown")
	public void Wat_ValidateSwitchBetPageswithTool() {
	
		super.addLog("Wat_ValidateSwitchBetPageswithTool Test started");
		log.info("Wat_ValidateSwitchBetPageswithTool Test started");
		Assert.assertTrue(watcherPage.SwitchBetPageswithTool(),
				"Switch between pages using Tool dropdown does not work");
		log.info("Switch between pages using Tool dropdown works");
		log.info("Wat_ValidateSwitchBetPageswithTool Test completed");
		super.addLog("Wat_ValidateSwitchBetPageswithTool Test completed");
	}
	
		
	@Test(priority = 25, description ="Switching between stores from top page dropdown")
	public void Wat_ValidateSwitchStore() {
	
		super.addLog("Wat_ValidateSwitchStore Test started");
		log.info("Wat_ValidateSwitchStore Test started");
		Assert.assertTrue(watcherPage.SwitchStore(),
				"Switching between stores does not work");
		log.info("Switching between stores from top page dropdown works");
		log.info("Wat_ValidateSwitchStore Test completed");
		super.addLog("Wat_ValidateSwitchStore Test completed");
	}
	@Test(priority = 26, description ="Backward Navigate from Watcher client")
	public void Wat_ValidateBackwardNavigate() {
	
		super.addLog("Wat_ValidateBackwardNavigate Test started");
		log.info("Wat_ValidateBackwardNavigate Test started");
		Assert.assertTrue(watcherPage.BackwardNavigate(),
				"Backward Navigate from Watcher client does not work");
		log.info("Backward Navigate from Watcher client works");
		log.info("Wat_ValidateBackwardNavigate Test completed");
		super.addLog("Wat_ValidateBackwardNavigate Test completed");
	}

	
	@AfterClass
	public void logout() {
		loginPage = homePage.Logout();
		Assert.assertTrue(loginPage.validateMainLogoImage(),
				"Not logged out successfully");
		log.info("Logged out successfully");
		driver.quit();

	}

}
