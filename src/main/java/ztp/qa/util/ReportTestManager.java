//This is class for logging into extent spark report
//@author : Praggati Oswal
package ztp.qa.util;
import java.util.HashMap;
import java.util.Map;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ReportTestManager {
	
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = ExtentReportManager.getReportInstance();

	
	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}
	
	public static synchronized ExtentTest startTest(String testName, String className, String Description) {
		ExtentTest test = extent.createTest(testName,Description);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		test.assignAuthor("Praggati");
		test.assignCategory(className);	
		//test.assignDevice("Windows:Chrome");
		return test;
	}
	
	public static synchronized void logText(String message) {
		getTest().log(Status.PASS, message);		
	}
}