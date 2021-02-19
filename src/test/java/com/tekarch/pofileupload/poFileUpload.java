package com.tekarch.pofileupload;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekarch.utilities.TestBase;

public class poFileUpload extends TestBase {

	Logger log = Logger.getLogger(getClass().getSimpleName());

	public poFileUpload(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='./fileupload.html']")
	WebElement file_upload_button;

	@FindBy(xpath = "//input[@id='logo']")
	WebElement filepath;

	@FindBy(xpath = "//div[@class='imagearea']//img")
	WebElement image;

	@FindBy(xpath = "//button[@type='button']")
	WebElement button;

	public boolean chooseFile(String path) throws Exception {

		oBroUti.waitForElementVisible(driver, file_upload_button, 5);

		file_upload_button.click();
		Thread.sleep(5000);
		System.out.println("File upload button is clicked");

		// Clicked on file path
		filepath.sendKeys(path);

		// gave one loaded image path
		Thread.sleep(3000);

		oBroUti.waitForElementVisible(driver, image, 5);

		Boolean imagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				image);

		if (!imagePresent) {
			System.out.println("Image is not Present");
		} else {
			System.out.println("Image is Present");
		}
		Thread.sleep(5000);
		button.click();
		Thread.sleep(5000);
		return imagePresent;
	}
}
