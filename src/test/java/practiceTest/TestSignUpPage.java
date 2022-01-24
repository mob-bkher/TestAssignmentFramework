package practiceTest;

import static interfaces.ClassObjects.*;

import org.testng.annotations.Test;

import commonPackage.BaseClass;

public class TestSignUpPage extends BaseClass{

@Test(enabled = false,priority = 0,groups = {"sanity"},description = "Enter valid credentials on alert pop up")
	
	public void LoginWithvalidCredentials() {
		alertpage.entervalidCredntials();
	}
	
@Test(priority = 1,groups = {"sanity"},description = "Verify the header text of Sign Up")
	public void VerifyHeaderext() {
	
	signup.ClickOnSignUpLink();
	signup.headertext();
}


@Test(priority = 2,groups = {"sanity"},description = "Verify the sign up button when entering invalid username and keep other field empoty")

	public void CheckSignupButton() {
	signup.EnterUsername();
	signup.CheckSignupbuttonEnabled();
	signup.ClearAllTextbox();
}

@Test(priority = 3,groups = {"sanity"},description = "Verify  and validate the sign up page functionality when all the fields are empty.")
public void CheckSignupButtonAllFieldEmpty() {

	signup.CheckSignupbuttonEnabled();

}

@Test(priority = 4,groups = {"sanity"},description = "Verify  and validate the sign up page functionality with invalid email id and rest of the data should be empty.")

public void CheckSignupButtonWhenEmilIsEntered() {
	signup.EnterEmail();
	signup.CheckSignupbuttonEnabled();
	signup.ClearAllTextbox();

}

@Test(priority = 5,groups = {"sanity"},description = "Verify  and validate the sign up page functionality with valid username and email id and password field should be empty.")

public void CheckSignupButtonWhenPasswordIsEntered() {
	signup.EnterEmail();
	signup.EnterUsername();
	signup.CheckSignupbuttonEnabled();
	signup.ClearAllTextbox();

}

@Test(priority = 6,groups = {"sanity"},description = "Verify  and validate the sign up page functionality with valid username and email id and password.")

public void CheckSignupButtonWithValidData() {
	signup.EnterUsername();
	signup.EnterEmail();
	signup.EnterPassword();
	signup.ClickOnSignUpButton();
	signup.CheckNewArtickelink();
}


}
