package practiceTest;

import org.testng.annotations.Test;
import static interfaces.ClassObjects.*;
import commonPackage.BaseClass;

public class TestHomePageBeforeLogin extends BaseClass{

	
	@Test(priority = 0,description = "Check All hoempage links",groups = {"sanity"})
	public void  verifyHomepageLinks() {
		homepage.CheckHeaderlink();
	}
	
	@Test(priority = 1,description = "Check Your feed link",groups = {"sanity"})
	public void VerifyYourfeedtab() {
		homepage.YourFeedLink();
	}
	
	@Test(priority = 1,description = "Check page links",groups = {"sanity"})
	public void TestPages() {
		homepage.ClickOnPage();
	}
}
