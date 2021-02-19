package com.tekarch.fileupload;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tekarch.pofileupload.poFileUpload;
import com.tekarch.pohome.pohome;
import com.tekarch.pologin.pologinTekApp;
import com.tekarch.utilities.TestBase;

public class fileupload extends TestBase{

	pologinTekApp login;
	pohome home;
	poFileUpload fileupload;
	
	Logger log = Logger.getLogger(getClass().getSimpleName());

	@BeforeTest
	public void settingUpEnvironment() throws Exception {
		sErrorMessage = "";
		sClassNameForScreenShot = getClass().getSimpleName();
		driver.get(oCons.getTekAppURL());
		login = new pologinTekApp(driver);
		home = new pohome(driver);
		fileupload = new poFileUpload(driver);
		login.checkLoggedIntoTekAppOrNotElseLogin();
		home.navigateToFileUpload();
	}
	
	@AfterMethod
	public void settingReqURL() throws Exception {
		driver.get(oCons.getTekAppURL());
		home.navigateToFileUpload();
	}
	
	@Test(priority = 1)
	public boolean To_check_whether_FILEUPLOAD_is_Working_Fine_Or_Not() throws Exception{
		return fileupload.chooseFile("C:\\\\Users\\\\Ranjan\\\\Desktop\\\\Fileuploadpic.jpg");
	};

	
}
