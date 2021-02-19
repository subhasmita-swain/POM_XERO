package com.tekarch.pohome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekarch.utilities.TestBase;

import org.apache.log4j.Logger;

public class pohome extends TestBase{

	Logger log = Logger.getLogger(getClass().getSimpleName());

	public pohome(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement button_Home;
	@FindBy(xpath="//a[contains(text(),'Calculator')]")
	WebElement tab_calculator;
	@FindBy(xpath="//a[contains(text(),'File Upload')]")
	WebElement tab_fileupload;
	@FindBy(xpath="//button[contains(text(),'Intractions')]")
	WebElement tab_interactions;
	@FindBy(xpath="//button[contains(text(),'Widget')]")
	WebElement tab_widget;
	
	
	public boolean navigateToCalculator() throws Exception{
		boolean bRes_Flag=false;
		oBroUti.waitForElementVisible(driver, button_Home, 5);
		oBroUti.ufClick(tab_calculator);
		bRes_Flag=true;
		return bRes_Flag;
	}

	public boolean navigateToFileUpload() throws Exception{
		boolean bRes_Flag=false;
		oBroUti.waitForElementVisible(driver, button_Home, 5);
		oBroUti.ufClick(tab_fileupload);
		bRes_Flag=true;
		return bRes_Flag;
	}

	public boolean navigateToInteractions() throws Exception{
		boolean bRes_Flag=false;
		oBroUti.waitForElementVisible(driver, button_Home, 5);
		Actions action = new Actions(driver);
		action.moveToElement(tab_interactions).perform();
		bRes_Flag=true;
		return bRes_Flag;
	}
	public boolean navigateToWidget() throws Exception{
		boolean bRes_Flag=false;
		oBroUti.waitForElementVisible(driver, button_Home, 5);
		Actions action = new Actions(driver);
		action.moveToElement(tab_widget).perform();
		bRes_Flag=true;
		return bRes_Flag;
	}

}
