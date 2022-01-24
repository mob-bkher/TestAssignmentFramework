package interfaces;

import commonPackage.BaseClass;
import commonPackage.UtilityClass;
import pages.AlerturlPage;
import pages.HomePageBeforeLogin;
import pages.SignUpPage;

public interface ClassObjects{
	
	BaseClass base = new BaseClass();
	UtilityClass utility = new UtilityClass();
	AlerturlPage alertpage = new AlerturlPage();
	SignUpPage signup = new SignUpPage();
	HomePageBeforeLogin homepage = new HomePageBeforeLogin();
	
}
