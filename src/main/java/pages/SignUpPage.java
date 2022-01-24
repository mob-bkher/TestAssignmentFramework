package pages;

import static interfaces.ClassObjects.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonPackage.BaseClass;
import io.restassured.path.json.JsonPath;

public class SignUpPage extends BaseClass{

	@FindBy(xpath = "//a[contains(text(),'Sign up')]")
	WebElement SignUpLink;
	
	@FindBy(xpath = "//h1[text()='Sign up']")
	WebElement SignUptext;
	
	@FindBy(xpath = "//p/a[text()='Have an account?']")
	WebElement HaveAnAccountLink;
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usernameTextBox;
	
	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement EmailTextbox;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement PasswordTextBox;
	
	@FindBy(xpath = "//button[contains(text(),'Sign up')]")
	WebElement signupButton;
	
	@FindBy(xpath = "//a[contains(text(),'New Article')]")
	WebElement NewArtickelink;
	
	public  String userUsername;
	public  String userEmailId;
	
	
	public void ClickOnSignUpLink() {
		utility.clickOnElement(SignUpLink, 20, "SignUp link");
	}

	public void headertext() {
		
		utility.textVerification(SignUptext, JsonPath.from(jsonTestData).getString("SignUpText"), 10);
		utility.textVerification(HaveAnAccountLink, JsonPath.from(jsonTestData).getString("HaveAnAccountText"), 10);
	}
	
	public void EnterUsername() {
		userUsername = utility.generateRandomStringWithLengthOf(7);
		utility.clearAndEnterText(usernameTextBox, userUsername, "username", 10);
	}
	
	public void EnterEmail() {
		userEmailId =utility.getRandomEmail("test", "gmail.com");
		utility.clearAndEnterText(EmailTextbox, userEmailId, "email", 10);
	}
	
	public void EnterPassword() {
		utility.clearAndEnterText(PasswordTextBox, JsonPath.from(jsonTestData).getString("password"), "password", 10);
	}
	
	public void ClickOnSignUpButton() {
		utility.clickOnElement(signupButton, 20, "SignUp Button");
	}
	
	public void CheckSignupbuttonEnabled() {
		utility.elementIsNotEnabaled(signupButton, 10, "Signup button");
	}
	
	public void CheckNewArtickelink() {
		utility.elementIsDisplayed(NewArtickelink,20, "New Article Link");
	}
	
	public void ClearAllTextbox() {
		utility.clearText(EmailTextbox, "Emal textBox", 10);
		utility.clearText(usernameTextBox, "username textBox", 10);
		utility.clearText(PasswordTextBox, "password textBox", 10);
		
	}
	
	

	
}
