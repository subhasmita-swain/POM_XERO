package com.tekarch.powidget;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekarch.utilities.TestBase;

public class powidget extends TestBase {

	Logger log = Logger.getLogger(getClass().getSimpleName());

	public powidget(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Accordian')]")
	WebElement Accordian_button;

	@FindBy(xpath = "//button[contains(text(),'Section 1')]")
	WebElement Section1_mess;

	@FindBy(xpath = "//button[contains(text(),'Section 2')]")
	WebElement Section2_mess;

	@FindBy(xpath = "//button[contains(text(),'Section 3')]")
	WebElement Section3_mess;

	public void accordian() throws Exception {
		oBroUti.waitForElementVisible(driver, Accordian_button, 2);
		Accordian_button.click();
		System.out.println("Accordian button is clicked.");
		System.out.println(Accordian_button.getText());
		
		oBroUti.waitForElementVisible(driver, Section1_mess, 3);
		Section1_mess.click();
		System.out.println("Section1 mess is clicked.");
		System.out.println(Accordian_button.getText());
		
		oBroUti.waitForElementVisible(driver, Section2_mess, 3);
		Section2_mess.click();
		System.out.println("Section2 mess is clicked.");
		System.out.println(Accordian_button.getText());
		
		oBroUti.waitForElementVisible(driver, Section3_mess, 3);
		Section3_mess.click();
		System.out.println(Accordian_button.getText());
		System.out.println("Section3 mess is clicked.");

	}
}
