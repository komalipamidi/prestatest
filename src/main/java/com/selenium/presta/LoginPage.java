package com.selenium.presta;

import com.selenium.presta.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	public WebDriver driver = Configuration.browser();

	@FindBy(id = "email")
	public WebElement userNametextbox;

	@FindBy(id = "passwd")
	public WebElement Passwordtextbox;

	@FindBy(id = "SubmitLogin")
	public WebElement submitBtn;

	@FindBy(xpath = ".//*[@id='center_column']/div[2]/ol/li")
	public WebElement errormsgValidation;

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	public void LogintoApp(String username, String password) {

		userNametextbox.clear();
		userNametextbox.sendKeys(username);

		Passwordtextbox.clear();
		Passwordtextbox.sendKeys(password);

		submitBtn.click();
	}

	public void ValidateErrormsg() {

		Assert.assertEquals(errormsgValidation.getText(), "Invalid e-mail address");
	}

}
