package pages;

import static interfaces.ClassObjects.*;

import org.openqa.selenium.Alert;

import com.relevantcodes.extentreports.LogStatus;

import commonPackage.BaseClass;
import io.restassured.path.json.JsonPath;
import reports.ExtentManager;
import reports.Log;

public class AlerturlPage extends BaseClass{

	
	
	
	public void entervalidCredntials() {
		String url ="https://"+prop.getProperty("username")+":"+prop.getProperty("password")+"@"+prop.getProperty("url");
		
			getDriver().get(url);
			utility.TitletextVerification(getDriver(), JsonPath.from(jsonTestData).getString("PageTitle"), 10);
		
	}
	
	public void enterInvalidCredntials() {
		String url = "https://"+prop.getProperty("invalidusername")+":"+prop.getProperty("invalidpassword")+"@"+prop.getProperty("url");
		try {
			getDriver().get(url);
			Log.info("page is loaded with " + url + "'");
			ExtentManager.getTest().log(LogStatus.PASS,
                    "page is not loaded with " + "'" + url + "'", ExtentManager.getTest().addBase64ScreenShot(utility.captureScreenshot()));
		} catch (Exception e) {
			// TODO: handle exception
			Log.info("page is loaded with " + url + "'");
			ExtentManager.getTest().log(LogStatus.FAIL,
                    "page is loaded with " + "'" + url + "'", ExtentManager.getTest().addBase64ScreenShot(utility.captureScreenshot()));

		}
	}
	
	public void enterEmptyusernameInCredentials() {
		String url ="https://"+"  "+":"+prop.getProperty("password")+"@"+prop.getProperty("url");
		try {
			getDriver().get(url);
			Log.info("page is loaded with " + url + "'");
			ExtentManager.getTest().log(LogStatus.PASS,
                    "page is not loaded with " + "'" + url + "'", ExtentManager.getTest().addBase64ScreenShot(utility.captureScreenshot()));
		} catch (Exception e) {
			// TODO: handle exception
			Log.info("page is loaded with " + url + "'");
			ExtentManager.getTest().log(LogStatus.FAIL,
                    "page is loaded with " + "'" + url + "'", ExtentManager.getTest().addBase64ScreenShot(utility.captureScreenshot()));

		}
	}
	
	public void enterEmptyPasswordInCredntials() {
		String url ="https://"+prop.getProperty("username")+"  "+":"+"@"+prop.getProperty("url");
		try {
			getDriver().get(url);
			Log.info("page is loaded with " + url + "'");
			ExtentManager.getTest().log(LogStatus.PASS,
                    "page is not loaded with " + "'" + url + "'", ExtentManager.getTest().addBase64ScreenShot(utility.captureScreenshot()));
		} catch (Exception e) {
			// TODO: handle exception
			Log.info("page is loaded with " + url + "'");
			ExtentManager.getTest().log(LogStatus.FAIL,
                    "page is loaded with " + "'" + url + "'", ExtentManager.getTest().addBase64ScreenShot(utility.captureScreenshot()));

		}
	}
	public void EmptyUsernanePasswordInCredntials() {
		String url ="https://"+"  "+":"+"@"+prop.getProperty("url");
		try {
			getDriver().get(url);
			Log.info("page is loaded with " + url + "'");
			ExtentManager.getTest().log(LogStatus.PASS,
                    "page is not loaded with " + "'" + url + "'", ExtentManager.getTest().addBase64ScreenShot(utility.captureScreenshot()));
		} catch (Exception e) {
			// TODO: handle exception
			Log.info("page is loaded with " + url + "'");
			ExtentManager.getTest().log(LogStatus.FAIL,
                    "page is loaded with " + "'" + url + "'", ExtentManager.getTest().addBase64ScreenShot(utility.captureScreenshot()));

		}

			
	}
	
}
