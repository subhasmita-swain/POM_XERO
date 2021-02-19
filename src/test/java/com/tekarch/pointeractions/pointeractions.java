package com.tekarch.pointeractions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tekarch.utilities.TestBase;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class pointeractions extends TestBase {

	Logger log = Logger.getLogger(getClass().getSimpleName());

	public pointeractions(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Drag & Drop')]")
	WebElement D_D;

	@FindBy(xpath = "//img[@id='drag1']")
	WebElement draggble_image;

	@FindBy(xpath = "//div[@class='container']//div[2]")
	WebElement D_DTo;
	
	@FindBy(xpath = "//a[contains(text(),'Mouse Hover')]")
	WebElement mouse_hover_button1;
	
	@FindBy(xpath = "//button[contains(text(),'mousehover')]")
	WebElement mouse_hover_button2;
	
	@FindBy(linkText = "Alert")
	WebElement alert_button;
	
	
	public void draganddrop() throws Exception {

	Thread.sleep(5000);
		System.out.println("Intractions button is clicked");

		oBroUti.waitForElementVisible(driver, D_D, 5);
		D_D.click();
		Thread.sleep(1000);
		
		oBroUti.waitForElementVisible(driver, draggble_image, 5);
		oBroUti.waitForElementVisible(driver, D_DTo, 5);
		
		Actions act = new Actions(driver);
		act.dragAndDrop(draggble_image, D_DTo).build().perform();
		oBroUti.wait(3000);
		Thread.sleep(3000);
		
		}
	public void mousehover() throws Exception{
		System.out.println("Mouser hover button1 is clicked.");
		oBroUti.waitForElementVisible(driver, mouse_hover_button1, 5);
		mouse_hover_button1.click();
		Thread.sleep(1000);
		
		System.out.println("Mouser hover button2 is clicked.");
		oBroUti.waitForElementVisible(driver, mouse_hover_button2, 5);
		mouse_hover_button2.click();
		
		Actions action1 = new Actions(driver);
		action1.moveToElement(mouse_hover_button2).perform();
		Thread.sleep(3000);
		
		System.out.println("Alert button is clicked.");
		oBroUti.waitForElementVisible(driver, alert_button, 5);
		alert_button.click();
		
		Alert Ok_Alert = driver.switchTo().alert();
		String alertText = Ok_Alert.getText();
		System.out.println("Alert text is " + alertText);
		Thread.sleep(4000);
		Ok_Alert.accept();
	}
}
