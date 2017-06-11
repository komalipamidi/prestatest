package com.selenium.presta.tests;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.selenium.presta.CommonCode;
import com.selenium.presta.Configuration;
import com.selenium.presta.Home;
import com.selenium.presta.LoginPage;
import com.selenium.presta.MyAccount;
import com.selenium.presta.ReadExcel;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


public class TestngAnnotationsTest {

	// public WebDriver driver = Configuration.browser();
	public WebDriver driver = Configuration.browser();

	public LoginPage login;
	static Workbook wbook;
	static WritableWorkbook wwbCopy;
	static String ExecutedTestCasesSheet;
	public WritableWorkbook workbook;
	public Home home;
	public MyAccount account;
	public CommonCode common;
	public ReadExcel read;
	//public ExtentTest test;
	// public static ExtentReports extent;
	// public static ExtentTest test;

	public TestngAnnotationsTest() {
		login = new LoginPage();
		home = new Home();
		account = new MyAccount();
		common = new CommonCode();
		read = new ReadExcel();
	}

	/*
	 * String extentReportFile = System.getProperty("user.dir") +
	 * "\\extentReportFile.html"; String extentReportImage =
	 * System.getProperty("user.dir") + "\\extentReportImage.png"; ExtentReports
	 * extent = new ExtentReports(extentReportFile, false); ExtentTest
	 * extentTest = extent.startTest("My First Test", "Verify WebSite Title");
	 */
	@BeforeSuite(alwaysRun = true)
	public void LogintoApp() {
/*
		String filepath = "src/test/resources/Book1.xls";
		filepath = System.getProperty("user.dir") + "/" + filepath;
		File file = new File(filepath);
		WorkbookSettings wbSettings = new WorkbookSettings();

		wbSettings.setLocale(new Locale("en", "EN"));

		try {
			workbook = Workbook.createWorkbook(file, wbSettings);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		workbook.createSheet("Report", 0);
		try {
			workbook.write();
			workbook.close();
			Reporter.log("Sheet created", true);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ds = new DataSheet();
*/
		driver.manage().window().maximize();
		driver.get(Configuration.LoginURL());
		// extentTest.log(LogStatus.INFO, "Browser Launched");
		String currenturl = driver.getCurrentUrl();

		// test.log(LogStatus.PASS, "The current URL of the web page ::" +
		// currenturl);

		//home.LoginLink();
	//login.LogintoApp(Configuration.loginUserName(), Configuration.Loginpassword());

		// extent = new
		// ExtentReports("C://Users//Kumar//workspace6//PrestaAutomation//Extentreport.html",
		// true);
		// extent.loadConfig(new
		// File("C://Users//Kumar//workspace6//PrestaAutomation//extent-config.xml"));

	}

	// Select select = new Select("");

	@AfterMethod(alwaysRun = true)
	public void HomePage() {

		home.navigate_to_home();

	}
	/*
	 * @AfterMethod public void getResult(ITestResult result) throws IOException
	 * { if (result.getStatus() == ITestResult.FAILURE) { String screenShotPath
	 * = GetScreenShot.capture(driver, "screenShotName");
	 * test.log(LogStatus.FAIL, result.getThrowable()); test.log(LogStatus.FAIL,
	 * "Snapshot below: " + test.addScreenCapture(screenShotPath)); }
	 * extent.endTest(test); }
	 */

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		driver.quit();
		

		// extentTest.log(LogStatus.INFO, "Browser closed");
		// close report.
		// extent.endTest(extentTest);

		// writing everything to document.
		// extent.flush();
		/*
		 * test.log(LogStatus.PASS, "Browser closed successfully..!");
		 * extent.endTest(test); extent.flush(); extent.close();
		 */
	}
}