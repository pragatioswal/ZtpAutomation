//This is listener for TestNG which records the status of each test
//@author : Praggati Oswal
package ztp.qa.util;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import ztp.qa.base.TestBase;

public class TestListener extends TestBase implements ITestListener{

	//ExtentReports extent = ExtentReportManager.getReportInstance();
	ExtentTest test;
	
	
	public TestListener() {
		super();
	}
	
	
	@Override
	public void onTestStart(ITestResult iTestResult) {
		// TODO Auto-generated method stub
	
		String description = iTestResult.getMethod().getDescription();
		test = ReportTestManager.startTest(iTestResult.getMethod().getMethodName(),
				iTestResult.getInstance().getClass().getCanonicalName(),description);
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, result.getMethod().getMethodName());
		log.info(result.getMethod().getMethodName() + " PASSED");
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		test.log(Status.FAIL, iTestResult.getMethod().getMethodName());
		test.log(Status.FAIL, iTestResult.getThrowable());
		log.error(iTestResult.getMethod().getMethodName()+ " FAILED");
		String screenShot=null;
		try {
			screenShot = TestUtil.captureScreen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.fail("Screen Shot : " + ReportTestManager.getTest().addScreenCaptureFromPath(screenShot));
		
	}
	
	
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		ReportTestManager.extent.flush();
	}

}
