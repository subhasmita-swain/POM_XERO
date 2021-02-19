package com.tekarch.widget;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tekarch.pofileupload.poFileUpload;
import com.tekarch.pohome.pohome;
import com.tekarch.pointeractions.pointeractions;
import com.tekarch.pologin.pologinTekApp;
import com.tekarch.powidget.powidget;
import com.tekarch.utilities.TestBase;

public class widget extends TestBase {

		pologinTekApp login;
		pohome home;
		powidget Widget;
		
		Logger log = Logger.getLogger(getClass().getSimpleName());

		@BeforeTest
		public void settingUpEnvironment() throws Exception {
			sErrorMessage = "";
			sClassNameForScreenShot = getClass().getSimpleName();
			driver.get(oCons.getTekAppURL());
			login = new pologinTekApp(driver);
			home = new pohome(driver);
			Widget = new powidget(driver);
			login.checkLoggedIntoTekAppOrNotElseLogin();
			home.navigateToWidget();
		}
		
		@AfterMethod
		public void settingReqURL() throws Exception {
			driver.get(oCons.getTekAppURL());
			home.navigateToWidget();
		}
		
		@Test(priority = 1)
		public void To_check_whether_ACCORDIAN_is_Working_Fine_Or_Not() throws Exception{
			Widget.accordian();
		};
		}


