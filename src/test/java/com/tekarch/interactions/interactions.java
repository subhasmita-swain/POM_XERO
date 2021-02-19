package com.tekarch.interactions;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tekarch.pofileupload.poFileUpload;
import com.tekarch.pohome.pohome;
import com.tekarch.pointeractions.pointeractions;
import com.tekarch.pologin.pologinTekApp;
import com.tekarch.utilities.TestBase;

public class interactions extends TestBase{
	pologinTekApp login;
	pohome home;
	pointeractions interractions;
	
	Logger log = Logger.getLogger(getClass().getSimpleName());

	@BeforeTest
	public void settingUpEnvironment() throws Exception {
		sErrorMessage = "";
		sClassNameForScreenShot = getClass().getSimpleName();
		driver.get(oCons.getTekAppURL());
		login = new pologinTekApp(driver);
		home = new pohome(driver);
		interractions = new pointeractions(driver);
		login.checkLoggedIntoTekAppOrNotElseLogin();
		home.navigateToInteractions();
	}
	
	@AfterMethod
	public void settingReqURL() throws Exception {
		driver.get(oCons.getTekAppURL());
		home.navigateToInteractions();
	}
	
	//@Test(priority = 1)
	public void To_check_whether_DRAGANDDROP_is_Working_Fine_Or_Not() throws Exception{
		interractions.draganddrop();
	}
	@Test(priority = 2)
	public void To_check_whether_MOUSEHOVER_is_Working_Fine_Or_Not() throws Exception{
		interractions.mousehover();
	};
}
