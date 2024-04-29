//This is QR code test page
//@author : Praggati Oswal
package ztp.qa.testcases;
import java.util.Base64;
import org.testng.Assert;
import org.testng.annotations.*;
import ztp.qa.base.TestBase;
import ztp.qa.pages.*;
import ztp.qa.util.*;

public class QRTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	SupportToolsPage supportToolsPage;
	WatcherPage watcherPage;
	QRCodePage qrCodePage;
	
	public QRTest() {
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
		qrCodePage = supportToolsPage.GotoQRCodePage();
		Assert.assertTrue(qrCodePage.VerifyQRPage(),"Unable to load QR code page");
		log.info("On QR Code page");
		qrCodePage.QRCodeCreation();
		TestUtil.sleep(2000);
		Assert.assertTrue(qrCodePage.verifyQRImage(),"Unable to create QR code");
		log.info("QR Code image created");
	}


	@Test(priority = 1, description ="QR Code Download")
	public void QR_ValidateDownloadQRImage() {
	
		super.addLog("QR_ValidateDownloadQRImage Test started");
		log.info("QR_ValidateDownloadQRImage Test started");
		super.addLog("Download QR code qr-code.png file");
		Assert.assertTrue(qrCodePage.DownloadQRImage(1),
				"QR Code downloaded not working");
		log.info("QR Code downloaded");
		log.info("QR_ValidateDownloadQRImage Test completed");
		super.addLog("QR_ValidateDownloadQRImage Test completed");
	}

	@Test(priority = 2, description ="QR Code Print")
	public void QR_ValidatePrintQRImage() {
	
		super.addLog("QR_ValidatePrintQRImage Test started");
		log.info("QR_ValidatePrintQRImage Test started");
		super.addLog("Click on QR Code print button");
		Assert.assertTrue(qrCodePage.PrintQRImage(1),
				"QR Print page not found");
		
		log.info("QR Print page found");
		log.info("QR_ValidatePrintQRImage Test completed");
		super.addLog("QR_ValidatePrintQRImage Test completed");
	}

	@Test(priority = 3, description ="QR Code Download")
	public void QR_ValidateDownloadQRImageNew() {
	
		super.addLog("QR_ValidateDownloadQRImageNew Test started");
		log.info("QR_ValidateDownloadQRImageNew Test started");
		super.addLog("Download QR code qr-code.png file for New ZTP");
		Assert.assertTrue(qrCodePage.DownloadQRImage(2),
				"QR Code downloaded not working  for New ZTP");
		log.info("QR Code downloaded  for New ZTP");
		log.info("QR_ValidateDownloadQRImageNew Test completed");
		super.addLog("QR_ValidateDownloadQRImageNew Test completed");
	}
	
	@Test(priority = 4, description ="QR Code Print")
	public void QR_ValidatePrintQRImageNew() {
		
		super.addLog("QR_ValidatePrintQRImageNew Test started");
		log.info("QR_ValidatePrintQRImageNew Test started");
		super.addLog("Click on QR Code print button  for New ZTP");
		Assert.assertTrue(qrCodePage.PrintQRImage(2),
				"QR Print page not found  for New ZTP");	
		log.info("QR Print page found for New ZTP");
		log.info("QR_ValidatePrintQRImageNew Test completed");
		super.addLog("QR_ValidatePrintQRImageNew Test completed");
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