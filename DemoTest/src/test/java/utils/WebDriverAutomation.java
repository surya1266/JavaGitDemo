package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.LoginPage;


public class WebDriverAutomation {
	
	public static  final int MAX_WAIT_TIME_SECONDS=40;
	public static final String CONFIG_FILE_PATH="resources/config.properties";
    public  static WebDriver driver=null;

	public static LoginPage loginPage;
	//public static ExtentReportingUtil extentReport;
	
	private static WebDriverAutomation instance =null;
	
	public static WebDriverAutomation getInstance() {
		
		System.out.println("Inside GetInstance Method");
		System.out.println("instalnce value is "+instance);
		
		try{
			if(instance==null){

				System.out.println("Inside GetInstance if");
				
				instance = new WebDriverAutomation();
			
				loginPage=PageFactory.initElements(driver,LoginPage.class);
				
				//extentReport=new ExtentReportingUtil();
				System.out.println("After PageFactory Instance");
				
			}else
			{
				System.out.println("in instance else");
			}
				
				
				
			}catch (Exception e){
				e.printStackTrace();
			}
			return instance;
		
		
	}
	public static WebDriver getWebDriver(String sBRowserName)
		{
		
		System.out.println("Inside GetwebDriver Method");
			try{
				if(sBRowserName.equalsIgnoreCase("firefox")){
					
					System.out.println("Inside firfox Method");
				System.setProperty("webdriver.gecko.driver", PropertyFileHandling.getPropertyValue("SERVER_DRIVER_FIREFOX",CONFIG_FILE_PATH));
				
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				
				
				}
				else if(sBRowserName.equalsIgnoreCase("chrome"))
				{
					DesiredCapabilities cap = DesiredCapabilities.chrome();
					
					ChromeOptions options = new ChromeOptions();
					
					
					//cap.setJavascriptEnabled(true);
				System.setProperty("webdriver.chrome.driver", PropertyFileHandling.getPropertyValue("SERVER_DRIVER_CHROME",CONFIG_FILE_PATH));
				driver = new ChromeDriver(cap);
				driver.manage().window().maximize();
				}
				else if(sBRowserName.equalsIgnoreCase("ie"))
				{
					
					
					DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
					cap.setJavascriptEnabled(true);
					cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
					cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				System.setProperty("webdriver.ie.driver", PropertyFileHandling.getPropertyValue("SERVER_DRIVER_IE",CONFIG_FILE_PATH));
				driver = new InternetExplorerDriver(cap);
				driver.manage().window().maximize();
				}
				else if(sBRowserName.equalsIgnoreCase("edge"))
				{
					DesiredCapabilities cap = DesiredCapabilities.edge();
					cap.setJavascriptEnabled(true);
					cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
					cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				System.setProperty("webdriver.edge.driver", PropertyFileHandling.getPropertyValue("SERVER_DRIVER_EDGE",CONFIG_FILE_PATH));
				driver = new EdgeDriver(cap);
				driver.manage().window().maximize();
				}
				
				
				}
				catch(Exception e){
					System.out.println("Exception in Creation the Web Driver : "+e.getMessage());
				}
			getInstance();
		
			return driver;
		  }
		
		
		public static void waitForElement( WebElement  ele){
			
			
			try{
			WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT_TIME_SECONDS);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			}
			catch(Exception exp){
				System.out.println(exp.getMessage()+" for xpath "+ele);
			}
		}
		
		public static String getScreenShotAs(WebDriver driver)
		{
			System.out.println("In getScrenscreenshot meethod");
			TakesScreenshot ts=(TakesScreenshot) driver;
			
			         File src=  ts.getScreenshotAs(OutputType.FILE);
			         
			        String path= System.getProperty("user.dir")+"\\target\\"+System.currentTimeMillis()+".png";
			        
			        File destination=new File(path);
			        
			        try {
						FileUtils.copyFile(src,destination);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Captured Failed "+e.getMessage());
					}
				
			return path;
			
		}
		
		
	}	
		
		
//		prop=new Properties();
//		FileInputStream fis=null;
//		try {
//			fis = new FileInputStream("D://Selenium//CucumberDemo//resources//Config.properties");
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		try {
//			prop.load(fis);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}	
//		public static void initialization()
//		{
//			String browser=prop.getProperty("browsername");
//			
//			if(browser.equals("Chrome"))
//			{
//				System.setProperty("webdriver.chrome.driver", "D://Personal//Selenium//latestDrivers//chromedriver.exe");
//				
//				driver=new ChromeDriver();
//				
//			}else if(browser.equals("Firefox"))
//					{
//				
//	                  System.setProperty("webdriver.chrome.driver", "D://Selenium//CucumberDemo//drivers//geckodriver.exe");
//				
//				        driver=new FirefoxDriver();
//				      
//					}
//			
//			driver.manage().window().maximize();
//			driver.manage().deleteAllCookies();
//			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//			
//			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
//			
//			String MainURLstr=prop.getProperty("URL");
//		    String URLString= MainURLstr.substring(0,49)+"/communications/index.html?root=status-schemes";
//		    
//		    
//		    driver.get(URLString);
//		    try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
					
		//}
	
		


