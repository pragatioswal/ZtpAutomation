//This is POS plugin test page
//@author : Praggati Oswal
package ztp.qa.testcases;
import java.util.Base64;
import org.testng.Assert;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import ztp.qa.base.TestBase;
import ztp.qa.pages.*;

public class POSTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	SupportToolsPage supportToolsPage;
	WatcherPage watcherPage;
	POSPage posPage;
	QRCodePage qrCodePage;
	ExtentReports report;
	ExtentTest test;
	
	
	public POSTest() {
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
		
		posPage = supportToolsPage.GotoPOSPage();
		Assert.assertTrue(posPage.VerifyPOSPage(),"Unable to load POS plugin page");
		log.info("On POS page");
		
	}


	@Test(priority = 1, description ="Checks POS information")
	public void POS_ValidatePOSInformation() {
		
		super.addLog("POS_ValidatePOSInformation Test started");
		log.info("POS_ValidatePOSInformation Test started");
		Assert.assertTrue(posPage.POSSystemNameVersion(1),"POS Information not displayed");
		log.info("POS information  present");
		log.info("POS_ValidatePOSInformation Test completed");
		super.addLog("POS_ValidatePOSInformation Test completed");
	}

	@Test(priority = 2, description ="Checks Agent Version")
	public void POS_ValidateAgentVersion() {

		super.addLog("POS_ValidateAgentVersion Test started");
		log.info("POS_ValidateAgentVersion Test started");
		Assert.assertTrue(posPage.POSSystemNameVersion(2),"Agent Version not displayed");
		log.info("Agent Version  present");
		log.info("POS_ValidateAgentVersion Test completed");
		super.addLog("POS_ValidateAgentVersion Test completed");
	}

	@Test(priority = 3, description ="Checks Plugin Version")
	public void POS_ValidatePluginVersion() {

		super.addLog("POS_ValidatePluginVersion Test started");
		log.info("POS_ValidatePluginVersion Test started");
		Assert.assertTrue(posPage.POSSystemNameVersion(3),"Agent Version not displayed");
		log.info("Plugin Version  present");
		log.info("POS_ValidatePluginVersion Test completed");
		super.addLog("POS_ValidatePluginVersion Test completed");
	}

	@Test(priority = 4, description ="Checks Plugin Features")
	public void POS_ValidatePosFeatures() {

		super.addLog("POS_ValidatePosFeatures Test started");
		log.info("POS_ValidatePosFeatures Test started");
		posPage.PosFeatures();
		log.info("Plugin Version  present");
		log.info("POS_ValidatePosFeatures Test completed");
		super.addLog("POS_ValidatePosFeatures Test completed");
	}

	@Test(priority = 5, description ="Checks Agent Health parameters")
	public void POS_ValidateAgentHealth() {

		super.addLog("POS_ValidateAgentHealth Test started");
		log.info("POS_ValidateAgentHealth Test started");
		posPage.AgentHealth();
		log.info("Agent Health paramters displayed");
		log.info("POS_ValidateAgentHealth Test completed");
		super.addLog("POS_ValidateAgentHealth Test completed");
	}
	
	@Test(priority = 6, description ="Checks GetRVCList parameters")
	public void POS_ValidateGetRVCList() {

		super.addLog("POS_ValidateGetRVCList Test started");
		log.info("POS_ValidateGetRVCList Test started");
		Assert.assertTrue(posPage.GetRVCList(),"GetRVCList parameters not displayed");
		log.info("GetRVCList parameters displayed");
		log.info("POS_ValidateGetRVCList Test completed");
		super.addLog("POS_ValidateGetRVCList Test completed");
	}
	
	@Test(priority = 7, description ="Checks GetMenuItems paramters")
	public void POS_ValidateGetMenuItems() {

		super.addLog("POS_ValidateGetMenuItems Test started");
		log.info("POS_ValidateGetMenuItems Test started");
		posPage.POSGetMenuItems();
		log.info("GetMenuItems parameters displayed");
		log.info("POS_ValidateGetMenuItems Test completed");
		super.addLog("POS_ValidateGetMenuItems Test completed");
	}
	
	@Test(priority = 8, description ="Checks Open Agent Config paramters")
	public void POS_ValidateOpenAgentConfig() {

		super.addLog("POS_ValidateOpenAgentConfig Test started");
		log.info("POS_ValidateOpenAgentConfig Test started");
		posPage.OpenAgentConfig();
		log.info("Open Agent Config parameters displayed");
		log.info("POS_ValidateOpenAgentConfig Test completed");
		super.addLog("POS_ValidateOpenAgentConfig Test completed");
	}

	@Test(priority = 9, description ="Error messaage is dislayed on entering empty Open Agent Config parameter")
	public void POS_ValidateOpenAgentEmptyValue() {

		super.addLog("POS_ValidateOpenAgentEmptyValue Test started");
		log.info("POS_ValidateOpenAgentEmptyValue Test started");
		Assert.assertTrue(posPage.OpenAgentEmptyValue(),
				"Error message is not dislayed on entering empty Open Agent Config parameter");
		log.info("Error message is dislayed on entering empty Open Agent Config parameter");
		log.info("POS_ValidateOpenAgentEmptyValue Test completed");
		super.addLog("POS_ValidateOpenAgentEmptyValue Test completed");
	}

	@Test(priority = 10, description ="Update Settings for Open Agent Config")
	public void POS_ValidateOpenAgentUpdateSettings() {

		super.addLog("POS_ValidateOpenAgentUpdateSettings Test started");
		log.info("POS_ValidateOpenAgentUpdateSettings Test started");
		Assert.assertTrue(posPage.OpenAgentUpdateSettings(),
				"Update Settings for Open Agent Config does not work");
		log.info("Update Settings for Open Agent Config works");
		log.info("POS_ValidateOpenAgentUpdateSettings Test completed");
		super.addLog("POS_ValidateOpenAgentUpdateSettings Test completed");
	}

	@Test(priority = 11, description ="Checks Service Config paramters")
	public void POS_ValidateServiceConfig() {

		super.addLog("POS_ValidateServiceConfig Test started");
		log.info("POS_ValidateServiceConfig Test started");
		posPage.ServiceConfig();
		log.info("Service Config parameters displayed");
		log.info("POS_ValidateServiceConfig Test completed");
		super.addLog("POS_ValidateServiceConfig Test completed");
	}
	
	@Test(priority = 12, description ="Error messaage is dislayed on entering empty Service Config parameter")
	public void POS_ValidateServiceEmptyValue() {

		super.addLog("POS_ValidateServiceEmptyValue Test started");
		log.info("POS_ValidateServiceEmptyValue Test started");
		Assert.assertTrue(posPage.ServiceEmptyValue(),
				"Error message is not dislayed on entering empty Service Config parameter");
		log.info("Error message is dislayed on entering empty Service Config parameter");
		log.info("POS_ValidateServiceEmptyValue Test completed");
		super.addLog("POS_ValidateServiceEmptyValue Test completed");
	}

	
	@Test(priority = 13, description ="Update Settings for Service Config")
	public void POS_ValidateServiceUpdateSettings() {

		super.addLog("POS_ValidateServiceUpdateSettings Test started");
		log.info("POS_ValidateServiceUpdateSettings Test started");
		Assert.assertTrue(posPage.ServiceUpdateSettings(),
				"Update Settings for Service Config does not work");
		log.info("Update Settings for Service Config works");
		log.info("POS_ValidateServiceUpdateSettings Test completed");
		super.addLog("POS_ValidateServiceUpdateSettings Test completed");
	}
	
	@Test(priority = 14, description ="Update Settings for Service Config")
	public void POS_ValidateGetOpenTables() {

		super.addLog("POS_ValidateGetOpenTables Test started");
		log.info("POS_ValidateGetOpenTables Test started");
		posPage.GetOpenTables();
		log.info("Get Open Table values match values from API call");
		log.info("POS_ValidateGetOpenTables Test completed");
		super.addLog("POS_ValidateGetOpenTables Test completed");
	}
	
	@AfterClass
	public void logout() {
		loginPage = homePage.Logout();
		Assert.assertTrue(loginPage.validateMainLogoImage());
		log.info("Logged out successfully");
		driver.quit();
	}
}