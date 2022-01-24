package commonPackage;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import reports.ExtentManager;
import reports.Log;

public class UtilityClass  extends BaseClass{

	
	SoftAssert soft = new SoftAssert();
	public void WaitForElement(WebDriver driver, WebElement locator,int time) {
		
		try {
				WebDriverWait wait = new WebDriverWait(driver, time);
				wait.until(ExpectedConditions.visibilityOf(locator));
			//	ExtentManager.getTest().log(LogStatus.PASS," ");
		} catch (Exception e) {
			Log.error("Element "+locator+" is not visible and error is "+e.getMessage());
		//	ExtentManager.getTest().log(LogStatus.FAIL,locator+" is not visible");		
			}
	}
	
	
	public void ImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void TakeAscreesnhot(WebDriver driver,String screenshotname) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String ScreenshotPath = System.getProperty("user.dir")+prop.getProperty("ScreenshotPath")+screenshotname+".png";
		try {
			FileHandler.copy(src, new File(ScreenshotPath));
		} catch (Exception e) {			
			System.out.println("unable to capture "+ e.getMessage());
		}
		
	}
	
	public  String captureScreenshot() {
        String base64Screenshot = null;
        if (driver != null) {
            base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).
                    getScreenshotAs(OutputType.BASE64);
        }
        return base64Screenshot;
    }
	
	public void textVerification(WebElement element, String expectedText,int time) {
		WaitForElement(getDriver(),element, time);
        try {
            if (element.isDisplayed()) {
                if (StringUtils.normalizeSpace(element.getText()).equals(expectedText)) {
                	Log.info("Element is displayed, \n Element Text is " + "'" + element.getText() + "'");
                	ExtentManager.getTest().log(LogStatus.PASS,
                            "Element is displayed, \n Element Text is " + "'" + element.getText() + "'", ExtentManager.getTest().addBase64ScreenShot(captureScreenshot()));
                } else {
                	Log.error(element.getText()+" is not same as "+expectedText);
           //     	soft.assertEquals(element.getText(), expectedText);
                	ExtentManager.getTest().log(LogStatus.FAIL,
                            "Expected Text is " + "'" + expectedText + "'" + " " + "but got " + "'" + element.getText() + "'", ExtentManager.getTest().addBase64ScreenShot(captureScreenshot()));
                	
                }
            }
        } catch (NoSuchElementException e) {
            Log.error(e.getMessage());
            ExtentManager.getTest().log(LogStatus.FAIL, e.getMessage(), ExtentManager.getTest().addBase64ScreenShot(captureScreenshot()));
        }
    }
	
	public void TitletextVerification(WebDriver driver,String  expectedText,int time) {
		
        try {
            if (getDriver().getTitle()!=" ") {
            	String actualText = StringUtils.normalizeSpace(getDriver().getTitle());
                if (actualText.equals(expectedText)) {
                	
                	Log.info("Title is displyed and title is "+getDriver().getTitle());
                	ExtentManager.getTest().log(LogStatus.PASS,
                            "title is displayed, \n Element Text is " + "'" + actualText + "'", ExtentManager.getTest().addBase64ScreenShot(captureScreenshot()));
                } else {
                	Log.error("Title is "+getDriver().getTitle()+" which is  not same as "+expectedText);
                	ExtentManager.getTest().log(LogStatus.FAIL,
                            "Expected Text is " + "'" + expectedText + "'" + " " + "but got " + "'" + actualText + "'", ExtentManager.getTest().addBase64ScreenShot(captureScreenshot()));
                	soft.assertEquals(getDriver().getTitle(), expectedText);
                }
            }
        } catch (NoSuchElementException e) {
            e.getMessage();
        }
    }
	
	public void AttributetextVerification(WebElement element, String AttributeName,String expectedText,int time) {
		WaitForElement(getDriver(),element, time);
        try {
            if (element.isDisplayed()) {
            	String actualText = StringUtils.normalizeSpace(element.getAttribute(AttributeName));
                if (actualText.equals(expectedText)) {
                	Log.info("attribute is "+element.getAttribute(AttributeName));
                	ExtentManager.getTest().log(LogStatus.PASS,
                            "Element is displayed, \n Element Text is " + "'" + actualText + "'", ExtentManager.getTest().addBase64ScreenShot(captureScreenshot()));
                } else {
                	Log.error("Attribute is "+element.getAttribute(AttributeName)+" which is  not same as "+expectedText);
                	ExtentManager.getTest().log(LogStatus.FAIL,
                            "Expected Text is " + "'" + expectedText + "'" + " " + "but got " + "'" + actualText + "'", ExtentManager.getTest().addBase64ScreenShot(captureScreenshot()));
                	soft.assertEquals(element.getAttribute(AttributeName), expectedText);
                }
            }
        } catch (NoSuchElementException e) {
        	Log.error(e.getMessage());
        	ExtentManager.getTest().log(LogStatus.FAIL, e.getMessage(), ExtentManager.getTest().addBase64ScreenShot(captureScreenshot()));
        }
    }
	
	public  void clickOnElement(WebElement element,int time,String ElementName) {
		WaitForElement(getDriver(),element, time);
        try {
            element.click();
            Log.info("able to click on element "+element);
            ExtentManager.getTest().log(LogStatus.PASS, "Tap on "+ ElementName," ");
            
        } catch (Exception e) {
            try {
                 if (getDriver() != null) {
                    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
                    Log.info("able to click on element "+ElementName);
                    ExtentManager.getTest().log(LogStatus.PASS, "Tap on " + ElementName, "");
                    
                }
            } catch (Exception e2) {
            	Log.error(e2.getMessage());
            	ExtentManager.getTest().log(LogStatus.FAIL, e2.getMessage(), ExtentManager.getTest().addBase64ScreenShot(captureScreenshot()));
            }
        }
    }
	
	public  void clearAndEnterText(WebElement element, String textToEnter, String fieldName,int time) {
        
		WaitForElement(getDriver(),element, time);
		try {
            element.clear();
            element.sendKeys(textToEnter);
            Log.info("able to enter text "+textToEnter+" on "+fieldName);
            ExtentManager.getTest().log(LogStatus.PASS, "Entered " + textToEnter + " in " + fieldName,ExtentManager. getTest().addBase64ScreenShot(captureScreenshot()));
        }catch (Exception e2) {
        	Log.error("Failed to enter text : " + textToEnter + " in " + fieldName);
        	ExtentManager.getTest().log(LogStatus.FAIL, e2.getMessage(), ExtentManager.getTest().addBase64ScreenShot(captureScreenshot()));
           
        }
    }
	
