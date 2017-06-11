package com.selenium.presta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.selenium.presta.CommonCode;
import com.selenium.presta.Configuration;
import com.selenium.presta.ReadExcel;



public class SeleniumEasyAccount {
	public WebDriver driver = Configuration.browser();
	public ReadExcel read;
	public CommonCode commons;

	

	@FindBy(id = "btn_basic_example")
	public WebElement startprctisingbtn;

	@FindBy(xpath = ".//*[@id='home_bar']/span/i")
	public WebElement homebtn;

	@FindBy(xpath = ".//*[@id='basic']/h3")
	public WebElement verifycontent;

	@FindBy(xpath = ".//*[@id='inter_example']/span/i")
	public WebElement Intermediate;

	@FindBy(css = "a[class=\"list-group-item\"]")
	public WebElement verifybutton;

	@FindBy(id = "btn_advanced_example")
	public WebElement proceed;

	@FindBy(xpath = ".//*[@id='advanced']/h3")
	public WebElement verifycontent2;

	@FindBy(xpath = ".//*[@id='advanced']/div/a[5]")
	public WebElement verifycontent3;

	@FindBy(xpath = ".//*[@id='done_example']/span/i")
	public WebElement completebtn;

	@FindBy(css = "h3[class=\"head text-center\"]")
	public WebElement Completeverify;

	@FindBy(xpath = ".//*[@id='basic']/div/a[1]")
	public WebElement Simpleform;

	@FindBy(id = "user-message")
	public WebElement textbox;

	@FindBy(xpath = ".//*[@id='get-input']/button")
	public WebElement Showmsg;

	@FindBy(xpath = ".//*[@id='display']")
	public WebElement Dispalymsg;

	@FindBy(id = "sum1")
	public WebElement valueA;

	@FindBy(id = "sum2")
	public WebElement valueB;

	@FindBy(xpath = ".//*[@id='gettotal']/button")
	public WebElement totalbtn;

	@FindBy(id = "displayvalue")
	public WebElement dispalyvalue;

	@FindBy(xpath = ".//*[@id='navbar-brand-centered']/ul[1]/li[1]/a")
	public WebElement dropdown;

	@FindBy(xpath = ".//*[@id='easycont']/div/div[2]/div[1]/div[2]/p[1]")
	public WebElement verifyclicktext;

	@FindBy(xpath = ".//*[@id='easycont']/div/div[2]/div[1]/div[2]/label[2]/input")
	public WebElement radiobtn;

	@FindBy(id = "buttoncheck")
	public WebElement getcheckedvalue;

	@FindBy(xpath = ".//*[@id='easycont']/div/div[2]/div[2]/div[1]")
	public WebElement grouptext;

	@FindBy(xpath = ".//*[@id='carousel-example-generic']/div/div[1]/div/div/div[2]/h4")
	public WebElement Slide1;

	@FindBy(xpath = "..//*[@id='carousel-example-generic']/div/div[2]/div/div/div[1]/h4")
	public WebElement Slide2;

	@FindBy(xpath = ".//*[@id='carousel-example-generic']/div/div[3]/div/div/div[1]/h4")
	public WebElement Slide3;

	@FindBy(xpath = ".//*[@id='carousel-example-generic']/div/div[4]/div/div/div[1]/h4")
	public WebElement Slide4;

	@FindBy(xpath = ".//*[@id='carousel-example-generic']/a[2]/i")
	public WebElement forwardarrow;

	@FindBy(xpath = ".//*[@id='carousel-example-generic']/a[1]/i")
	public WebElement backarrow;

	public SeleniumEasyAccount() {

		PageFactory.initElements(driver, this);
		
		read = new ReadExcel();
		commons = new CommonCode();
	}

	public void test1() throws InterruptedException {

		Assert.assertTrue(homebtn.isDisplayed());
		startprctisingbtn.click();
		CommonCode.wait(3);
		String content = verifycontent.getText();
		Assert.assertEquals(content, read.readData("contenttext"));
		Intermediate.click();
		commons.wait(3);
		Assert.assertTrue(verifybutton.isDisplayed());
		proceed.click();
		commons.wait(3);
		Assert.assertTrue(verifycontent2.isDisplayed());
		commons.wait(3);
		Assert.assertTrue(verifycontent3.isDisplayed());
		completebtn.click();
		commons.wait(3);
		Assert.assertTrue(Completeverify.isDisplayed());
		homebtn.click();
	}

	public void test2() throws InterruptedException {
		commons.wait(4);
		String slideone = Slide1.getText();
		Assert.assertEquals(slideone, read.readData("slide1"));
		forwardarrow.click();
		commons.wait(4);
		String slidetwo = Slide2.getText();
		Assert.assertEquals(slidetwo, read.readData("slide2"));
		forwardarrow.click();
		commons.wait(4);
		String slidethree = Slide3.getText();
		Assert.assertEquals(slidethree, read.readData("slide3"));
		forwardarrow.click();
		commons.wait(4);
		String slidefour = Slide4.getText();
		Assert.assertEquals(slidefour, read.readData("slide4"));
		forwardarrow.click();
		commons.wait(4);
		backarrow.click();
		commons.wait(4);
		Assert.assertEquals(slidefour, read.readData("slide4"));
		backarrow.click();
		commons.wait(4);
		Assert.assertEquals(slidethree,read.readData("slide3"));

	}

	public void test3() throws InterruptedException {
		commons.wait(3);
		startprctisingbtn.click();
		commons.wait(3);
		String title = driver.getTitle();
		// Assert.assertEquals(title,read.readData("contenttext"));
		Simpleform.click();
		commons.wait(3);
		textbox.sendKeys(read.readData("textbox"));
		Showmsg.click();
		commons.wait(3);
		Assert.assertEquals(Dispalymsg.getText(), read.readData("textbox"));
		valueA.sendKeys(read.readData("A"));
		valueB.sendKeys(read.readData("B"));
		totalbtn.click();
		Reporter.log(dispalyvalue.getText());
		Assert.assertEquals(dispalyvalue.getText(), read.readData("displayedvalue"));
		//
	}

	public void test4() {
		homebtn.click();
		Select dropdownb = new Select(dropdown);
		dropdownb.selectByVisibleText("Radio Buttons Demo");
		String title2 = driver.getTitle();
		// Assert.assertEquals(title,read.readData("contenttext"));
		Assert.assertEquals(verifyclicktext.getText(), read.readData("verifyclicktext"));
		if (radiobtn.isSelected()) {
			Reporter.log("radiobtn is selected");
		} else
			radiobtn.click();
		getcheckedvalue.click();
		Assert.assertEquals(grouptext.getText(), read.readData("groupbtn"));

	}

}
