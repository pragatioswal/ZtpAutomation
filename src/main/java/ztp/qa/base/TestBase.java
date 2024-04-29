//This is base class which contains all the initialization code
//@author : Praggati Oswal
package ztp.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import ztp.qa.util.ReportTestManager;
import ztp.qa.util.TestUtil;
import ztp.qa.util.WebListener;

/**
 * This the base class imported by all pages and tests
 * This class opens the config.properties which has all parameters for the test
 * 
 */
public class TestBase {

//	public static WebDriver webdriver;
	
	public static Properties prop;
	public static ChromeDriver driver;
	public static ChromeOptions co;
	public static WebDriverListener listener = new WebListener();
	public static ExtentReports report;
	public static ExtentTest extentTest;
	public static Logger log;

	
	public TestBase() {
		log = LogManager.getLogger(TestBase.class);
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\ztp" + "\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.error("Could not find config.properties file");;
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	/**
	 * This function sets the configuration for chrome browser and opens the browser
	 */
	public static void initialization() {
		//String browserName = prop.getProperty("browser");
		String location = System.getProperty("user.dir");
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("download.default_directory", location);
 		co = new ChromeOptions();
		co.addArguments("--disable-infobars");
		co.addArguments("--disable-notifications");
		co.setAcceptInsecureCerts(true);
		co.addArguments("--remote-allow-origins=*");
		co.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		co.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(co);
	//	driver =  new  EventFiringDecorator<WebDriver>(listener).decorate(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		driver.get(prop.getProperty("url"));
		log.info("Logged into Support Portal Home Page");
	}

	/**
	 * This function adds the string message in the extent report as a log message
	 * @param message
	 */
	public void addLog(String message) {
		if (ReportTestManager.getTest()!=null) {
			ReportTestManager.getTest().log(Status.INFO, message);
		}
	}
	
	/**
	 * This function waits for alert present and then switch to it 
	 * @return alert
	 */
	public Alert switchToAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();
	}
	
	/**
	 * This function waits for the visibility of the element for given no of seconds
	 * @param element
	 * @param sec
	 * @return boolean which is set to true on being visible
	 */
    public static boolean waitForVisibilityOf(WebElement element,int sec){
    	boolean result=false;
    	try {
	        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
	        wait.until(ExpectedConditions.visibilityOf(element));
	        result=true;
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
        return result;
    }

    /**
	 * This function waits for the clicking of the element to be available for given no of seconds
	 * @param element
	 * @param sec
	 * @return boolean which is set to true on being clickable
	 */
    public static boolean waitForelementToBeClickable(WebElement element,int sec){
    	boolean result=false;
    	try {
	        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	     
	        result=true;
    	}catch(Exception e) {
    		e.printStackTrace();
    		
    	}
        return result;
    }
    
    public void clickIt(WebElement element)
	{

		int maxAttempts = 3; // Maximum number of times you want to retry
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		int attempt = 1;
		boolean elementClickable = false;
	
		while (attempt <= maxAttempts) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(element)).click();
				elementClickable = true; 
				break; 
	
			} catch (Exception e) {
				
				attempt++; 
			}
		}
		 if (!elementClickable) {
	            System.out.println(element+"Element was not clickable after " + maxAttempts + " attempts.");
	        }
	}

    /**
  	 * This function waits for the display of the element for given no of seconds
  	 * @param element
  	 * @param timeOutInSeconds
  	 * @return boolean which is set to true on being displayed
  	 */
	 public static boolean waitForElementToDisplay(WebElement element,int timeOutInSeconds){
		
	        boolean isDisplayed=false;
	        for(int i=0;i<timeOutInSeconds;i++){
	            try {
	                if(element.isDisplayed()){
	                	
	                //	log.info(element.toString()+" is visible");
	                    isDisplayed=true;
	                    TestUtil.sleep(1000);
	                    break;
	                }
	            }catch (Exception exception){
	            	log.info(element.toString()+" is not visible");
	                TestUtil.sleep(1000);
	            }
	        }
	        return isDisplayed;
	    }

	 
	 	/**
	  	 * This function waits for the element to be hidden for given no of seconds
	  	 * @param element
	  	 * @param timeOutInSeconds
	  	 * @return boolean which is set to true on being hidden
	  	 */
	    public static boolean waitForElementToHide(WebElement element,int timeOutInSeconds){
	        boolean isNotDisplayed=false;
	        try {
	            for (int i=0;i<timeOutInSeconds;i++){
	                if(element.isDisplayed()){
	                	TestUtil.sleep(1000);
	                }
	                
	            }
	        }catch (NoSuchElementException | StaleElementReferenceException exception){
	        	log.info(element.toString()+" is hidden");
	        	TestUtil.sleep(2000);
	            isNotDisplayed=true;
	        }
	        return isNotDisplayed;
	    }
	    
		/**
	  	 * This function waits for content of the display of the element for given no of seconds
	  	 * @param element
	  	 * @param timeOutInSeconds
	  	 * @return boolean which is set to true on being hidden
	  	 */
	    public static boolean waitForElementContentToDisplay(WebElement element,int timeOutInSeconds){
	        boolean _isContentDisplayed=false;
	        for(int i=0;i<timeOutInSeconds;i++){
	            String text=element.getText();
	            if(text==null){
	                text=element.getText();
	            }
	            if(text!=null && !text.equals("")){
	            	//log.info(element.toString()+" is visible");
	            	TestUtil.sleep(1000);
	            	_isContentDisplayed=true;
	                break;
	            }else{
	            	log.info(element.toString()+" is not visible");
	                TestUtil.sleep(1000);
	            }
	        }
	        return _isContentDisplayed;
	    }

	

}
