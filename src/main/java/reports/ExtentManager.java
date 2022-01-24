package reports;

import static interfaces.ClassObjects.base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentManager {

	public static ExtentReports extent;
    public static ExtentTest test ;

     static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();

     
     
    public static ExtentReports getReporter() {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
        if (extent == null) {
            extent = new ExtentReports(System.getProperty("user.dir") +base.prop.getProperty("ExtentReportpath")+"TestResults_" + timeStamp + ".html");
            
        }
        return extent;
    }

    public static ExtentTest getTest() {
    	
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static void endTest() {
        getReporter().endTest(extentTestMap.get((int) Thread.currentThread().getId()));
    }


    public  static void startTest(String testName,String browserName) {
        test = getReporter().startTest(testName);       
        test.getTest().getDescription();
        extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
        extentTestMap.put((int) Thread.currentThread().getId(), test);
    }

    public static void printLogs(String logs) {
        getTest().log(LogStatus.INFO, logs);
    }

	
}
