package commonPackage;

import static interfaces.ClassObjects.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import reports.Log;


public class BaseClass {

	public static WebDriver driver;
	public Properties prop;
	public static File jsonTestData;
	public static String platform = System.getProperty("platform");
    public static String Browser = System.getProperty("browser");
    public static String groups = System.getProperty("group");
	public BaseClass() {
		if(platform=="web") {
			try {
				prop = new Properties();
				FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/config.properties");
				prop.load(fis1);
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			PageFactory.initElements(driver, this);
		}else {
			try {
				prop = new Properties();
				FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/config.properties");
				prop.load(fis1);
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			PageFactory.initElements(driver, this);
		}
		
		
	}
	
	public WebDriver getDriver() {
		
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	 private void initJsonTestData() {
	        
	         jsonTestData = new File(System.getProperty("user.dir")+prop.getProperty("jsonTestData"));
	            
	    }
	 
	 
	 
	 
	@BeforeSuite(alwaysRun = true)
	@Parameters("browser")
	public void OpenBrowser(String browser) throws InterruptedException {
		
		
		if(browser.equals("Chrome")) {
	//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+prop.getProperty("ChromDriverPath"));		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			Log.info(browser +" Browser opened");
			driver.manage().window().maximize();
			Log.info( browser +" Browser miximized");
			
			utility.ImplicitWait(getDriver());
			
		}else if (browser.equals("Safari")) {
			driver= new SafariDriver();
			driver.manage().window().maximize();
			utility.ImplicitWait(getDriver());
		}else{
			System.out.println("Please select valid Browser name---Chrome or Safari");
			Log.error("Please select valid Browser like Chrome or Safari");
			System.exit(0);
		}
		
		initJsonTestData();
		Log.startLog(this.getClass().getSimpleName());
	}
	
	
	
	 @BeforeClass(alwaysRun = true)
	    public void initialize() throws Exception {
	       
	        Log.startLog(this.getClass().getSimpleName());
	  
	        
	    }
	 
	
	 
	 @BeforeMethod(alwaysRun = true)
	 public void startreportForMethod(Method method) {
		 reports.ExtentManager.startTest(method.getAnnotation(Test.class).description(), Browser);
	 }
	
	 
	 @AfterClass(alwaysRun = true)
	    public void terminateApp() {
		 WebStorage webStorage = (WebStorage) driver;
         webStorage.getLocalStorage().clear();
	    }
	@AfterSuite(alwaysRun = true)
	public void CloseBrowser() {
		driver.quit();
	}
	

}
