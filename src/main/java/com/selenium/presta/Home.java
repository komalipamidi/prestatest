package com.selenium.presta;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Home {

	public WebDriver driver = Configuration.browser();

	public ReadExcel read;

	@FindBy(className = "login")
	public WebElement LoginLink;

	@FindBy(className = "logout")
	public WebElement Logoutlink;

	@FindBy(xpath = ".//*[@id='header_logo']/img")
	public WebElement homepageLogo;

	public Home() {

		PageFactory.initElements(driver, this);
		read = new ReadExcel();

	}

	public void LoginLink() {
		LoginLink.click();

		Assert.assertEquals(driver.getTitle(), read.readData("Login_Title"));
	}

	public void LogOut() throws InterruptedException {
		Logoutlink.click();
		CommonCode.wait(2);
		LoginLink.click();
	}

	public void navigate_to_home() {
		homepageLogo.click();
	}

}
