//This is POS Plugin Tester page for support portal
//@author : Praggati Oswal
package ztp.qa.pages;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import ztp.qa.base.TestBase;
import ztp.qa.util.TestUtil;

public class POSPage extends TestBase {

	// Page Factory - OR:

	@FindBy(xpath = "//mat-select[@aria-label='Items per page:']")
	WebElement DropDownNoOfServices;
	
	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'100')]")
	WebElement NoOfService100;
	
	@FindAll({ @FindBy(xpath = "//span[contains(@class,'mat-select-min-line')]") })
	List<WebElement> Dropdowns;
	
	@FindAll({ @FindBy(xpath = "//li") })
	List<WebElement> posSettings;
	
	@FindBy(xpath = "//table//tr//td[1]")
	WebElement SystemName;
	
	@FindBy(xpath = "//table//tr//td[2]")
	WebElement SystemVersion;
	
	@FindBy(xpath = "//mat-select//span[contains(@class,'mat-select-min-line')]")
	WebElement CurrentTool;
	
	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'RM Portal')]")
	WebElement Tool_RMPortal;
	
	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'Watcher Client')]")
	WebElement Tool_WatcherClient;
	
	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'POS Tester')]")
	WebElement Tool_POSTester;
	
	@FindBy(xpath = "//span[contains(@class,'mat-option-text') and contains(text(),'QR Code')]")
	WebElement Tool_QRCode;

	@FindAll({ @FindBy(xpath = "//tr/td") })
	List<WebElement> posFeatures;
	
	@FindAll({ @FindBy(xpath = "//table//th") })
	List<WebElement> openTableHeaders;
	
	@FindAll({ @FindBy(xpath = "//div[contains(@class,'health-container')]//span") })
	List<WebElement> AgentHealthTagNames;
	
	@FindAll({ @FindBy(xpath = "//div[contains(@class,'health-container')]//span/following-sibling::div") })
	List<WebElement> AgentHealthTagValues;
	
	@FindAll({ @FindBy(xpath = "//div[contains(@class,'health-container')]") })
	List<WebElement> AgentHealthBlocks;

	@FindAll({ @FindBy(xpath = "//input[@data-placeholder='Enter Key']") })
	List<WebElement> OpenAgentKeys;
	
	@FindAll({ @FindBy(xpath = "//input[@data-placeholder='Enter Value']") })
	List<WebElement> OpenAgentValues;
	
	@FindAll({ @FindBy(xpath = "//button") })
	List<WebElement> AllButtons;
	
	@FindBy(xpath = "//p/div")
	WebElement AlertMsg;
	
	@FindBy(xpath = "//span[@class='mat-button-wrapper' and text()='Yes']")
	WebElement YesBtn;
	
	@FindBy(xpath = "//div[@class='err']")
	WebElement ErrorMsg;
	
	@FindBy(xpath = "//simple-snack-bar/span")
	
	WebElement SystemMsg;
	public static String ServiceURL;
	public static String baseURL ="https://restposagenttester-test.azurewebsites.net/api/v1/";
	public static String siteID = prop.getProperty("siteID");
	SoftAssert softAssert = new SoftAssert(); 
	
	// Initializing the Page Objects:
	public POSPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean VerifyPOSPage() {
		super.addLog("Verify POS page is displayed correctly");
    	log.info("Verify POS page is displayed correctly");
		waitForElementContentToDisplay(posSettings.get(0),10);
		return posSettings.get(0).getText().equals("POS Information");	
	}

	/**
	 * This function validates the system name and version with API calls for the various page of POS depending on the parameter passed
	 * @param i 
	 * 1 : POS_ValidatePOSInformation
	 * 2 : POS_ValidateAgentVersion
	 * 3 : POS_ValidatePluginVersion
	 * 
	 * @return true if values match the values returned by API calls
	 */
	public boolean POSSystemNameVersion(int i) {
		boolean b=false; 
		waitForElementContentToDisplay(posSettings.get(i-1),20);
		clickIt(posSettings.get(i-1));
		waitForElementContentToDisplay(SystemName,20);
		super.addLog("Connect with the backend for API data");
		log.info("Connect with the backend for API data");
		if(i==1)
			RestAssured.baseURI = baseURL + "posinformation/" + siteID;
		else if(i==2)
			RestAssured.baseURI = baseURL + "posagentversion/" + siteID;
		else if(i==3)
			RestAssured.baseURI = baseURL + "pluginversion/" + siteID;
			
		Response response =RestAssured.given().when().get();
		JsonPath js = response.jsonPath();
		String RI_SystemName = js.get("result.systemName");
		String RI_SystemVersion = js.get("result.systemVersion");
	//	System.out.println("$$$$$$$$$$$$$$$$$$$$$"+RI_SystemName+"$$$$$$$$$$$$$$$$$$$$$"+RI_SystemVersion);
		super.addLog("Check System Name and Version values match with API calls");
		log.info("Check System Name and Version values match with API calls");
		if(SystemName.getText().equals(RI_SystemName) && SystemVersion.getText().equals(RI_SystemVersion))
			b=true;	
		return b;
	}

	/**
	 * This function selects watcher from the tools drops downs
	 * @return watcher page
	 */
	public WatcherPage POStoWatcher() {
		waitForElementToDisplay(CurrentTool, 10);
		waitForVisibilityOf(CurrentTool, 10);
		super.addLog("Click on WatcherClient on tool");
		log.info("Click on WatcherClient on tool");
		clickIt(CurrentTool);
		waitForVisibilityOf(Tool_WatcherClient, 10);
		clickIt(Tool_WatcherClient);
		return new WatcherPage();
	}

	/**
	 * This function validates all the rows in POS Features table match the values from API call
	 */
	public void PosFeatures() {
		
		String RI_SystemName,RI_SystemVersion;
		super.addLog("Click on POS Features link");
		log.info("Click on POS Features link");
		waitForElementContentToDisplay(posSettings.get(3),10);
		clickIt(posSettings.get(3));
		waitForElementContentToDisplay(SystemName,20);
		TestUtil.sleep(2000);
		
		super.addLog("Select 100 for items per page");
		log.info("Select 100 for items per page");

		waitForelementToBeClickable(DropDownNoOfServices, 10);
		clickIt(DropDownNoOfServices);
		waitForVisibilityOf(NoOfService100, 10);
		clickIt(NoOfService100);
		super.addLog("Connect with the backend for API data");
		log.info("Connect with the backend for API data");
		RestAssured.baseURI = baseURL + "posfeatures/" + siteID;
		Response response =RestAssured.given().when().get();
	//	System.out.println(response.asString());
		JsonPath js = response.jsonPath();
		String initName = "result.featureList.name[";
		String initVersion = "result.featureList.version[";
		String end = "]";
		int i=0;
		int j=0;
		while(i<posFeatures.size()){
			RI_SystemName = js.getString(initName+j+end);
			
			RI_SystemVersion = js.getString(initVersion+j+end);
			//System.out.println(RI_SystemName + "******************" + posFeatures.get(i).getText());
			super.addLog("Verify value of " + RI_SystemName + " with value from API call");
			log.info("Verify value of " + RI_SystemName + " with value from API call");
			softAssert.assertTrue(posFeatures.get(i).getText().equals(RI_SystemName),"Value does not match for "+RI_SystemName);
			softAssert.assertTrue(posFeatures.get(i+1).getText().equals(RI_SystemVersion),"Value does not match for "+RI_SystemName);
		//	System.out.println(RI_SystemVersion + "******************" + posFeatures.get(i+1).getText());
			i=i+2;
			j=j+1;
		}
		softAssert.assertAll(); 
	}

	/**
	 * This function converts the date from yyyy-MM-dd HH:mm:ss format to MM/dd/yy hh:mm a
	 * @param string 
	 * @return date in MM/dd/yy hh:mm a format
	 */
	public String ChangeDateFormat(String s) {
		String changedDate="";
		Date date;
		String format = "yyyy-MM-dd HH:mm:ss";
		String targetformat = "MM/dd/yy hh:mm a";
	    SimpleDateFormat utcFormatter = new SimpleDateFormat(format);
	    utcFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
	    if(!s.equals("0001-01-01T00:00:00")) {
		    try {
		    	date = utcFormatter.parse(s.replace("T", " ").split("\\+")[0].trim());
		    	 SimpleDateFormat estFormatter = new SimpleDateFormat(targetformat);
		 	    estFormatter.setTimeZone(TimeZone.getTimeZone("EST"));
	
		 	    changedDate= estFormatter.format(date);
		 	    return changedDate;
		    }catch(Exception e) {
				System.out.println("Confirmation alert not displayed");
			}
	    }
	    return changedDate;
	}
	
	/**
	 * This function validates all the rows in AgentHealth table match the values from API call
	 */
	public void AgentHealth() {
		super.addLog("Click on Agent Health link");
		log.info("Click on Agent Health link");

		waitForElementContentToDisplay(posSettings.get(4),10);
		clickIt(posSettings.get(4));
		TestUtil.sleep(2000);
		waitForElementContentToDisplay(AgentHealthTagNames.get(0),20);
		int n=AgentHealthBlocks.size();
		super.addLog("Connect with the backend for API data");
		log.info("Connect with the backend for API data");
		RestAssured.baseURI = baseURL + "posagenthealth/" + siteID;
		Response response =RestAssured.given().when().get();
	//	System.out.println(response.asString());
		JsonPath js = response.jsonPath();
		String initName1 = "result.operations.operation[";
		String initName2 = "result.operations.lastRequest[";
		String initName3 = "result.operations.requestCount[";
		String initName4 = "result.operations.lastError[";
		String initName5 = "result.operations.errorCount[";
		String initName6 = "result.operations.lastErrorMessage[";
		String initName7 = "result.operations.failureRate[";
		
		String end = "]";
		
		super.addLog("Check whether Agent Health parameters appear as expected");
		log.info("Check whether Agent Health parameters appear as expected");	
		
		String p0 = js.getString("result.agentStarted");
		String cp0 = ChangeDateFormat(p0);
		softAssert.assertTrue(AgentHealthTagValues.get(0).getText().equals(cp0),"Agent Started does not match");
		
		String p1 = js.getString("result.lastRequest");
		String cp1 = ChangeDateFormat(p1);
		softAssert.assertTrue(AgentHealthTagValues.get(1).getText().equals(cp1),"lastRequest does not match");
		
		String p2 = js.getString("result.requestCount");
		softAssert.assertTrue(AgentHealthTagValues.get(2).getText().equals(p2),"Request count does not match");
		
		String p3 = js.getString("result.lastError");
		String cp3 = ChangeDateFormat(p3);
		softAssert.assertTrue(AgentHealthTagValues.get(3).getText().equals(cp3),"last error does not match");
		
		String p4 = js.getString("result.errorCount");
		softAssert.assertTrue(AgentHealthTagValues.get(4).getText().equals(p4),"Error count does not match");
		
		String p6 = js.getString("result.failureRate");
		softAssert.assertTrue(AgentHealthTagValues.get(6).getText().equals(p6),"Failure rate count does not match");
		
		for(int i=1;i<n;i++)
		{	
			String RI_Value1 = js.getString(initName1+(i-1)+end);
			String RI_Value2 = js.getString(initName2+(i-1)+end);
			String RI_Value3 = js.getString(initName3+(i-1)+end);
			String RI_Value4 = js.getString(initName4+(i-1)+end);
			String RI_Value5 = js.getString(initName5+(i-1)+end);
			String RI_Value6 = js.getString(initName6+(i-1)+end);
			String RI_Value7 = js.getString(initName7+(i-1)+end);
			super.addLog("Verify values for Block " + i + " with value from API call");
			super.addLog("Verify values for Block " + i + " with value from API call");
			super.addLog("Verify value of " + AgentHealthTagNames.get(7*i).getText() + " with value from API call");
			log.info("Verify value of " + AgentHealthTagNames.get(7*i).getText() + " with value from API call");
			softAssert.assertTrue(AgentHealthTagValues.get(7*i).getText().equals(RI_Value1),
					"Value does not match for "+AgentHealthTagNames.get(7*i).getText());
			
			super.addLog("Verify value of " + AgentHealthTagNames.get(7*i+1).getText() + " with value from API call");
			log.info("Verify value of " + AgentHealthTagNames.get(7*i+1).getText() + " with value from API call");
			softAssert.assertTrue(AgentHealthTagValues.get(7*i+1).getText().equals(ChangeDateFormat(RI_Value2)),
					"Value does not match for "+AgentHealthTagNames.get(7*i+1).getText());
			
			super.addLog("Verify value of " + AgentHealthTagNames.get(7*i+2).getText() + " with value from API call");
			log.info("Verify value of " + AgentHealthTagNames.get(7*i+2).getText() + " with value from API call");
			softAssert.assertTrue(AgentHealthTagValues.get(7*i+2).getText().equals(RI_Value3),
					"Value does not match for "+AgentHealthTagNames.get(7*i+2).getText());
			
			super.addLog("Verify value of " + AgentHealthTagNames.get(7*i+3).getText() + " with value from API call");
			log.info("Verify value of " + AgentHealthTagNames.get(7*i+3).getText() + " with value from API call");
			softAssert.assertTrue(AgentHealthTagValues.get(7*i+3).getText().equals(ChangeDateFormat(RI_Value4)),
					"Value does not match for "+AgentHealthTagNames.get(7*i+3).getText());
			
			super.addLog("Verify value of " + AgentHealthTagNames.get(7*i+4).getText() + " with value from API call");
			log.info("Verify value of " + AgentHealthTagNames.get(7*i+4).getText() + " with value from API call");
			softAssert.assertTrue(AgentHealthTagValues.get(7*i+4).getText().equals(RI_Value5),
					"Value does not match for "+AgentHealthTagNames.get(7*i+4).getText());
			
			super.addLog("Verify value of " + AgentHealthTagNames.get(7*i+6).getText() + " with value from API call");
			log.info("Verify value of " + AgentHealthTagNames.get(7*i+6).getText() + " with value from API call");
			softAssert.assertTrue(AgentHealthTagValues.get(7*i+6).getText().equals(RI_Value7),
					"Value does not match for "+AgentHealthTagNames.get(7*i+6).getText());
			
			super.addLog("Verify value of " + AgentHealthTagNames.get(7*i+5).getText() + " with value from API call");
			log.info("Verify value of " + AgentHealthTagNames.get(7*i+5).getText() + " with value from API call");
			if(RI_Value6==null)
				softAssert.assertTrue(AgentHealthTagValues.get(7*i+5).getText().equals("- - -"),
						"Value does not match for "+AgentHealthTagNames.get(7*i+5).getText());
			else
				softAssert.assertTrue(AgentHealthTagValues.get(7*i+5).getText().equals(RI_Value6),
						"Value does not match for "+AgentHealthTagNames.get(7*i+5).getText());
			/*	System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			//System.out.println(AgentHealthTagValues.get(7*i).getText() + "**************" + RI_Value1);
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<"+AgentHealthTagValues.get(7*i+1).getText()+ "**************" + ChangeDateFormat(RI_Value2)+"<<<<<<<<<<<<<<<<<<<<<<<<");
			//System.out.println(AgentHealthTagValues.get(7*i+2).getText()+ "**************" + RI_Value3);
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<"+AgentHealthTagValues.get(7*i+3).getText()+ "**************" + ChangeDateFormat(RI_Value4)+"<<<<<<<<<<<<<<<<<<<<<<<<");
			//System.out.println(AgentHealthTagValues.get(7*i+4).getText()+ "**************" + RI_Value5);
			//System.out.println(AgentHealthTagValues.get(7*i+5).getText()+ "**************" + RI_Value6);
			//System.out.println(AgentHealthTagValues.get(7*i+6).getText()+ "**************" + RI_Value7);*/
		}
		softAssert.assertAll();
		
	}

	/**
	 * Find the index of value for given string in Open Agent Config page
	 * @param s
	 * @return index
	 */
	public int findIndexofValue(String s) {
		
		int n=0;
		for(int i=0;i<OpenAgentKeys.size();i++) {
			if(OpenAgentKeys.get(i).getDomProperty("value").equals(s)) {
				n=i;
				break;
			}
		}
		return n;
	}

	/**
	 * This function validates all the rows in OpenAgentConfig table match the values from API call
	 */
	public void OpenAgentConfig() {
		String RI_SystemName,RI_SystemVersion;
		super.addLog("Click on Open Agent Config link");
		log.info("Click on Open Agent Config link");

		waitForElementContentToDisplay(posSettings.get(6),10);
		clickIt(posSettings.get(6));
		waitForElementContentToDisplay(SystemName,20);
		TestUtil.sleep(2000);
		super.addLog("Connect with the backend for API data");
		log.info("Connect with the backend for API data");
		RestAssured.baseURI = baseURL + "agentconfig/" + siteID;
		Response response =RestAssured.given().when().get();
	//	System.out.println(response.asString());
		JsonPath js = response.jsonPath();
		String initName = "result.key[";
		String initVersion = "result.value[";
		String end = "]";
		//System.out.println(OpenAgentKeys.get(0).getDomProperty("value"));
		for(int i=0;i<OpenAgentKeys.size();i++) {
			RI_SystemName = js.getString(initName+i+end);
			RI_SystemVersion = js.getString(initVersion+i+end);
			//System.out.println(RI_SystemName + "******************" + OpenAgentKeys.get(i).getDomProperty("value"));
			super.addLog("Verify value of " + RI_SystemName+ " with value from API call");
			log.info("Verify value of " + RI_SystemName+ " with value from API call");
			softAssert.assertTrue(OpenAgentKeys.get(i).getDomProperty("value").equals(RI_SystemName),"Value does not match for "+RI_SystemName);
			softAssert.assertTrue(OpenAgentValues.get(i).getDomProperty("value").equals(RI_SystemVersion),"Value does not match for "+RI_SystemName);
			//System.out.println(RI_SystemVersion + "******************" + OpenAgentValues.get(i).getDomProperty("value"));
		}
		softAssert.assertAll(); 
	}


	/**
	 * This function deletes the value of one key in Open Agent Config page
	 * @return true when Update Settings button is disabled and error message is displayed in red
	 */
	public boolean OpenAgentEmptyValue() {
		super.addLog("Click on Open Agent Config link");
		log.info("Click on Open Agent Config link");

		waitForElementContentToDisplay(posSettings.get(6),10);
		clickIt(posSettings.get(6));
		super.addLog("Clear the value of GiftCardBalanceInquiry");
		log.info("Clear the value of GiftCardBalanceInquiry");
		int i = findIndexofValue("GiftCardBalanceInquiry");
		OpenAgentValues.get(i).sendKeys(Keys.BACK_SPACE);
		OpenAgentValues.get(i).sendKeys(Keys.BACK_SPACE);
		OpenAgentValues.get(i).sendKeys(Keys.BACK_SPACE);
		OpenAgentValues.get(i).sendKeys(Keys.BACK_SPACE);
		super.addLog("Verify that error message 'Highlighted values cannot be empty' is displayed");
		log.info("Verify that error message 'Highlighted values cannot be empty' is displayed");
		if(ErrorMsg.getText().equals("Highlighted values cannot be empty") && 
				AllButtons.get(3).getAttribute("ng-reflect-disabled").equals("true"))
			return true;
		else
			return false;
	}


	/**
	 * This function verifies that update settings in Open Agent config page works 
	 * @return true when value is updated and message about update is also displayed as alert
	 */
	public boolean OpenAgentUpdateSettings() {
		boolean b=false;
		super.addLog("Type true in GiftCardBalanceInquiry textbox");
		log.info("Type true in GiftCardBalanceInquiry textbox");
		int i = findIndexofValue("GiftCardBalanceInquiry");
		OpenAgentValues.get(i).sendKeys("true");
		clickIt(AllButtons.get(3));
		super.addLog("Check whether Update settings feature works");
		log.info("Check whether Update settings feature works");
		if(VerifyAlertMessage("GiftCardBalanceInquiry : true")) {
			TestUtil.sleep(3000);
			if(OpenAgentValues.get(i).getDomProperty("value").equals("true") && 
					SystemMsg.getText().contains("Agent Config Settings Updated"))
				b=true;
			else
				b=false;
		}
		return b;
	}

	/**
	 * verify that alert message is displayed
	 * @param s
	 * @return true if message is displayed
	 */
	public boolean VerifyAlertMessage(String s){
		if(AlertMsg.getText().contains(s)) {
			clickIt(YesBtn);
			return true;
		}
		else
			return false;
			
	}
	
	/**
	 * This function validates all the rows in ServiceConfig table match the values from API call
	 */
	public void ServiceConfig() {
		String RI_SystemName,RI_SystemVersion;
		super.addLog("Click on Service Config link");
		log.info("Click on Service Config link");
		waitForElementContentToDisplay(posSettings.get(8),10);
		clickIt(posSettings.get(8));
		waitForElementContentToDisplay(SystemName,20);
		TestUtil.sleep(2000);
		RestAssured.baseURI = baseURL + "serviceconfig/" + siteID;
		Response response =RestAssured.given().when().get();
	//	System.out.println(response.asString());
		JsonPath js = response.jsonPath();
		String initName = "result.key[";
		String initVersion = "result.value[";
		String end = "]";
		//System.out.println(OpenAgentKeys.get(0).getDomProperty("value"));
		for(int i=0;i<OpenAgentKeys.size();i++) {
			RI_SystemName = js.getString(initName+i+end);	
			RI_SystemVersion = js.getString(initVersion+i+end);
			//System.out.println(RI_SystemName + "******************" + OpenAgentKeys.get(i).getDomProperty("value"));
			super.addLog("Verify value of " + RI_SystemName+ " with value from API call");
			log.info("Verify value of " + RI_SystemName+ " with value from API call");
			softAssert.assertTrue(OpenAgentKeys.get(i).getDomProperty("value").equals(RI_SystemName),"Value does not match for "+RI_SystemName);
			softAssert.assertTrue(OpenAgentValues.get(i).getDomProperty("value").equals(RI_SystemVersion),"Value does not match for "+RI_SystemName);
		//	System.out.println(RI_SystemVersion + "******************" + OpenAgentValues.get(i).getDomProperty("value"));
		}
		softAssert.assertAll(); 
	}


	/**
	 * This function verifies that update settings in Service config page works 
	 * @return true when value is updated and message about update is also displayed as alert
	 */
	public boolean ServiceUpdateSettings() {
		boolean b=false;
		super.addLog("Type the URL in BasicHttpBinding_IDataAggregator textbox:" + ServiceURL);
		log.info("Type the URL in BasicHttpBinding_IDataAggregator textbox:" + ServiceURL);

		int i = findIndexofValue("BasicHttpBinding_IDataAggregator");
		OpenAgentValues.get(i).sendKeys(ServiceURL);
		clickIt(AllButtons.get(2));
		super.addLog("Check whether Update settings feature works");
		log.info("Check whether Update settings feature works");
		if(VerifyAlertMessage("BasicHttpBinding_IDataAggregator")) {
			TestUtil.sleep(4000);
			if(OpenAgentValues.get(i).getDomProperty("value").equals(ServiceURL)&& 
					SystemMsg.getText().contains("Client Settings Updated"))
				b=true;
			else
				b=false;
		}
		return b;
	}


	/**
	 * This function deletes the value of one key in Service Config page
	 * @return true when Update Settings button is disabled and error message is displayed in red
	 */
	public boolean ServiceEmptyValue() {
		super.addLog("Click on Service Config link");
		log.info("Click on Service Config link");

		waitForElementContentToDisplay(posSettings.get(8),10);
		clickIt(posSettings.get(8));
		TestUtil.sleep(2000);
		super.addLog("Clear the value of BasicHttpBinding_IDataAggregator");
		log.info("Clear the value of BasicHttpBinding_IDataAggregator");
		int i = findIndexofValue("BasicHttpBinding_IDataAggregator");
		ServiceURL = OpenAgentValues.get(i).getDomProperty("value");
		clickIt(OpenAgentValues.get(i));
		OpenAgentValues.get(i).sendKeys(Keys.chord(Keys.CONTROL,"a"));
		OpenAgentValues.get(i).sendKeys(Keys.DELETE);
		super.addLog("Verify that error message is displayed");
		log.info("Verify that error message is displayed");
		if(ErrorMsg.getText().equals("Highlighted values cannot be empty") && 
				AllButtons.get(2).getAttribute("ng-reflect-disabled").equals("true"))
			return true;
		else
			return false;
	}
	
	/**
	 * This function validates all the rows in POSGetMenuItems table match the values from API call
	 */
	public void POSGetMenuItems() {
		super.addLog("Click on Get Menu Items link");
		log.info("Click on Get Menu Items link");

		waitForElementContentToDisplay(posSettings.get(9),20);
		clickIt(posSettings.get(9));
		waitForElementContentToDisplay(SystemName,20);
		super.addLog("Connect with the backend for API data");
		log.info("Connect with the backend for API data");
		RestAssured.baseURI = baseURL + "menuitems/" + siteID;
	
		Response response =RestAssured.given().when().get();
		//System.out.println(response.asString());
		JsonPath js = response.jsonPath();
		
		for(int i=0;i<openTableHeaders.size();i++) {
			String x = openTableHeaders.get(i).getText().replaceAll("\\s+", "");
			char[] y = x.toCharArray();
			char c = y[0];
			String c1 = String.valueOf(c).toLowerCase();
			String sub = x.substring(1);
			String f = c1+sub;
			String key = "result.itemList."+f;
			String RI_value = js.getString(key).toString();
		//	System.out.println("********************" +posFeatures.get(i).getText()+ 
		//			"********************" + RI_value+ "********************");
			super.addLog("Verify value of " + f+ " with value from API call");
			log.info("Verify value of " + f+ " with value from API call");
			if(i==1) {
				softAssert.assertTrue(RI_value.contains("null"),"Value does not match for "+f);
				softAssert.assertTrue(posFeatures.get(i).getText().equals(""),"Value does not match for "+f);
			}else
				softAssert.assertTrue(RI_value.contains(posFeatures.get(i).getText()),"Value does not match for "+f);
		}
		softAssert.assertAll(); 
	}

	/**
	 * This function validates all the rows in GetRVCList table match the values from API call
	 */
	public boolean GetRVCList() {
		boolean b=false; 
		super.addLog("Click on Get RVC List link");
		log.info("Click on Get RVC List link");
		waitForElementContentToDisplay(posSettings.get(7),20);
		clickIt(posSettings.get(7));
		waitForElementContentToDisplay(SystemName,20);
		super.addLog("Connect with the backend for API data");
		log.info("Connect with the backend for API data");
		RestAssured.baseURI = baseURL + "rvclist/" + siteID;
		Response response =RestAssured.given().when().get();
		JsonPath js = response.jsonPath();
		String RI_Name = js.getString("result.revenueCenterList.revenueCenterName");
		String RI_Value = js.getString("result.revenueCenterList.revenueCenterValue");
	//	System.out.println("$$$$$$$$$$$$$$$$$$$$$"+RI_Name+"$$$$$$$$$$$$$$$$$$$$$"+RI_Value);
		super.addLog("Verify System Name and Value match with value from API calls");
		log.info("Verify System Name and Value match with value from API calls");
		if(RI_Name.contains(SystemName.getText()) && RI_Value.contains(SystemVersion.getText()))
			b=true;	
		return b;
	}

	/**
	 * This function validates all the rows in GetOpenTables table match the values from API call
	 */
	public void GetOpenTables() {

		super.addLog("Click on Get Open Tables link");
		log.info("Click on Get Open Tables link");
		waitForElementContentToDisplay(posSettings.get(5),20);
		clickIt(posSettings.get(5));
		waitForElementContentToDisplay(SystemName,20);
		super.addLog("Connect with the backend for API data");
		log.info("Connect with the backend for API data");
		RestAssured.baseURI = baseURL + "opentables/" + siteID;
		Response response =RestAssured.given().when().get();
	//	System.out.println(response.asString());
		JsonPath js = response.jsonPath();	
		for(int i=0;i<openTableHeaders.size();i++) {
			String x = openTableHeaders.get(i).getText().replaceAll("\\s+", "");
			char[] y = x.toCharArray();
			char c = y[0];
			String c1 = String.valueOf(c).toLowerCase();
			String sub = x.substring(1);
			String f = c1+sub;
			if(i==6)
				f=f.toLowerCase();
			String key = "result.tableList."+f;
			String RI_value = js.getString(key).toString();
			//System.out.println("********************" +posFeatures.get(i).getText()+ 
					//"********************" + RI_value+ "********************");
			super.addLog("Verify value of " + f+ " with value from API call");
			log.info("Verify value of " + f+ " with value from API call");
			if(i==0 || i==1 || i==2 || i==6 || i==11) {
				softAssert.assertTrue(RI_value.contains(posFeatures.get(i).getText()),"Value does not match for "+f);
			}
			else if(i==4 || i==5) {
				softAssert.assertTrue(RI_value.contains(posFeatures.get(i).getText().substring(1)),"Value does not match for "+key);
			}
			else if(i==3) {	
				softAssert.assertTrue(RI_value.contains("2"),"Value does not match for "+key);
				softAssert.assertTrue(posFeatures.get(i).getText().equals("OPEN"),"Value does not match for "+key);
			}
			else if(i==7 || i==10) {
				softAssert.assertTrue(RI_value.contains("false"),"Value does not match for "+key);
				softAssert.assertTrue(posFeatures.get(i).getText().equals("NO"),"Value does not match for "+key);
			}
			else if(i==8) {	
				softAssert.assertTrue(RI_value.contains("null"),"Value does not match for "+key);
				softAssert.assertTrue(posFeatures.get(i).getText().equals(""),"Value does not match for "+key);
			}else if(i==9) {
				softAssert.assertTrue(RI_value.contains("null"),"Value does not match for "+key);
				softAssert.assertTrue(posFeatures.get(i).getText().equals(""),"Value does not match for "+key);
			}		
		}
		softAssert.assertAll(); 
	}
}
