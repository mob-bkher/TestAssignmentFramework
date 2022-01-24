package practiceTest;

import org.testng.annotations.Test;

import static interfaces.ClassObjects.*;
import commonPackage.BaseClass;

public class TestAlertUrlPage extends BaseClass{

	@Test(priority = 4,groups = {"sanity"},description = "Enter valid credentials on alert pop up")
	
	public void LoginWithvalidCredentials() {
		alertpage.entervalidCredntials();
	}
	
	@Test(priority = 0,groups = {"sanity"},description = "Enter invalid credentials on alert pop up")
	
	public void LoginWithInvalidCredentials() {
		alertpage.enterInvalidCredntials();
	}

	@Test(priority = 1,groups = {"sanity"},description = "Enter valid password and empty username on alert pop up")

	public void LoginWithEmptyusernameCredentials() {
	alertpage.enterEmptyusernameInCredentials();
}

	@Test(priority = 2,groups = {"sanity"},description = "Enter valid username and empty password on alert pop up")

	public void LoginWithEmptypasswordCredentials() {
	alertpage.enterEmptyPasswordInCredntials();
}

	@Test(priority = 3,groups = {"sanity"},description = "empty username and empty password on alert pop up")

	public void LoginWithEmptyusernamePasswordCredentials() {
	alertpage.EmptyUsernanePasswordInCredntials();
}
	
	
}
