//This is class for creating extent spark report
//@author : Praggati Oswal
package ztp.qa.util;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	public static ExtentSparkReporterConfig config;

	public static ExtentReports getReportInstance() {

		String reportName = "ZioskSupportPortal.html";
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "\\test-output\\" + reportName);
		extent = new ExtentReports();
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Ziosk Support Portal Automation Results");
		spark.config().setReportName("Ziosk Support Portal UI Test Report");
		return extent;

	}
}
