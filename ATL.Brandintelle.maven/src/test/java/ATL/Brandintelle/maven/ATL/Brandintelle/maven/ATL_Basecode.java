package ATL.Brandintelle.maven.ATL.Brandintelle.maven;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Screencast;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ATL_Basecode {
	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	// Xpath list
	static String usernameXpath = "//*[@id=\"m_login\"]/div/div[1]/div/div[2]/div/div/div/div/div/m-login/form/div[2]/input";
    static String Search1="//*[@id=\"mat-input-0\"]";
    //static String Seragency = "//*[@id=\"mat-input-0\"]";
    
    
	//Sendkeys List
	static String username ="Sanyuktaa";
	static String Data = "Brand 1";
	//static String agency = "AARTI ADVERTISING";
	
	@BeforeTest
	public void launch () throws Exception {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito","--disable-notifications");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://qa.m-net.in/login"); //https://qa.m-net.in/login
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.findElement(By.xpath(usernameXpath)).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"m_login\"]/div/div[1]/div/div[2]/div/div/div/div/div/m-login/div[2]/label/span")).click();
		driver.findElement(By.xpath("//*[@id=\"m_login\"]/div/div[1]/div/div[2]/div/div/div/div/div/m-login/div[3]/m-spinner-button/button")).click();
		driver.findElement(By.xpath("//*[@id=\"m_login\"]/div/div[1]/div/div[2]/div/div/div/div/div/m-login/form/div[2]/div/input")).sendKeys("Tt@123456");
		driver.findElement(By.xpath("//*[@id=\"m_login\"]/div/div[1]/div/div[2]/div/div/div/div/div/m-login/div[3]/m-spinner-button/button/span/span")).click();
		Thread.sleep(4000);

		// Extent Report Desgining 
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
		// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Brandintelle");
		extent.setSystemInfo("Environment", "TestPortal");
		extent.setSystemInfo("User Name", "Abhijeet");
		htmlReporter.config().setDocumentTitle("Brandintelle Test Report ");
		// Name of the report
		htmlReporter.config().setReportName(" Test Execution Report ");
		// Dark Theme
		htmlReporter.config().setTheme(Theme.DARK);	
	}
	
	public static void ActionClick(String Xpath, String dataKeys ) throws InterruptedException {
		
		Actions action = new Actions(driver);
		WebElement selbr1 = driver.findElement(By.xpath(Xpath));
		action.moveToElement(selbr1).sendKeys(dataKeys).build().perform();
		Thread.sleep(3000);
		
		}

	//This method is to capture the screenshot and return the path of the screenshot.
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	@AfterTest 
	public void closeapp() {
//		WebElement close = driver.findElement(By.xpath("//*[@id=\"m_header_topbar\"]/div/ul/m-language-selector/a/span/img"));
//		close.click();
//		WebElement logout = driver.findElement(By.xpath("//*[@id=\"m_header_topbar\"]/div/ul/m-language-selector/div/div/div/div/ul/li[3]/a/span[2]"));
//		logout.click();
		extent.flush();

		//driver.quit();
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception{
		if(result.getStatus() == ITestResult.FAILURE){
			//MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
			//We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.
			//String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
			String screenshotPath = getScreenShot(driver, result.getName());
			//To add it in the extent report
			logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
		}
		else if(result.getStatus() == ITestResult.SKIP){
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" - Test Case PASSED", ExtentColor.GREEN));
		}

		Thread.sleep(3000);
		
	}
	 
}


