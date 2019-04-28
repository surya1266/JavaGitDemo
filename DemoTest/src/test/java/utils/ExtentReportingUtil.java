package utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReportingUtil extends WebDriverAutomation{
	
	 static com.aventstack.extentreports.ExtentReports extent ;
	 static  ExtentHtmlReporter htmlReporter;
	 static ExtentTest test;
	
	 public ExtentReportingUtil()
	 {
		// System.out.println("Scenario name is "+scenario.getName());
		 Random rand = new Random(); 
		 int value = rand.nextInt(10);//generates random number
		 String nextValue=Integer.toString(value);
		 
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
         Date date = new Date();
         String s = dateFormat.format(date);
         
         System.out.println("Date is "+s);
		 
		 System.out.println("Int value is "+nextValue);
		 System.out.println("file is "+System.getProperty("user.dir") + "\\target\\"+ "MyOwnReport RunAt"+s.toString()+".html");
		 System.out.println("Extent Constructor");
		 
         
         htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\target\\"+ "MyOwnReport RunAt"+s.toString()+"RunAt"+".html");

         extent  = new com.aventstack.extentreports.ExtentReports();
         extent.attachReporter(htmlReporter);
         
	 }
	 
	 public static ExtentTest createExtentTest(String TestName)
	 {
		 test=extent.createTest(TestName);
		 return test;
		 
	 }
	 
	 public static void createLogForpass(String LogText)
	 {
		 
		 test.log(Status.PASS,LogText);
		 
	 }
	 
	 public static void passLogforCondtitons(String expected, String actual)
	 {
		 test.log(Status.PASS, "<span class='label pass' style='font-weight:bold;'>" + "Expected  is   "+" : &nbsp;"  +expected+" , &nbsp;"   +"Actual is "+" : &nbsp;" +actual+ "</span>");
		 
		 
	 }
	 public static void failLogforCondtitons(String expected, String actual)
	 {
		 test.log(Status.FAIL, "<span class='label pass' style='font-weight:bold;'>" + "Expected  is   "+" : &nbsp;"  +expected+" , &nbsp;"   +"Actual is "+" : &nbsp;" +actual+ "</span>");
		 
		 
	 }
	 
	 public static void extentflush()
	 {
		 extent.flush();
	 }
	 public  static void ScreenshotforPass() {
			
		 
		 String path=WebDriverAutomation.getScreenShotAs(driver);
	        try {
	        
				test.pass("Screenshot").addScreenCaptureFromPath(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
    public static void ScreenshotforFail() {
    	
    	
    	 String path=WebDriverAutomation.getScreenShotAs(driver);
	        try {
	        	
				test.fail("details").addScreenCaptureFromPath(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
    }

}
