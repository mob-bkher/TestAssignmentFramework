package pages;

import static interfaces.ClassObjects.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonPackage.BaseClass;
import io.restassured.path.json.JsonPath;

public class HomePageBeforeLogin extends BaseClass{

	@FindBy(xpath = "//a[contains(text(),'Global Feed')]")
	WebElement GlobalFeedTab;
	
	@FindBy(xpath = "//a[contains(text(),'Your Feed')]")
	WebElement YourfeedTab;
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement HomeLink;
	
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement SignInLink;
	
	@FindBy(xpath = "//a[contains(text(),'Sign up')]")
	WebElement SignUpLink;
	
	@FindBy(xpath = "//nav/div[@class='container']/a[contains(text(),'conduit')]")
	WebElement conduitLogo;
	
	@FindBy(xpath = "//h1[contains(text(),'Sign in')]")
	WebElement SignInText;
	
	@FindBy(xpath = "//p[text()='Popular Tags']")
	WebElement populartagsLink;
	
	@FindBy(xpath = "//li/a[@class='page-link' and text()=27]")
	WebElement Page27;
	public void CheckHeaderlink() {
		
		utility.textVerification(GlobalFeedTab, JsonPath.from(jsonTestData).getString("GlobalFeedText"), 10);
		utility.elementIsEnabaled(GlobalFeedTab, 10, "Global Feed tab");
		
		utility.textVerification(YourfeedTab, JsonPath.from(jsonTestData).getString("Yourfeedtext"), 10);
		utility.elementIsEnabaled(YourfeedTab, 10, "Your Feed tab");
		
		utility.textVerification(SignInLink, JsonPath.from(jsonTestData).getString("signIntext"), 10);
		utility.elementIsEnabaled(SignInLink, 10, "Sign In link");
		
		utility.textVerification(SignUpLink, JsonPath.from(jsonTestData).getString("SignUpText"), 10);
		utility.elementIsEnabaled(SignUpLink, 10, "Sign up link");
		
		utility.textVerification(HomeLink, JsonPath.from(jsonTestData).getString("HomeText"), 10);
		utility.elementIsEnabaled(HomeLink, 10, "home link");
		
		utility.textVerification(populartagsLink, JsonPath.from(jsonTestData).getString("PopularTagsText"), 10);

		utility.elementIsDisplayed(conduitLogo, 10, "conduit Logo");
	}
	
	public void YourFeedLink() {
		
		utility.clickOnElement(YourfeedTab, 10, "Your feed tab");
		utility.textVerification(SignInText, "Sign in", 10);
	
	}
	
	public void ClickOnPage() {
		utility.elementIsEnabaled(Page27, 10, "Page# 27");
		utility.clickOnElement(Page27, 10, "Page #27 ");
	}

}