public  void clearText(WebElement element, String fieldName,int time) {
        
		WaitForElement(getDriver(),element, time);
		try {
            element.clear();
            Log.info("clear  "+ fieldName);
            ExtentManager.getTest().log(LogStatus.PASS, "Cleared "  + fieldName,ExtentManager. getTest().addBase64ScreenShot(captureScreenshot()));
        }catch (Exception e2) {
        	Log.error("Failed to clear  " + fieldName);
        	ExtentManager.getTest().log(LogStatus.FAIL, e2.getMessage(), ExtentManager.getTest().addBase64ScreenShot(captureScreenshot()));
           
        }
    }
	
	public  void elementIsDisplayed(WebElement element,int time,String ElementName) {
		WaitForElement(getDriver(),element, time);
        try {

            if (element.isDisplayed()) {
                Log.info(ElementName+ " is displayed");
                ExtentManager.getTest().log(LogStatus.PASS, ElementName + " is Displayed", ExtentManager.getTest().addBase64ScreenShot(captureScreenshot()));
                }
        } catch (NoSuchElementException e) {
        	Log.error(ElementName+" is not displayed");
            ExtentManager.getTest().log(LogStatus.FAIL, e.getMessage(), ExtentManager.getTest().addBase64ScreenShot(captureScreenshot()));

        	
        }
    }
	
	
	public  void elementIsEnabaled(WebElement element,int time,String ElementName) {
		WaitForElement(getDriver(),element, time);
        try {

            if (element.isEnabled()) {
                Log.info(ElementName+ " is enabled");
                ExtentManager.getTest().log(LogStatus.PASS, ElementName + " is enabled", ExtentManager.getTest().addBase64ScreenShot(captureScreenshot()));
                }
        } catch (NoSuchElementException e) {
        	Log.error(ElementName+" is not enabled");
            ExtentManager.getTest().log(LogStatus.FAIL, e.getMessage(), ExtentManager.getTest().addBase64ScreenShot(captureScreenshot()));

        	
        }
    }
	
	public  void elementIsNotEnabaled(WebElement element,int time,String ElementName) {
		WaitForElement(getDriver(),element, time);
        try {

            if (!element.isEnabled()) {
                Log.info(ElementName+ " is not enabled");
                ExtentManager.getTest().log(LogStatus.PASS, ElementName + " is Displayed", ExtentManager.getTest().addBase64ScreenShot(captureScreenshot()));
                }
        } catch (NoSuchElementException e) {
        	Log.error(ElementName+" is  enabled");
            ExtentManager.getTest().log(LogStatus.FAIL, e.getMessage(), ExtentManager.getTest().addBase64ScreenShot(captureScreenshot()));

        	
        }
    }
	
	
	public String FetchDataFromjson(String Key) throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		Object obj1 = jsonParser.parse(new FileReader(System.getProperty("user.dir")+prop.getProperty("jsonTestData")));
        JSONObject jsonObject = (JSONObject) obj1; 
        String value = (String) jsonObject.get(Key);
		return value;
	}
	
	public Object FetchdataInArray(int index,String ArrayName) throws FileNotFoundException, IOException, ParseException {
		
		JSONParser jsonParser = new JSONParser();
		Object obj1 = jsonParser.parse(new FileReader(System.getProperty("user.dir")+prop.getProperty("jsonTestData")));
        JSONObject jsonObject = (JSONObject) obj1; 
        JSONArray jsonarray = (JSONArray) jsonObject.get(ArrayName);
     //   String value = (String) jsonObject.get("InformationData");
        return jsonarray.get(index);
	}
	
	public int FetchSizeOfJsonarray(String ArrayName) throws FileNotFoundException, IOException, ParseException {
		
		JSONParser jsonParser = new JSONParser();
		Object obj1 = jsonParser.parse(new FileReader(System.getProperty("user.dir")+prop.getProperty("jsonTestData")));
        JSONObject jsonObject = (JSONObject) obj1; 
        JSONArray jsonarray = (JSONArray) jsonObject.get(ArrayName);
        return jsonarray.size();
		
	}
	
	public  String getRandomEmail(String prefix, String domain) {
        Random random = new SecureRandom();
        return prefix + random.nextInt(999999) + "@" + domain;
    }
	
	public  String generateRandomStringWithLengthOf(int n) {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder stringBuilder = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());
            stringBuilder.append(AlphaNumericString
                    .charAt(index));
        }

        return stringBuilder.toString();
    }
	
}
